
import com.letv.cases.leui.os.launcher.widgets.StringProblem;

import junit.framework.Assert;

import org.testng.Assert;

/**
 * Created by jinlingkwang on 8/28/16.
 */
public class StringProblemTests {
    @Test(dataProvider = "ValidDataProvider")
    public void testWithPositiveCases(String str, String replacement, String expected) throws Exception {
        StringProblem sp = new StringProblem();
        Assert.assertEquals(expected, sp.replaceString(str, replacement));

    }

    @Test(dataProvider = "InvalidDataProvider")
    public void testWithNegativeCases(String str, String replacement, String expected) throws Exception {
        StringProblem sp = new StringProblem();
        Assert.assertEquals(expected, sp.replaceString(str, replacement));

    }

     @DataProvider
     public Object[][] ValidDataProvider() {
     		return new Object[][]{
     			{ "Aab", 'a', "Ab"},
     			{ "Aab", 'A', "ab"},
     			{ "Aaaab", 'a', "Ab"},
     			{ "AAAab", 'A', "ab"},
     			{ "abaA", 'a', "bA"},
     			{ "AbaA", 'A', "ba"},
     			{ "Abaa123", 'a', "Ab123"},
     			{ "AbaA123", 'A', "ba123"}
     		};
     }

     @DataProvider
     public Object[][] InvalidDataProvider() {
     		return new Object[][]{
     			{ "", 'a', null},
     			{ null, 'A', null},
     			{ "123", 'a', "123"},
     			{ "AAAab", 'C', "AAAab"},
     			{ "abaA#@$?>*&()+", 'a', "bA"}
     		};
     }
     
}
