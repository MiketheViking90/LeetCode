package objectorienteddesign.blackjack;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
@ToString
public class Player {
    private final String name;
    private List<Card> hand = new ArrayList<>();

    public void getCard(Card card) {
        hand.add(card);
    }

    public boolean canHit() {
        return hand.size() < 5 && getHandValue(hand) <= 21;
    }

    public int getHandValue(List<Card> hand) {
        return hand.stream().mapToInt(Card::getRank).sum();
    }
}
