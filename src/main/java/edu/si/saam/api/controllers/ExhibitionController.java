package edu.si.saam.api.controllers;

import edu.si.saam.api.models.Exhibition;
import edu.si.saam.api.services.ExhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This controls access to the Exhibition data contained in the smashup DB
 *
 * Created by BrassellRK@si.edu on 7/15/16.
 */
@RestController
public class ExhibitionController {

    @Autowired
    public ExhibitionService es;

    /**
     * Returns a list of exhibitions
     * @param limit - the number of exhibitions to return
     * @param start - the place in the list of results to start
     * @param order - the column you wish to sort the results
     * @return list of exhibitions
     */
    @RequestMapping(path="/exhibitions",method=RequestMethod.GET)
    public List<Exhibition> getAllExhibitions(@RequestParam(value="limit",defaultValue = "20") int limit,
                                           @RequestParam(value="start",defaultValue = "0") int start,
                                           @RequestParam(value="order",defaultValue = "open_date") String order ) {

        // small bit of validation
        if (order.equalsIgnoreCase("open_date") || order.equalsIgnoreCase("location")
                || order.equalsIgnoreCase("end_date"))
        {
            order = " order by " + order + " desc";
        } else {
            order = " order by open_date desc";
        }

        List<Exhibition> results = es.getAllExhibitions(limit, start, order);

        return results;
    }

    /**
     * Returns a requested exhibition
     * @param exhibition_code - passed in on the path, unique code used to locate exhibition data
     * @param request - the request recieved from an agent
     * @return the requested exhibition
     */
    @RequestMapping(path="/exhibitions/{exhibition_code}", method=RequestMethod.GET)
    public Exhibition getExhibition(@PathVariable("exhibition_code") String exhibition_code, HttpServletRequest request) {

        Exhibition ex = new Exhibition();
        ex.setExhibition_code(exhibition_code);

        Exhibition results = es.getExhibition(ex);

        return results;
    }

    /**
     * Updates the information for an exhibition based on passed in form data
     * @param ex - the exhibition with updated exhibition data.
     * @return the updated exhibition
     */
    @RequestMapping(path="/exhibitions", method=RequestMethod.POST)
    public Exhibition updateExhibition(@RequestBody final Exhibition ex) {

        Exhibition results = es.updateExhibition(ex);

        return results;
    }

    /**
     * Removes the specified exhibition
     * @param exhibition_code - passed in on the path, unique code used to locate exhibition to be deleted
     * @param request - the request received from an agent
     * Currently not functional as DELETE is not a supported method at si.edu
     */
    @RequestMapping(path="/exhibitions/{exhibition_code}/delete", method=RequestMethod.DELETE)
    public void deleteExhibition(@PathVariable("exhibition_code") String exhibition_code, HttpServletRequest request) {

        Exhibition ex = new Exhibition();
        ex.setExhibition_code(exhibition_code);

        es.deleteExhibition(ex);
    }
}
