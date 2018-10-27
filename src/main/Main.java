package main;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import domen.Player;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class Main {

    public static void main(String[] args) throws IOException {

//        File json = new File("igrac2.json");
        Player p = null;

        Client c = ClientBuilder.newClient();
        WebTarget t = c.target("https://jsonplaceholder.typicode.com/posts");
        String json = t.request(MediaType.APPLICATION_JSON).get(String.class);

        ObjectMapper om = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        p = om.readValue(json, Player.class);
        JsonNode node = om.readTree(json).get("seasons").get(0).get("teams").get(0).get("average").get("points");
        int kapacitet = om.readTree(json).get("seasons").get(0).get("teams").size();
        String market = om.readValue(node.get("market").traverse(), String.class);
        String name = om.readValue(node.get("name").traverse(), String.class);
        int founded = om.readValue(node.get("founded").traverse(), Integer.class);
        System.out.println("Team " + market + " " + name + " founded in " + founded + ".");
        System.out.println(node + ", " + kapacitet);

        Calendar datumPocetkaSezone = Calendar.getInstance();
        Calendar datumKrajaSezone = Calendar.getInstance();
        datumPocetkaSezone.set(2017, 1, 26);
        datumKrajaSezone.set(2017, 3, 12);

        while (datumPocetkaSezone.before(datumKrajaSezone)) {
            String godina = String.valueOf(datumPocetkaSezone.get(Calendar.YEAR));
            String mesec = ((datumPocetkaSezone.get(Calendar.MONTH) + 1) < 10) ? "0" + String.valueOf((datumPocetkaSezone.get(Calendar.MONTH) + 1)) : String.valueOf((datumPocetkaSezone.get(Calendar.MONTH) + 1));
            String dan = (datumPocetkaSezone.get(Calendar.DAY_OF_MONTH) < 10) ? "0" + String.valueOf(datumPocetkaSezone.get(Calendar.DAY_OF_MONTH)) : String.valueOf(datumPocetkaSezone.get(Calendar.DAY_OF_MONTH));

            System.out.println("Godina ---> " + godina + ", Mesec ---> " + mesec + ", Dan ---> " + dan);
            datumPocetkaSezone.add(Calendar.DAY_OF_MONTH, 1);
        }
        Map<String, Integer> mapaTimovi = new HashMap<>();
        mapaTimovi.put("Boston Celtics", 17);
        mapaTimovi.put("Los Angeles Lakers", 16);
        mapaTimovi.put("Chicago Bulls", 6);
        mapaTimovi.put("Detroit Pistons", 3);
        mapaTimovi.put("Golden State Warriors", 4);
        mapaTimovi.put("Cleveland Cavaliers", 1);
        mapaTimovi.put("Portland Trail Blazers", 1);
        mapaTimovi.put("New York Knicks", 2);
        mapaTimovi.put("San Antonio Spurs", 5);
        mapaTimovi.put("Houston Rockers", 2);

        mapaTimovi.put("Golden State Warriors", mapaTimovi.get("Golden State Warriors") - 20);
        System.out.println(mapaTimovi.get("Golden State Warriors"));

    }

}
