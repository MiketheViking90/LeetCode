package designpatterns.adapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DuckToChickenAdapter implements Chicken {

    private final Duck duck;

    @Override
    public void cluck() {
        duck.quck();
    }

    @Override
    public void fly() {
        duck.swim();
    }

}
