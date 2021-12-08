package com.example;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeHelloWorldControllerIT extends HelloWorldControllerTest {

    // Execute the same tests but in native mode.
}