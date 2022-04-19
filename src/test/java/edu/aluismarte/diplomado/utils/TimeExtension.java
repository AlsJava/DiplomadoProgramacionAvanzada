package edu.aluismarte.diplomado.utils;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.junit.jupiter.api.extension.ExtensionContext.Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * Created by Aluis on 10/24/2021.
 */
public class TimeExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private static final Logger logger = LoggerFactory.getLogger(TimeExtension.class);

    private static final String START_TIME_NS = "start time NS";

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        getStore(context).put(START_TIME_NS, System.nanoTime());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        Method testMethod = context.getRequiredTestMethod();
        long startTimeNS = getStore(context).remove(START_TIME_NS, long.class);
        double durationNS = System.nanoTime() - startTimeNS;
        logger.info("Method [{}] took {} ms.", testMethod.getName(), durationNS / 1000000);
    }

    private Store getStore(ExtensionContext context) {
        return context.getStore(Namespace.create(getClass(), context.getRequiredTestMethod()));
    }
}
