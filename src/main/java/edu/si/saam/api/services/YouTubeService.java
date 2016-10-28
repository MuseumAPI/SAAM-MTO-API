package edu.si.saam.api.services;

import edu.si.saam.api.models.YouTube;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides access to YouTube data in the smashup DB
 * Created by LapanK@si.edu on 9/29/16.
 */

@Repository
public class YouTubeService {

    /** The named jdbc template. */
    private NamedParameterJdbcTemplate namedJdbcTemplate;
    public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
        this.namedJdbcTemplate = namedJdbcTemplate;
    }

    /** The jdbc template. */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Produces a list of all available YouTube.
     * @param limit - the max number of results you want to see
     * @param start - where in the results list you want to start
     * @param order - the sort column of the results
     * @return java.uil.List of edu.si.saam.api.models.YouTube
     */
    public List<YouTube> getAllYouTube(int limit, int start, String order)  {

        List<YouTube> results = new ArrayList<YouTube>();

        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(new YouTube());

        if (namedJdbcTemplate == null) {
            namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        }

        String sql = "select * from youtube " + order + " limit "+ start + "," + limit;

        try {
            results = namedJdbcTemplate
                    .query(sql, namedParameters,
                            BeanPropertyRowMapper
                                    .newInstance(YouTube.class));
//            System.out.println("Results Size == " + results.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }

    /**
     * getYouTube takes a fresh edu.si.saam.api.models.YouTube object with a set id and locates that specific
     * YouTube object and returning it.
     * @param ex - edu.si.saam.api.models.YouTube object containing only the exhibit code.
     * @return the specified edu.si.saam.api.models.YouTube
     */
    public YouTube getYouTube(YouTube ex) {

        String sql = "select * from YouTube where YouTube_code=:YouTube_code limit 0,1";
        List<YouTube> r_YouTube = new ArrayList<YouTube>();
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(ex);

        if (namedJdbcTemplate == null) {
            namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        }

        try {
            r_YouTube = namedJdbcTemplate.query(sql, namedParameters,
                    BeanPropertyRowMapper
                            .newInstance(YouTube.class));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (r_YouTube.size() > 0) {
            ex = r_YouTube.get(0);
        }

//        System.out.println(ex.getText_display());

        return ex;
    }

    /**
     * Takes a given edu.si.saam.api.models.YouTube object and adds it to the backend.
     * @param ex - a filled out edu.si.saam.api.models.YouTube object
     * @return the updated edu.si.saam.api.models.YouTube
     */
    public YouTube addYouTube(YouTube ex) {

        System.out.println("In addYouTube.");

        if (namedJdbcTemplate == null) {
            namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        }


        String sql = "insert into youtube (id,url,relatedConstituent,exhibitionCode,uploadDate,title,thumbnail,isbnNoSoftcover,isbnNoHardcover,subjectGeneral,subjectSpecific,description) " +
                "VALUES (:id,:url,:relatedConstituent,:exhibitionCode,:uploadDate,:title,:thumbnail,:isbnNoSoftcover,:isbnNoHardcover,:subjectGeneral,:subjectSpecific,:description)";

        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(ex);

        int status = namedJdbcTemplate.update(sql, namedParameters);

        return ex;
    }

    /**
     * Updates the edu.si.saam.api.models.YouTube using the filled out edu.si.saam.api.models.YouTube object.
     * @param ex - edu.si.saam.api.models.YouTube object with changes.
     * @return the updated edu.si.saam.api.models.YouTube object
     */
    public YouTube updateYouTube(YouTube ex) {

        if(ex.getActionType() != null && "add".equalsIgnoreCase(ex.getActionType().trim())) {
            return addYouTube(ex);
        }

//        System.out.println("In updateYouTube");

        if (namedJdbcTemplate == null) {
            namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        }

        // if YouTube exists then continue else go to add.

        String sql = "update YouTube set id=:id,url=:url,relatedConstituent=:relatedConstituent," +
                "exhibitionCode=:exhibitionCode,uploadDate=:uploadDate,title=:title,thumbnail=:thumbnail," +
                "isbnNoSoftcover=:isbnNoSoftcover,isbnNoHardcover=:isbnNoHardcover,subjectGeneral=:subjectGeneral," +
                "subjectSpecific=:subjectSpecific,description=:description where YouTube_code=:YouTube_code";

        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(ex);

        int status = namedJdbcTemplate.update(sql, namedParameters);

        return ex;
    }

    /**
     * Deletes an existing edu.si.saam.api.models.YouTube
     * @param ex - the edu.si.saam.api.models.YouTube to remove.
     * Currently not used
     */
    public void deleteYouTube(YouTube ex){

        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(ex);

        if (namedJdbcTemplate == null) {
            namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        }

        try {

            int satus = namedJdbcTemplate.update("delete from YouTube where YouTube_code=:YouTube_code",
                    namedParameters);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
