package edu.si.saam.api.services;

import edu.si.saam.api.models.Museum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by richardbrassell on 6/3/16.
 */
@Repository
public class MuseumService {

    /** The named jdbc template. */
    private NamedParameterJdbcTemplate namedJdbcTemplate;

    /** The jdbc template. */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Museum> getAllMuseums() {

        List<Museum> results = new ArrayList<Museum>();

        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(new Museum());

        namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);

        try {
            results = namedJdbcTemplate
                    .query("select * from museums", namedParameters,
                            BeanPropertyRowMapper
                                    .newInstance(Museum.class));
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Museum m1 = new Museum();
//        m1.setName("Smithsonian American Art Museum");
//        m1.setAddress("Smackdown Ave. DC");
//        Museum m2 = new Museum();
//        m2.setName("Renwick Gallery");
//        m2.setAddress("Jabrone St. DC");
//        results.add(m1);
//        results.add(m2);
        return results;
    }

}
