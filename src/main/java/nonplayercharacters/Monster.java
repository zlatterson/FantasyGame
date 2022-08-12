package nonplayercharacters;

import behaviours.IBasicAttack;
import behaviours.IDefend;
import behaviours.IGiveItems;
import behaviours.IGiveMoney;
import items.Item;
import items.Potion;

import java.util.ArrayList;

public class Monster implements IBasicAttack, IDefend, IGiveItems, IGiveMoney {
    private String name;
    private int health;
    private int power;
    private int money;
    private ArrayList<Item> items;
    Potion potion;

    public Monster(String name, int money, int health, int power) {
        this.name = name;
        this.money = money;
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
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
            lootItems = this.getItems();
        }
        return lootItems;
    }
    public int giveMoney(){
        int runningTotal = 0;
        if(this.getHealth() == 0){
            runningTotal += this.getMoney();
        }
        return runningTotal;
    }
    public void clearMoney(){
        setMoney(0);
    }
}
