package objectorienteddesign.vendingmachine;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@RequiredArgsConstructor
@ToString
public class Item {
    String name;
    double price;
}
