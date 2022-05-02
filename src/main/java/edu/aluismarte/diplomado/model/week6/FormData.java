package edu.aluismarte.diplomado.model.week6;

import edu.aluismarte.diplomado.model.week3.FrequencyType;
import edu.aluismarte.diplomado.model.week3.LoanType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Objeto de prueba para evaluar cada campo
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class FormData {

    @Form(required = false, copyFromDefault = false, preData = false)
    private String fullName;

    @Form(required = true, copyFromDefault = false, emptyValue = "null", preData = true)
    private LoanType loanType;

    @Form(required = true, copyFromDefault = false, emptyValue = "0", preData = true)
    private BigDecimal capital;

    @Form(required = true, copyFromDefault = false, emptyValue = "FrequencyType.MONTHLY", preData = true)
    private FrequencyType frequencyType;

    @Form(required = true, copyFromDefault = true, defaultValue = "12", emptyValue = "1", preData = true)
    private Integer quotes;

    @Form(required = false, copyFromDefault = true, defaultValue = "8.5", emptyValue = "0", preData = true)
    private BigDecimal interest;

    @Form(required = true, copyFromDefault = true, defaultValue = "LocalDate.now()", emptyValue = "null", preData = false)
    private LocalDate startDate;
}
