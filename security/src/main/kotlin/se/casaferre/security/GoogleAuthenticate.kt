package se.casaferre.security

import org.jsoup.Connection
import org.jsoup.Jsoup

/**
 * Purpose of this class is validating a cookie to see if this is a value authenticated by Google
 *
 * Created by Jorgen Andersson on 2018-06-29.
 */
class GoogleAuthentication : IAuthenticate {

    override fun authenticated(cookieValue: String): Boolean {
        return tokenExistWithGoogle(cookieValue)
    }

    private fun tokenExistWithGoogle(token: String): Boolean {
        val googleAuthUrl = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=$token"

        val response = Jsoup
                .connect(googleAuthUrl)
                .ignoreContentType(true)
                .timeout(10000)
                .method(Connection.Method.GET)
                .execute();
        //
        return response.statusCode() == 200;

    }

}