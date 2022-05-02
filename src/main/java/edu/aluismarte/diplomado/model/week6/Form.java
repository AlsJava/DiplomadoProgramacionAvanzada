package edu.aluismarte.diplomado.model.week6;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author aluis on 5/2/2022.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Form {

    boolean required();

    boolean copyFromDefault();

    String defaultValue() default "";

    String emptyValue() default "";

    boolean preData();

}
