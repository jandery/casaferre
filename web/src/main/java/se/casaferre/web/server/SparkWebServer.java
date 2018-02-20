package se.casaferre.web.server;

import com.google.gson.Gson;
import lombok.val;
import se.casaferre.common.Temperature;
import se.casaferre.common.Volume;
import se.casaferre.config.ConfigVariable;
import se.casaferre.security.GoogleAuthentication;

import java.nio.file.Paths;

import static spark.Spark.*;

/**
 * Purpose of this file is ...
 * <p>
 * Created by Jorgen Andersson on 2018-01-29.
 */
public class SparkWebServer {

    public static void main(String[] args) {
        val currentPath = Paths.get("").toAbsolutePath().toString();

        //
        port(Integer.parseInt(ConfigVariable.getValue(ConfigVariable.PORT)));
        staticFiles.location("/site");
        //
        path("/api", () -> {
            Gson gson = new Gson();
            // Temperatures
            path("/temps", () -> {
                get("/c2f/:degree", (request, response) -> {
                    int degr = Integer.parseInt(request.params(":degree"));
                    return Temperature.centigradeToFahrenheit.convert(degr);
                });
                get("/f2d/:degree", (request, response) -> {
                    int degr = Integer.parseInt(request.params(":degree"));
                    return Temperature.farenheightToCentigrade.convert(degr);
                });
            });
            // Volumes
            path("/volumes", () -> {
                get("/liter/:volume", (request, response) -> {
                    Double volume = Double.parseDouble(request.params(":volume"));
                    return gson.toJson(Volume.setLiter(volume));
                });
            });
            // MID 99
            path("/mid", () -> {
                // Make sure use is authenticated
                before((request, response) -> {
                    String authCookie = request.cookie("midauth");
                    boolean authenticated = new GoogleAuthentication().isAuthenticated(authCookie);
                    // ... check if authenticated
                    if (!authenticated) {
                        halt(401, "You are not welcome here");
                    }
                });

                get("/menu", (request, response) -> {
                    return "";
                });
            });
        });

        System.out.println("*********************************************");
        System.out.println("****  Spark server started on port " + port() + "  ****");
        System.out.println("*********************************************");

        // val path = System.getProperty("user.dir")


    }
}
