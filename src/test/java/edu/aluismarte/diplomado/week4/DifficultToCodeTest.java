package edu.aluismarte.diplomado.week4;

import edu.aluismarte.diplomado.model.week4.User;
import edu.aluismarte.diplomado.utils.DBSimulator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Writer;

/**
 * @author aluis on 3/27/2022.
 */
public class DifficultToCodeTest {

    private final DifficultToCode difficultToCode = new DifficultToCode();

    @Test
    void calculateUserAgeOnDaysTest() {
        difficultToCode.writeUserName("1"); // What can i test?
    }

    @RequiredArgsConstructor
    public class Refactory {

        private final DBSimulator dbSimulator;

        public boolean writeUserName(String id, Writer writer) {
            User user = this.dbSimulator.findUser(id);
            try {
                writer.write(user.getName());
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
    }
}
