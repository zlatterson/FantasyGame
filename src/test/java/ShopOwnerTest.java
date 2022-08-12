import items.Potion;
import nonplayercharacters.ShopOwner;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShopOwnerTest {
    ShopOwner shopOwner;
    Potion potion;
    @Before
    public void before(){
        potion = new Potion("Health Potion",105,20,100);
        shopOwner = new ShopOwner("Shopkeeper",2000);
    }
    @Test
    public void hasStock(){
        assertEquals(1, shopOwner.getTotalStock());
    }
    @Test
    public void returnsItemPriceIfItemOfTheNameExists(){
        assertEquals(105, shopOwner.hasItem(potion));

    }
}
