import com.example.Lion;
import com.example.Feline;
import com.example.Animal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParaLionTest {

    private final String sex;
    private final boolean hasMane;

    @Mock
    private Feline feline;

    @Mock
    private Animal animal;

    public ParaLionTest(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);  // Инициализация мок-объектов
    }

    @Test
    public void lionConstructorTest() throws Exception {
        Lion lion = new Lion(sex);  // Создаем объект Lion, передавая только sex
        assertEquals(hasMane, lion.doesHaveMane());
    }
}

