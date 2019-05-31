package objectorienteddesign.jukebox;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class Song {
    private final String name;

    public void playSong() {
        System.out.println(name);
    }
}
