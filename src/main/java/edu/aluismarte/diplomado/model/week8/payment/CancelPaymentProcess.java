package edu.aluismarte.diplomado.model.week8.payment;

/**
 * @author aluis on 4/24/2022.
 */
public interface CancelPaymentProcess<REQUEST, RESPONSE> {

    RESPONSE cancel(REQUEST request);
}
