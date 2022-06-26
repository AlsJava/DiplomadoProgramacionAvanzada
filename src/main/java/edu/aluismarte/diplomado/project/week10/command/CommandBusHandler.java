package edu.aluismarte.diplomado.project.week10.command;

import lombok.RequiredArgsConstructor;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommandBusHandler {

    private final CommandProvider commandProvider;

    @ServiceActivator(inputChannel = "commandChannel")
    public <R> R executeCommand(Command<R> command) {
        return (R) commandProvider.get(command.getClass()).handle(command);
    }
}
