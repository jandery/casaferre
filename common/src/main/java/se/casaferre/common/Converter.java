package se.casaferre.common;

/**
 * Purpose of this class ...
 * <p>
 * Created by Jorgen Andersson (jorgen@kollektiva.se) on 2018-01-29.
 */
@FunctionalInterface
public interface Converter<T, R> {
    R convert(T t);
}
