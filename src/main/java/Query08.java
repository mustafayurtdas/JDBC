import static utilities.DatabaseUtility.*;

public class Query08 {
    public static void main(String[] args) {
        createConnection();

        String sql01 = "select * from ogrenciler";
        System.out.println("Sütun isimleri = "+getColumnNames(sql01));

        System.out.println("ögrenci numaraları = " + getColumnData(sql01, "okul_no"));
        System.out.println("ögrenci isimleri = " + getColumnData(sql01, "ogrenci_ismi"));


    }

}
