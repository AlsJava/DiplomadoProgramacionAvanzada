package edu.aluismarte.diplomado.project.repositories;

import edu.aluismarte.diplomado.project.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author aluis on 6/12/2022.
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID> {
}
