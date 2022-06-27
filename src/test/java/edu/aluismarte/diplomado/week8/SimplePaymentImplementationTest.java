package edu.aluismarte.diplomado.week8;

import edu.aluismarte.diplomado.model.week8.network.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Test simples, inicialmente, más luego se completan los escenarios deseados
 *
 * @author aluis on 6/19/2022.
 */
class SimplePaymentImplementationTest {

    private final SimplePaymentImplementation simplePaymentImplementation = new SimplePaymentImplementation();

    private String lastPayment;

    @Test
    void payTest() {
        PaymentRequest paymentRequest = PaymentRequest.builder()
                .provider("STRIPE")
                .amount(new BigDecimal(20))
                .build();
        PaymentResponse paymentResponse = simplePaymentImplementation.pay(paymentRequest);
        assertNotNull(paymentResponse);
        lastPayment = paymentResponse.getId();
    }

    @Test
    void cancelTest() {
        CancelPaymentRequest cancelPaymentRequest = CancelPaymentRequest.builder()
                .provider("STRIPE")
                .id(lastPayment)
                .build();
        CancelPaymentResponse cancelPaymentResponse = simplePaymentImplementation.cancel(cancelPaymentRequest);
        assertNotNull(cancelPaymentResponse);
    }

    @Test
    void refundTest() {
        RefundPaymentRequest refundPaymentRequest = RefundPaymentRequest.builder()
                .provider("STRIPE")
                .id(lastPayment)
                .amount(new BigDecimal(10))
                .build();
        RefundPaymentResponse refundPaymentResponse = simplePaymentImplementation.refund(refundPaymentRequest);
        assertNotNull(refundPaymentResponse);
    }
}