import org.junit.Assert;
import org.junit.Test;

import static utilities.DatabaseUtility.*;

public class JUnit_Test {
    @Test
    public void test01(){

        createConnection();

        String sql01 = "select * from ogrenciler";

        System.out.println(getColumnData(sql01, "ogrenci_ismi"));
        Assert.assertTrue("Kayıt Bulunamadı!",getColumnData(sql01,"ogrenci_ismi").contains("Derya Soylu"));

        Assert.assertTrue("Kayıt yok!",
                getColumnData(sql01,"ogrenci_ismi").contains("Ahmet Aslan"));

        closeConnection();

    }

    @Test
    public void test02(){

        //118 numaralı öğrenci databasede var mı?
        createConnection();

        Assert.assertTrue("DATABASE'DE KAYIT BULUNAMADI",
                getColumnData("select * from ogrenciler", "okul_no").contains(118));

        closeConnection();

    }



}
