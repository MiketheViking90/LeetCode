package objectorienteddesign.callCenter;

public class Director extends Employee {
    @Override
    boolean isLeaf() {
        return false;
    }

    @Override
    boolean hasBoss() {
        return false;
    }

    @Override
    boolean escalate(Call call) {
        return false;
    }
}
