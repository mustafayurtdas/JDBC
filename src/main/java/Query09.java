import pojos.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query09 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/JDBC",
                "postgres",
                "pmyy.78530813");
        Statement st = con.createStatement();

        // Doctor tablosunu oluşturun
      //  String sql01 = "Create Table doctors (id int, isim varchar(20),bolum varchar(30),ucret int)";
      //  st.execute(sql01);

        // POJO class kullanarak tabloya veri ekleyelim
        List<Doctor> records = new ArrayList<>();
        records.add(new Doctor(20,"Ali Can","Cildiye",500));
        records.add(new Doctor(21,"Ayla Han","Psikoloji",800));
        records.add(new Doctor(22,"Aylin Kan","Dahiliye",750));
        records.add(new Doctor(23,"Ayşe Tan","Kadın Doğum",550));
        records.add(new Doctor(24,"Ahmet Yan","Ortopedi",500));
        records.add(new Doctor(25,"Arzu San","Genel",400));
        records.add(new Doctor(26,"Aslı Ban","Cocuk",550));
        records.add(new Doctor(27,"Akif Van","Kardiyolog",800));
        records.add(new Doctor(28,"Asım Lan","Noroloji",700));

        PreparedStatement data = con.prepareStatement("insert into doctors values(?,?,?,?)");

        for (Doctor w : records) {
            data.setInt(1,w.getId());
            data.setString(2,w.getIsim());
            data.setString(3,w.getBolum());
            data.setDouble(4,w.getUcret());

            data.addBatch();
        }

        data.executeBatch();

        con.close();
        data.close();

    }
}
