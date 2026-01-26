package test.java.com.demo.app;

import main.java.com.demo.model.*;
import main.java.com.demo.app.App;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class TestApp {
    @Test
    public void testSampleMethod() {
        App app = new App();
        // Since sampleMethod only prints to console, we can just call it to ensure no exceptions are thrown
        String str = app.sampleMethod();
        assertNull(str); // sampleMethod does not return anything, so we expect null
    }
}
