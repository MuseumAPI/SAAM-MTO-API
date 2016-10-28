package edu.si.saam.api.controllers;

import edu.si.saam.api.models.Museum;
import edu.si.saam.api.services.MuseumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * This is a test controller to provide museum information.
 * May revisit once we start talking about feeding site info to the CMS.
 * Using a unified data location means we can alter it on one place as opposed
 * to editing in multiple places.
 * Created by BrassellRK@si.edu on 6/3/16.
 */
@RestController
public class MuseumController {

    private static final String template = "%s Museum(s)!";

    @Autowired
    public MuseumService ms;

    /**
     * Retrieves a list of museums from the DataSource
     * @return - list of museums.
     */
    @RequestMapping("/museums")
    public List<Museum> getAllMuseums() {

        List<Museum> results = ms.getAllMuseums();

        return results;
    }
}
