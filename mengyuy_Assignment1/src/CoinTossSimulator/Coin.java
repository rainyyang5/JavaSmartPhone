package CoinTossSimulator;

/**
 * Created by Mengyu Yang (AndrewID: mengyuy) on 9/5/15.
 */
public class Coin {
    private String sideUp;
    private final String HEAD = "heads";
    private final String TAIL = "tails";

    public Coin() {
        sideUp = Math.random() < 0.5 ? HEAD : TAIL;
    }

    public void toss() {
        sideUp = Math.random() < 0.5 ? HEAD : TAIL;
    }

    public String getSideUp() {
        return sideUp;
    }

    public void setSideUp(String sideUp) { this.sideUp = sideUp; }
}
