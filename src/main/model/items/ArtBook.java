package model.items;

import java.util.ArrayList;

public class ArtBook extends Book {
    int quantity;
    double priceTag;

    public static final ArtBook NIER = new ArtBook("NieR: Automata World Guide", 1,
            "Square Enix",2019, 4, 49.99);
    public static final ArtBook TOKYO_GHOUL = new ArtBook("Tokyo Ghoul Illustrations: Zakki", 0,
            "Sui Ishida", 2017, 2, 24.99);
    public static final ArtBook DARK_SOULS = new ArtBook("Dark Souls: Design Works", 0,
            "From Software", 2014, 0, 56.99);
    public static final ArtBook BATTLE_ANGEL = new ArtBook("Battle Angel Alita Deluxe Complete Series Box Set",
            0, "Yukito Kishiro", 2018, 1, 164.99);

    public static final ArrayList<ArtBook> ARTBOOK_LIST = new ArrayList<ArtBook>() {
        {
            add(ArtBook.NIER);
            add(ArtBook.BATTLE_ANGEL);
            add(ArtBook.DARK_SOULS);
            add(ArtBook.TOKYO_GHOUL);
        }
    };

    public ArtBook(String title, int volumeOrChapter, String author,
                    int  year, int quantity, double priceTag) {
        super(title, volumeOrChapter, author, year, quantity, priceTag);
    }

    @Override
    public String getVolumeOrChapter() {
        if (volumeOrChapter == 0) {
            return "(no volume)";
        }
        return "vol. " + Integer.toString(volumeOrChapter);
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public int putItemOnHold() {
        return quantity--;
    }


    @Override
    public double setPriceTag(double newPriceTag) {
        return priceTag = newPriceTag;
    }


    @Override
    public String getInformation() {
        return (getTitle() + " " + getVolumeOrChapter() + ", " + getAuthor() + ", "
                + getYearPublished() + ", Quantity: " + quantity + ", $" + priceTag);
    }

    @Override
    public String mangaChapterOrArtBookVolume() {
        if (getVolumeOrChapter().substring(0, 4).equals("vol.")) {
            return "The volume of this art book is " + getVolumeOrChapter().substring(5) + ".";
        }
        return "This art book does not have any volumes.";
    }

}
