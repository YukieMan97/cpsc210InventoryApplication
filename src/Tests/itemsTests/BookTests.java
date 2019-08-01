package itemsTests;

import model.items.Item.ArtBook;
import model.items.Manga;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.items.Item.ArtBook.NIER;
import static model.items.Manga.PROMISED_MN;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookTests {
    private Manga mn;
    private ArtBook ab;

    @BeforeEach
    void BeforeTest() {
        mn = PROMISED_MN;
        ab = NIER;
    }

    @Test
    void getTitle() {
        assertTrue(mn.getTitle().equals("The Promised Neverland"));
        assertFalse(ab.getTitle().equals("Nieer: Automata World Guide"));
    }

    @Test
    void getAuthor() {
        assertTrue(mn.getAuthor().equals("by Kaiu Shirai and Posuka Demizu"));
        assertFalse(ab.getAuthor().equals("by Jojo"));
    }

    @Test
    void getVolumeOrChapter() {
        assertTrue(mn.getVolumeOrChapter().equals("ch. 2"));
        assertFalse(mn.getVolumeOrChapter().equals("ch. 3"));

        assertFalse(ab.getVolumeOrChapter().equals("vol. 2"));
        assertTrue(ab.getVolumeOrChapter().equals("vol. 1"));
    }

    @Test
    void getYearPublished() {
        assertTrue(mn.getYearPublished().equals("published in 2016"));
        assertFalse(ab.getYearPublished().equals("published in 1996)"));
    }

    @Test
    void getQuantity() {
        assertTrue(mn.getQuantity() == 1);
        assertFalse(ab.getQuantity() == 0);
    }

    @Test
    void getPriceTag() {
        assertTrue(mn.getPriceTag() == 14.99);
        assertFalse(ab.getPriceTag() == 34.99);
    }

    @Test
    void getInfo() {
        assertTrue(mn.getInformation().equals("The Promised Neverland ch. 2, by Kaiu Shirai and Posuka Demizu, published in 2016, Quantity: 1, $14.99"));
        System.out.println(mn.getInformation());

        assertTrue(ab.getInformation().equals("NieR: Automata World Guide vol. 1, by Square Enix, published in 2019, Quantity: 4, $49.99"));
        System.out.println(ab.getInformation());

        assertFalse(ab.getInformation().equals("NieR: Automata World Guide"));
    }

    // TODO
    @Test
    void setTitle() {
    }

    @Test
    void mangaOrArtBook() {
        System.out.println(mn.mangaChapterOrArtBookVolume());
        System.out.println(mn.getVolumeOrChapter().substring(0,3));
        System.out.println(mn.getVolumeOrChapter().substring(4));
        assertTrue(mn.mangaChapterOrArtBookVolume().equals("The chapter of this manga is 2."));
        assertFalse(mn.mangaChapterOrArtBookVolume().equals("This manga does not have any chapters."));

        System.out.println(ab.mangaChapterOrArtBookVolume());
        System.out.println(ab.getVolumeOrChapter().substring(0,4));
        System.out.println(ab.getVolumeOrChapter().substring(5));
        assertTrue(ab.mangaChapterOrArtBookVolume().equals("The volume of this art book is 1."));
        assertFalse(ab.mangaChapterOrArtBookVolume().equals("This art book does not have any volumes."));
    }

    @Test
    void doesContainNameOrTitle() {
        assertTrue(mn.containsNameOrTitle("Promised"));
    }
}
