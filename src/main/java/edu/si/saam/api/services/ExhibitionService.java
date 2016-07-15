package edu.si.saam.api.services;

import edu.si.saam.api.models.Exhibition;
import edu.si.saam.api.models.Museum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by richardbrassell on 7/15/16.
 */
public class ExhibitionService {

    /** The named jdbc template. */
    private NamedParameterJdbcTemplate namedJdbcTemplate;
    public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
        this.namedJdbcTemplate = namedJdbcTemplate;
    }

    private BeanPropertyRowMapper<Museum> museumBeanPropertyRowMapper;
    public void setMuseumBeanPropertyRowMapper(BeanPropertyRowMapper<Museum> museumBeanPropertyRowMapper){
        this.museumBeanPropertyRowMapper = museumBeanPropertyRowMapper;
    }

    /** The jdbc template. */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Produces a list of all available museums.
     *
     * @return @java.uil.List of @edu.si.saam.api.models.Museum
     */
    public List<Exhibition> getAllMuseums() {

        List<Exhbition> results = new ArrayList<Exhibition>();

        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(new Exhibition());

        if (namedJdbcTemplate == null) {
            namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        }

        try {
            results = namedJdbcTemplate
                    .query("select * from exhibitions", namedParameters,
                            BeanPropertyRowMapper
                                    .newInstance(Museum.class));
            System.out.println("Results Size == " + results.size());
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

    /**
     * getExhibition takes a fresh exhibition object with a set id and locates that specific exhibition object and
     * returning it.
     * @param ex - exhibition object containing only the exhibit code.
     * @return the specified exhibition
     */
    public Exhibition getExhibition(Exhibition ex) {
        return ex;
    }

    /**
     * Takes a given exhibition object and adds it to the backend.
     * @param ex - a filled out exhibit object
     * @return
     */
    public Exhibition addExhibition(Exhibition ex) {
        return ex;
    }

    /**
     * Updates the exhibition using the filled out exhibition object.
     *
     * @param ex - exhibition object with exhibit changes.
     * @return the updated exhibit object
     */
    public Exhibition updateExhibition(Exhibition ex) {
        return ex;
    }

    public void deleteExhibition(Exhibition ex) {

    }
}