package edu.aluismarte.diplomado.model.week8;

import edu.aluismarte.diplomado.model.week8.payment.PaymentGateway;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Elemento común para simular a stripe, normalmente esto se hace con la API que la misma empresa provee
 *
 * @author aluis on 4/24/2022.
 * @implNote Demostration class only
 */
public class StripeService implements PaymentGateway {

    private static final Map<String, Payment> PAYMENTS = new HashMap<>();

    @Override
    public String pay(String id, BigDecimal amount) {
        if (amount == null) {
            return "FAIL_DATA";
        }
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            return "NO_BALANCE";
        }
        PAYMENTS.put(id, Payment.builder().id(id).amount(amount).build());
        return "OK";
    }

    @Override
    public String cancel(String id) {
        if (id == null || id.isBlank()) {
            return "BAD_ID";
        }
        Payment payment = PAYMENTS.get(id);
        if (payment == null) {
            return "NO_FOUND";
        }
        payment.setCancel(true);
        return "OK";
    }

    @Override
    public String refund(String id, BigDecimal amount) {
        if (id == null || id.isBlank()) {
            return "BAD_ID";
        }
        Payment payment = PAYMENTS.get(id);
        if (payment == null) {
            return "NO_FOUND";
        }
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            return "CANT_REFUND";
        }
        if (payment.getRefund().add(amount).compareTo(payment.getAmount()) > 0) {
            return "CANT_REFUND";
        }
        payment.setRefund(payment.getRefund().add(amount));
        return "OK";
    }

    @Override
    public String printWhoIAm() {
        return "Yo soy Stripe";
    }
}
