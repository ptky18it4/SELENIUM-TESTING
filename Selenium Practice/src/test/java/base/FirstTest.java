package base;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FirstTest {
    @Test
    void testFirstMethod() {
        System.out.println("Hi, Method 1");
    }

    @Test
    @DisplayName("TestCase 01 - The method 2")
    void testSecondMethod() {
        System.out.println("Hi, Method 2");
    }
}
