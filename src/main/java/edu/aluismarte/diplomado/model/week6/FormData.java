package edu.aluismarte.diplomado.model.week6;

import edu.aluismarte.diplomado.model.week3.FrequencyType;
import edu.aluismarte.diplomado.model.week3.LoanType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class FormData {

    private String fullName;
    private LoanType loanType;
    private BigDecimal capital;
    private FrequencyType frequencyType;
    private Integer quotes;
    private BigDecimal interest;
    private LocalDate startDate;
}
