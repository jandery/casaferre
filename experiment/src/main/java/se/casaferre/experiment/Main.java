package se.casaferre.experiment;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Purpose of this class ...
 * <p>
 * Created by Jorgen Andersson (jorgen@kollektiva.se) on 2018-07-27.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        // create a script engine manager
        ScriptEngineManager factory = new ScriptEngineManager();
        // create a JavaScript engine
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        // evaluate JavaScript code from String
        engine.eval("print('Welocme to java world')");
    }
}
