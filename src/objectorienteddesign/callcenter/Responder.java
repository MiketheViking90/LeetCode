package objectorienteddesign.callcenter;

public class Responder extends Employee {
    @Override
    boolean isLeaf() {
        return true;
    }

    @Override
    boolean hasBoss() {
        return true;
    }

    @Override
    boolean escalate(Call call) {
        return getBoss().acceptCall(call);
    }
}
