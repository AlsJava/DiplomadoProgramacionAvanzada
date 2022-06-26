package edu.aluismarte.diplomado.week8;

/**
 * Ejemplo funcional del una constante básica
 *
 * @author aluis on 6/4/2022.
 */
public class ConstantDesign {

    /**
     * Forma simple de usar constantes con string
     */
    public static final String PAYPAL_PROVIDER = "PAYPAL";

    /**
     * Forma simple de usar constantes con string
     */
    public static final String STRIPE_PROVIDER = "STRIPE";


    public static final int PAYPAL_CONSTANT = 0;
    public static final int STRIPE_CONSTANT = 1;


    public boolean isValidStringProvider(String provider) {
        if (PAYPAL_PROVIDER.equals(provider)) {
            return true;
        }
        return STRIPE_PROVIDER.equals(provider);
    }

    public boolean isValidIntegerProvider(Integer provider) {
        if (provider == null) {
            return false;
        }
        if (PAYPAL_CONSTANT == provider) {
            return true;
        }
        return STRIPE_CONSTANT == provider;
    }

}
