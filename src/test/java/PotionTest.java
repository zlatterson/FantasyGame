import items.Potion;
import org.junit.Before;
import org.junit.Test;
import playercharacters.Knight;
import playercharacters.WeaponType;

import static org.junit.Assert.assertEquals;

public class PotionTest {
    Potion potion;
    Knight knight;
    Knight boromir;

    @Before
    public void before(){
        knight = new Knight("Faramir",10,100,20,10,0,0, WeaponType.SWORD);
        potion = new Potion("Health Potion",239,50, 100);
    }
    @Test
    public void hasVolume(){
        assertEquals(100,potion.getVolume());
    }
    @Test
    public void canHeal(){
        potion.heal(knight);
        assertEquals(70, knight.getHealth());
    }
    @Test
    public void potionVolumeDecreases(){
        potion.heal(knight);
        assertEquals(0,potion.getVolume());
    }
    @Test
    public void potionHasOneUse(){
        potion.heal(knight);
        potion.heal(knight);
        potion.heal(knight);
        assertEquals(70, knight.getHealth());
    }
    @Test
    public void potionValueDecreases(){
        potion.heal(knight);
        assertEquals(0, potion.getValue());
    }
    @Test
    public void cannotHealPastMaxHealth(){
        boromir = new Knight("Boromir",10,100,75,10,0,0, WeaponType.SWORD);
        potion.heal(boromir);
        assertEquals(100,boromir.getHealth());
    }

}
