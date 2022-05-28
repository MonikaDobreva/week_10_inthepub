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
        Double expected = PINT;
        Beer actual = barkeeper.tapBeer(expected);
        assertThat(actual.getSize()).isCloseTo(expected, within(0.1d));
        //fail("You know what to do");
    }

    @Test
    void barkeeperServesDrinker() throws EmptyStockException, DrinkerTooYoungException, DrinkerFullException {
        Drinker drinker = new Drinker(3.0, 18);
        double startCapacity = drinker.getVolumeLeft();
        double startStock = stock;

        barkeeper.serve(drinker, PINT);
        double capacityLeft = drinker.getVolumeLeft();

        SoftAssertions.assertSoftly(softly -> {
            softly. assertThat(capacityLeft)
                    .isCloseTo(startCapacity - PINT, within(.01));
            softly.assertThat(startStock - PINT).isCloseTo(pub.getStock(), within(0.01));
        });

        //fail("You know what to do");
    }
    
    @Test
    public void testTabBeerEmptyStock() {
        ThrowingCallable code = () -> barkeeper.tapBeer(120.0);
        assertThatThrownBy(code)
                .isExactlyInstanceOf(EmptyStockException.class);

        //fail("You know what to do");
    }
    
    @Test
    public void testServeDrinkerTooYoung() {
        Drinker drinker = new Drinker(5.0, 12);
        ThrowingCallable code = () -> barkeeper.serve(drinker, PINT);
        assertThatThrownBy(code)
                .isExactlyInstanceOf(DrinkerTooYoungException.class);
        //fail("You know what to do");
    }
}
