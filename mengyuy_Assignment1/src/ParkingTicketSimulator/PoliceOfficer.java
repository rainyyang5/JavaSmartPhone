package ParkingTicketSimulator;

/**
 * Created by Mengyu Yang (AndrewID: mengyuy) on 9/5/15.
 */
public class PoliceOfficer {
    private String name;
    private String badgeNum;
    private static final int INIT_FINE = 25;
    private static final int EXTRA_FINE = 10;
    private static final double MINS_PER_HOUR = 60d;

    public PoliceOfficer() {}
    public PoliceOfficer(String name, String badgeNum) {
        this.name = name;
        this.badgeNum = badgeNum;
    }

    public static boolean isExpired(ParkedCar car, ParkingMeter meter) {
        return car.getMinParked() - meter.getMinPurchased() > 0 ? true : false;
    }

    public ParkingTicket issueTicket(ParkedCar car, ParkingMeter meter) {
        if (isExpired(car, meter)) {
            return new ParkingTicket(car.getMake(), car.getModel(), car.getColor(), car.getLicenseNumber(),
                    getFine(car.getMinParked() - meter.getMinPurchased()), name, badgeNum);
        }
        return null;
    }

    private static int getFine(int expiredTime) {
        int fine = 0;
        int expiredHour = (int)(Math.ceil(expiredTime / MINS_PER_HOUR));
        if (expiredHour <= 1) {
            fine = INIT_FINE;
        } else if (expiredHour > 1) {
            fine = INIT_FINE + (expiredHour - 1) * EXTRA_FINE;
        }
        return fine;
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
