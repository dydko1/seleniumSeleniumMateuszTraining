import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyFirstTest1 {

    @BeforeMethod
    public void runBeforeTest() {
        System.out.println("run before each ");
    }

    @AfterMethod
    public void afterBeforeTest() {
        System.out.println("run after each test");
    }

    @Test
    public void test1() {
        System.out.println("start test1");
        Assert.assertEquals(add(3, 2), 5);
        System.out.println("end test1");
    }

    @Test
    public void test2() {
        int a = 10;
        System.out.println("start test2");
        Assert.assertEquals(multiply(3, 3), 5, "Oczekuje błedu");
        System.out.println("end test2");
    }

    int add(int a, int b) {
        return a + b;
    }

    int multiply(int a, int b) {
        //return a*b;
        return 4;
    }
}

