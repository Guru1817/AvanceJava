import java.sql.*;
import java.util.Scanner;

public class JDBCdemo {
 // Register krte ho driver ko
 // Connection establish krna(Code or database mein connection establish ho jaega)
 // SQL queries ko execute krna hai(Statement)
 public static Connection conn = null;
 public static Scanner sc  = new Scanner(System.in);

 public static void main(String[] args) {
  try {
     Class.forName("com.mysql.cj.jdbc.Driver");
     String url = "jdbc:mysql://localhost:3306/jdbcDB";
     String username = "root";
     String password = "@181712Ab";
     conn = DriverManager.getConnection(url,username,password);
     insert();

    }
  catch (Exception e) {
     e.printStackTrace();
    }
 }
   private static void insert() throws SQLException{
    String sql = "insert into friends(name ,mobile_num) values (? , ?)";
    PreparedStatement stat = conn.prepareStatement(sql);
    System.out.println("Enter the customer name");
    stat.setString(1 ,sc.nextLine());
    System.out.println("Enter the customer mobile number");
    stat.setLong(2,sc.nextLong());
    int rows = stat.executeUpdate();
    if (rows > 0){
     System.out.println("record inserted successfully");
    }
 }
   private static void read() throws SQLException{
    String sql = "select * from friends";
    PreparedStatement stat = conn.prepareStatement(sql);
    ResultSet rs = stat.executeQuery();
    while (rs.next()){
     System.out.println(rs.getInt(1) + "\t"+rs.getString(2) + " " + rs.getLong(3));
    }
 }
    private static void update() throws SQLException{
     String sql = "update customer set customer_name = 'gudu' where mobile_number = 7735287196 ";
     PreparedStatement stat = conn.prepareStatement(sql);

     int rows = stat.executeUpdate();
     if (rows > 0){
      System.out.println("record inserted successfully");
     }

    }
    private static void delete() throws SQLException{
        String sql = "delete from friends where sl_num = ?";
        PreparedStatement stat = conn.prepareStatement(sql);
        System.out.println("Enter the sl number which you want to delete");
        stat.setString(1 ,sc.nextLine());

        int rows = stat.executeUpdate();
        if (rows > 0){
            System.out.println("record inserted successfully");
        }
    }
}
//"C:\Users\gbtri\Downloads\apache-tomcat-10.1.16.exe"