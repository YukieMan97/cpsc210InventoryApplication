package inventoryTests;

import model.inventory.FigureList;
import model.inventory.InventoryList;
import model.items.Item.Exq;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testInventoryList {

    private InventoryList fl;

    @BeforeEach
    void beforeTest() { fl = new FigureList(); }

    @Test
    void testAddOne() {
        fl.insert(Exq.ASUNA_WEDDING);
        assertTrue(fl.contains(Exq.ASUNA_WEDDING));
        assertEquals(1, fl.size());
    }

    @Test
    void testAddOneDuplicate() {
        fl.insert(Exq.ASUNA_WEDDING);
        fl.insert(Exq.ASUNA_WEDDING);
        assertTrue(fl.contains(Exq.ASUNA_WEDDING));
        assertEquals(1, fl.size());
    }

    @Test
    void testAddTwoDifferent() {
        fl.insert(Exq.REM_WEDDING);
        fl.insert(Exq.ASUNA_WEDDING);
        assertTrue(fl.contains(Exq.ASUNA_WEDDING));
        assertTrue(fl.contains(Exq.REM_WEDDING));
        assertEquals(2, fl.size());
    }

//    @Test
//    void testDoesPutSameFigureInOneList() {
//        InventoryList sl2 = new InventoryList();
//        InventoryList sl3;
//        fl.insert(Exq.ASUNA_WEDDING);
//        fl.insert(Exq.KIRITO_DUAL_WIELD);
//        fl.insert(Exq.REM_WEDDING);
//
//        sl2.insert(Exq.ASUNA_WEDDING);
//        sl3 = fl.putSameFigureInList(sl2);
//        assertTrue(sl3.size() == 1);
//    }

//    @Test
//    void testDoesNotPutSameFigureInOneList() {
//        InventoryList sl2 = new InventoryList();
//        InventoryList sl3;
//        fl.insert(Exq.KIRITO_DUAL_WIELD);
//        fl.insert(Exq.REM_WEDDING);
//
//        sl2.insert(Exq.ASUNA_WEDDING);
//        sl3 = fl.putSameFigureInList(sl2);
//        assertTrue(sl3.size() == 0);
//    }

    @Test
    void testPrintNamesAndQuantitiesInList() {
        ArrayList a = new ArrayList<>();
        fl.insert(Exq.ASUNA_WEDDING);
        fl.insert(Exq.REM_WEDDING);
        a = fl.namesAndQuantities();
        assertTrue(2 == a.size());

    }

    @Test
    void testPrintInStockFigures(){
        ArrayList a = new ArrayList<>();
        fl.insert(Exq.ASUNA_WEDDING);
        fl.insert(Exq.KIRITO_DUAL_WIELD);
        a = fl.inStockList();
        assertTrue(2 == a.size());

        fl.insert(Exq.REM_WEDDING);
        fl.inStockList();
        assertTrue(2 == a.size());
    }
}
