package edu.aluismarte.diplomado.week8;

import lombok.*;

/**
 * @author aluis on 6/26/2022.
 */
public class ConstantExample {

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    @Setter
    static class Parameters {

        private static final String PARAMETER_ENABLE = "TRUE";
        private static final String PARAMETER_DISABLE = "FALSE";

        private String enableParameter1;
        private String enableParameter2;
        private String enableParameter3;

        public boolean isEnableParameter1() {
            return PARAMETER_ENABLE.equalsIgnoreCase(enableParameter1) ||
                    PARAMETER_DISABLE.equalsIgnoreCase(enableParameter1);
        }
    }
}
