package edu.aluismarte.diplomado.project.week10.command;

import lombok.RequiredArgsConstructor;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandBus {

    private final MessagingTemplate messagingTemplate;
    private final MessageChannel commandChannel;

    public <R, C> R sendCommand(C command) {
        return (R) messagingTemplate.sendAndReceive(commandChannel, new GenericMessage<>(command)).getPayload();
    }
}
