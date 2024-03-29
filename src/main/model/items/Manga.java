package model.items;

import java.util.ArrayList;

public class Manga extends Book {

    public static final Manga PROMISED_MN1 = new Manga("The Promised Neverland", 1,
            "Kaiu Shirai and Posuka Demizu", 2016, 1, 14.99);
    public static final Manga PROMISED_MN2 = new Manga("The Promised Neverland", 2,
            "Kaiu Shirai and Posuka Demizu", 2016, 1, 14.99);
    public static final Manga PROMISED_MN3 = new Manga("The Promised Neverland", 3,
            "Kaiu Shirai and Posuka Demizu", 2016, 3, 14.99);
    public static final Manga KAKEGURUI = new Manga("Kakegurui", 1,
            "Homura Kawamoto & Toru Naomura (Illustrator)", 2017, 0, 16.99);
    public static final Manga KAKEGURUI_2 = new Manga("Kakegurui", 2,
            "Homura Kawamoto & Toru Naomura (Illustrator)", 2017, 4, 16.99);
    public static final Manga KAKEGURUI_3 = new Manga("Kakegurui", 2,
            "Homura Kawamoto & Toru Naomura (Illustrator)", 2017, 0, 16.99);
    public static final Manga NARUTO_SHIPPUDEN = new Manga("Naruto", 45,
            "Masashi Kishimoto", 2015, 2, 13.99);
    public static final Manga OVERLORD = new Manga("Overlord", 10,
            "Kugane Maruyama", 2016, 4, 15.99);

    public static final ArrayList<Manga> MANGA_LIST = new ArrayList<Manga>() {
        {
            add(Manga.PROMISED_MN1);
            add(Manga.PROMISED_MN2);
            add(Manga.PROMISED_MN3);
            add(Manga.KAKEGURUI);
            add(Manga.KAKEGURUI_2);
            add(Manga.KAKEGURUI_3);
            add(Manga.NARUTO_SHIPPUDEN);
            add(Manga.OVERLORD);
        }
    };

    public Manga(String title, int volumeOrChapter, String author, int year, int quantity, double priceTag) {
        super(title, volumeOrChapter, author, year, quantity, priceTag);
    }

    // EFFECTS: returns the quantity of a manga
    @Override
    public int getQuantity() {
        return quantity;
    }

    // EFFECTS returns the chapter of the manga
    @Override
    public String getVolumeOrChapter() {
        if (volumeOrChapter == 0) {
            return "(no chapter)";
        }
        return "ch. " + volumeOrChapter;
    }

    @Override
    public String mangaChapterOrArtBookVolume() {
        if (getVolumeOrChapter().substring(0, 3).equals("ch.")) {
            return "The chapter of this manga is " + getVolumeOrChapter().substring(4) + ".";
        }
        return "This manga does not have any chapters.";
    }

    @Override
    public double getPriceTag() {
        return priceTag;
    }

    @Override
    public double setPriceTag(double newPriceTag) {
        return priceTag = newPriceTag;
    }

    // EFFECTS: returns all of the information about the book which includes its title,
    //          volume or chapter, author, year published, quantity, and price
    @Override
    public String getInformation() {
        return (getTitle() + " " + getVolumeOrChapter() + ", " + getAuthor() + ", "
                + getYearPublished() + ", Quantity: " + getQuantity() + ", $" + getPriceTag());
    }
}
