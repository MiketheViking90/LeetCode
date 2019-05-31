package objectorienteddesign.callCenter;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CallCenter {
    private final List<Employee> directors = new ArrayList<>();
    private final Queue<Employee> responders = new LinkedList<>();
    private final Queue<Call> callsOnHold = new LinkedList<>();

    public void takeCall(@NonNull Call call) {
        Employee responder = responders.poll();
        responder.acceptCall(call);
        responders.offer(responder);
    }

}
