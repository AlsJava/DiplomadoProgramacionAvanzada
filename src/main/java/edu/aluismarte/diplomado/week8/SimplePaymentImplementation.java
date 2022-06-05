package edu.aluismarte.diplomado.week8;

import edu.aluismarte.diplomado.model.week8.Paypal;
import edu.aluismarte.diplomado.model.week8.Stripe;
import edu.aluismarte.diplomado.model.week8.network.*;

import java.util.UUID;

/**
 * Implementación común de un sistema de pago con multiples proveedores
 *
 * @author aluis on 4/24/2022.
 */
public class SimplePaymentImplementation {

    public PaymentResponse pay(PaymentRequest paymentRequest) {
        PaymentResponse paymentResponse = PaymentResponse.builder().id(UUID.randomUUID().toString()).build();
        switch (paymentRequest.getProvider()) {
            case "STRIPE" -> paymentResponse.setStatus(Stripe.pay(paymentResponse.getId(), paymentRequest.getAmount()));
            case "PAYPAL" -> paymentResponse.setStatus(Paypal.pay(paymentResponse.getId(), paymentRequest.getAmount()));
            default -> paymentResponse.setId(null);
        }
        return paymentResponse;
    }

    public CancelPaymentResponse cancel(CancelPaymentRequest cancelPaymentRequest) {
        CancelPaymentResponse cancelPaymentResponse = CancelPaymentResponse.builder().build();
        switch (cancelPaymentRequest.getProvider()) {
            case "STRIPE" -> cancelPaymentResponse.setStatus(Stripe.cancel(cancelPaymentRequest.getId()));
            case "PAYPAL" -> cancelPaymentResponse.setStatus(Paypal.cancel(cancelPaymentRequest.getId()));
        }
        return cancelPaymentResponse;
    }

    public RefundPaymentResponse refund(RefundPaymentRequest refundPaymentRequest) {
        RefundPaymentResponse refundPaymentResponse = RefundPaymentResponse.builder().build();
        switch (refundPaymentRequest.getProvider()) {
            case "STRIPE" ->
                    refundPaymentResponse.setStatus(Stripe.refund(refundPaymentRequest.getId(), refundPaymentRequest.getAmount()));
            case "PAYPAL" ->
                    refundPaymentResponse.setStatus(Paypal.refund(refundPaymentRequest.getId(), refundPaymentRequest.getAmount()));
        }
        return refundPaymentResponse;
    }
}
