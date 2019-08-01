package model.items;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Book extends Item implements GeneralInformation {
    protected String title;

    protected int volumeOrChapter;

    protected String author;

    protected int year;

    protected int quantity;

    protected double priceTag;

    public static final List<Book> bookList = Collections.unmodifiableList(
            new ArrayList<Book>() {
                {
                    add(ArtBook.NIER);
                    add(Manga.PROMISED_MN);
                }
            }
    );

    public Book(String title, int volumeOrChapter, String author, int year, int quantity, double priceTag) {
        this.title = title;
        this.volumeOrChapter = volumeOrChapter;
        this.author = author;
        this.year = year;
        this.quantity = quantity;
        this.priceTag = priceTag;
    }

    public String getTitle() {
        return title;
    }

    public abstract String getVolumeOrChapter();

    public String getAuthor() {
        return ("by " + author);
    }

    public String getYearPublished() {
        return ("published in " + Integer.toString(year));
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

    public String setTitle(String newTitle) {
        return title = newTitle;
    }

    public abstract String mangaChapterOrArtBookVolume();


    public boolean containsNameOrTitle(String givenNameOrTitle) {
        return getTitle().toLowerCase().contains(givenNameOrTitle.toLowerCase());
    }
}