package com.yllu.junit5.demo.extensions.lifecycle;


import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(WiremockExtension.class)
public @interface WiremockServer {
}
