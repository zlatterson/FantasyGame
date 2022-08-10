import PlayerCharacters.Knight;
import PlayerCharacters.WeaponType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnightTest {
    Knight knight;
    Knight victim;
    @Before
    public void before(){
        knight = new Knight("Aragorn",100,10,0,0, WeaponType.SWORD);
    }
    @Test
    public void hasSword(){
        assertEquals(WeaponType.SWORD,knight.getCurrentWeapon());
    }

    @Test
    public void canChangeWeapons(){
        knight.setCurrentWeapon(WeaponType.AXE);
        assertEquals(WeaponType.AXE, knight.getCurrentWeapon());
    }
    @Test
    public void canAttackOtherPlayer(){
        victim = new Knight("Timmy",100,10,0,0,WeaponType.SWORD);
        knight.attack(victim);
        assertEquals(90,victim.getHealth());
    }
}
