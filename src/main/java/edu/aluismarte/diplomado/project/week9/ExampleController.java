package edu.aluismarte.diplomado.project.week9;

import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Ejemplo de como crear un controlador con sus diversos métodos
 *
 * @author aluis on 6/26/2022.
 */
@RestController
public class ExampleController {

    @GetMapping("/example/demo/{id}")
    public ResponseEntity<String> demoPath(@PathVariable String id) {
        return ResponseEntity.ok("Tengo el ID: " + id);
    }

    @PostMapping("/example/demo")
    public ResponseEntity<String> demoPost(@RequestBody DemoRequest demoRequest) {
        return ResponseEntity.ok("Tengo el objeto: " + demoRequest);
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    static class DemoRequest {
        private String id;
        private Long number;
    }
}
