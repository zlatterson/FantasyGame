package nonplayercharacters;

import behaviours.IBasicAttack;
import behaviours.IDefend;
import behaviours.IGiveItems;
import items.Item;
import items.Potion;

import java.util.ArrayList;

public class Monster implements IBasicAttack, IDefend, IGiveItems {
    private String name;
    private int health;
    private int power;
    private ArrayList<Item> items;
    Potion potion;

    public Monster(String name, int health, int power) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.items = new ArrayList<>();
        potion = new Potion("Health Potion",105,20,100);
        items.add(potion);
        items.add(potion);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    public void basicAttack(IDefend defender){
        defender.takeDamage(this.getPower());
    }
    public void takeDamage(int damage){
        int health = this.getHealth();
        health -= damage;
        if (health <= 0){
            this.setHealth(0);
        }else {
            this.setHealth(health);
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    public void clearItems(){
        this.items.clear();
    }

    public ArrayList giveItems(){
        ArrayList<Item> lootItems = new ArrayList<>();
        if(this.getHealth() == 0){
            for(Item item : this.getItems()){
                lootItems.add(item);
            }
//            items.clear();
            System.out.println(lootItems);
//            System.out.println(getItems());
        }
        return lootItems;
    }
}
