package SourceCode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class VehicleDao {
    static Connection con;
    public static boolean insertVehicle(Vehicle vh) {
        boolean flag = false;
        try {
            // get connection
            con = ConnectionProvider.createC();
            // Query
            String q = "insert into vehicles_info(vehicleName,ownerName,contactNo)values(?,?,?)";
            // fire query
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, vh.getName());
            pstmt.setString(2, vh.getOwner());
            pstmt.setString(3, vh.getContact());
            //execute the query
            pstmt.executeUpdate();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean updateVehicle(){
        boolean flag = false;
        try{
            // get connection
            con = ConnectionProvider.createC();
            // fire query
            String q = "update vehicles_info set vehicleName=?,ownerName=?,contactNo=? where vehicleId=? ";
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter new vehicle name : ");
            String name = br.readLine();
            System.out.println("Enter new owner name : ");
            String owner = br.readLine();
            System.out.println("Enter new contact number : ");
            String contact = br.readLine();
            System.out.println("Enter Vehicle Id to update : ");
            int id = Integer.parseInt(br.readLine());

            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1,name);
            pstmt.setString(2,owner);
            pstmt.setString(3,contact);
            pstmt.setInt(4,id);

            pstmt.executeUpdate();
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    public static boolean deleteVehicle(){
        boolean flag = false;
        try{
            // get connection
            con = ConnectionProvider.createC();
            // fire query
            String q = "delete from vehicles_info where vehicleId = ?";
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter Vehicle Id To delete : ");
            int id = Integer.parseInt(br.readLine());
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1,id);
            // execute query
            pstmt.executeUpdate();
            flag = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    public static void displayVehicles(){
        try{
            // get connection
            con = ConnectionProvider.createC();
            // fire query
            String q = "select * from vehicles_info";
            // execute query
            Statement stmt = con.createStatement();
            // get results of query
            ResultSet set = stmt.executeQuery(q);
            while (set.next()){
                int id = set.getInt(1);
                String name = set.getString(2);
                String owner = set.getString(3);
                String contact = set.getString(4);

                System.out.println(
                        "Vehicle Id : "+id+
                                "\nVehicle Name : "+name+
                                "\nVehicle Owner Name : "+owner+
                                "\nContact Number : "+contact
                );
                System.out.println("---------------------------------------------------------------------------------------");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
