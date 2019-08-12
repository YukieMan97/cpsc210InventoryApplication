package model.items;

import model.orders.ItemsSold;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Book extends Item implements GeneralInformation {
    private String title;
    int volumeOrChapter;
    private String author;
    private int year;
    protected int quantity;
    double priceTag;
    protected ItemsSold itemsSold;

    public static final ArrayList<Book> BOOK_LIST = new ArrayList<Book>() {
        {
            add(ArtBook.NIER);
            add(ArtBook.BATTLE_ANGEL);
            add(ArtBook.DARK_SOULS);
            add(ArtBook.TOKYO_GHOUL);
            add(ArtBook.FINAL_FANTASY);
            add(ArtBook.FINAL_FANTASY_2);
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

    public Book(String title, int volumeOrChapter, String author, int year,
                int quantity, double priceTag) {
        this.title = title;
        this.volumeOrChapter = volumeOrChapter;
        this.author = author;
        this.year = year;
        this.quantity = quantity;
        this.priceTag = priceTag;
        itemsSold = new ItemsSold();

    }

    public String getTitle() {
        return title;
    }

    public String setTitle(String newTitle) {
        return title = newTitle;
    }

    public abstract String getVolumeOrChapter();

    public String getAuthor() {
        return ("by " + author);
    }

    public String getYearPublished() {
        return ("published in " + Integer.toString(year));
    }

    public abstract String mangaChapterOrArtBookVolume();

    // REQUIRES: an actual word to properly find a book with a matching title.
    // MODIFIES: this
    // EFFECTS: returns true when the givenTitle is contained in a book title by making it
    //          lower cased first. Otherwise, return false.
    public boolean containsNameOrTitle(String givenTitle) {
        return getTitle().toLowerCase().contains(givenTitle.toLowerCase());
    }

    @Override
    public String getInformation() {
        return (getTitle() + " " + getVolumeOrChapter() + ", " + getAuthor() + ", "
                + getYearPublished() + ", Quantity: " + getQuantity() + ", $" + getPriceTag());
    }

    // MODIFIES: This
    // EFFECTS: purchases an item by decreasing its quantity by one.
    //          Also increases the amount of items sold by one.
    //          If the quantity is zero, then will print out a statement saying
    //          that the item will be unavailable for purchase but available
    //          for putting on hold.
    @Override
    public String purchaseItem() {
        if (quantity != 0) {
            itemsSold.sellItem();
            return Integer.toString(quantity -= 1);
        }
        return "This item is currently unavailable. However, it can be put on hold.";
    }

    // MOFIDIES: this
    // EFFECTS: puts an item on hold by decreasing the quantity by one.
    //          When the quantity becomes a negative integer, that indicates
    //          how much the store should order in.
    @Override
    public String putItemOnHold() {
        int newQuantity = (quantity -= 1);
        return Integer.toString(newQuantity);
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPriceTag() {
        return priceTag;
    }

    public double setPriceTag(double newPriceTag) {
        return priceTag = newPriceTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Book)) {
            return false;
        }
        Book book = (Book) o;
        return volumeOrChapter == book.volumeOrChapter
                && year == book.year
                && Objects.equals(title, book.title)
                && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, volumeOrChapter, author, year);
    }
}