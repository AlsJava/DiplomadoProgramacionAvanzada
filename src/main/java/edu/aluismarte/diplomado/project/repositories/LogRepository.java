package edu.aluismarte.diplomado.project.repositories;

import edu.aluismarte.diplomado.project.domain.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author aluis on 7/3/2022.
 */
@Repository
public interface LogRepository extends CrudRepository<Log, UUID> {
}
