import SourceCode.Vehicle;
import SourceCode.VehicleDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartApp {
    public static void main(String[] args) throws IOException {
        System.out.println("** Welcome to Vehicle Registration App **\n");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("** Menue Bar ** \n");
            System.out.println("PRESS 1 to add Vehicle Information");
            System.out.println("PRESS 2 to Update Vehicle Information");
            System.out.println("PRESS 3 to delete Vehicle Information");
            System.out.println("PRESS 4 to display Vehicle Information");
            System.out.println("PRESS 5 to Exit\n");
            int c = Integer.parseInt(br.readLine());

            if (c == 1) {
                // insert vehicle info
                System.out.println("Enter Vehicle Name : ");
                String name = br.readLine();
                System.out.println("Enter Owner Name : ");
                String owner = br.readLine();
                System.out.println("Enter Contact number : ");
                String contact = br.readLine();

                Vehicle vh = new Vehicle(name, owner, contact);
                System.out.println(vh);
                boolean answer = VehicleDao.insertVehicle(vh);
                if (answer) {
                    System.out.println("Vehicle is added successfully...........\n");

                } else {
                    System.out.println("Something went wrong please try again........!\n");
                }

            } else if (c == 2) {
                // update info
                boolean answer = VehicleDao.updateVehicle();
                if (answer){
                    System.out.println("Vehicle information updated successfully.........\n");
                } else {
                    System.out.println("Something went wrong please try again......!\n");
                }

            } else if (c == 3) {
                // delete info
                boolean answer = VehicleDao.deleteVehicle();
                if (answer){
                    System.out.println("Vehicle information deleted successfully.........\n");
                }else{
                    System.out.println("Something went wrong please try again..........!\n");
                }
            } else if (c == 4) {
                // display info
                System.out.println("** Vehicles List **");
                VehicleDao.displayVehicles();
            } else {
                break;
            }
        }
    }
}
