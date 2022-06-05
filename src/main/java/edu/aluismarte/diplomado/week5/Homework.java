package edu.aluismarte.diplomado.week5;

import lombok.*;

import java.util.List;

/**
 * ¿Como probar estos métodos?
 * <p>
 * Hacer los test principalmente de los métodos privados
 *
 * @author aluis on 4/3/2022.
 * @implNote Se hace de forma indirecta, no se prueba el método directamente
 * @implSpec La función no esta haciendo bien su trabajo, literalmente no puedo reemplazar la variable con un valor mio.
 * @implSpec solo estoy poniendo el nombre de la variable, lo cual esta mal, pues debe reemplazar por otro valor
 */
public class Homework {

    public String prepareTemplate(List<VarsReplace> varsReplaces, String template) {
        for (VarsReplace varsReplace : varsReplaces) {
            template = replaceVar(template, varsReplace);
        }
        return template;
    }

    // TODO test this method
    private String replaceVar(String template, VarsReplace varsReplace) {
        String var = "\\$\\{" + varsReplace.getVarReplace() + "\\}";
        return template.replaceAll(var, varsReplace.getValue());
    }

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
