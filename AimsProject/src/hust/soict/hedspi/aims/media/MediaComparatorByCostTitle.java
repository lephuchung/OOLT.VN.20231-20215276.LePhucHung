package AimsProject.src.hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    public MediaComparatorByCostTitle() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public int compare(Media md1, Media md2) {
        if(md1.getCost() != md2.getCost()) {
            return Float.compare(md1.getCost(), md2.getCost());
        }

        return md1.getTitle().compareTo(md2.getTitle());
    }
}
