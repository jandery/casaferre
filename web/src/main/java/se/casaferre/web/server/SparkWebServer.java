package se.casaferre.web.server;

import se.casaferre.common.Convert;

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
            // Temperatures
            path("/temps", () -> {
                get("/c2f/:degree", (request, response) -> {
                    int degr = Integer.parseInt(request.params(":degree"));
                    return Convert.centigradeToFahrenheit.convert(degr);
                });
                get("/f2d/:degree", (request, response) -> {
                    int degr = Integer.parseInt(request.params(":degree"));
                    return Convert.farenheightToCentigrade.convert(degr);
                });
            });
        });
    }
}
