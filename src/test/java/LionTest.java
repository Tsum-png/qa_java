import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;
    Lion lion;

    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец");
    }


    @Test(expected = Exception.class)
    public void loinExceptionTest() throws Exception {
        new Lion("Не самец и не самка");
    }

    @Test
    public void getKittensTest() {
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void haveManeTest() {
        Assert.assertTrue(lion.doesHaveMane());
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> food = lion.getFood();
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, food);
    }
}