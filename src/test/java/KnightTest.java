import items.Potion;
import nonplayercharacters.Monster;
import playercharacters.Knight;
import playercharacters.WeaponType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnightTest {
    Knight knight;
    Knight victim;
    Potion potion;
    Monster monster;
    Knight strongKnight;
    Monster anotherMonster;
    @Before
    public void before(){
        potion = new Potion("Health Potion",30,30,100);
        knight = new Knight("Aragorn",120,100,100,10,0,0, WeaponType.SWORD);
        victim = new Knight("Timmy",3000,100,100,10,0,0,WeaponType.SWORD);
        strongKnight = new Knight("Sauron",0,100,100,1000,0,0,WeaponType.SWORD);
        monster = new Monster("Monster",10,100,10);
        anotherMonster = new Monster("Monster",15,100,10);
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
        knight.basicAttack(victim);
        assertEquals(90,victim.getHealth());
    }
    @Test
    public void canUseSpellOnOtherPlayer(){
        knight.useCleave(victim);
        knight.useCleave(victim);
        knight.useCleave(victim);
        assertEquals(10,victim.getHealth());
    }
    @Test
    public void canStabOtherPlayer(){
        knight.useStab(victim);
        assertEquals(70,victim.getHealth());
    }
    @Test
    public void healthRemains0WhenDead(){
        knight.setCurrentWeapon(WeaponType.AXE);
        knight.useCleave(victim);
        knight.useCleave(victim);
        knight.useCleave(victim);
        assertEquals(0, victim.getHealth());
    }
    @Test
    public void cleaveHeals(){
        knight.setHealth(50);
        knight.useCleave(victim);
        assertEquals(60,knight.getHealth());
    }
    @Test
    public void canLootItems(){
        strongKnight.useCleave(monster);
        strongKnight.lootItems(monster);
        assertEquals(2,strongKnight.getItems().size());
    }
    @Test
    public void canOnlyLootDeadEnemies(){
        knight.useCleave(monster);
        knight.lootItems(monster);
        assertEquals(0,knight.getItems().size());
    }
    @Test
    public void cannotLootTwice(){
        strongKnight.useCleave(monster);
        knight.lootItems(monster);
        knight.lootItems(monster);
        assertEquals(2,knight.getItems().size());
    }
    @Test
    public void canGetTotalItemsValue(){
        strongKnight.useCleave(monster);
        knight.lootItems(monster);
        assertEquals(210,knight.getItemsValue());
    }
    @Test
    public void canGetLootedByOtherPlayers(){
        strongKnight.useCleave(monster);
        strongKnight.lootItems(monster);
        strongKnight.useCleave(anotherMonster);
        strongKnight.lootItems(anotherMonster);
        strongKnight.setHealth(0);
        knight.lootItems(strongKnight);
        assertEquals(4,knight.getItems().size());
    }
    @Test
    public void canLootDeadTargetsMoney(){
        strongKnight.useCleave(monster);
        strongKnight.lootMoney(monster);
        assertEquals(10,strongKnight.getMoney());
    }
    @Test
    public void canOnlyLootDeadTargetsMoneyOnce(){
        strongKnight.useCleave(monster);
        strongKnight.lootMoney(monster);
        strongKnight.lootMoney(monster);
        assertEquals(10,strongKnight.getMoney());
    }
    @Test
    public void canLootPlayer(){
        strongKnight.useCleave(victim);
        strongKnight.lootMoney(victim);
        strongKnight.lootMoney(victim);
        assertEquals(3000,strongKnight.getMoney());
    }
    @Test
    public void cannotLootAliveTarget(){
        knight.useStab(strongKnight);
        knight.lootMoney(strongKnight);
        assertEquals(0,strongKnight.getMoney());
    }
}
