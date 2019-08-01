package model.items;

public class Manga extends Book {
    int quantity;
    double priceTag;

    public static final Manga PROMISED_MN = new Manga("The Promised Neverland", 2,
            "Kaiu Shirai and Posuka Demizu", 2016, 1, 14.99);

    public Manga(String title, int volumeOrChapter, String author, int year, int quantity, double priceTag) {
        super(title, volumeOrChapter, author, year, quantity, priceTag);
    }


    @Override
    public String getVolumeOrChapter() {
        return "ch. " + volumeOrChapter;
    }

    @Override
    public String mangaChapterOrArtBookVolume() {
        if (getVolumeOrChapter().substring(0, 3).equals("ch.")) {
            return "The chapter of this manga is " + getVolumeOrChapter().substring(4) + ".";
        }
        return "This manga does not have any chapters.";
    }
}
