package edu.aluismarte.diplomado.project.domain;

import edu.aluismarte.diplomado.utils.MapJsonConverter;
import lombok.*;

import javax.persistence.*;
import java.util.Map;
import java.util.UUID;

/**
 * @author aluis on 6/19/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "logs")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String classOwner;

    @Column
    private String process;

    @Lob
    @Column
    private String parameters;

    @Convert(converter = MapJsonConverter.class)
    private Map<String, String> parameterMap;
}
