package se.casaferre.web.server;

import com.google.gson.Gson;
import se.casaferre.common.Temperature;
import se.casaferre.common.Volume;

import static spark.Spark.*;

/**
 * Purpose of this file is ...
 * <p>
 * Created by Jorgen Andersson on 2018-01-29.
 */
public class SparkWebServer {

    public static void main(String[] args) {
        //
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
        });
    }
}
