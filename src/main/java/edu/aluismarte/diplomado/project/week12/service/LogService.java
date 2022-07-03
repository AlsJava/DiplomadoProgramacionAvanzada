package edu.aluismarte.diplomado.project.week12.service;

import edu.aluismarte.diplomado.project.domain.Log;
import edu.aluismarte.diplomado.project.repositories.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * @author aluis on 7/3/2022.
 */
@RequiredArgsConstructor
@Service
public class LogService {

    private final LogRepository logRepository;

    public void save(Log log) {
        logRepository.save(log);
    }

    public Iterable<Log> fetchAll() {
        return logRepository.findAll();
    }

    public Optional<Log> get(UUID id) {
        return logRepository.findById(id);
    }

    public void update(Log log) {
        logRepository.save(log);
    }

    public void delete(UUID id) {
        logRepository.deleteById(id);
    }
}
