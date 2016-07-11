package edu.si.saam.api.models;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by richard on 7/7/16.
 */
public class MuseumUnitTests {

    @Test
    public void gettersAndSettersTest() {

        Museum m = new Museum();
        m.setHours("hours");
        m.setName("name");
        m.setAddress("address");
        m.setDays_off("days_off");
        m.setEmergency_message("message");
        m.setEmergency_message_on(false);
        m.setUrl("url");

        Assert.assertEquals("hours", m.getHours());
        Assert.assertEquals("name", m.getName());
        Assert.assertEquals("address", m.getAddress());
        Assert.assertEquals("days_off", m.getDays_off());
        Assert.assertEquals("message", m.getEmergency_message());
        Assert.assertEquals(false, m.isEmergency_message_on());

    }
}
