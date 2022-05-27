package pub;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import static pub.Pub.PINT;

/**
 * @author urs
 */
public class BarkeeperTest {

    private Barkeeper barkeeper;
    private Pub pub;
    private final double stock = 100.0;

    @BeforeEach
    void setUp() {
        pub = new Pub( stock );
        barkeeper = new Barkeeper( pub );
    }

    @Test
    void barkeeperTapsBeer() throws EmptyStockException {
        //TODO Test that the correct size beer is poured
        fail("You know what to do");
    }

    @Test
    void barkeeperServesDrinker() throws EmptyStockException, DrinkerTooYoungException, DrinkerFullException {
        //TODO Test that both the stock is decreased and the drinkers capacity is decreased (drink responsibly ;-))
        fail("You know what to do");
    }
    
    @Test
    public void testTabBeerEmptyStock() {
        //TODO Test that you cannot pour more beer than is in stock
        fail("You know what to do");        
    }
    
    @Test
    public void testServeDrinkerTooYoung() {
        //TODO Test that underage drinkers cannot drink
        fail("You know what to do");
    }
}
