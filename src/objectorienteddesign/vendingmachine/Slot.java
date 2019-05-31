package objectorienteddesign.vendingmachine;

import lombok.Getter;

import java.util.Queue;

@Getter
public class Slot {
    Queue<Item> items;
}
