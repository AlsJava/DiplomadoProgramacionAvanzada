package edu.aluismarte.diplomado.project.domain;

import edu.aluismarte.diplomado.model.project.EmployeeState;
import edu.aluismarte.diplomado.project.week9.Conversions;
import edu.aluismarte.diplomado.project.week9.network.dto.EmployeeDTO;
import edu.aluismarte.diplomado.project.week9.network.request.UpdateEmployeeRequest;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    // Audit Fields, no es necesario exponer esto en la API

    @Column
    private String createdBy;
    @Column
    private String updatedBy;
    @Column
    private LocalDateTime createdAt;
    @Column
    private LocalDateTime updatedAt;

    /**
     * Patrón más integrado y adecuado en la lógica, cada objeto se hace responsable de sus conversiones
     *
     * @return Modelo DTO del Employee
     */
    public EmployeeDTO toDTO() {
        return EmployeeDTO.builder()
                .id(id)
                .name(name)
                .build();
    }

    public void applyChanges(UpdateEmployeeRequest updateEmployeeRequest) {
        this.name = updateEmployeeRequest.getName();
        this.description = updateEmployeeRequest.getDescription();
        this.entryDate = updateEmployeeRequest.getEntryDate();
    }
}
