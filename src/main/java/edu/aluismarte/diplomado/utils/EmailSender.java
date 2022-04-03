package edu.aluismarte.diplomado.utils;

import lombok.extern.slf4j.Slf4j;
import org.owasp.encoder.Encode;

import java.util.regex.Pattern;

/**
 * @author aluis on 4/3/2022.
 */
@Slf4j
public class EmailSender {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public static boolean sendValidationEmail(String email) {
        if (!patternMatches(email)) {
            log.info("Bad Email Format: {}", Encode.forJava(email));
            return false;
        }
        log.info("Validation sent to {}", Encode.forJava(email)); // Simulate Email Send
        return true;
    }

    private static boolean patternMatches(String emailAddress) {
        return Pattern.compile(EMAIL_REGEX)
                .matcher(emailAddress)
                .matches();
    }
}
