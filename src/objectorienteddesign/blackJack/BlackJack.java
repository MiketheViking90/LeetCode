package objectorienteddesign.blackJack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJack {
    private Dealer dealer;
    private List<Player> players = new ArrayList<>();
    private Scanner scan;

    public BlackJack() {
        dealer = new Dealer();
        Player player1 = new Player("Bill");
        Player player2 = new Player("Jay");
        players.add(player1);
        players.add(player2);
    }

    private void playGame(Scanner scan) {
        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                dealer.dealCard(player);
            }
        }

        for (Player player : players) {
            System.out.println(player.getHand());
        }

        for (Player player : players) {
            playRound(player);
        }
    }

    private void playRound(Player player) {
        System.out.println(player);
        while (player.canHit() && scan.nextLine().equals("h")) {
            dealer.dealCard(player);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BlackJack blackJack = new BlackJack();
        blackJack.scan = scan;
        blackJack.playGame(scan);
    }

}
