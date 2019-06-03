package objectorienteddesign.blackjack;

public class Dealer {
    Deck deck;

    public Dealer() {
        deck = new Deck();
    }

    public void dealCard(Player player) {
        Card card = deck.deal();
        player.getCard(card);
    }
}
