package objectorienteddesign.socialnetwork;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode
@RequiredArgsConstructor
@ToString
public class SearchKey {
    private final String word;
    private final long count;
}
