import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.DatabaseUtility.*;

public class TestNG_Test {

    @Test
    public void test01() {

        createConnection();

        String sql01 = "select * from ogrenciler";

        Assert.assertTrue(getColumnData(sql01,"ogrenci_ismi").contains("Ahmet Aslan"),"Database de kayıt bulunamadı!");

        closeConnection();

    }

    @Test
    public void test02(){

        createConnection();

        Assert.assertTrue(getColumnData("select * from ogrenciler","okul_no").contains(120),
                "Database de kayıt bulunamadı!");

        closeConnection();

    }

}
