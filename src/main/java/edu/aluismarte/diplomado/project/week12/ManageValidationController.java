package edu.aluismarte.diplomado.project.week12;

import edu.aluismarte.diplomado.project.week12.exceptions.NoFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aluis on 6/4/2022.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/week12")
@Slf4j
public class ManageValidationController {


    @GetMapping("/normal")
    public ResponseEntity<String> normal() {
        return ResponseEntity.ok("normal");
    }

    @GetMapping("/bad")
    public ResponseEntity<String> explote() {
        log.info("Explote service");
        throw new NoFoundException("Lalalla");
    }
}
