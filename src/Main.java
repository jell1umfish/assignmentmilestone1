import javax.xml.transform.Result;
import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        int attempts = 3;
        while (attempts > 0) {
            int globalvar1 = 0;
            Scanner sc = new Scanner(System.in);
            String pass = sc.nextLine();
            String log = sc.nextLine();
            Login lg = new Login(log);
            Password pw = new Password(pass);
            if (pw.check_pass(pass) && lg.check_log(log)) {
                String ConnectURL = "jdbc:postgresql://localhost:5432/postgres";
                Connection conn = null;
                ResultSet rs = null;
                Statement stmt = null;
                try {
                    Class.forName("org.postgresql.Driver");
                    conn = DriverManager.getConnection(ConnectURL, "postgres", "qwerty123");
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery("select * from \"user\"");
                    while (rs.next()) {

                        if (Objects.equals(rs.getString("login"), lg.getLogin())) {
                            System.out.println("Correct");
                            globalvar1 = globalvar1 + 1;
                        } else {
                            System.out.println("incorrect");
                            attempts--;
                            break;
                        }

                        if (Objects.equals(rs.getString("password"), pw.getPassword())) {
                            System.out.println("Correct");
                            globalvar1 = globalvar1 + 1;
                        } else {
                            System.out.println("incorrect");
                            attempts--;
                            break;
                        }
                    }
                } catch (
                        Exception e) {
                    System.out.println(e);
                } finally {
                    try {

                        rs.close();
                        stmt.close();
                        conn.close();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                if (globalvar1 == 2) {
                    Capcha c = new Capcha();
                    String realCaptcha = c.getCaptcha();
                    if (c.jframe(realCaptcha)) {
                        System.out.println("Successful");
                    } else {
                        System.out.println("Failed");
                    }
                }
            }
        }
    }
}