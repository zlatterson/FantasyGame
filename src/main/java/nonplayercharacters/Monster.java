package nonplayercharacters;

import behaviours.IBasicAttack;
import behaviours.IDefend;
import behaviours.IGiveItems;
import items.Item;

import java.util.ArrayList;

public class Monster implements IBasicAttack, IDefend, IGiveItems {
    private String name;
    private int health;
    private int power;
    private ArrayList<Item> items;

    public Monster(String name, int health, int power) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.items = new ArrayList<>();
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
    public ArrayList giveItems(ArrayList<Item> items){
        if(this.getHealth() == 0){
            return items;
        }
        return null;
    }
}
