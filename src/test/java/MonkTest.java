import nonplayercharacters.Monster;
import org.junit.Before;
import org.junit.Test;
import playercharacters.Knight;
import playercharacters.Monk;
import playercharacters.WeaponType;

import static org.junit.Assert.assertEquals;

public class MonkTest {
    Monk monk;
    Monster monster;
    Knight knight;
    @Before
    public void before(){
        monk = new Monk("Monk",56,100,40,5,0,10, WeaponType.STAFF);
        knight = new Knight("Lurtz",10,100,30,10,0,0,WeaponType.SWORD);
        monster = new Monster("Goblin",10,100,20);
    }
    @Test
    public void hasLowHealth(){
        assertEquals(40, monk.getHealth());
    }
    @Test
    public void canBasicAttack(){
        monk.basicAttack(monster);
        assertEquals(95,monster.getHealth());
    }
    @Test
    public void canTakeDamage(){
        monster.basicAttack(monk);
        assertEquals(20,monk.getHealth());
    }
    @Test
    public void canHealSelf(){
        monk.useHealSelf();
        assertEquals(70,monk.getHealth());
    }
    @Test
    public void cannotOverHealSelf(){
        monk.useHealSelf();
        monk.useHealSelf();
        monk.useHealSelf();
        assertEquals(100, monk.getHealth());
    }
    @Test
    public void canHealPlayerTarget(){
        monk.heal(knight);
        assertEquals(50,knight.getHealth());
    }
    @Test
    public void cannotOverHealTarget(){
        monk.heal(knight);
        monk.heal(knight);
        monk.heal(knight);
        monk.heal(knight);
        monk.heal(knight);
        assertEquals(100,knight.getHealth());
    }

}
