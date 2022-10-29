import com.student.manage.ConnectionProvider;
import com.student.manage.Student;
import com.student.manage.StudentDao;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;

public class Start_App {
    public static void main(String[] args) throws IOException {

        System.out.println("**** Welcome to Student Management App ****");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("\nMenu Bar : ");
            System.out.println("PRESS 1 TO Add Student ");
            System.out.println("PRESS 2 TO Delete Student ");
            System.out.println("PRESS 3 TO Update Student ");
            System.out.println("PRESS 4 TO Display Student ");
            System.out.println("PRESS 5 TO Exit App \n");
            System.out.println("Choose Option : ");
            int c = Integer.parseInt(br.readLine());

            if (c == 1) {
                // ADD Student to Database
                System.out.println("Enter the student name : ");
                String name = br.readLine();
                System.out.println("Enter the student phone : ");
                String phone = br.readLine();
                System.out.println("Enter the student city : ");
                String city = br.readLine();

                Student st = new Student(name, phone, city);
                System.out.println(st);
                boolean answer = StudentDao.insertStudentToDB(st);
                if (answer) {
                    System.out.println("Student information added successfully...");
                } else {
                    System.out.println("Something went wrong try again.....!");
                }
            }
            else if (c == 2) {
                // Delete Student from Database
                System.out.println("Enter the Student Id : ");
                int userId = Integer.parseInt(br.readLine());
                boolean answer = StudentDao.deleteStudent(userId);
                if (answer){
                    System.out.println("Student deleted.....");
                }
                else {
                    System.out.println("Something went wrong try again....!");
                }

            }
            else if (c == 3) {
                // update student information by taking id
               boolean answer = StudentDao.updateStudent();

               if (answer){
                   System.out.println("Student information updated successfully.......");
               }
               else {
                   System.out.println("Something went wrong try again.........!");
               }
            } else if (c == 4) {
                // Display the Students from Database
                System.out.println("*** The Students List ***");
                StudentDao.showAllStudents();
            }  else {
                break;
            }
        }
        System.out.println(" Thank You For Using Student Management APP ");
        System.out.println(" See You Soon ...Bye");


    }
}
