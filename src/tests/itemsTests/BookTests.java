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

class BookTests {
    private Manga mn1;
    private Manga mn2;
    private Manga mn3;
    private Manga mn4;
    private ArtBook ab;
    private ArtBook ab2;
    private ArtBook ab3;

    @BeforeEach
    void BeforeTest() {
        ab = NIER;
        ab2 = DARK_SOULS;
        ab3 = TOKYO_GHOUL;
        mn1 = NARUTO_SHIPPUDEN;
        mn2 = PROMISED_MN2;
        mn3 = KAKEGURUI;
        mn4 = OVERLORD;

    }

    @Test
    void testGetTitleOfBook() {
        assertTrue(ab.getTitle().equals("NieR: Automata World Guide"));
        assertFalse(ab.getTitle().equals("Nieer: Automata World Guide"));

        assertTrue(mn2.getTitle().equals("The Promised Neverland"));
        assertFalse(mn2.getTitle().equals("The Promised  Neverland"));
    }

    @Test
    void testSetTitleOfBook() {
        assertTrue(ab2.getTitle().equals("Dark Souls: Design Works"));
        ab2.setTitle("Dark Souls: Design Works!");
        assertFalse(ab2.getTitle().equals("Dark Souls: Design Works"));
        assertTrue(ab2.getTitle().equals("Dark Souls: Design Works!"));

        assertTrue(mn1.getTitle().equals("Naruto"));
        mn1.setTitle("Naruto Shippuden!");
        assertFalse(mn1.getTitle().equals("Naruto"));
        assertTrue(mn1.getTitle().equals("Naruto Shippuden!"));
    }

    @Test
    void testGetAuthorOfBook() {
        assertTrue(ab.getAuthor().equals("by Square Enix"));
        assertFalse(ab.getAuthor().equals("by Jojo"));

        assertTrue(mn2.getAuthor().equals("by Kaiu Shirai and Posuka Demizu"));
        assertFalse(mn2.getAuthor().equals("by Kaiu Shirai"));
    }

    @Test
    void testGetVolumeOfBook() {
        assertTrue(ab2.getVolumeOrChapter().equals("(no volume)"));
        assertFalse(ab.getVolumeOrChapter().equals("vol. 2"));
        assertTrue(ab.getVolumeOrChapter().equals("vol. 1"));
    }

    @Test
    void testGetChapterOfBook() {
        assertTrue(mn1.getVolumeOrChapter().equals("ch. 45"));
        assertTrue(mn2.getVolumeOrChapter().equals("ch. 2"));
        assertFalse(mn2.getVolumeOrChapter().equals("ch. 3"));
    }

    @Test
    void testGetPriceTagOfBook() {
        assertTrue(ab.getPriceTag() == 49.99);
        assertFalse(ab.getPriceTag() == 34.99);

        assertTrue(mn1.getPriceTag() == 13.99);
        assertFalse(mn1.getPriceTag() == 13.999);
    }

    @Test
    void testSetPriceTag() {
        assertTrue(ab2.getPriceTag() == 56.99);
        ab2.setPriceTag(56.99);
        assertTrue(ab2.getPriceTag() == 56.99);
        ab2.setPriceTag(26.99);
        assertTrue(ab2.getPriceTag() == 26.99);

        assertTrue(mn2.getPriceTag() == 14.99);
        mn2.setPriceTag(14.99);
        assertTrue(mn2.getPriceTag() == 14.99);
        mn2.setPriceTag(26.99);
        assertTrue(mn2.getPriceTag() == 26.99);
    }

    @Test
    void testYearPublished() {
        assertFalse(ab.getYearPublished().equals("published in 1996"));
        assertTrue(ab.getYearPublished().equals("published in 2019"));

        assertTrue(mn2.getYearPublished().equals("published in 2016"));
        assertFalse(mn2.getYearPublished().equals("published in 20167"));
    }

    @Test
    void testGetQuantityOfBook() {
        System.out.println(ab.getQuantity());
        assertFalse(ab.getQuantity() == 0);

        assertTrue(mn4.getQuantity() == 4);
    }

