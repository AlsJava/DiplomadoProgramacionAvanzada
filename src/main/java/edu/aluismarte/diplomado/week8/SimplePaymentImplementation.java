package edu.aluismarte.diplomado.week8;

import edu.aluismarte.diplomado.model.week8.ServicePaypal;
import edu.aluismarte.diplomado.model.week8.ServiceStripe;
import edu.aluismarte.diplomado.model.week8.network.*;

import java.util.UUID;

/**
 * Implementación común de un sistema de pago con multiples proveedores
 * <p>
 * Esta forma es de un novato y demuestra que no se sabe usar el concepto de objetos y delegación de responsabilidad del SOLID
 *
 * @author aluis on 4/24/2022.
 */
public class SimplePaymentImplementation {

    public PaymentResponse pay(PaymentRequest paymentRequest) {
        PaymentResponse paymentResponse = PaymentResponse.builder().id(UUID.randomUUID().toString()).build();
        switch (paymentRequest.getProvider()) {
            case "STRIPE" -> paymentResponse.setStatus(ServiceStripe.pay(paymentResponse.getId(), paymentRequest.getAmount()));
            case "PAYPAL" -> paymentResponse.setStatus(ServicePaypal.pay(paymentResponse.getId(), paymentRequest.getAmount()));
            default -> paymentResponse.setId(null);
        }
        return paymentResponse;
    }

    public CancelPaymentResponse cancel(CancelPaymentRequest cancelPaymentRequest) {
        CancelPaymentResponse cancelPaymentResponse = CancelPaymentResponse.builder().build();
        switch (cancelPaymentRequest.getProvider()) {
            case "STRIPE" -> cancelPaymentResponse.setStatus(ServiceStripe.cancel(cancelPaymentRequest.getId()));
            case "PAYPAL" -> cancelPaymentResponse.setStatus(ServicePaypal.cancel(cancelPaymentRequest.getId()));
        }
        return cancelPaymentResponse;
    }

    public RefundPaymentResponse refund(RefundPaymentRequest refundPaymentRequest) {
        RefundPaymentResponse refundPaymentResponse = RefundPaymentResponse.builder().build();
        switch (refundPaymentRequest.getProvider()) {
            case "STRIPE" ->
                    refundPaymentResponse.setStatus(ServiceStripe.refund(refundPaymentRequest.getId(), refundPaymentRequest.getAmount()));
            case "PAYPAL" ->
                    refundPaymentResponse.setStatus(ServicePaypal.refund(refundPaymentRequest.getId(), refundPaymentRequest.getAmount()));
        }
        return refundPaymentResponse;
    }
}
