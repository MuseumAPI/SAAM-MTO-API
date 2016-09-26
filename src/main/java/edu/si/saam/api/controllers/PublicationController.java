package edu.si.saam.api.controllers;

import edu.si.saam.api.models.Exhibition;
import edu.si.saam.api.models.Publication;
import edu.si.saam.api.services.ExhibitionService;
import edu.si.saam.api.services.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Controller for interacting with publications.
 *
 * Created by richardbrassell on 7/15/16.
 */
@RestController
public class PublicationController {

    @Autowired
    public PublicationService ps;

    /**
     * Returns a list of publications
     * @param limit - the number of publications to return
     * @parma start - the place in the list of results to start
     * @param order - the column you wish to sort the results
     * @return list of publications
     */

    @RequestMapping(path="/publications",method=RequestMethod.GET)
    public List<Publication> getAllPublications(@RequestParam(value="limit",defaultValue = "20") int limit,
                                                @RequestParam(value="start",defaultValue = "0") int start,
                                                @RequestParam(value="order",defaultValue = "yearPublished") String order ) {

        // small bit of validation
        if (order.equalsIgnoreCase("author")
                || order.equalsIgnoreCase("type"))
        {
            order = " order by " + order + " desc";
        } else {
            order = " order by yearPublished desc";
        }

        List<Publication> results = ps.getAllPublications(limit, start, order);

        return results;
    }

    /**
     * Returns the requested publication
     * @return the requested publication
     */
    @RequestMapping(path="/publications/{id}", method=RequestMethod.GET)
    public Publication getPublication(@PathVariable("id") int id, HttpServletRequest request) {

        Publication publication = new Publication();
        publication.setId(id);

        Publication results = ps.getPublication(publication);

        return results;
    }

    /**
     * Updates the information for a publication
     * @return the updated publication
     */
    @RequestMapping(path="/publications", method=RequestMethod.POST)
    public Publication updatePublication(@RequestBody final Publication publication) {

        Publication results = ps.updatePublication(publication);

        return results;
    }

    /**
     * Removes the specified exhibition
     */
    @RequestMapping(path="/publications/{id}/delete", method=RequestMethod.GET)
    public void deletePublication(@PathVariable("id") int id, HttpServletRequest request) {

        Publication publication = new Publication();
        publication.setId(id);

        ps.deletePublication(publication);
    }
}
