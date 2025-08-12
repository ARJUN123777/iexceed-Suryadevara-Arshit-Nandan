//Program to demonstrate the operations carried out in a parking lot

import java.util.*;

class vehicle {

    int type;
    twowheeler two;
    fourwheeler four;

    vehicle(int type) {
        this.type = type;
        if (this.type == 1) {
            two = new twowheeler();     //Calling a Method from another class 
        } else {
            four = new fourwheeler();  //Calling amethod from another class
        }
    }
}

class twowheeler {

    twowheeler() {
        displaydetails();
    }

    public void displaydetails() {
        System.out.println("Please select your Two Wheeler Type");
        System.out.println("TYPE 1---MOTOR BIKE");
        System.out.println("TYPE 2---CYCLE");
    }
}

class fourwheeler {

    fourwheeler() {
        displaydetails();
    }

    public void displaydetails() {
        System.out.println("Please Select your Four wheeler Type");
        System.out.println("TYPE 1---CAR");
        System.out.println("TYPE 2---VAN");
        System.out.println("TYPE 3---TRUCK");
    }
}

class parkinglot //Class to demonstrate the Number of lots for each type of vehicle
{

    mbfare mb = new mbfare();
    cfare cy = new cfare();
    crfare cr = new crfare();
    vfare v = new vfare();
    tfare t = new tfare();
    String type;
    int mbspots = 20;
    int cyspots = 30;
    int clspots = 15;
    int vspots = 10;
    int tspots = 5;

    parkinglot(String type) {
        if (this.type == "motorbike") {
            System.out.println("No of Parking lots Available for Motor Bikes are- " + this.mbspots);
            mb.fare();
        } else if (this.type == "cycle") {
            System.out.println("No of Parking Lots Available for Cycles are- " + this.cyspots);
            cy.fare();
        } else if (this.type == "car") {
            System.out.println("No of Parking Lots Available for Cars are- " + this.clspots);
            cr.fare();
        } else if (this.type == "van") {
            System.out.println("No of Parking Lots Available for Vans are- " + this.vspots);
            v.fare();
        } else if (this.type == "truck") {
            System.out.println("No of Parking lots Available for Trucks are- " + this.tspots);
            t.fare();
        } else {
            System.out.println("Invalid Input");
        }
    }
}

interface parkingfare {

    public void fare();
}

class mbfare implements parkingfare {

    public void fare() {
        System.out.println("Parking Fare for Motor Cycle");
        System.out.println("1-3hrs --- " + "80");
        System.out.println("More than 3hrs --- " + "130");
    }
}

class cfare implements parkingfare {

    public void fare() {
        System.out.println("Parking Fare for Cycle");
        System.out.println("1-3hrs --- " + "30");
        System.out.println("More than 3hrs --- " + "80");
    }
}

class crfare implements parkingfare {

    public void fare() {
        System.out.println("Parking Fare for Cars");
        System.out.println("1-3hrs --- " + "100");
        System.out.println("More than 3hrs --- " + "150");
    }
}

class vfare implements parkingfare {

    public void fare() {
        System.out.println("Parking Fare for Vans");
        System.out.println("1-3hrs --- " + "150");
        System.out.println("More than 3hrs --- " + "200");
    }
}

class tfare implements parkingfare {

    public void fare() {
        System.out.println("Parking Fare for Trucks");
        System.out.println("1-3hrs --- " + "200");
        System.out.println("More than 3hrs --- " + "250");
    }
}

class parking {

    public static void main(String args[]) {
        System.out.println("================================");
        System.out.println("PLEASE PARK YOUR VEHICLES HERE");
        Scanner sc = new Scanner(System.in);
        System.out.println("Select your vehicle");
        System.out.println("1.TWO-WHEELER");
        System.out.println("2.FOUR-WHEELER");
        System.out.print("Your choice: ");
        int s = sc.nextInt();
        new vehicle(s);
    }
}
