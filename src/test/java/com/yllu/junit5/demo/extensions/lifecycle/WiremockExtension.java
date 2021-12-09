package com.yllu.junit5.demo.extensions.lifecycle;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.junit.jupiter.api.extension.*;

public class WiremockExtension implements BeforeAllCallback, AfterAllCallback, BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private WireMockServer wireMockServer;

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        wireMockServer = new WireMockServer(new WireMockConfiguration()
                .port(8087)
                .httpsPort(8088));
        System.out.println("wiremockHasStarted");
        wireMockServer.start();

    }

    @Override
    public void afterAll(ExtensionContext extensionContext) {
        wireMockServer.stop();
        System.out.println("wiremockHasStopped");
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        System.out.println("After test execution");
    }

    @Override
    public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
        System.out.println("Before test execution");

    }
}
