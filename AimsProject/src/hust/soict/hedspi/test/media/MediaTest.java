package AimsProject.src.hust.soict.hedspi.test.media;

import AimsProject.src.hust.soict.hedspi.aims.media.Book;
import AimsProject.src.hust.soict.hedspi.aims.media.CompactDisc;
import AimsProject.src.hust.soict.hedspi.aims.media.DigitalVideoDisc;
import AimsProject.src.hust.soict.hedspi.aims.media.Media;

import java.util.List;
import java.util.ArrayList;

public class MediaTest {

    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();
        CompactDisc cd = new CompactDisc("Sơn Tung MTP","Ca Nhac","Em Cua Ngay Homie",15.00f);
        DigitalVideoDisc dvd = new DigitalVideoDisc("Narutoo","Anime","WibuNo1",23,2.50f);
        Book book = new Book("haha","Truyen cuoi", 1.50f);
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        for(Media m: mediae) {
            System.out.println(m.toString());
        }
    }

}