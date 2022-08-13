import items.Potion;
import nonplayercharacters.Monster;
import nonplayercharacters.ShopOwner;
import org.junit.Before;
import org.junit.Test;
import playercharacters.Knight;
import playercharacters.Monk;
import playercharacters.WeaponType;
import playercharacters.Wizard;
import rooms.Room;

import static org.junit.Assert.assertEquals;

public class RoomTest {
    Room room;
    Knight knight;
    Wizard wizard;
    Monk monk;
    Potion potion;
    Monster monster;
    ShopOwner shopOwner;
    @Before
    public void before(){
        room = new Room("Forest");
        knight = new Knight("Aragorn",120,100,100,10,0,0, WeaponType.SWORD);
        wizard = new Wizard("Gandalf",200,100,100,10,1000,0,WeaponType.WAND);
        monster = new Monster("Goblin",12,20,10);
        shopOwner = new ShopOwner("Harry",2000);
        room.addMonster(monster);
        room.addPlayer(knight);
        room.addShopOwner(shopOwner);
    }
    @Test
    public void canAddMonster(){
        room.addMonster(monster);
        assertEquals(2, room.getMonsters().size());
    }
    @Test
    public void canClearRoom(){
        wizard.useFireball(monster);
        assertEquals(true, room.isCleared());
    }
    @Test
    public void roomWontClearIfMonsterIsAlive(){
        assertEquals(false,room.isCleared());
    }
}
