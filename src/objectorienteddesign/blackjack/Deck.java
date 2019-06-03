package objectorienteddesign.blackjack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Deck implements Iterable<Card> {
    LinkedList<Card> cards;

    public Deck() {
        cards = new LinkedList<>();
        for (Suite suite : Suite.values()) {
            for (int i = 1; i <= 13; i++) {
                Card card = new Card(suite, i);
                cards.add(card);
            }
        }
        shuffle();
    }

    private void shuffle() {
        List<Card> shuffleCards = new ArrayList<Card>(cards);
        int N = shuffleCards.size();
        for (int i = 0; i < N; i++) {
            int j = (int) (Math.random() * (N - i));
            Card tmp = shuffleCards.get(i);
            shuffleCards.set(i, shuffleCards.get(j));
            shuffleCards.set(j, tmp);
        }
        cards = new LinkedList<>(shuffleCards);
    }

    public Card deal() {
        if (!cards.isEmpty()) {
            return cards.poll();
        }
        return null;
    }

    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();
        Card c1 = deck.deal();
        Card c2 = deck.deal();
        Card c3 = deck.deal();
        Card c4 = deck.deal();
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(deck.cards.size());
    }

}
