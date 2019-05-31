package objectorienteddesign.callCenter;

import java.util.List;

public abstract class Employee {
    Call call;
    Employee boss;
    List<Employee> reports;

    abstract boolean isLeaf();
    abstract boolean hasBoss();
    abstract boolean escalate(Call call);

    public boolean acceptCall(Call call) {
        if (call == null) {
            this.call = call;
            return true;
        } else {
            return escalate(call);
        }
    }

    public void finishCall() {
        call = null;
    }

    boolean isAvailable() {
        return call == null;
    }


    public Employee getBoss() {
        return boss;
    }
}
