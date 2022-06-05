package edu.aluismarte.diplomado.project.week9.model;

import edu.aluismarte.diplomado.model.project.DemoResponse;
import edu.aluismarte.diplomado.project.week9.command.Command;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommandDemo extends Command<DemoResponse> {

    private String id;
}
