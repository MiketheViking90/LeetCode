package objectorienteddesign.carrental;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@ToString
public class Event {
    public Renter renter;
    private LocalDateTime eventTime;
    private final String descr;
}
