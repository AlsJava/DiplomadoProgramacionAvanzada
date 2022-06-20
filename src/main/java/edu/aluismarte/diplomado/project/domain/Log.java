package edu.aluismarte.diplomado.project.domain;

import lombok.*;

import javax.persistence.*;
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
}
