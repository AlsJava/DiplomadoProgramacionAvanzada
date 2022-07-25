package edu.aluismarte.diplomado.project.week12;

import edu.aluismarte.diplomado.project.domain.LogEvent;
import edu.aluismarte.diplomado.project.week12.service.LogEventService;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.*;

/**
 * A veces el DEBUG no es suficiente, necesitamos saber que ocurre con un proceso con ciertos eventos
 * <p>
 * Por lo que haremos un follo que permitirá hacer nuevamente el proceso con tal de replicar paso a paso
 *
 * @author aluis on 6/26/2022.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class ReplicateEventsInMicroServices {

    private final LogEventService logEventService;

    @GetMapping("/log/events/prepare")
    public ResponseEntity<String> callLogEvent() {
        ParameterEvent parameterEvent = ParameterEvent.builder()
                .id(UUID.randomUUID().toString())
                .parameters(new HashMap<>())
                .build();
        step1(parameterEvent);
        step2(parameterEvent);
        step3(parameterEvent);
        return ResponseEntity.ok("Ready");
    }

    @GetMapping("/log/events")
    public ResponseEntity<List<LogEvent>> listEvents() {
        List<LogEvent> logEvents = new ArrayList<>();
        for (LogEvent logEvent : logEventService.fetchAll()) {
            logEvents.add(logEvent);
        }
        return ResponseEntity.ok(logEvents);
    }

    public void step1(ParameterEvent parameterEvent) {
        log.info("Process step 1");
        logEventService.save(LogEvent.builder()
                .classOwner(getClass())
                .process("Demo 1")
                .parametersMap(Map.of("step1", parameterEvent))
                .build());
    }

    public void step2(ParameterEvent parameterEvent) {
        log.info("Process step 2");
        parameterEvent.getParameters().put("Random Value", "Holaaaaa");
        logEventService.save(LogEvent.builder()
                .classOwner(getClass())
                .process("Demo 1")
                .parametersMap(Map.of("step2", parameterEvent))
                .build());
    }

    public void step3(ParameterEvent parameterEvent) {
        log.info("Process step 3");
        parameterEvent.getParameters().put("Step 3 value", "Mundo");
        logEventService.save(LogEvent.builder()
                .classOwner(getClass())
                .process("Demo 1")
                .parametersMap(Map.of("step3", parameterEvent))
                .build());
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Getter
    @Setter
    private static class ParameterEvent implements Serializable {

        private String id;
        private Map<String, String> parameters;
    }
}
