package edu.si.saam.api.services;

import edu.si.saam.api.models.Exhibition;
import edu.si.saam.api.models.Museum;
import edu.si.saam.api.models.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BrassellRK@si.edu on 7/15/16.
 */
@Repository
public class PublicationService {

    /** The named jdbc template. */
    private NamedParameterJdbcTemplate namedJdbcTemplate;
    public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
        this.namedJdbcTemplate = namedJdbcTemplate;
    }

    /** The jdbc template. */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Produces a list of all available edu.si.saam.api.models.Publication.
     * @param limit - the number of edu.si.saam.api.models.Publication you want returned
     * @param start - where to start in the list of results
     * @param order - how to sort the list of results
     * @return java.uil.List of edu.si.saam.api.models.Publication
     */
    public List<Publication> getAllPublications(int limit, int start, String order)  {

        List<Publication> results = new ArrayList<Publication>();

        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(new Publication());

        if (namedJdbcTemplate == null) {
            namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        }

        // small bit of validation
        if (order.equalsIgnoreCase("yearPublished")) {
            order = " order by " + order + " desc";
        } else {
            order = " order by yearPublished desc";
        }


        String sql = "select * from publications " + order + " limit "+ start + "," + limit;

        try {
            results = namedJdbcTemplate
                    .query(sql, namedParameters,
                            BeanPropertyRowMapper
                                    .newInstance(Publication.class));
//            System.out.println("Results Size == " + results.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }

    /**
     * getPublication takes a fresh @edu.si.saam.api.models.Publication object with a set id and locates that specific
     * edu.si.saam.api.models.Publication object and returns it.
     * @param publication - edu.si.saam.api.models.Publication object containing only the exhibit code.
     * @return the specified edu.si.saam.api.models.Publication
     */
    public Publication getPublication(Publication publication) {

        String sql = "select * from publications where id=:id limit 0,1";
        List<Publication> r_publications = new ArrayList<Publication>();
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(publication);

        if (namedJdbcTemplate == null) {
            namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        }

        try {
            r_publications = namedJdbcTemplate.query(sql, namedParameters,
                    BeanPropertyRowMapper
                            .newInstance(Publication.class));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (r_publications.size() > 0) {
            publication = r_publications.get(0);
        }

//        System.out.println(ex.getText_display());

        return publication;
    }

    /**
     * Takes a given edu.si.saam.api.models.Publication object and adds it to the backend.
     * @param publication - a filled out edu.si.saam.api.models.Publication object
     * @return - the added edu.si.saam.api.models.Publication
     */
    public Publication addPublication(Publication publication) {

//        System.out.println("In addPublication.");

        if (namedJdbcTemplate == null) {
            namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        }


        String sql = "insert into publications (id,type,internalTitle,author,publisher,exhibitionCode," +
                "bookTitleDisplay,authorDisplay,blurbText,pages,isbnNoHardcover,isbnNoSoftcover,yearPublished," +
                "dimensions,subjectType,relatedConstituent,coPublisherDisplay) VALUES (:id,:type,:internalTitle," +
                ":author,:publisher,:exhibitionCode,:bookTitleDisplay,:authorDisplay,:blurbText,:pages," +
                ":isbnNoHardcover,:isbnNoSoftcover,:yearPublished,:dimensions,:subjectType,:relatedConstituent," +
                ":coPublisherDisplay)";

        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(publication);

        KeyHolder holder = new GeneratedKeyHolder();

        int status = namedJdbcTemplate.update(sql, namedParameters, holder, new String[]{"id"});

        int id = holder.getKey().intValue();

        publication.setId(id);

        return publication;
    }

    /**
     * Updates the edu.si.saam.api.models.Publication using the filled out edu.si.saam.api.models.Publication object.
     *
     * @param publication - edu.si.saam.api.models.Publication object with edu.si.saam.api.models.Publication changes.
     * @return - the updated edu.si.saam.api.models.Publication object
     */
    public Publication updatePublication(Publication publication) {
//        System.out.println(publication.getActionType());
        if(publication.getActionType() != null && "add".equalsIgnoreCase(publication.getActionType().trim())) {
            return addPublication(publication);
        }

//        System.out.println("In updatePublication");

        if (namedJdbcTemplate == null) {
            namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        }

        // if publication exists then continue else go to add.

        String sql = "update publications set type=:type,internalTitle=:internalTitle,author=:author," +
                "publisher=:publisher,exhibitionCode=:exhibitionCode,bookTitleDisplay=:bookTitleDisplay," +
                "authorDisplay=:authorDisplay,blurbText=:blurbText,pages=:pages,isbnNoHardcover=:isbnNoHardcover," +
                "isbnNoSoftcover=:isbnNoSoftcover,yearPublished=:yearPublished,dimensions=:dimensions," +
                "subjectType=:subjectType,relatedConstituent=:relatedConstituent,coPublisherDisplay=:coPublisherDisplay" +
                " where id=:id";

        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(publication);

        int status = namedJdbcTemplate.update(sql, namedParameters);

        return publication;
    }

    /**
     * Deletes an existing edu.si.saam.api.models.Publication
     * @param publication - the edu.si.saam.api.models.Publication to remove.
     * Currently not used.
     */
    public void deletePublication(Publication publication){

        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(publication);

        if (namedJdbcTemplate == null) {
            namedJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        }

        try {

            int satus = namedJdbcTemplate.update("delete from publications where id=:id",
                    namedParameters);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}