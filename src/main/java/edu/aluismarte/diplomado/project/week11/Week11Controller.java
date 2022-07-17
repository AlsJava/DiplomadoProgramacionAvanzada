package edu.aluismarte.diplomado.project.week11;

import edu.aluismarte.diplomado.project.week11.model.ExerciseResponse;
import edu.aluismarte.diplomado.project.week11.service.Week11Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aluis on 6/4/2022.
 */
@RestController
@RequiredArgsConstructor
public class Week11Controller {

    private final Week11Service week11Service;

    @GetMapping("/week11")
    public ResponseEntity<ExerciseResponse> exercise(@RequestParam(defaultValue = "0") String explote) {
        return ResponseEntity.ok(week11Service.exercise(explote.equals("1")));
    }
}
