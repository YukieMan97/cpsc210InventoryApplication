package itemsTests;

import model.items.ArtBook;
import model.items.Manga;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.items.ArtBook.DARK_SOULS;
import static model.items.ArtBook.NIER;
import static model.items.Manga.KAKEGURUI;
import static model.items.Manga.NARUTO_SHIPPUDEN;
import static model.items.Manga.PROMISED_MN2;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookTests {
    private Manga mn1;
    private Manga mn2;
    private Manga mn3;
    private ArtBook ab;
    private ArtBook ab2;

    @BeforeEach
    void BeforeTest() {
        mn1 = NARUTO_SHIPPUDEN;
        mn2 = PROMISED_MN2;
        mn3 = KAKEGURUI;
        ab = NIER;
        ab2 = DARK_SOULS;

    }

    @Test
    void TestGetTitleOfBook() {
        assertTrue(mn2.getTitle().equals("The Promised Neverland"));
        assertFalse(ab.getTitle().equals("Nieer: Automata World Guide"));
    }

    @Test
    void TestSetTitleOfBook() {
        assertTrue(mn1.getTitle().equals("Naruto"));
        mn1.setTitle("Naruto Shippuden!");
        assertFalse(mn1.getTitle().equals("Naruto"));
        assertTrue(mn1.getTitle().equals("Naruto Shippuden!"));
    }

    @Test
    void TestGetAuthorOfBook() {
        assertTrue(mn2.getAuthor().equals("by Kaiu Shirai and Posuka Demizu"));
        assertFalse(ab.getAuthor().equals("by Jojo"));
    }

    @Test
    void TestGetVolumeOfBook() {
        assertTrue(ab2.getVolumeOrChapter().equals("(no volume)"));
        assertFalse(ab.getVolumeOrChapter().equals("vol. 2"));
        assertTrue(ab.getVolumeOrChapter().equals("vol. 1"));
    }

    @Test
    void TestGetPriceTagOfBook() {
        assertTrue(ab.getPriceTag() == 49.99);
        assertFalse(ab.getPriceTag() == 34.99);
    }

    @Test
    void TestSetPriceTag() {
        assertTrue(mn2.getPriceTag() == 14.99);
        mn2.setPriceTag(14.99);
        assertTrue(mn2.getPriceTag() == 14.99);
        mn2.setPriceTag(26.99);
        assertTrue(mn2.getPriceTag() == 26.99);
    }

    @Test
    void TestGetChapterOfBook() {
        assertTrue(mn1.getVolumeOrChapter().equals("ch. 45"));
        assertTrue(mn2.getVolumeOrChapter().equals("ch. 2"));
        assertFalse(mn2.getVolumeOrChapter().equals("ch. 3"));
    }

    @Test
    void TestYearPublished() {
        assertTrue(mn2.getYearPublished().equals("published in 2016"));
        assertFalse(ab.getYearPublished().equals("published in 1996)"));
    }

    @Test
    void TestGetQuantityOfBook() {
        assertTrue(mn2.getQuantity() == 1);
        System.out.println(ab.getQuantity());
        assertFalse(ab.getQuantity() == 0);
    }

    @Test
    void TestGetInfoOfBook() {
        System.out.println(ab.getInformation());
        assertTrue(ab.getInformation().equals("NieR: Automata World Guide vol. 1, by Square Enix, published in 2019, Quantity: 4, $49.99"));
        System.out.println(ab.getInformation());

        assertFalse(ab.getInformation().equals("NieR: Automata World Guide"));
    }

    @Test
    void TestIfManga() {
        System.out.println(mn2.mangaChapterOrArtBookVolume());
        System.out.println(mn2.getVolumeOrChapter().substring(0, 3));
        System.out.println(mn2.getVolumeOrChapter().substring(4));
        assertTrue(mn2.mangaChapterOrArtBookVolume().equals("The chapter of this manga is 2."));
        assertFalse(mn2.mangaChapterOrArtBookVolume().equals("This manga does not have any chapters."));

        System.out.println(mn1.mangaChapterOrArtBookVolume());
        assertTrue(mn1.mangaChapterOrArtBookVolume().equals("The chapter of this manga is 45."));
    }

    @Test
    void TestIfArtBook() {
        System.out.println(ab.mangaChapterOrArtBookVolume());
        System.out.println(ab.getVolumeOrChapter().substring(0, 4));
        System.out.println(ab.getVolumeOrChapter().substring(5));
        assertTrue(ab.mangaChapterOrArtBookVolume().equals("The volume of this art book is 1."));
        assertFalse(ab.mangaChapterOrArtBookVolume().equals("This art book does not have any volumes."));
    }

    @Test
    void TestDoesContainBookTitle() {
        assertTrue(mn2.containsNameOrTitle("Promised"));
        assertTrue(mn2.containsNameOrTitle("promised"));
        assertFalse(mn2.containsNameOrTitle("Proomised"));
    }

    @Test
    void TestPurchaseBook() {
        assertTrue(mn1.getQuantity() == 2);
        mn1.purchaseItem();
        assertTrue(mn1.getQuantity() == 1);
        mn3.purchaseItem();
        assertTrue(mn3.getQuantity() == 0);
    }

    @Test
    void TestPutBookOnHold() {
        assertTrue(mn1.getQuantity() == 2);
        mn1.putItemOnHold();
        assertTrue(mn1.getQuantity() == 1);

        assertTrue(ab.getQuantity() == 4);
        ab.putItemOnHold();
        assertTrue(ab.getQuantity() == 3);

        mn3.putItemOnHold();
        assertTrue(mn3.getQuantity() == -1);
    }

    @Test
    void TestEquals() {
        assertFalse(mn1.equals(mn2));
    }
}
