
import java.sql.*;

public class Query02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        // 1) Driver Tanımla
        Class.forName("org.postgresql.Driver");

        // 2) Database'e Bağlan
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/JDBC",
                "postgres",
                "12345");

        // 3) Statement
        Statement st = con.createStatement();


        //Soru: Region id'si 1 olan "country name" değerlerini çağırın.

        String sql01 = "select country_name from countries where region_id=1";

        //4) ResultSet
        ResultSet data = st.executeQuery(sql01);

        while (data.next()) {
            System.out.println(data.getString(1));
        }

        //Soru: "region_id"nin 2'den büyük olduğu "country_id" ve "country_name" değerlerini çağırın.

        String sql02 = "select country_id, country_name from countries where region_id>2";
        ResultSet data2 = st.executeQuery(sql02);

        while (data2.next()) {

            System.out.println(data2.getString("country_id") + data2.getString("country_name"));
        }

        con.close();
        st.close();
        data.close();
        data2.close();











    }
}
