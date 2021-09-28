package strings;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.tianqj.fundamentals.strings.RemoveAllAdjacentDuplicatesInString;

public class RemoveAllAdjacentDuplicatesInStringTest {
    private RemoveAllAdjacentDuplicatesInString removeAllAdjacentDuplicatesInString;

    @Before
    public void setup() {
        removeAllAdjacentDuplicatesInString = new RemoveAllAdjacentDuplicatesInString();
    }

    @Test
    public void test() {
        String result = removeAllAdjacentDuplicatesInString.solution("ibfjcaffccadidiaidchakchchcahabhibdcejkdkfbaeeaecdjhajbkfebebfea");
        Assert.assertEquals("ibfjcdidiaidchakchchcahabhibdcejkdkfbecdjhajbkfebebfea", result);
    }

}
