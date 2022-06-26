package edu.aluismarte.diplomado.project.domain;

import edu.aluismarte.diplomado.model.project.EmployeeState;
import edu.aluismarte.diplomado.project.week9.Conversions;
import edu.aluismarte.diplomado.project.week9.network.dto.EmployeeDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author aluis on 6/12/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private LocalDate entryDate;

    /**
     * Conversión del enum para la DB en un número
     */
    @Convert(converter = Conversions.EmployeeStateConverter.class)
    @Column
    private EmployeeState state;


    /**
     * Patrón más integrado y adecuado en la lógica, cada objeto se ahce responsable de sus conversiones
     *
     * @return Modelo DTO del Employee
     */
    public EmployeeDTO toDTO() {
        return EmployeeDTO.builder()
                .id(id)
                .name(name)
                .build();
    }
}
