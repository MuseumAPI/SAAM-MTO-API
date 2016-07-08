package edu.si.saam.api.services;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by richard on 6/9/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/mock_application.properties" })
public class MuseumServiceTest {

    @Autowired
    private MuseumService ms;

    @Test
    public void getAllMuseumsTest() {

    }

    @Test
    public void setEmergencyMessageTest() {

    }
}
