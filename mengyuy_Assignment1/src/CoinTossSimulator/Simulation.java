package CoinTossSimulator;


/**
 * Created by Mengyu Yang (AndrewID: mengyuy) on 9/5/15.
 */
public class Simulation {

    private static final String HEAD = "heads";
    private static final String TAIL = "tails";
    private static final int LOOP_NUM = 20;

    public static void main(String[] args) {
        Coin coin = new Coin();
        System.out.println("The side that is initially facing up is " + coin.getSideUp());
        int countHead = 0;
        int countTail = 0;

        for (int i = 0; i < LOOP_NUM; i++) {
            coin.toss();
            String faceUp = coin.getSideUp();
            System.out.println("The side that is facing up is " + faceUp);
            if (HEAD.equals(faceUp)) {
                countHead ++;
            } else if (TAIL.equals(faceUp)) {
                countTail++;
            }
        }

        System.out.println("The number of times heads is facing up is " + countHead);
        System.out.println("The number of times tails is facing up is " + countTail);
    }
}
