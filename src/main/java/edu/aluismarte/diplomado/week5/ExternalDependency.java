package edu.aluismarte.diplomado.week5;

import edu.aluismarte.diplomado.model.week5.ValidUser;
import edu.aluismarte.diplomado.utils.EmailSender;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author aluis on 4/3/2022.
 */
@Slf4j
public class ExternalDependency {

    private final Map<ValidUser, String> VERIFICATIONS = new HashMap<>();

    public boolean sendValidation(ValidUser validUser) {
        if (validUser == null) {
            return false;
        }
        String key = UUID.randomUUID().toString().replaceAll("-", "");
        if (EmailSender.sendValidationEmail(validUser.getEmail())) {
            VERIFICATIONS.put(validUser, key);
            return true;
        }
        return false;
    }

    public boolean validateUser(ValidUser validUser, String verification) {
        String key = VERIFICATIONS.get(validUser);
        if (key == null || key.isBlank()) {
            return false; // Have to be an exception here
        }
        return verification.equals(key);
    }
}
