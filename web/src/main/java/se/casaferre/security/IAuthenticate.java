package se.casaferre.security;

/**
 * Purpose of this class ...
 * <p>
 * Created by Jorgen Andersson (jorgen@kollektiva.se) on 2018-02-13.
 */
public interface IAuthenticate {

    boolean isAuthenticated(String cookieValue);
}
