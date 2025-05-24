import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SILab2Test {

    @Test
    public void test1() {
        RuntimeException prv=assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, "1234123412341234"));
        assertEquals("allItems list can't be null!", prv.getMessage());
    }

    @Test
    public void test2() {
        List<Item> items= Arrays.asList(
                new Item("apple", 2,10,0.5),
                new Item(null, 0,0,0)
        );
        RuntimeException vtor=assertThrows(RuntimeException.class, () -> SILab2.checkCart(items, "1234123412341234"));
        assertEquals("Invalid item!", vtor.getMessage());

    }

    @Test
    public void test3() {
        List<Item> items= List.of(
                new Item("apple", 2, 10, 0)
        );
        RuntimeException tret=assertThrows(RuntimeException.class, () -> SILab2.checkCart(items, null));
        assertEquals("Invalid card number!", tret.getMessage());
    }

    @Test
    public void test4() {
        List<Item> items= List.of(
                new Item("apple", 2, 10, 0)
        );
        double result=SILab2.checkCart(items, "1234123412341234");
        assertEquals(20.0, result);
    }

    @Test
    public void test5() {
        List<Item> items= List.of(
                new Item("apple", 2, 10, 0)
        );
        RuntimeException petti=assertThrows(RuntimeException.class, () -> SILab2.checkCart(items, "1a2b3c4d12341234"));
        assertEquals("Invalid character in card number!", petti.getMessage());

    }

    @Test
    public void MultipleCondition(){
        List<Item> items= Arrays.asList(
                new Item("apple", 2, 350, 0.5),
                new Item("apple", 2, 250, 0.7),
                new Item("apple", 15, 250, 0),
                new Item("apple", 2, 250, 0)
        );
        assertEquals(4660.0, SILab2.checkCart(items, "1234123412341234"));
    }
}
