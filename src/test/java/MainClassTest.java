import org.junit.*;

public class MainClassTest {
    // Метод будет выполнен перед выполнением всех остальных тестовых методов.
    // Позволяет подготовить среду перед использованием остальных тестовых методов
    @BeforeClass
    public void beforeClassMethod(){

    }

    // будет запускаться перед каждым тестовым методом
    @Before
    public void setUp(){

    }

    // непосредственно сам тест
    @Test
    public void method1(){

    }

    @Test
    @Ignore // заставит проигнорировать тест
    public void method2(){

    }

    // будет выполняться после каждого тестового метода
    @After
    public void tearDown(){

    }

    // Будет выполняться после всех методов
    @AfterClass
    public void afterClassMethod(){

    }
}
