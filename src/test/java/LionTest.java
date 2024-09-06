import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    private Lion lion;

    @Mock
    private Feline feline;  // Замокированная зависимость

    @Before
    public void setUp() throws Exception {

        Mockito.when(feline.getKittens()).thenReturn(1);
        Mockito.when(feline.getFood("Хищник")).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        lion = new Lion("Самец", feline);
    }

    @Test
    public void loinExceptionTest() {

        Exception exception = assertThrows(Exception.class, () -> new Lion("Не самец и не самка", feline));
        assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
    }

    @Test
    public void getKittensTest() {

        assertEquals(1, lion.getKittens());
    }

    @Test
    public void getFoodTest() throws Exception {

        List<String> food = lion.getFood();
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, food);
    }
}