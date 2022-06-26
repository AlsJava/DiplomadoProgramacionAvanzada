package edu.aluismarte.diplomado.project.week11;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aluis on 6/4/2022.
 */
@RestController
@RequiredArgsConstructor
public class SagaController {

    private final SagaDemoService sagaDemoService;

    @GetMapping("/saga")
    public ResponseEntity<String> demo() {
        return ResponseEntity.ok(sagaDemoService.runDemo());
    }
}
