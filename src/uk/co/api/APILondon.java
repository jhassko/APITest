package uk.co.api;

import jdk.swing.interop.SwingInterOpUtils;
import uk.co.entity.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Path("/london")
public class APILondon {
    @GET
    @Produces("application/json")
    public String doGetAsJson() {
        Client client = ClientBuilder.newClient();
        Response response = client.target("https://bpdts-test-app.herokuapp.com/users").request().get();
        User[] users = response.readEntity(User[].class);

        List<User> listUsers = Arrays.asList(users);
        List<User> result = new ArrayList<>();
        double latitude = 51.509865;
        double longitude = -0.118092;

        System.out.println("List Lenght: " + listUsers.size());

        listUsers.forEach(u -> {
            System.out.print("ID: " + u.getId() + " ");
            if (calculateDistance(latitude, longitude, Double.parseDouble(u.getLatitude()), Double.parseDouble(u.getLongitude())) < 50) {
                result.add(u);
            }
        });

        response = client.target("https://bpdts-test-app.herokuapp.com/city/London/users").request().get();
        users = response.readEntity(User[].class);
        listUsers = Arrays.asList(users);
        listUsers.forEach(u -> {
            if (!result.contains(u)) {
                result.add(u);
            }
        });

        response.close();
        client.close();
        return result.stream().map(User::toString).collect(Collectors.toList()).toString();
    }

    private double calculateDistance(double originLat, double originLon, double destLat, double destLon) {
        // Distance between 2 points

        double dLat = (destLat - originLat) * Math.PI / 180;
        double dLong = (destLon - originLon) * Math.PI / 180;
        double rad = 6378.137;

        double a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(originLat * Math.PI / 180) * Math.sin(dLong/2) * Math.sin(dLong/2);
        double distance = rad * (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)));

        distance = distance * 0.621371;
        return distance;
    }
}
