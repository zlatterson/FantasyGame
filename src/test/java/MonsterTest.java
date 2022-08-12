import nonplayercharacters.Monster;
import org.junit.Before;
import org.junit.Test;
import playercharacters.Knight;
import playercharacters.WeaponType;

import static org.junit.Assert.assertEquals;

public class MonsterTest {
    Monster monster;
    Knight knight;
    @Before
    public void before(){
        monster = new Monster("Goblin",10,100,10);
        knight = new Knight("Gimli",0,100,100,10,0,0, WeaponType.AXE);
    }
    @Test
    public void hasHealth(){
        assertEquals(100, monster.getHealth());
    }
    @Test
    public void canBasicAttack(){
        monster.basicAttack(knight);
        assertEquals(90, knight.getHealth());
    }
    @Test
    public void canSubsequentlyGetDestroyedByKnight(){
        monster.basicAttack(knight);
        knight.useCleave(monster);
        knight.useStab(monster);
        assertEquals(20,monster.getHealth());
    }
}
