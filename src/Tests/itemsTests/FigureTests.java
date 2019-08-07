package itemsTests;

import model.items.Exq;
import model.items.Nendoroid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FigureTests {
    private Exq e1;
    private Exq e2;
    private Nendoroid n1;
    private Nendoroid n2;

    @BeforeEach
    void runBefore() {
        e1 = Exq.LEAFA_FAIRY;
        e2 = Exq.KIRITO_DUAL_WIELD;
        n1 = Nendoroid.NYARUKO_MAID_VER;
        n2 = Nendoroid.ALBEDO;
    }

    @Test
    void setNewName() {
        e1.setName("Leafa");
        assertTrue(e1.getName().equals("Leafa"));

        n1.setName("Nya~");
        assertTrue(n1.getName().equals("Nya~"));
    }
}
