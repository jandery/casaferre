package se.casaferre.security

/**
 * Purpose of this file is ...
 *
 * Created by Jorgen Andersson on 2018-06-29.
 */
internal interface IAuthenticate {

    fun authenticated(cookieValue: String): Boolean
}
