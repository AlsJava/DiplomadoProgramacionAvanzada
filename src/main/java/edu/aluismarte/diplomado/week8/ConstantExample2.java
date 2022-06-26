package edu.aluismarte.diplomado.week8;

import lombok.*;

import java.math.BigDecimal;

/**
 * Uso de constantes porque no se usó el ENUM en el diseño y se apegó demasiado la app a una DB
 *
 * @author aluis on 6/26/2022.
 */
public class ConstantExample2 {

    public static final int UNPAID = 1;
    public static final int PAID = 2;
    public static final int HOLD = 3; // Lo adiciono 3 meses después porque queremos cotizaciones

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    @Setter
    static class Invoice {

        private Long id;
        private InvoiceState state;
        private BigDecimal amount;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    @Setter
    static class InvoiceState {

        // SELECT id FROM invoice_states;
        // SELECT * FROM invoice_states WHERE id = ?;

        private Long id;
        private String name;
        private String description;
    }

    public static void demo() {
        Invoice invoice = Invoice.builder()
                .id(1L)
                .state(InvoiceState.builder().id(1L).description("Unpaid").build())
                .amount(new BigDecimal(50))
                .build();
        payInvoice(invoice);
    }

    public static void payInvoice(Invoice invoice) {
        if (UNPAID == invoice.state.id) {
            System.out.println("La pagamos");
        } else {
            System.out.println("Notificamos que la factura ya esta paga");
        }
    }
}
