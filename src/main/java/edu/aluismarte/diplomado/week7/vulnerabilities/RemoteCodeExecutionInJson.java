package edu.aluismarte.diplomado.week7.vulnerabilities;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Como puedo hacer ejecución de data remota usando un JSON
 *
 * https://bbossola.wordpress.com/2018/04/14/remotely-execute-java-code-using-json/
 * https://github.com/bbossola/vulnerability-java-samples
 * @author aluis on 5/8/2022.
 */
@RestController
public class RemoteCodeExecutionInJson {

    @GetMapping
    public ResponseEntity<String> demo() {
        return ResponseEntity.ok("");
    }
}
