package edu.aluismarte.diplomado.week7.vulnerabilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.aluismarte.diplomado.model.week7.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;

/**
 * Como puedo hacer ejecución de data remota usando un JSON
 *
 * Ejemplo escrito en Spark Java
 *
 * @author aluis on 5/8/2022.
 * @see <a href="https://bbossola.wordpress.com/2018/04/14/remotely-execute-java-code-using-json/">remotely-execute-java-code-using-json</a>
 * @see <a href="https://github.com/bbossola/vulnerability-java-samples">vulnerability-java-samples</a>
 */
public class RemoteCodeExecutionInJson {

    private static final Logger log = LoggerFactory.getLogger(RemoteCodeExecutionInJson.class);

    private static final List<Account> ACCOUNTS = new ArrayList<>();

    private static ObjectMapper deserializer = new ObjectMapper().enableDefaultTyping();
    private static ObjectMapper serializer = new ObjectMapper();

    public static void main(String[] args) {
        port(8888);
        get("/accounts", (request, response) -> {
            log.info("/accounts -> {}", ACCOUNTS);
            return serializer.writeValueAsString(ACCOUNTS);
        });

        post("/accounts", (request, response) -> {
            log.info("/accounts -> {}", request.body());
            Account account = deserialize(request);
            if (account != null) {
                ACCOUNTS.add(account);
                response.status(201);
                return serializer.writeValueAsString(account);
            } else {
                response.status(400);
                return "Invalid content";
            }
        });
    }

    private static Account deserialize(Request request) {
        try {
            return deserializer.readValue(request.body(), Account.class);
        } catch (Exception any) {
            log.warn("Unexpected exception deserializing content: {}", any.getClass());
            return null;
        }
    }
}
