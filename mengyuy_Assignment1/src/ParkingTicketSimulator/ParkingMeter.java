package ParkingTicketSimulator;

/**
 * Created by Mengyu Yang (AndrewID: mengyuy) on 9/5/15.
 */
public class ParkingMeter {
    private int minPurchased;

    public ParkingMeter() {}

    public ParkingMeter(int minPurchased) {
        this.minPurchased = minPurchased;
    }

    public int getMinPurchased() {
        return minPurchased;
    }

    public void setMinPurchased(int minPurchased) {
        this.minPurchased = minPurchased;
    }
}
