import org.junit.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.is;

//Ensures Chance class verifies probability calculations
public class TestChance {
    @Test
    public void testEqualsReflexive() {
        Chance chance = new Chance(.5);
        assertEquals(true, chance.equals(chance));
    }

    @Test
    public void testEqualsIsSymmetric() {
        Chance chance1 = new Chance(.2);
        Chance chance2 = new Chance(.2);

        assertEquals(true, chance1.equals(chance2));
        assertEquals(true, chance2.equals(chance1));
    }

    @Test
    public void testEqualsIsTransitive() {
        Chance chance1 = new Chance(.2);
        Chance chance2 = new Chance(.2);
        Chance chance3 = new Chance(.2);

        assertEquals(true, chance1.equals(chance2));
        assertEquals(true, chance2.equals(chance3));
        assertEquals(true, chance1.equals(chance3));
    }

    @Test
    public void shouldCompare1By2And1By5() {
        assertEquals(false, new Chance((0.5)).equals(new Chance((0.2))));
    }

    @Test
    public void shouldCompare1By2And1By2() {
        Assert.assertTrue(new Chance((0.5)).equals(new Chance((0.5))));
    }

    @Test
    public void shouldCalculateProbabilityOfNotGetting3OnDice() {
        Chance chanceOfGetting3 = new Chance(0.16);

        Assert.assertTrue(chanceOfGetting3.not().equals(new Chance(0.84)));
    }

    @Test
    public void shouldCalculateProbabilityOf1On6And6On6For2Dice() {
        Chance chance1On6 = new Chance(.16);
        Chance chance6On6 = new Chance(.16);

        Assert.assertTrue(chance1On6.and(chance6On6).equals(new Chance(0.0256)));
    }

    @Test
    public void shouldCalculateProbabilityForGettingHeadOnBothCoins() {
        Chance headCoin1 = new Chance(.5);
        Chance headCoin2 = new Chance(.5);
        boolean result;

        result = headCoin1.and(headCoin2).equals(new Chance(0.25));

        Assert.assertTrue(result);
    }

    @Test
    public void shouldCalculateProbabilityForGettingHeadsOn1CoinOrTailsOnOther() {
        Chance chance1On6 = new Chance(.5);
        Chance chance6On6 = new Chance(.5);
        boolean result;

        result=chance1On6.or(chance6On6).equals(new Chance(0.75));

        Assert.assertTrue(result);
    }

    @Test
    public void shouldCalculateProbabilityForZeroTwoOrZeroFour() {
        Chance chance1On6 = new Chance(.2);
        Chance chance6On6 = new Chance(.4);
        boolean result;

        result=chance1On6.or(chance6On6).equals(new Chance(0.52));

        Assert.assertTrue(result);
    }
}
