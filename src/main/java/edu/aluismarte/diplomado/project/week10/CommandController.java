package edu.aluismarte.diplomado.project.week10;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API Rest para probar el comando
 *
 * @author aluis on 6/4/2022.
 */
@RequiredArgsConstructor
@RestController
public class CommandController {

    private final CommandDemoService commandDemoService;

    @GetMapping("/command")
    public ResponseEntity<String> demo() {
        return ResponseEntity.ok(commandDemoService.runDemo());
    }
}
