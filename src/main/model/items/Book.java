package model.items;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Book extends Item implements GeneralInformation {
    protected String title;
    protected int volumeOrChapter;
    protected String author;
    protected int year;
    protected int quantity;
    protected double priceTag;
    protected static ArrayList<ArtBook> artBookArrayList;
    protected static ArrayList<Manga> mangaArrayList;

    public static final ArrayList<Book> BOOK_LIST = new ArrayList<Book>() {
        {
//            BOOK_LIST.addAll(artBookArrayList);
//            BOOK_LIST.addAll(mangaArrayList);
            add(ArtBook.NIER);
            add(ArtBook.BATTLE_ANGEL);
            add(ArtBook.DARK_SOULS);
            add(ArtBook.TOKYO_GHOUL);
            add(Manga.PROMISED_MN1);
            add(Manga.PROMISED_MN2);
            add(Manga.PROMISED_MN3);
            add(Manga.KAKEGURUI);
            add(Manga.NARUTO_SHIPPUDEN);
            add(Manga.OVERLORD);
        }
    };

    public Book(String title, int volumeOrChapter, String author, int year, int quantity, double priceTag) {
        this.title = title;
        this.volumeOrChapter = volumeOrChapter;
        this.author = author;
        this.year = year;
        this.quantity = quantity;
        this.priceTag = priceTag;
        artBookArrayList = ArtBook.ARTBOOK_LIST;
        mangaArrayList = Manga.MANGA_LIST;

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

    public boolean containsNameOrTitle(String givenNameOrTitle) {
        return getTitle().toLowerCase().contains(givenNameOrTitle.toLowerCase());
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public String getInformation() {
        return (getTitle() + " " + getVolumeOrChapter() + ", " + getAuthor() + ", "
                + getYearPublished() + ", Quantity: " + quantity + ", $" + priceTag);
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