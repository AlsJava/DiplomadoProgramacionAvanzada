package edu.aluismarte.diplomado.week6;

/**
 * Convertir el ejemplo en un test dinámico o parametrizado, con tal de mejorar su forma de prueba si las reglas cambian
 * <p>
 * Si el campo es requerido se retorna en blanco, pero solo si el valor preData es NULL
 * Si el valor no es requerido pero pide un valor default se retorna el valor default, de lo contrario vacío
 *
 * @author aluis on 4/3/2022.
 * @implNote Tomar en cuenta cada campo del objeto edu.aluismarte.diplomado.model.week6.FormData
 */
public class HomeWork {

    public <T> T formValidation(boolean required, boolean useDefaultValue, T preDataValue, T defaultValue, T emptyValue) {
        if (required) {
            if (preDataValue != null) {
                return preDataValue;
            }
            return emptyValue;
        }
        if (useDefaultValue) {
            // TODO el cliente pide que si es null, no se retorne y se lleve el emptyValue
//            if (defaultValue != null) {
//                return defaultValue;
//            }
            return defaultValue;
        }
        return emptyValue;
    }

}
