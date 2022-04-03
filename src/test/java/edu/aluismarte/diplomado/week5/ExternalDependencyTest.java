package edu.aluismarte.diplomado.week5;

import edu.aluismarte.diplomado.model.week5.ValidUser;
import edu.aluismarte.diplomado.utils.EmailSender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * How can a get the validation key in this test?
 *
 * @author aluis on 4/3/2022.
 */
class ExternalDependencyTest {

    private static final ExternalDependency externalDependency = new ExternalDependency();

    @Test
    void sendBadEmailTest() {
        ValidUser validUser = ValidUser.builder().id("1").name("Bad Email").email("hola@@").build();
        assertFalse(externalDependency.sendValidation(validUser));
    }

    @Test
    void sendGoodEmailTest() {
        ValidUser validUser = ValidUser.builder().id("1").name("Bad Email").email("hola@mundo.com").build();
        assertTrue(externalDependency.sendValidation(validUser));
    }

    @Test
    void validateNullUserTest() {
        assertFalse(externalDependency.validateUser(null, ""));
    }

    @Test
    void validateNullUserAndKeyTest() {
        assertFalse(externalDependency.validateUser(null, null));
    }

    @Test
    void validateNullKeyTest() {
        ValidUser validUser = ValidUser.builder().id("1").name("Bad Email").email("hola@mundo.com").build();
        assertFalse(externalDependency.validateUser(validUser, null));
    }

    @Nested
    class TheWayTest {

        private final MockedStatic<EmailSender> emailSenderMockedStatic = Mockito.mockStatic(EmailSender.class);

        @Test
        void validateKeyTest() {
            emailSenderMockedStatic.when(() -> EmailSender.sendValidationEmail(ArgumentMatchers.anyString())).thenReturn(true);
            ExternalDependency externalDependencyMock = Mockito.spy(ExternalDependency.class); // Is spy not Mock
            ValidUser validUser = ValidUser.builder().id("10").name("Good Email").email("hola2@mundo.com").build();
            assertTrue(externalDependencyMock.sendValidation(validUser));
            Mockito.when(externalDependencyMock.validateUser(ArgumentMatchers.any(), ArgumentMatchers.anyString())).thenReturn(true);
            assertTrue(externalDependencyMock.validateUser(validUser, "hola"));
        }

        @Test
        void failEmailTest() {
            emailSenderMockedStatic.when(() -> EmailSender.sendValidationEmail(ArgumentMatchers.anyString())).thenReturn(false);
            assertFalse(EmailSender.sendValidationEmail(""));
        }

        @Test
        void forceGoodEmailTest() {
            emailSenderMockedStatic.when(() -> EmailSender.sendValidationEmail(ArgumentMatchers.anyString())).thenReturn(true);
            assertTrue(EmailSender.sendValidationEmail(""));
        }

        @AfterEach
        void unregister() {
            emailSenderMockedStatic.close();
        }
    }
}