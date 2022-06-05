package edu.aluismarte.diplomado.week5;

import lombok.*;

import java.util.List;

/**
 * ¿Como probar estos métodos?
 * <p>
 * Hacer los test principalmente de los métodos privados (Se hace de forma indirecta)
 *
 * Arreglar la lógica de la función, no siempre lo que el cliente pide o la primera implementación funciona adecuadamente
 *
 * @author aluis on 4/3/2022.
 * @implNote Se hace de forma indirecta, no se prueba el método directamente
 * @implSpec La función no está haciendo bien su trabajo, literalmente no puedo reemplazar la variable con un valor mio.
 * @implSpec solo estoy poniendo el nombre de la variable, lo cual está mal, pues debe reemplazar por otro valor
 */
public class Homework {

    // TODO el método como tal, no reemplaza la variable por un texto custom y eso tenemos que arreglarlo

    public String prepareTemplate(List<String> values, String template) {
        for (String value : values) {
            template = replaceVar(template, value);
        }
        return template;
    }

    // TODO test this method
    private String replaceVar(String template, String value) {
        String var = "\\$\\{" + value + "\\}";
        return template.replaceAll(var, value);
    }

    /**
     * Usar esta clase para solucionar el problema de la función
     */
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    @Setter
    public static class VarsReplace {
        private String varReplace;
        private String value;
    }
}
