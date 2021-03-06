package edu.si.saam.api.services;

import edu.si.saam.api.models.Exhibition;
import edu.si.saam.api.models.Museum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BrassellRK@si.edu on 7/15/16.
 */
@Repository
public class ExhibitionService {

    /** The named jdbc template. */
    private NamedParameterJdbcTemplate namedJdbcTemplate;
    public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
        this.namedJdbcTemplate = namedJdbcTemplate;
    }

    /** The jdbc template. */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Produces a list of all available exhibitions.
     * @param limit - the number of edu.si.saam.api.models.Exhibition you want returned
     * @param start - where to start in the list of results
     * @param order - how to sort the list of results
     * @return java.uil.List of edu.si.saam.api.models.Exhibition
     */
    public List<Exhibition> getAllExhibitions(int limit, int start, String order)  {

        List<Exhibition> results = new ArrayList<Exhibition>();

        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(new Exhibition());

        if (namedJdbcTemplate == null) {
            namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        }

        String sql = "select * from exhibitions " + order + " limit "+ start + "," + limit;

        try {
            results = namedJdbcTemplate
                    .query(sql, namedParameters,
                            BeanPropertyRowMapper
                                    .newInstance(Exhibition.class));
//            System.out.println("Results Size == " + results.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }

    /**
     * getExhibition takes a fresh edu.si.saam.api.models.Exhibition object with a set id and locates that specific
     * exhibition object and returns it.
     * @param ex - edu.si.saam.api.models.Exhibition object containing only the exhibit code.
     * @return the specified edu.si.saam.api.models.Exhibition
     */
    public Exhibition getExhibition(Exhibition ex) {

        String sql = "select * from exhibitions where exhibition_code=:exhibition_code limit 0,1";
        List<Exhibition> r_exhibitions = new ArrayList<Exhibition>();
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(ex);

        if (namedJdbcTemplate == null) {
            namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        }

        try {
            r_exhibitions = namedJdbcTemplate.query(sql, namedParameters,
                    BeanPropertyRowMapper
                            .newInstance(Exhibition.class));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (r_exhibitions.size() > 0) {
            ex = r_exhibitions.get(0);
        }

//        System.out.println(ex.getText_display());

        return ex;
    }

    /**
     * Takes a given edu.si.saam.api.models.Exhibition object and adds it to the backend.
     * @param ex - a filled out edu.si.saam.api.models.Exhibition object
     * @return the new exhibition
     */
    public Exhibition addExhibition(Exhibition ex) {

//        System.out.println("In addExhibition.");

        if (namedJdbcTemplate == null) {
            namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        }


        String sql = "insert into exhibitions (exhibition_code,open_date,close_date,headline,text,text_display," +
                "accession_number,saam_image,location,related_constituent,web_directory,traveling,permanent_exhibit," +
                "travel_beg_date,travel_end_date,offered_for_tour,past_date,publication,isbn_softcover," +
                "isbn_hardcover,subject_general,subject_specific,display_date,caption) " +
                "VALUES (:exhibition_code,:open_date,:close_date,:headline,:text,:text_display,:accession_number," +
                ":saam_image,:location,:related_constituent,:web_directory,:traveling,:permanent_exhibit," +
                ":travel_beg_date,:travel_end_date,:offered_for_tour,:past_date,:publication,:isbn_softcover," +
                ":isbn_hardcover,:subject_general,:subject_specific,:display_date,:caption)";

        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(ex);

        int status = namedJdbcTemplate.update(sql, namedParameters);

        return ex;
    }

    /**
     * Updates the edu.si.saam.api.models.Exhibition using the filled out edu.si.saam.api.models.Exhibition object.
     *
     * @param ex - edu.si.saam.api.models.Exhibition object with exhibit changes.
     * @return the updated edu.si.saam.api.models.Exhibition object
     */
    public Exhibition updateExhibition(Exhibition ex) {

        if(ex.getType() != null && "add".equalsIgnoreCase(ex.getType().trim())) {
            return addExhibition(ex);
        }

        System.out.println("In updateExhibition");

        if (namedJdbcTemplate == null) {
            namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        }

        // if exhibitions exists then continue else go to add.

        String sql = "update exhibitions set exhibition_code=:exhibition_code,open_date=:open_date,close_date=:close_date," +
                "headline=:headline,text=:text,text_display=:text_display,accession_number=:accession_number," +
                "saam_image=:saam_image,location=:location,related_constituent=:related_constituent," +
                "web_directory=:web_directory,traveling=:traveling,permanent_exhibit=:permanent_exhibit," +
                "travel_beg_date=:travel_beg_date,travel_end_date=:travel_end_date," +
                "offered_for_tour=:offered_for_tour,past_date=:past_date,publication=:publication," +
                "isbn_softcover=:isbn_softcover,isbn_hardcover=:isbn_hardcover,subject_general=:subject_general," +
                "subject_specific=:subject_specific,display_date=:display_date,caption=:caption where exhibition_code=:exhibition_code";

        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(ex);

        int status = namedJdbcTemplate.update(sql, namedParameters);

        return ex;
    }

    /**
     * Deletes an existing edu.si.saam.api.models.Exhibition
     * @param ex - existing edu.si.saam.api.models.Exhibition to be deleted
     * currently not used.
     */
    public void deleteExhibition(Exhibition ex){

        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(ex);

        if (namedJdbcTemplate == null) {
            namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        }

        try {

            int satus = namedJdbcTemplate.update("delete from exhibitions where exhibition_code=:exhibition_code",
                    namedParameters);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}