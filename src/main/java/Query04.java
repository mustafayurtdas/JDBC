import java.sql.*;

public class Query04 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/JDBC",
                "postgres",
                "12345");
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("select * from ogrenciler");

        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println("Sütun  sayısı: "+rsmd.getColumnCount());
        System.out.println("1. sütun : "+ rsmd.getColumnName(1));
        System.out.println("2. sütun : "+ rsmd.getColumnName(2));
        System.out.println("3. sütun : "+ rsmd.getColumnName(3));
        System.out.println("4. sütun : "+ rsmd.getColumnName(4));

        System.out.println("Tablo Ismi = " + rsmd.getTableName(2));

        System.out.println("rsmd.getColumnType(1) = " + rsmd.getColumnTypeName(1));
        System.out.println("rsmd.getColumnType(1) = " + rsmd.getColumnTypeName(2));
        System.out.println("rsmd.getColumnType(1) = " + rsmd.getColumnTypeName(3));
        System.out.println("rsmd.getColumnType(1) = " + rsmd.getColumnTypeName(4));


    }

}
