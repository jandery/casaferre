package se.casaferre.security;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

/**
 * Purpose of this class is validating a cookie to see if this is a value authenticated by Google
 *
 * <p>
 * Created by Jorgen Andersson (jorgen@kollektiva.se) on 2018-02-13.
 */
public class GoogleAuthentication implements IAuthenticate {

    @Override
    public boolean isAuthenticated(String cookieValue) {
        return tokenExistWithGoogle(cookieValue);
    }


    private boolean tokenExistWithGoogle(String token) {
        String googleAuthUrl = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";
        String url = googleAuthUrl + token;

        try {
            Connection.Response response = Jsoup
                    .connect(url)
                    .ignoreContentType(true)
                    .timeout(10000)
                    .method(Connection.Method.GET)
                    .execute();
            //
            return response.statusCode() == 200;
        } catch (IOException e) {
            return false;
        }
    }
}
