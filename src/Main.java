//Sam Carrillo
//1.29.18
//CSC 346 Homework 02

import java.sql.*;
import java.util.Scanner;

public class Main {
    static Connection conn;
    static ResultSet rs;
    static Statement stmt;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String host = "jdbc:mysql://turing.cs.missouriwestern.edu:3306/misc";
        String user = "csc254";
        String password = "age126";

        System.out.println("Enter in a ZIP code and a radius in miles.");
        System.out.print("ZIP: ");
        int zipCode = scan.nextInt();
        System.out.print("Diameter: ");
        int diameter = scan.nextInt();

        String queryString = "SELECT city, region, country, latitude, longitude " +
                "FROM cities " +
                "WHERE longitude < 0.0 LIMIT 25";

        try{
            conn = DriverManager.getConnection(host,user,password);
            if(conn == null){
                System.out.println("Connection to database failed");
            }else{
                System.out.println("Connection to database successful");
            }
            stmt = conn.createStatement();//prepares packet of information to be sent
            rs = stmt.executeQuery(queryString);

            ResultSetMetaData rsMetaData = rs.getMetaData();

            while(rs.next()){
                //returns null when it hits the EOF (for if you use it in another method)
                //this shows how it is linked to the result set
                String country = rs.getString("country");
                String name = rs.getString("city");//name = city in database
                String region = rs.getString("region");
                double lat = rs.getDouble("latitude");
                double lon = rs.getDouble("longitude");
                place place = new place(name, region, country, lat, lon);//the placeholder "place" Object
                System.out.println(place);
            }

            conn.close();

        }catch(SQLException e){
            //e.printStackTrace();
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
