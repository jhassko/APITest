package uk.co.entity;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String ipAddress;
    private String latitude;
    private String longitude;
    private String city;

    @JsonbCreator
    public User(
            @JsonbProperty("id") int id, @JsonbProperty("first_name") String firsName, @JsonbProperty("last_name") String lastName,
            @JsonbProperty("email") String email, @JsonbProperty("ip_address") String ipAddress, @JsonbProperty("latitude") String latitude,
            @JsonbProperty("longitude") String longitude) {
        this.id = id;
        this.firstName = firsName;
        this.lastName = lastName;
        this.email = email;
        this.ipAddress = ipAddress;
        this.latitude = latitude;
        this.longitude = longitude;
    }

//    @JsonbCreator
//    public User(int id, String firstName, String lastName, String email, String ipAddress, String latitude, String longitude, String city) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.ipAddress = ipAddress;
//        this.latitude = latitude;
//        this.longitude = longitude;
//        this.city = city;
//    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "{ \"id\": " + this.id +
               " \"first_name\": " + this.firstName +
               " \"last_name\": " + this.lastName +
               " \"email\": " + this.email +
               " \"ip_address\": " + this.ipAddress +
               " \"latitude\": " + this.latitude +
               " \"longitude\": " + this.longitude + "}";
    }
}