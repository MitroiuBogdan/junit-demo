package com.yllu.junit5.demo.extensions.conditional;

import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@ExtendWith(EnvironmentExecutionCondition.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Environment {
    String[] enabledFor();
}
