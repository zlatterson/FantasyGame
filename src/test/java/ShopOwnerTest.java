import items.Potion;
import nonplayercharacters.ShopOwner;
import org.junit.Before;
import org.junit.Test;
import playercharacters.Knight;
import playercharacters.WeaponType;

import static org.junit.Assert.assertEquals;

public class ShopOwnerTest {
    ShopOwner shopOwner;
    Potion potion;
    Knight knight;
    @Before
    public void before(){
        potion = new Potion("Health Potion",105,20,100);
        shopOwner = new ShopOwner("Shopkeeper",2000);
        knight = new Knight("Aragorn",120,100,100,10,0,0, WeaponType.SWORD);
    }
    @Test
    public void hasStock(){
        assertEquals(1, shopOwner.getTotalStock());
    }
    @Test
    public void returnTrueIfItemExists(){
        assertEquals(true, shopOwner.hasItem(potion));
    }
    @Test
    public void shopReceivesItemWhenPlayerSellsItem(){
        knight.addItem(potion);
        knight.addItem(potion);
        knight.sellToShop(shopOwner, potion);
        knight.sellToShop(shopOwner, potion);
        assertEquals(3, shopOwner.getTotalStock());
    }
    @Test
    public void moneyDecreasesWhenPlayerSellsItem(){
        knight.addItem(potion);
        knight.sellToShop(shopOwner,potion);
        assertEquals(1895,shopOwner.getMoney());
    }
}
