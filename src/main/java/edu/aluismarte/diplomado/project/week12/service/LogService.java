package edu.aluismarte.diplomado.project.week12.service;

import edu.aluismarte.diplomado.project.domain.Log;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.keyvalue.core.KeyValueTemplate;
import org.springframework.data.keyvalue.core.query.KeyValueQuery;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * @author aluis on 7/3/2022.
 */
@RequiredArgsConstructor
@Service
public class LogService {

    private final KeyValueTemplate keyValueTemplate;

    public void save(Log log) {
        keyValueTemplate.insert(log);
    }

    public Optional<Log> get(UUID id) {
        return keyValueTemplate.findById(id, Log.class);
    }

    public Iterable<Log> fetchAll() {
        return keyValueTemplate.findAll(Log.class);
    }

    public void update(Log log) {
        keyValueTemplate.update(log);
    }

    public void delete(UUID id) {
        keyValueTemplate.delete(id, Log.class);
    }

    public Iterable<Log> getSortedListOfLogsBySalary() {
        KeyValueQuery<Log> query = new KeyValueQuery<>();
        query.setSort(Sort.by(Sort.Direction.DESC, "dateTime"));
        return keyValueTemplate.find(query, Log.class);
    }
}
