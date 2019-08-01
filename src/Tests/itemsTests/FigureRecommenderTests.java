package itemsTests;

import model.items.Item.Exq;
import model.items.Item.FigureRecommender;
import model.items.Nendoroid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FigureRecommenderTests {
    private Exq e1;
    private Exq e2;
    private Exq e3;
    private Nendoroid n1;
    private Nendoroid n2;
    private FigureRecommender fr;

    @BeforeEach
    void runBefore() {
        e1 = Exq.LEAFA_FAIRY;
        e2 = Exq.KIRITO_DUAL_WIELD;
        e3 = Exq.ASUNA_WEDDING;
        n1 = new Nendoroid("Ainz Ooal Gown", "689", 2, 64.99);
        n2 = Nendoroid.ALBEDO;
        fr = new FigureRecommender();
    }

    @Test
    void testReturnExqRecommendations() {
        fr.addRecommendation(e1, e2);
        fr.addRecommendation(e1, e3);
        assertTrue(fr.recommended(e1).size() == 2);
        System.out.println(fr.recommendedFigures(e1));
        fr.print();
    }

    @Test
    void testReturnNendoroidRecommendations() {
        fr.addRecommendation(n1, n2);
        assertTrue(fr.recommended(n1).size() == 1);
        fr.print();
    }
}
