package ParkingTicketSimulator;

/**
 * Created by Mengyu Yang (AndrewID: mengyuy) on 9/6/15.
 */
public class Simulation {
    public static void main(String[] args) {

        PoliceOfficer officer = new PoliceOfficer("Peter", "123456789");
        System.out.println("The officer's name is " + officer.getName() + ". The officer's badge number is " +
            officer.getBadgeNum() + ".");

        ParkingMeter meter = new ParkingMeter(60);
        System.out.println("The car purchased " + meter.getMinPurchased() + " mins.");

        ParkedCar car = new ParkedCar("Toyota", "Prius", "white", "A53452", 0);
        System.out.println("The car is made by  " + car.getMake() + " with model " + car.getModel() +
            " and color " + car.getColor() + ". The lisence number is " + car.getLicenseNumber() + ".\n");

        // Case1: ParkedCar is in the parking time purchased
        System.out.println("Test Case 1: ParkedCar is in the parking time purchased.");
        car.setMinParked(30);
        System.out.println("The car has been parked for " + car.getMinParked() + " mins.");
        System.out.println("The car's parking time is expired? " + PoliceOfficer.isExpired(car, meter));
        System.out.println("The issued ticket is " + officer.issueTicket(car, meter) + "\n");



        // Case2: ParkedCar is just in the parking time purchased
        System.out.println("Test Case 2: ParkedCar is just in the parking time purchased");
        car.setMinParked(60);
        System.out.println("The car has been parked for " + car.getMinParked() + " mins.");
        System.out.println("The car's parking time is expired? " + PoliceOfficer.isExpired(car, meter));
        System.out.println("The issued ticket is " + officer.issueTicket(car, meter) + "\n");


        // Case3: ParkedCar is out the parking time purchased
        System.out.println("Test Case 3: ParkedCar is out the parking time purchased");
        car.setMinParked(120);
        System.out.println("The car has been parked for " + car.getMinParked() + " mins.");
        System.out.println("The car's parking time is expired? " + PoliceOfficer.isExpired(car, meter));
        ParkingTicket ticket = officer.issueTicket(car, meter);
        System.out.println("===== The following are tickets information =====");
        System.out.println("Car's make: " + ticket.getMake());
        System.out.println("Car's model: " + ticket.getModel());
        System.out.println("Car's color: " + ticket.getColor());
        System.out.println("License number: " + ticket.getLicenseNum());
        System.out.println("Fine is " + ticket.getFine());
        System.out.println("Officer's name: " + ticket.getName());
        System.out.println("Officer's badge number: " + ticket.getBadgeNum() + "\n");


        // Case4: Ticket under one hour
        System.out.println("Test Case 4: Ticket under one hour");
        car.setMinParked(90);
        System.out.println("The car has been parked for " + car.getMinParked() + " mins.");
        System.out.println("The car's parking time is expired? " + PoliceOfficer.isExpired(car, meter));
        ParkingTicket ticket2 = officer.issueTicket(car, meter);
        System.out.println("===== The following are tickets information =====");
        System.out.println("Car's make: " + ticket2.getMake());
        System.out.println("Car's model: " + ticket2.getModel());
        System.out.println("Car's color: " + ticket2.getColor());
        System.out.println("License number: " + ticket2.getLicenseNum());
        System.out.println("Fine is " + ticket2.getFine());
        System.out.println("Officer's name: " + ticket2.getName());
        System.out.println("Officer's badge number: " + ticket2.getBadgeNum() + "\n");

        // Case5: Ticket more than one hour
        System.out.println("Test Case 5: Ticket more than one hour");
        car.setMinParked(230);
        System.out.println("The car has been parked for " + car.getMinParked() + " mins.");
        System.out.println("The car's parking time is expired? " + PoliceOfficer.isExpired(car, meter));
        ParkingTicket ticket3 = officer.issueTicket(car, meter);
        System.out.println("===== The following are tickets information =====");
        System.out.println("Car's make: " + ticket3.getMake());
        System.out.println("Car's model: " + ticket3.getModel());
        System.out.println("Car's color: " + ticket3.getColor());
        System.out.println("License number: " + ticket3.getLicenseNum());
        System.out.println("Fine is " + ticket3.getFine());
        System.out.println("Officer's name: " + ticket3.getName());
        System.out.println("Officer's badge number: " + ticket3.getBadgeNum() + "\n");

    }
}
