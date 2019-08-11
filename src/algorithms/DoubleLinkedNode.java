package algorithms;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class DoubleLinkedNode {
    DoubleLinkedNode prev;
    DoubleLinkedNode next;

    final String k;
    final int v;
}
