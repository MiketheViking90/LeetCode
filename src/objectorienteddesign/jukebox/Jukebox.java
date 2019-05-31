package objectorienteddesign.jukebox;

import java.util.List;

public class Jukebox {
    List<SongSlot> slots;

    void setSong(int i, Song song) {
        slots.get(i).setSong(song);
    }

    void playSong(int i) {
        slots.get(i).play();
    }
}
