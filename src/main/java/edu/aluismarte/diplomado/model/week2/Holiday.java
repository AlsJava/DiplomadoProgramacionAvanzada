package edu.aluismarte.diplomado.model.week2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Created by Aluis on 10/18/2021.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Holiday {

    private String name;
    private LocalDate date;

}
