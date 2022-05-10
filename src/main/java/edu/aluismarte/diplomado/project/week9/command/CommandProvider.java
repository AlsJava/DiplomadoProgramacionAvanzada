package edu.aluismarte.diplomado.project.week9.command;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CommandProvider<T extends CommandHandler, C extends Command> implements BeanPostProcessor {

    Map<Class<? extends Command>, CommandHandler> registry = new HashMap<>();

    public CommandHandler<?, ? extends Command<?>> get(Class<? extends Command> c) {
        return registry.get(c);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        if (clazz.isAnnotationPresent(CommandEvent.class)) {
            Class<? extends Command> command = clazz.getAnnotation(CommandEvent.class).command();
            registry.put(command, (CommandHandler) bean);
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }


}
