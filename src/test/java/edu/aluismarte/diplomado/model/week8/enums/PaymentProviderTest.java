package edu.aluismarte.diplomado.model.week8.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author aluis on 6/26/2022.
 */
class PaymentProviderTest {

    @Test
    void mastercardShowWhoIAmTest() {
        String whoIAm = PaymentProvider.MASTERCARD.getPaymentGateway().printWhoIAm();
        System.out.println(whoIAm);
        assertEquals("Yo soy Mastercard", whoIAm);
    }

    @Test
    void paypalShowWhoIAmTest() {
        String whoIAm = PaymentProvider.PAYPAL.getPaymentGateway().printWhoIAm();
        System.out.println(whoIAm);
        assertEquals("Yo soy Paypal", whoIAm);
    }

    @Test
    void visaShowWhoIAmTest() {
        String whoIAm = PaymentProvider.VISA.getPaymentGateway().printWhoIAm();
        System.out.println(whoIAm);
        assertEquals("Yo soy Visa", whoIAm);
    }

    @Test
    void stripeShowWhoIAmTest() {
        String whoIAm = PaymentProvider.STRIPE.getPaymentGateway().printWhoIAm();
        System.out.println(whoIAm);
        assertEquals("Yo soy Stripe", whoIAm);
    }

}