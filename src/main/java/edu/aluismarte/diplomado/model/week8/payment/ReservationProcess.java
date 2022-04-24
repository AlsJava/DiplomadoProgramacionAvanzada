package edu.aluismarte.diplomado.model.week8.payment;

/**
 * @author aluis on 4/24/2022.
 */
public interface ReservationProcess<REQUEST, RESPONSE> {

    RESPONSE reservation(REQUEST request);
}
