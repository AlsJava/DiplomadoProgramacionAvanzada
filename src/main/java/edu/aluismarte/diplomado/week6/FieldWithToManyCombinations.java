package edu.aluismarte.diplomado.week6;

/**
 * Tendremos un evaluador del formulario del préstamo, donde cada campo seguira las siguientes reglas
 * <p>
 * Cuando un campo es requerido se deja en blanco
 * Cuando un campo no es requerido vemos si se copia de un valor anterior, si no se deja en blanco
 *
 * @author aluis on 4/3/2022.
 */
public class FieldWithToManyCombinations {

    public <T> T formValidation(boolean required, boolean copyFromOldData, T oldDataValue, T emptyValue) {
        if (required) {
            return emptyValue;
        }
        if (copyFromOldData) {
            return oldDataValue;
        }
        return emptyValue;
    }
}
