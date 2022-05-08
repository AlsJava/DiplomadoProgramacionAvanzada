package edu.aluismarte.diplomado.week2;

import edu.aluismarte.diplomado.model.week2.Holiday;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

/**
 * Crear una mejora de cualquiera de los algoritmos optimizados para pasarle los días laborales (no asumir, que llegue como parámetro)
 *
 * @author aluis on 3/27/2022.
 * @implNote Debe tener sus test
 */
public class Homework {

    /**
     * Hacer una implementación propia basado en los ejemplos explicados en clase.
     *
     * @param laborDays Los dias que son laborables, es decir, podemos trabajar de lunes a viernes, de lunes a sábado, o la semana entera, o solo 3 dias a la semana
     * @param holidays  Todos los dias feriados que serán relevantes para el cálculo, tomar en cuenta diciembre para esto, puede que necesites los feriados del año siguiente
     * @param startDate Fecha de inicio para calcular las vacaciones, esta fecha es incluyente, es decir, desde aquí se inicia la vacación
     * @param vacation  La cantidad de día a vacacionar
     * @return La fecha que debe retornar el trabajador
     * @implNote El último día de vacación también cuenta, es decir, que regresa el siguiente dia laboral
     */
    public LocalDate calculateDueDate(List<DayOfWeek> laborDays, List<Holiday> holidays, LocalDate startDate, int vacation) {
        return null;
    }
}
