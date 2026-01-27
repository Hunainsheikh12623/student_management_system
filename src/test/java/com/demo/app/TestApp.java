package test.java.com.demo.app;

import main.java.com.demo.model.*;
import main.java.com.demo.app.App;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;





class TestApp {
    @Test
    void testMainRunsWithoutError() {
        App.main(new String[]{});
    }
}

