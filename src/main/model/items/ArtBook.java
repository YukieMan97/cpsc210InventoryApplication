package model.items;

import java.util.ArrayList;

public class ArtBook extends Book {

    public static final ArtBook NIER = new ArtBook("NieR: Automata World Guide",
            1, "Square Enix",2019, 4, 49.99);
    public static final ArtBook TOKYO_GHOUL = new ArtBook("Tokyo Ghoul Illustrations: Zakki",
            0, "Sui Ishida", 2017, 2, 24.99);
    public static final ArtBook DARK_SOULS = new ArtBook("Dark Souls: Design Works",
            0, "From Software", 2014, 0, 56.99);
    public static final ArtBook BATTLE_ANGEL = new ArtBook("Battle Angel Alita Deluxe Complete Series Box Set",
            0, "Yukito Kishiro", 2018, 1, 164.99);
    public static final ArtBook FINAL_FANTASY = new ArtBook("Final Fantasy Ultimania",
            1, "Square Enix", 2018, 3, 49.99);
    public static final ArtBook FINAL_FANTASY_2 = new ArtBook("Final Fantasy Ultimania",
            2, "Square Enix", 2018, 0, 53.99);

    public static final ArrayList<ArtBook> ARTBOOK_LIST = new ArrayList<ArtBook>() {
        {
            add(ArtBook.NIER);
            add(ArtBook.BATTLE_ANGEL);
            add(ArtBook.DARK_SOULS);
            add(ArtBook.TOKYO_GHOUL);
            add(ArtBook.FINAL_FANTASY);
            add(ArtBook.FINAL_FANTASY_2);
        }
    };

    private ArtBook(String title, int volumeOrChapter, String author,
                    int year, int quantity, double priceTag) {
        super(title, volumeOrChapter, author, year, quantity, priceTag);
    }

    // EFFECTS returns the volume of the art book
    @Override
    public String getVolumeOrChapter() {
        if (volumeOrChapter == 0) {
            return "(no volume)";
        }
        return "vol. " + Integer.toString(volumeOrChapter);
    }

    // EFFECTS: returns the quantity of an art book
    @Override
    public int getQuantity() {
        return quantity;
    }

    // EFFECTS: returns the current price of an art book
    @Override
    public double getPriceTag() {
        return priceTag;
    }

    // MODIFIES: this
    // EFFECTS: sets a new price and returns it
    @Override
    public double setPriceTag(double newPriceTag) {
        return priceTag = newPriceTag;
    }

    // EFFECTS: returns all of the information about the book which includes its title,
    //          volume or chapter, author, year published, quantity, and price
    @Override
    public String getInformation() {
        return (getTitle() + " " + getVolumeOrChapter() + ", " + getAuthor() + ", "
                + getYearPublished() + ", Quantity: " + quantity + ", $" + priceTag);
    }

    // EFFECTS: returns the volume of the artbook unless there isn't a volume
    @Override
    public String mangaChapterOrArtBookVolume() {
        if (getVolumeOrChapter().substring(0, 4).equals("vol.")) {
            return "The volume of this art book is " + getVolumeOrChapter().substring(5) + ".";
        }
        return "This art book does not have any volumes.";
    }

}
