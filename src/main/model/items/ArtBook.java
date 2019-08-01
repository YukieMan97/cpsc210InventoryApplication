package model.items;

public class ArtBook extends Book {
    int quantity;
    double priceTag;

    public static final ArtBook NIER = new ArtBook("NieR: Automata World Guide", 1,
            "Square Enix",2019, 4, 49.99);

    public ArtBook(String title, int volumeOrChapter, String author,
                    int  year, int quantity, double priceTag) {
        super(title, volumeOrChapter, author, year, quantity, priceTag);
        this.quantity = quantity;
        this.priceTag = priceTag;

    }

    @Override
    public String getVolumeOrChapter() {
        return "vol. " + Integer.toString(volumeOrChapter);
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public double getPriceTag() {
        return priceTag;
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
