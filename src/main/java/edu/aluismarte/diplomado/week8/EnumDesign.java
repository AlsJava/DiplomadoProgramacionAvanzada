package edu.aluismarte.diplomado.week8;

/**
 * Ejemplo funcional del uso apropiado de un ENUM en los diseños
 *
 * @author aluis on 6/4/2022.
 */
public class EnumDesign {

    public enum PaymentProvider {
        PAYPAL, STRIPE
    }

    public boolean isValidProvider(PaymentProvider paymentProvider) {
        return paymentProvider != null;
    }

}
