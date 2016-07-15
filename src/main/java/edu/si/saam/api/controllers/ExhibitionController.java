package edu.si.saam.api.controllers;

import edu.si.saam.api.models.Exhibition;
import edu.si.saam.api.services.ExhibitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by richardbrassell on 7/15/16.
 */

@Repository
public class ExhibitionController {

    @Autowired
    public ExhibitionService es;

    /**
     * Returns a list of exhibits
     * @return list of exhibits
     */
    @RequestMapping("/exhibits")
    public List<Exhibition> getAllExhibits() {

        List<Exhibition> results = es.getAllExhibits();

        return results;
    }

}
