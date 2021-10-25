package edu.aluismarte.diplomado;

import edu.aluismarte.diplomado.model.Holiday;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * Created by Aluis on 10/18/2021.
 */
public class Data {

    public static final List<Holiday> HOLY_DAYS = List.of(
           new Holiday(2021, LocalDate.of(2021, Month.JANUARY, 3)),
           new Holiday(2021, LocalDate.of(2021, Month.JANUARY, 10)),
           new Holiday(2021, LocalDate.of(2021, Month.JANUARY, 12))
    );
}
