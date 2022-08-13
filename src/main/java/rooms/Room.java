package rooms;

import nonplayercharacters.Monster;
import nonplayercharacters.QuestGiver;
import nonplayercharacters.ShopOwner;
import playercharacters.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Room {
    private String name;
    private int playerMaxCapacity;
    private ArrayList<Player> players;
    private ArrayList<Monster> monsters;
    private ArrayList<ShopOwner> shopOwners;

    public Room(String name) {
        this.name = name;
        this.playerMaxCapacity = 20;
        this.players = new ArrayList<>();
        this.monsters = new ArrayList<>();
        this.shopOwners = new ArrayList<>();
    }

    public int getPlayerMaxCapacity() {
        return playerMaxCapacity;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
    public void addPlayer(Player player){
        if(getPlayerMaxCapacity() > getPlayers().size())
        players.add(player);
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }
    public void addMonster(Monster monster){
        monsters.add(monster);
    }
    public ArrayList<ShopOwner> getShopOwners() {
        return shopOwners;
    }
    public void addShopOwner(ShopOwner shopOwner){
        shopOwners.add(shopOwner);
    }
    
    public boolean isCleared(){
        for(Monster monster : getMonsters()){
            if(monster.getHealth() != 0){
                return false;
            }
        }
        return true;
    }
}
