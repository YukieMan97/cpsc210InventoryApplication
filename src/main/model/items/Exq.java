package model.items;

import java.util.ArrayList;

public class Exq extends Figure {
    public static final Exq ASUNA_WEDDING = new Exq("Code Register Wedding Asuna", 2, 29.99);
    public static final Exq REM_WEDDING = new Exq("Starting Life in Another World Rem", 0, 39.99);
    public static final Exq KIRITO_DUAL_WIELD = new Exq("Sword Art Online Kirito", 2, 25.99);
    public static final Exq ALICE_SITTING = new Exq("Alicization Alice Schuberg", 4, 28.99);
    public static final Exq LEAFA_FAIRY = new Exq("Memory Defrag Leafa", 1, 29.99);

    public static final ArrayList<Exq> EXQ_LIST = new ArrayList<Exq>() {
        {
            add(Exq.ASUNA_WEDDING);
            add(Exq.REM_WEDDING);
            add(Exq.KIRITO_DUAL_WIELD);
            add(Exq.ALICE_SITTING);
            add(Exq.LEAFA_FAIRY);
        }
    };

    public Exq(String name, int quantity, double priceTag) {
        super(name, quantity, priceTag);
    }


    @Override
    public int purchaseItem() {
        itemsSold++;
        return quantity--;
    }

    @Override
    public int putItemOnHold() {
        itemsSold++;
        return quantity--;
    }

    @Override
    public double setPriceTag(double newPriceTag) {
        return priceTag = newPriceTag;
    }
}
