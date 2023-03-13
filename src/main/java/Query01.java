import java.sql.*;

public class Query01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 1) Driver Tanımla
        Class.forName("org.postgresql.Driver");

        // 2) Database'e Bağlan
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/JDBC",
                "postgres",
                "pmyy.78530813");

        // 3) Statement
        Statement st = con.createStatement();

        ResultSet data = st.executeQuery("select * from ogrenciler");

        // 4) Dataları Al
        while (data.next()) {
            System.out.println(
                    data.getInt(1)
                            + data.getString(2)
                            + data.getString(3)
                            + data.getString(4)
            );
        }

        //Bağlantıları Kapatma
        con.close();
        st.close();
        data.close();

    }
}
