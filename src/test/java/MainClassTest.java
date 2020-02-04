import org.junit.*;

public class MainClassTest {
    // Метод будет выполнен перед выполнением всех остальных тестовых методов.
    // Позволяет подготовить среду перед использованием остальных тестовых методов
    @BeforeClass
    public static void beforeClassMethod(){
        System.out.println("@BeforeClass");
    }

    // будет запускаться перед каждым тестовым методом
    @Before
    public void setUp(){
        System.out.println("@Before");
    }

    // непосредственно сам тест
    @Test
    public void method1(){
        Assert.assertTrue("Values aren't equal", 1 == 1);
        Assert.assertFalse(1 == 2);

        Assert.assertNull(null); // в () можно указать метод, который должен вернуть null
        Assert.assertNotNull(new Object()); // ожидает получить объект

        Assert.assertEquals("Values aren't equal 2",10, 5+5); // ожидаемый результат, реальный результат
        Assert.assertNotEquals(10, 7+9); // ожидаемый результат, реальный результат
    }

    @Test
    @Ignore // заставит проигнорировать тест
    public void method2(){

    }

    // будет выполняться после каждого тестового метода
    @After
    public void tearDown(){
        System.out.println("@After");
    }

    // Будет выполняться после всех методов
    @AfterClass
    public static void afterClassMethod(){
        System.out.println("@AfterClass");
    }
}
