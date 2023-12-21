package AimsProject.src.hust.soict.hedspi.aims.media;

import AimsProject.src.hust.soict.hedspi.aims.exception.PlayerException;

public interface Playable {
    public String[] play() throws PlayerException;
}