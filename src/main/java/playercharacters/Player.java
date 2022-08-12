package playercharacters;

import behaviours.IBasicAttack;
import behaviours.IDefend;
import behaviours.IGiveItems;
import behaviours.ILoot;
import items.Item;

import java.util.ArrayList;

public abstract class Player implements IBasicAttack, IDefend, ILoot, IGiveItems {
    private String name;
    private int maxHealth;
    private int health;
    private int power;
    private int magic;
    private int clarity;
    private ArrayList<Item> items;

    public Player(String name, int maxHealth, int health, int power, int magic, int clarity) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = health;
        this.power = power;
        this.magic = magic;
        this.clarity = clarity;
        this.items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
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

    public void setPower(int power) {
        this.power = power;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getClarity() {
        return clarity;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void setClarity(int clarity) {
        this.clarity = clarity;
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
    public void addItem(Item item){
        items.add(item);
    }
    public void loot(IGiveItems lootTarget){
        ArrayList<Item> newItems = lootTarget.giveItems();
        for(Item item : newItems){
            addItem(item);
        }
        lootTarget.clearItems();
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
    public int getItemsValue(){
        int total = 0;
        for(Item item : items){
            total += item.getValue();
        }
        return total;
    }
}
