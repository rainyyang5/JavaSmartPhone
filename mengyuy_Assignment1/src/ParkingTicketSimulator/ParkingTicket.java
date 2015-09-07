package ParkingTicketSimulator;

/**
 * Created by Mengyu Yang (AndrewID: mengyuy) on 9/5/15.
 */
public class ParkingTicket {
    private String make;
    private String model;
    private String color;
    private String licenseNum;
    private int fine;
    private String name;
    private String badgeNum;


    public ParkingTicket(String make, String model, String color, String licenseNum, int fine, String name, String badgeNum) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.licenseNum = licenseNum;
        this.fine = fine;
        this.name = name;
        this.badgeNum = badgeNum;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicenseNum() {
        return licenseNum;
    }

    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBadgeNum() {
        return badgeNum;
    }

    public void setBadgeNum(String badgeNum) {
        this.badgeNum = badgeNum;
    }
}
