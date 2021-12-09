package com.yllu.junit5.demo.extensions.conditional;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.extension.ConditionEvaluationResult.disabled;
import static org.junit.jupiter.api.extension.ConditionEvaluationResult.enabled;
import static org.junit.platform.commons.support.AnnotationSupport.findAnnotation;
import static org.springframework.util.StringUtils.hasLength;

public class EnvironmentExecutionCondition implements ExecutionCondition {

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext extensionContext) {

        String activeEnvironment = System.getProperty("environment");
        if (!hasLength(activeEnvironment)) {
            System.out.println(activeEnvironment);
            return disabled("There is no environment specified " + activeEnvironment);
        }
        Set<String> enabledEnvironments = getEnabledEnvironments(extensionContext);
        return enabledEnvironments.contains(activeEnvironment) ?
                enabled("Enabled for env " + activeEnvironment) :
                disabled("Disabled for env: " + getEnabledEnvironments(extensionContext));
    }

    private Set<String> getEnabledEnvironments(ExtensionContext context) {
        Set<String> enabledEnvironments = new HashSet<>();
        context.getElement()
                .ifPresent(annotatedElement -> findAnnotation(annotatedElement, Environment.class)
                        .map(Environment::enabledFor)
                        .ifPresent(enabledEnvironment -> enabledEnvironments.addAll(List.of(enabledEnvironment))));

        return enabledEnvironments;

    }
}
