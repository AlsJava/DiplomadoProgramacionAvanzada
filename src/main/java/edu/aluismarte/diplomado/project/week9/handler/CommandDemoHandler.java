package edu.aluismarte.diplomado.project.week9.handler;

import edu.aluismarte.diplomado.model.project.DemoResponse;
import edu.aluismarte.diplomado.project.week9.command.CommandEvent;
import edu.aluismarte.diplomado.project.week9.command.CommandHandler;
import edu.aluismarte.diplomado.project.week9.model.CommandDemo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@CommandEvent(command = CommandDemo.class)
public class CommandDemoHandler implements CommandHandler<DemoResponse, CommandDemo> {

    @Override
    public DemoResponse handle(CommandDemo command) {
        System.out.println("Processing command");
        return DemoResponse.builder().result("OK").build();
    }
}
