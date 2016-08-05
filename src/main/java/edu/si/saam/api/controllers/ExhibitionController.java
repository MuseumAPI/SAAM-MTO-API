package edu.si.saam.api.controllers;

import edu.si.saam.api.models.Exhibition;
import edu.si.saam.api.services.ExhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by richardbrassell on 7/15/16.
 */
@RestController
public class ExhibitionController {

    @Autowired
    public ExhibitionService es;

    /**
     * Returns a list of exhibits
     * @param limit - the number of exhibitions to return
     * @parma start - the place in the list of results to start
     * @param order - the column you wish to sort the results
     * @return list of exhibits
     */
    @RequestMapping(path="/exhibits",method=RequestMethod.GET)
    public List<Exhibition> getAllExhibits(@RequestParam(value="limit",defaultValue = "20") int limit,
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
     * Returns a requested exhibit
     * @return the requested exhibit
     */
    @RequestMapping(path="/exhibits/{exhibit_code}", method=RequestMethod.GET)
    public Exhibition getExhibition(@PathVariable("exhibit_code") String exhibition_code, HttpServletRequest request) {

        Exhibition ex = new Exhibition();
        ex.setExhibit_code(exhibition_code);

        Exhibition results = es.getExhibition(ex);

        return results;
    }

    @RequestMapping(path="/exhibits",method=RequestMethod.POST)
    public Exhibition addExhibition(@RequestBody Exhibition ex)
    {
        // pull the posted json data out of the request.

        Exhibition results  = es.addExhibition(ex);

        return results;
    }

    /**
     * Updates the information for an exhibit
     * @return the updated exhibition
     */
    @RequestMapping(path="/exhibits", method=RequestMethod.PUT)
    public Exhibition updateExhibition(@RequestBody final Exhibition ex) {

        Exhibition results = es.updateExhibition(ex);

        return results;
    }

    /**
     * Removes the specified exhibit
     */
    @RequestMapping(path="/exhibits/{exhibit_code}", method=RequestMethod.DELETE)
    public void deleteExhibition(@PathVariable("exhibit_code") String exhibition_code, HttpServletRequest request) {

        Exhibition ex = new Exhibition();
        ex.setExhibit_code(exhibition_code);

        es.deleteExhibition(ex);
    }


}
