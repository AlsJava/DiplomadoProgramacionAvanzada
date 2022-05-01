package edu.aluismarte.diplomado.week2;

import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;

/**
 * Uso de logs
 * <p>
 * Created by Aluis on 10/17/2021.
 */
@NoArgsConstructor
public class LogDemo {

    private static final Logger logger = LoggerFactory.getLogger(LogDemo.class);

    public void demoLog() {
        try {
            SecureRandom secureRandom = new SecureRandom();

            int a = 20;
            int b = secureRandom.nextInt();

            double c = a * b;

            System.out.printf("AxB is equals to %s%n", c);
            logger.info("AxB is equals to {}", c);

            throw new Exception("Hello Exception");
        } catch (Exception ex) {
            logger.error("Get a exception", ex);
        }
    }

    public static void main(String[] args) {
        LogDemo logDemo = new LogDemo();
        logDemo.demoLog();
        System.out.println("Finish");
    }
}