    @Test
    void testGetInfoOfBook() {
        System.out.println(ab3.getInformation());
        assertTrue(ab3.getInformation().equals("Tokyo Ghoul Illustrations: Zakki (no volume),"
                + " by Sui Ishida, published in 2017, Quantity: 2, $24.99"));
        assertFalse(ab3.getInformation().equals("Tokyo Ghoul Illustrations: Zakki"));

        assertTrue(mn4.getInformation().equals("Overlord ch. 10, by Kugane Maruyama, "
                + "published in 2016, Quantity: 4, $15.99"));
        assertFalse(mn4.getInformation().equals("Overlord ch. 10, by Kugane Maruyama, "
                + "published in 2016, Quantity: 4, $15.999"));
    }

    @Test
    void testIfArtBook() {
        System.out.println(ab.mangaChapterOrArtBookVolume());
        System.out.println(ab.getVolumeOrChapter().substring(0, 4));
        System.out.println(ab.getVolumeOrChapter().substring(5));
        assertTrue(ab.mangaChapterOrArtBookVolume().equals("The volume of this art book is 1."));
        assertFalse(ab.mangaChapterOrArtBookVolume().equals("This art book does not have any volumes."));
        assertTrue(ArtBook.BATTLE_ANGEL.mangaChapterOrArtBookVolume().equals(
                "This art book does not have any volumes."));
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
    void testDoesContainBookTitle() {
        assertTrue(ab.containsNameOrTitle("nier"));
        assertTrue(ab.containsNameOrTitle("Nier"));
        assertFalse(ab.containsNameOrTitle("nier!"));

        assertTrue(mn2.containsNameOrTitle("Promised"));
        assertTrue(mn2.containsNameOrTitle("promised"));
        assertFalse(mn2.containsNameOrTitle("Proomised"));
    }

    @Test
    void testPurchaseBook() {
        ArtBook ab4 = ArtBook.BATTLE_ANGEL;
        Manga mn6 = Manga.KAKEGURUI_3;
        System.out.println(ab2.getQuantity());
        assertTrue(ab2.getQuantity() == 0);
        assertTrue(ab2.purchaseItem().equals(
                "This item is currently unavailable. However, it can be put on hold."));

        assertTrue(ab4.getQuantity() == 1);
        assertTrue(ab4.purchaseItem().equals("0"));
        System.out.println(ab4.purchaseItem());
        assertTrue(ab4.getQuantity() == 0);

        assertTrue(ArtBook.TOKYO_GHOUL.getQuantity() == 2);
        assertTrue(mn1.purchaseItem().equals("1"));
        mn1.purchaseItem();
        assertTrue(mn1.getQuantity() == 0);

        mn6.purchaseItem();
        assertTrue(mn6.getQuantity() == 0);
        assertTrue(mn6.purchaseItem().equals(
                "This item is currently unavailable. However, it can be put on hold."));

    }

    @Test
    void testPutBookOnHold() {
        ArtBook ab5 = ArtBook.FINAL_FANTASY;
        ArtBook ab6 = ArtBook.FINAL_FANTASY_2;
        Manga mn5 = Manga.KAKEGURUI_2;

        assertTrue(ab5.getQuantity() == 3);
        ab5.putItemOnHold();
        assertTrue(ab5.getQuantity() == 2);

        assertTrue(ab6.getQuantity() == 0);
        ab6.putItemOnHold();
        assertTrue(ab6.getQuantity() == -1);

        assertTrue(ab.getQuantity() == 4);
        ab.putItemOnHold();
        assertTrue(ab.getQuantity() == 3);

        assertTrue(mn5.getQuantity() == 4);
        mn5.putItemOnHold();
        assertTrue(mn5.getQuantity() == 3);

        mn3.putItemOnHold();
        assertTrue(mn3.getQuantity() == -1);
    }

    @Test
    void testEquals() {
        assertTrue(ab2.equals(ab2));
        assertFalse(ab.equals(ab2));

        assertTrue(mn1.equals(mn1));
        assertFalse(mn1.equals(mn2));
    }

    @Test
    void testHash() {
        System.out.println(mn1.hashCode());
        System.out.println(mn2.hashCode());
        assertTrue(mn1.hashCode() == mn1.hashCode());
        assertFalse(mn1.hashCode() == mn2.hashCode());
    }
}
