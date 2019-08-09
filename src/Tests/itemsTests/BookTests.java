package itemsTests;

import model.items.ArtBook;
import model.items.Manga;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.items.ArtBook.DARK_SOULS;
import static model.items.ArtBook.NIER;
import static model.items.ArtBook.TOKYO_GHOUL;
import static model.items.Manga.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookTests {
    private Manga mn1;
    private Manga mn2;
    private Manga mn3;
    private Manga mn4;
    private ArtBook ab;
    private ArtBook ab2;
    private ArtBook ab3;

    @BeforeEach
    void BeforeTest() {
        mn1 = NARUTO_SHIPPUDEN;
        mn2 = PROMISED_MN2;
        mn3 = KAKEGURUI;
        mn4 = OVERLORD;
        ab = NIER;
        ab2 = DARK_SOULS;
        ab3 = TOKYO_GHOUL;

    }

    @Test
    void testGetTitleOfBook() {
        assertTrue(mn2.getTitle().equals("The Promised Neverland"));
        assertFalse(ab.getTitle().equals("Nieer: Automata World Guide"));
    }

    @Test
    void testSetTitleOfBook() {
        assertTrue(mn1.getTitle().equals("Naruto"));
        mn1.setTitle("Naruto Shippuden!");
        assertFalse(mn1.getTitle().equals("Naruto"));
        assertTrue(mn1.getTitle().equals("Naruto Shippuden!"));
    }

    @Test
    void testGetAuthorOfBook() {
        assertTrue(mn2.getAuthor().equals("by Kaiu Shirai and Posuka Demizu"));
        assertFalse(ab.getAuthor().equals("by Jojo"));
    }

    @Test
    void testGetVolumeOfBook() {
        assertTrue(ab2.getVolumeOrChapter().equals("(no volume)"));
        assertFalse(ab.getVolumeOrChapter().equals("vol. 2"));
        assertTrue(ab.getVolumeOrChapter().equals("vol. 1"));
    }

    @Test
    void testGetPriceTagOfBook() {
        assertTrue(ab.getPriceTag() == 49.99);
        assertFalse(ab.getPriceTag() == 34.99);
    }

    @Test
    void testSetPriceTag() {
        assertTrue(mn2.getPriceTag() == 14.99);
        mn2.setPriceTag(14.99);
        assertTrue(mn2.getPriceTag() == 14.99);
        mn2.setPriceTag(26.99);
        assertTrue(mn2.getPriceTag() == 26.99);
    }

    @Test
    void testGetChapterOfBook() {
        assertTrue(mn1.getVolumeOrChapter().equals("ch. 45"));
        assertTrue(mn2.getVolumeOrChapter().equals("ch. 2"));
        assertFalse(mn2.getVolumeOrChapter().equals("ch. 3"));
    }

    @Test
    void testYearPublished() {
        assertTrue(mn2.getYearPublished().equals("published in 2016"));
        assertFalse(ab.getYearPublished().equals("published in 1996)"));
    }

    @Test
    void testGetQuantityOfBook() {
        assertTrue(mn4.getQuantity() == 4);
        System.out.println(ab.getQuantity());
        assertFalse(ab.getQuantity() == 0);
    }

    @Test
    void testGetInfoOfBook() {
        System.out.println(ab3.getInformation());
        assertTrue(ab3.getInformation().equals("Tokyo Ghoul Illustrations: Zakki (no volume), by Sui Ishida, published in 2017, Quantity: 2, $24.99"));
        System.out.println(ab3.getInformation());
        assertFalse(ab.getInformation().equals("Tokyo Ghoul Illustrations: Zakki"));
    }

    @Test
    void testIfManga() {
        System.out.println(mn2.mangaChapterOrArtBookVolume());
        System.out.println(mn2.getVolumeOrChapter().substring(0, 3));
        System.out.println(mn2.getVolumeOrChapter().substring(4));
        assertTrue(mn2.mangaChapterOrArtBookVolume().equals("The chapter of this manga is 2."));
        assertFalse(mn2.mangaChapterOrArtBookVolume().equals("This manga does not have any chapters."));

        System.out.println(mn1.mangaChapterOrArtBookVolume());
        assertTrue(mn1.mangaChapterOrArtBookVolume().equals("The chapter of this manga is 45."));
    }

    @Test
    void testIfArtBook() {
        System.out.println(ab.mangaChapterOrArtBookVolume());
        System.out.println(ab.getVolumeOrChapter().substring(0, 4));
        System.out.println(ab.getVolumeOrChapter().substring(5));
        assertTrue(ab.mangaChapterOrArtBookVolume().equals("The volume of this art book is 1."));
        assertFalse(ab.mangaChapterOrArtBookVolume().equals("This art book does not have any volumes."));
    }

    @Test
    void testDoesContainBookTitle() {
        assertTrue(mn2.containsNameOrTitle("Promised"));
        assertTrue(mn2.containsNameOrTitle("promised"));
        assertFalse(mn2.containsNameOrTitle("Proomised"));
    }

    @Test
    void testPurchaseBook() {
        assertTrue(mn1.getQuantity() == 2);
        mn1.purchaseItem();
        assertTrue(mn1.getQuantity() == 1);
        mn2.purchaseItem();
        assertTrue(mn2.getQuantity() == 0);
    }

    @Test
    void testPutBookOnHold() {
        assertTrue(ab.getQuantity() == 4);
        ab.putItemOnHold();
        assertTrue(ab.getQuantity() == 3);

        mn3.putItemOnHold();
        assertTrue(mn3.getQuantity() == -1);
    }

    @Test
    void testEquals() {
        assertFalse(mn1.equals(mn2));
    }
}
