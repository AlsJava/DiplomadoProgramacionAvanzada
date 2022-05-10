package edu.aluismarte.diplomado.week7.vulnerabilities;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author aluis on 5/9/2022.
 */
class RemoteCodeExecutionInJsonTest {

    private final RemoteCodeExecutionInJson remoteCodeExecutionInJson = new RemoteCodeExecutionInJson();

    @Test
    void sendBadJson() throws IOException {
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("AttackScript.json");
        assertNotNull(inputStream);
        String json = new String(inputStream.readAllBytes());
        remoteCodeExecutionInJson.simulatePOSTRequest(json); // Have a attack
    }

}