package edu.aluismarte.diplomado.project.repositories;

import edu.aluismarte.diplomado.project.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author aluis on 6/12/2022.
 */
public interface PaymentRepository extends JpaRepository<Payment, UUID> {
}
