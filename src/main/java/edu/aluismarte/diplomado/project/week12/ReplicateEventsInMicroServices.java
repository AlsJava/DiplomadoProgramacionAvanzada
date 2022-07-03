package edu.aluismarte.diplomado.project.week12;

import lombok.extern.slf4j.Slf4j;

/**
 * A veces el DEBUG no es suficiente, necesitamos saber que ocurre con un proceso con ciertos eventos
 * <p>
 * Por lo que haremos un follo que permitirá hacer nuevamente el proceso con tal de replicar paso a paso
 *
 * @author aluis on 6/26/2022.
 */
@Slf4j
public class ReplicateEventsInMicroServices {

    // TODO Hacer esto con la implementación del Objeto de LOG, que ya esta hecha, solo falta aplicar

    public void step1(int number) {
        log.info("Process {} step 1, with parameters: {}", "Demo", number);
    }

    public void step2(String data) {
        log.info("Process {} step 2, with parameters: {}", "Demo", data);

    }

    public void step3(int number, String data) {
        log.info("Process {} step 3, with parameters: {}, {}", "Demo", number, data);
    }

    public static void main(String[] args) {
        ReplicateEventsInMicroServices replicateEventsInMicroServices = new ReplicateEventsInMicroServices();
        replicateEventsInMicroServices.step1(1);
        replicateEventsInMicroServices.step2("Hola");
        replicateEventsInMicroServices.step3(5, "Mundo");
    }
}
