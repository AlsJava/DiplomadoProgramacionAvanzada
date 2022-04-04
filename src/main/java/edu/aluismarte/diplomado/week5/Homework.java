package edu.aluismarte.diplomado.week5;

import java.util.List;

/**
 * Como probar estos métodos?
 *
 * @author aluis on 4/3/2022.
 */
public class Homework {

    public String prepareTemplate(List<String> values, String template) {
        for (String value : values) {
            template = replaceVar(template, value);
        }
        return template;
    }

    // TODO test this method
    private String replaceVar(String template, String value) {
        String var = "${" + value + "}";
        return template.replaceAll(var, value);
    }
}
