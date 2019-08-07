package itemsTests;

import model.items.ArtBook;
import model.items.Manga;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.items.ArtBook.NIER;
import static model.items.Manga.NARUTO_SHIPPUDEN;
import static model.items.Manga.PROMISED_MN2;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookTests {
    private Manga mn1;
    private Manga mn2;
    private ArtBook ab;

    @BeforeEach
    void BeforeTest() {
        mn1 = NARUTO_SHIPPUDEN;
        mn2 = PROMISED_MN2;
        ab = NIER;

    }

    @Test
    void getTitle() {
        assertTrue(mn2.getTitle().equals("The Promised Neverland"));
        assertFalse(ab.getTitle().equals("Nieer: Automata World Guide"));
    }

    @Test
    void getAuthor() {
        assertTrue(mn2.getAuthor().equals("by Kaiu Shirai and Posuka Demizu"));
        assertFalse(ab.getAuthor().equals("by Jojo"));
    }

    @Test
    void getVolumeOrChapter() {
        assertTrue(mn1.getVolumeOrChapter().equals("ch. 45"));

        assertTrue(mn2.getVolumeOrChapter().equals("ch. 2"));
        assertFalse(mn2.getVolumeOrChapter().equals("ch. 3"));

        assertFalse(ab.getVolumeOrChapter().equals("vol. 2"));
        assertTrue(ab.getVolumeOrChapter().equals("vol. 1"));
    }

    @Test
    void getYearPublished() {
        assertTrue(mn2.getYearPublished().equals("published in 2016"));
        assertFalse(ab.getYearPublished().equals("published in 1996)"));
    }

    @Test
    void getQuantity() {
        assertTrue(mn2.getQuantity() == 1);
        assertFalse(ab.getQuantity() == 0);
    }

    @Test
    void getPriceTag() {
        assertTrue(mn2.getPriceTag() == 14.99);
        assertFalse(ab.getPriceTag() == 34.99);
    }

    @Test
    void getInfo() {
        assertTrue(mn2.getInformation().equals("The Promised Neverland ch. 2, by Kaiu Shirai and Posuka Demizu, published in 2016, Quantity: 1, $14.99"));
        System.out.println(mn2.getInformation());

        assertTrue(ab.getInformation().equals("NieR: Automata World Guide vol. 1, by Square Enix, published in 2019, Quantity: 4, $49.99"));
        System.out.println(ab.getInformation());

        assertFalse(ab.getInformation().equals("NieR: Automata World Guide"));
    }

    // TODO
    @Test
    void setTitle() {
        assertTrue(mn1.getTitle().equals("Naruto"));
        mn1.setTitle("Naruto Shippuden!");
        assertFalse(mn1.getTitle().equals("Naruto"));
        assertTrue(mn1.getTitle().equals("Naruto Shippuden!"));
    }

    @Test
    void mangaOrArtBook() {
        System.out.println(mn2.mangaChapterOrArtBookVolume());
        System.out.println(mn2.getVolumeOrChapter().substring(0,3));
        System.out.println(mn2.getVolumeOrChapter().substring(4));
        assertTrue(mn2.mangaChapterOrArtBookVolume().equals("The chapter of this manga is 2."));
        assertFalse(mn2.mangaChapterOrArtBookVolume().equals("This manga does not have any chapters."));

        System.out.println(mn1.mangaChapterOrArtBookVolume());
        assertTrue(mn1.mangaChapterOrArtBookVolume().equals("The chapter of this manga is 45."));

        System.out.println(ab.mangaChapterOrArtBookVolume());
        System.out.println(ab.getVolumeOrChapter().substring(0,4));
        System.out.println(ab.getVolumeOrChapter().substring(5));
        assertTrue(ab.mangaChapterOrArtBookVolume().equals("The volume of this art book is 1."));
        assertFalse(ab.mangaChapterOrArtBookVolume().equals("This art book does not have any volumes."));
    }

    @Test
    void doesContainNameOrTitle() {
        assertTrue(mn2.containsNameOrTitle("Promised"));
    }
}
