import pojos.Urun;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query07 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/JDBC",
                "postgres",
                "12345");

        Statement st = con.createStatement();

    // SORU: Urunler adında bir tablo olusturalım (id int, isim varchar(10), fiyat int)

       // st.execute("Create Table Urunler(id int,isim varchar(10),fiyat int)");

    //Çok miktarda kayıt eklemek için PrepareStatement () kullanılır.
    //Bunun haricinde POJO class kulanarakta bunu yapabiliriz.

        List<Urun> kayitlar =new ArrayList<>();

        kayitlar.add(new Urun(101,"Laptop",35000));
        kayitlar.add(new Urun(102,"Mouse",750));
        kayitlar.add(new Urun(103,"MacBookPro",95000));
        kayitlar.add(new Urun(104,"Ana Kart",5000));
        kayitlar.add(new Urun(105,"Klavye",1500));
        kayitlar.add(new Urun(106,"Ipad",45000));

        PreparedStatement tablo = con.prepareStatement("insert into urunler values(?,?,?)");

        for (Urun w : kayitlar) {
            tablo.setInt(1,w.getId());
            tablo.setString(2, w.getIsim());
            tablo.setDouble(3,w.getFiyat());

            tablo.addBatch();
        }

        tablo.executeBatch();
        con.close();
        st.close();
        tablo.close();







    }

}
