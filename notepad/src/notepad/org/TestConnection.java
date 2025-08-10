package notepad.org;

import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        try {
            Connection con = DBconnection.getConnection();
            System.out.println("✅ Connected successfully to MySQL database!");
            con.close();
        } catch (Exception e) {
            System.out.println("❌ Connection failed!");
            e.printStackTrace();
        }
    }
}