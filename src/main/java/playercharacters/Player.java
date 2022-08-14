package playercharacters;

import behaviours.*;
import items.Item;
import nonplayercharacters.ShopOwner;

import java.util.ArrayList;

public abstract class Player implements IBasicAttack, IDefend, ILootItems, IGiveItems, ILootMoney, IGiveMoney {
    private String name;
    private int money;
    private int maxHealth;
    private int health;
    private int power;
    private int magic;
    private int clarity;

    private ArrayList<Item> items;

    public Player(String name,int money, int maxHealth, int health, int power, int magic, int clarity) {
        this.name = name;
        this.money = money;
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
        int payload = this.getHealth() - damage;
        if (payload <= 0){
            this.setHealth(0);
        }else {
            this.setHealth(payload);
        }
    }
    public void addItem(Item item){
        items.add(item);
    }
    public int getItemsValue(){
        int total = 0;
        for(Item item : items){
            total += item.getValue();
        }
        return total;
    }
    public void lootItems(IGiveItems lootTarget){
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
            lootItems = this.getItems();
        }
        return lootItems;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void lootMoney(IGiveMoney lootTarget) {
        setMoney(getMoney() + lootTarget.giveMoney());
        lootTarget.clearMoney();
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
    public boolean hasItem(Item item){
        for(Item myItem : this.items){
            if (myItem.getName() == item.getName() && myItem.getValue() == item.getValue()){
                return true;
            }
        }
        return false;
    }
    public void sellToShop(ShopOwner shopOwner, Item item){
        if(hasItem(item)){
            shopOwner.setMoney(shopOwner.getMoney() - item.getValue());
            setMoney(getMoney() + item.getValue());
            shopOwner.addItem(item);
            this.items.remove(item);
        }
    }
    public void sellAllToShop(ShopOwner shopOwner){
        shopOwner.setMoney(shopOwner.getMoney() - getItemsValue());
        setMoney(getMoney() + getItemsValue());
        shopOwner.addItems(this.items);
        this.items.clear();
    }
    public void buyFromShop(ShopOwner shopOwner, Item item){
        if(shopOwner.hasItem(item)) {
            shopOwner.setMoney(shopOwner.getMoney() + item.getValue());
            setMoney(getMoney() - item.getValue());
            shopOwner.getItems().remove(item);
            this.items.add(item);
        }
    }

}
