package edu.aluismarte.diplomado.project.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.keyvalue.annotation.KeySpace;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

/**
 * Este objeto no es un Domain de DB, es un hack para mostrar rápida un log progresivo
 *
 * @author aluis on 6/19/2022.
 * @implNote Debería usarse un redis o incluso un kafka table para este caso con un simple POJO
 * @see <a href="https://www.baeldung.com/spring-data-key-value">Spring Key-Value API</a>
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@KeySpace("logEvents")
public class LogEvent implements Serializable {

    @Id
    @Builder.Default
    private UUID id = UUID.randomUUID();

    @Builder.Default
    private LocalDateTime dateTime = LocalDateTime.now();

    private Class<?> classOwner;

    private UUID processId;

    private String process;

    private Map<String, Object> parametersMap;
}
