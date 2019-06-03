package objectorienteddesign.blackjack;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class Card {
    private final Suite suite;
    private final int rank;
}
