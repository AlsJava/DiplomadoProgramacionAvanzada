package edu.aluismarte.diplomado.model.week8.payment;

/**
 * Ejemplo de interfaz de responsabilidad única
 *
 * @author aluis on 4/24/2022.
 */
public interface PaymentProcess<REQUEST, RESPONSE> {

    RESPONSE pay(REQUEST request);
}
