package tests;

import main.SummOfMinimumValues;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class AppTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void WithNegativeValue() {
        SummOfMinimumValues array = new SummOfMinimumValues(new int[]{4, 0, 3, 19, 492, -10, 1});
        int expected = -10;
        int actual = array.getSummin();
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void AllZero() {
        SummOfMinimumValues array = new SummOfMinimumValues(new int[]{0, 0, 0, 0, 0, 0, 0});
        int expected = 0;
        int actual = array.getSummin();
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void TwoSame() {
        SummOfMinimumValues array = new SummOfMinimumValues(new int[]{4, -10, 3, 19, 492, -10, 1});
        int expected = -20;
        int actual = array.getSummin();
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void EmptyArray() {
        try {
            SummOfMinimumValues array = new SummOfMinimumValues(new int[]{});
        } catch (ArrayIndexOutOfBoundsException thrown) {
            Assert.assertNotEquals("", thrown.getMessage());
        }
    }

    @Test
    public void BigArrayWithManySame() {
        SummOfMinimumValues array = new SummOfMinimumValues(new int[]{4, 0, 3, 19, 492, -10, 1,
                4, 0, 3, 19, 492, -10, 1,
                4, 0, 3, 19, 492, -10, 1,
                4, 0, 3, 19, 492, -10, 1,
                4, 0, 3, 19, 492, -10, 1,
                4, 0, 3, 19, 492, -10, 1,
                4, 0, 3, 19, 492, -10, 1,
                4, 0, 3, 19, 492, -10, 1,
                4, 0, 3, 19, 492, -10, 1,
                4, 0, 3, 19, 492, -10, 2});
        int expected = -20;
        int actual = array.getSummin();
        Assert.assertThat(actual, is(expected));
    }
}
