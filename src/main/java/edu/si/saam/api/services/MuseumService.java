package edu.si.saam.api.services;

import edu.si.saam.api.models.Museum;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by richardbrassell on 6/3/16.
 */
public class MuseumService {

    /** The named jdbc template. */
    private NamedParameterJdbcTemplate namedJdbcTemplate;
    /** The jdbc template. */
    private JdbcTemplate jdbcTemplate;

    public void init() {
        BasicDataSource dataSource = new org.apache.commons.dbcp2.BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://si-mysqlproxy01.si.edu:4040/saam_mashup?rewriteBatchedStatements=true" +
                "&useUnicode=yes&characterEncoding=UTF-8&failOverReadOnly=false&secondsBeforeRetryMaster=5");
        dataSource.setUsername("");
        dataSource.setPassword("");

        // setting these will permit connections not to die...
        dataSource.setValidationQuery("select 1");
        dataSource.setTestOnBorrow(true);

        setDataSource(dataSource);
    }

    public List<Museum> getAllMuseums() {

        List<Museum> results = new ArrayList<Museum>();
        Museum m1 = new Museum();
        m1.setName("Smithsonian American Art Museum");
        m1.setAddress("Smackdown Ave. DC");
        Museum m2 = new Museum();
        m2.setName("Renwick Gallery");
        m2.setAddress("Jabrone St. DC");
        results.add(m1);
        results.add(m2);
        return results;
    }

    /**
     * Sets the data source.
     *
     * @param ds
     *            the new data source
     */
    public void setDataSource(DataSource ds) {
        try {
            this.jdbcTemplate = new JdbcTemplate(ds);
            this.namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
