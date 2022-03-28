package edu.aluismarte.diplomado.utils;

import edu.aluismarte.diplomado.model.week2.Holiday;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

/**
 * Created by Aluis on 10/18/2021.
 */
public class Data {

    public static final List<Holiday> HOLIDAYS = List.of(
            new Holiday("Test 1", LocalDate.of(2021, Month.JANUARY, 6)),
            new Holiday("Test 2", LocalDate.of(2021, Month.JANUARY, 7)),
            new Holiday("Test 3", LocalDate.of(2021, Month.JANUARY, 12))
    );
}
