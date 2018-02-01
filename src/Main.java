//Sam Carrillo
//1.29.18
//CSC 346 Homework 02

import java.sql.*;
import java.util.Scanner;

public class Main {
    static Connection conn;
    static ResultSet rsp;//resultset for places variables
    static ResultSet rsd;//resultset for distance variables
    static Statement stmt, stmt2;

    //to do list:
    //implement methods for (km -> miles) conversion and (miles -> km)
    //solve multiple zipcodes returning back same place problem

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String host = "jdbc:mysql://turing.cs.missouriwestern.edu:3306/misc";
        String user = "csc254";
        String password = "age126";

        System.out.println("Enter in a ZIP code and a radius in miles.");
        System.out.print("ZIP: ");
        int inputZipCode = scan.nextInt();
        System.out.print("Radius: ");
        int radius = scan.nextInt();

        //this string should be all zips in an area
        String queryStringPlaces = "SELECT DISTINCT city, state_prefix, population, housingunits, lat, lon" +
                " FROM zips ORDER BY state_prefix";

        //this string is only the primary lat and long
        String queryStringDistances = "SELECT DISTINCT lat, lon "+
                "FROM zips WHERE zip_code LIKE "+inputZipCode+" LIMIT 1";

        try{
            conn = DriverManager.getConnection(host,user,password);
            if(conn == null){
                System.out.println("Connection to database failed");
            }else{
                System.out.println("Connection to database successful");
            }
            stmt = conn.createStatement();//prepares packet of information to be sent
            stmt2 = conn.createStatement();
            rsp = stmt.executeQuery(queryStringPlaces);
            rsd = stmt2.executeQuery(queryStringDistances);

            ResultSetMetaData rsMetaData = rsp.getMetaData();
            ResultSetMetaData rsMetaDataDistance = rsd.getMetaData();

            while(rsd.next()) {//outer loop check for rsd value (only 1 value since LIMIT 1 sql code)
                while (rsp.next()) {//inner loop check for all rsp values (until EOF)
                    //returns null when it hits the EOF
                    String name = rsp.getString("city");//name = city in database
                    String state = rsp.getString("state_prefix");

                    double lat = rsd.getDouble("lat");//primary lat
                    double lon = rsd.getDouble("lon");//primary lon
                    double lat2 = rsp.getDouble("lat");//end lat
                    double lon2 = rsp.getDouble("lon");//end lon

                    int housingunits = rsp.getInt("housingunits");
                    int population = rsp.getInt("population");

                    double distanceKM = place.distanceKM(lat, lon, lat2, lon2);
                    double distanceMiles = place.distanceMiles(lat, lon, lat2, lon2);

                    //return places within the radius
                    if(distanceMiles <= radius) {
                        place place = new place(name, state, housingunits, population, distanceKM, distanceMiles);//the placeholder "place" Object
                        System.out.println(place);//prints out all places with toString
                    }

                }
            }

            conn.close();

        }catch(SQLException e){
            //e.printStackTrace();
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
