package areaTriangle;

import org.junit.Before;
import org.junit.jupiter.api.*;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    private Triangle triangle;

    @Before
    private void setUp(int a, int b, int c) {
        triangle = new Triangle(a, b, c);
    }

    @Test
    void area() throws MyTriangleException {
        setUp(3, 3, 3);
        DecimalFormat decimalFormat = new DecimalFormat("#.##########");
        assertEquals(decimalFormat.format((Math.sqrt(3) / 4) * 9),
                decimalFormat.format(triangle.area()));
    }
    @Test
    void areaMax() throws MyTriangleException {
        setUp(2147483647, 2147483647, 2147483647);
        assertEquals(1.99691862125803904E18,
                triangle.area());
    }

    @Test
    void testInputWrongData() {
        setUp(0, 3, 3);
        try {
            triangle.area();
            fail("Please, check enter data");
        } catch (MyTriangleException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail("Wrong work the method area()");
        }
    }

    @Test
    void groupCheckTriangleIs() {
        int lengthSize = 4;
        assertAll("check if the triangle exists",
                () -> assertEquals(new Triangle(lengthSize, 3, 6).checkTriangle(), true),
                () -> assertEquals(new Triangle(lengthSize, 3, 7).checkTriangle(), false)
        );
    }

    @Test
    void groupCheckTriangleMin() {
        int[] lengthSize = {-1, 0, 1};
        assertAll("check the boundary values min",
                () -> assertEquals(new Triangle(lengthSize[0], 1, 1).checkTriangle(), false),
                () -> assertEquals(new Triangle(lengthSize[1], 1, 1).checkTriangle(), false),
                () -> assertEquals(new Triangle(lengthSize[2], 1, 1).checkTriangle(), true)
        );
    }

    @Test
    void groupCheckTriangleMax() {
        int a = 2147483646 + 25;
        int[] lengthSize = {2147483647, 2147483646, a};
        assertAll("check the boundary values max",
                () -> assertEquals(new Triangle(lengthSize[0], 2147483647, 2147483647).checkTriangle(), true),
                () -> assertEquals(new Triangle(lengthSize[1], 2147483647, 2147483647).checkTriangle(), true),
                () -> assertEquals(new Triangle(lengthSize[2], 2147483647, 2147483647).checkTriangle(), false)
        );
    }

    @Test
    void checkThrowException() {
        Throwable exception = assertThrows(UnsupportedOperationException.class, ()
                -> {
            throw new UnsupportedOperationException("Please, check enter data");
        });
        assertEquals(exception.getMessage(), "Please, check enter data");
    }
}