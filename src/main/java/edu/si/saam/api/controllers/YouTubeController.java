package edu.si.saam.api.controllers;

import edu.si.saam.api.models.Exhibition;
import edu.si.saam.api.models.YouTube;
import edu.si.saam.api.services.ExhibitionService;
import edu.si.saam.api.services.YouTubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lapank@si.edu on 9/29/16.
 *
 */
@RestController
public class YouTubeController {

    @Autowired
    public YouTubeService es;

    /**
     * Returns a list of youtube
     * @param limit - the number of youtube to return
     * @param start - the place in the list of results to start
     * @param order - the column you wish to sort the results
     * @return list of youtube
     */

    @RequestMapping(path="/youtube",method= RequestMethod.GET)
    public List<YouTube> getAllYouTube(@RequestParam(value="limit",defaultValue = "20") int limit,
                                       @RequestParam(value="start",defaultValue = "0") int start,
                                       @RequestParam(value="order",defaultValue = "uploadDate") String order ) {

        // small bit of validation
        if (order.equalsIgnoreCase("uploadDate"))
        {
            order = " order by " + order + " desc";
        } else {
            order = "";
        }

        List<YouTube> results = es.getAllYouTube(limit, start, order);

        return results;
    }

    /**
     * Returns a requested youtube
     * @param id - set on the path, the id used to find the youtube to display
     * @param request - the request received from an agent
     * @return the requested youtube
     */
    @RequestMapping(path="/youtube/{id}", method=RequestMethod.GET)
    public YouTube getYouTube(@PathVariable("id") String id, HttpServletRequest request) {

        YouTube ex = new YouTube();
        ex.setId(id);

        YouTube results = es.getYouTube(ex);

        return results;
    }

    /**
     * Updates the information for an YouTube
     * @param ex - the youtube with updated information to be saved
     * @return the updated YouTube
     */
    @RequestMapping(path="/youtube", method=RequestMethod.POST)
    public YouTube updateYouTube(@RequestBody final YouTube ex) {

        YouTube results = es.updateYouTube(ex);

        return results;
    }

    /**
     * Removes the specified YouTube
     * @param id - set on the path, the id used to locate the youtube to be deleted.
     * @param request - the request received from an agent
     * Currently not functional as DELETE is not a supported method at si.edu
     */
    @RequestMapping(path="/youtube/{id}/delete", method=RequestMethod.DELETE)
    public void deleteYouTube(@PathVariable("id") String id, HttpServletRequest request) {

        YouTube ex = new YouTube();
        ex.setId(id);

        es.deleteYouTube(ex);
    }

}