package edu.si.saam.api.models;

/**
 * Created by richardbrassell on 6/3/16.
 */
public class Museum {
    private String name;
    private String address;
    private String hours;
    private String days_off;
    private String emergency_message;
    private boolean emergency_message_on;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getDays_off() {
        return days_off;
    }

    public void setDays_off(String days_off) {
        this.days_off = days_off;
    }

    public String getEmergency_message() {
        return emergency_message;
    }

    public void setEmergency_message(String emergency_message) {
        this.emergency_message = emergency_message;
    }

    public boolean isEmergency_message_on() {
        return emergency_message_on;
    }

    public void setEmergency_message_on(boolean emergency_message_on) {
        this.emergency_message_on = emergency_message_on;
    }
}
