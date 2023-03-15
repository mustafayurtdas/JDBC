import org.junit.Assert;
import org.junit.Test;

public class FirstTest {

    @Test
    public void firstTest01(){
        Assert.assertTrue(6<8);

    }

    @Test
    public void firstTest02(){
        Assert.assertTrue("Test Fail",4<9);     // Test başarısız olduğunda mesaj verir

    }

    @Test
    public void firstTest03(){
Assert.assertEquals("Sayılar eşit değil",6,6);
    }


}
