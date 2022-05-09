package edu.aluismarte.diplomado.week7.vulnerabilities;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aluis on 5/8/2022.
 */
@RestController
public class RemoteCodeExecutionInJson {

    @GetMapping
    public ResponseEntity<String> demo() {
        return ResponseEntity.ok("");
    }
}
