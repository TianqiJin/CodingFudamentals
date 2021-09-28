package strings;

import org.junit.Assert;
import org.junit.Test;
import org.tianqj.fundamentals.strings.AddStrings;

public class AddStringsTest {
    @Test
    public void test() {
        AddStrings addStrings = new AddStrings();
        String result =  addStrings.solution("11", "123");
        Assert.assertEquals(result, "134");
    }
}
