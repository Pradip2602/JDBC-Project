package com.student.manage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

    static Connection con;
    public static boolean insertStudentToDB(Student st) {
        // we are using temp variable to check query executed successfully or not
        boolean flag = false;
        // jdbc code
        try {
            // create connection
             con = ConnectionProvider.createC();

            // fire Query(we are using dynamic parameters)
            String q = "insert into students_diary (sname,sphone,scity) values(?,?,?)";

            // dynamic query hence use Prepared statements
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1, st.getStudentName());
            pstmt.setString(2, st.getStudentPhone());
            pstmt.setString(3, st.getStudentCity());

            // execute the query
            // query retrieving any value hence using executeUpdate().
            pstmt.executeUpdate();
            // if above code runs fine then temp variable set true
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean deleteStudent(int userId) {
        boolean flag = false;
        //jdbc code
        try {
            // create connection
            Connection con = ConnectionProvider.createC();

            // fire query
            String q = "delete from students_diary where sid = ?";

            // dynamic query
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setInt(1, userId);

            // execute query
            pstmt.executeUpdate();

            // setting the temp variable true if all code run fine
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static void showAllStudents() {
        //jdbc code
        try {
            // create connection
            Connection con = ConnectionProvider.createC();

            // fire query
            String q = "Select * from students_diary";

            // here we use static statements (no dynamic query)
            Statement stmt = con.createStatement();

            //execute query
            // here we are retrieving data query getting values
            ResultSet set = stmt.executeQuery(q);

            // we get data and print it
            while (set.next()) {
                int id = set.getInt(1);
                String name = set.getString(2);
                String phone = set.getString(3);
                String city = set.getString(4);

                System.out.println(
                        "Student ID : " + id +
                                "\nStudent Name : " + name +
                                "\nStudent Phone : " + phone +
                                "\nStudent City : " + city
                );
                System.out.println("----------------------------------------------------------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static boolean updateStudent(){
        boolean flag = false;
        // jdbc code..
        try{
            // create connection
            con = ConnectionProvider.createC();

            // fire query
            String q = "update students_diary set sname = ? ,sphone = ? , scity = ? where sid = ?";
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Enter the new name : ");
            String name = br.readLine();
            System.out.println("Enter the new phone : ");
            String phone = br.readLine();
            System.out.println("Enter the new city name : ");
            String city = br.readLine();
            System.out.println("Enter Student Id for update : ");
            int userId = Integer.parseInt(br.readLine());

            // dynamic query map parameters
            PreparedStatement pstmt = con.prepareStatement(q);
            pstmt.setString(1,name);
            pstmt.setString(2,phone);
            pstmt.setString(3,city);
            pstmt.setInt(4,userId);

            // execute the query
            pstmt.executeUpdate();
            flag = true;

        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
