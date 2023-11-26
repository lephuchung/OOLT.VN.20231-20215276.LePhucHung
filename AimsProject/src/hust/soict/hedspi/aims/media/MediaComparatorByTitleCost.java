package AimsProject.src.hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    public MediaComparatorByTitleCost() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public int compare(Media md1, Media md2) {
        if(md1.getTitle().equals(md2.getTitle())) {
            return Float.compare(md1.getCost(),md2.getCost());
        }

        return md1.getTitle().compareTo(md2.getTitle());
    }
}
