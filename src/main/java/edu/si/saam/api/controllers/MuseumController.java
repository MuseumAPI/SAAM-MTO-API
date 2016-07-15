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
 * Created by richardbrassell on 6/3/16.
 */
@RestController
public class MuseumController {

    private static final String template = "%s Museum(s)!";

    @Autowired
    public MuseumService ms;

    @RequestMapping("/museums")
    public List<Museum> getAllMuseums() {

        List<Museum> results = ms.getAllMuseums();

        return results;
    }
}
