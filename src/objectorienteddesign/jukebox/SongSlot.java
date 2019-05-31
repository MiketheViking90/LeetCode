package objectorienteddesign.jukebox;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SongSlot {
    private Song song;

    public void play() {
        song.playSong();
    }
}
