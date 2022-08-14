package items;

import behaviours.IGiveItems;
import behaviours.IGiveMoney;
import playercharacters.Player;

import java.util.ArrayList;

public class Chest implements IGiveItems, IGiveMoney {
    private String name;
    private int money;
    private ArrayList<Item> items;

    public Chest(String name, int money) {
        this.name = name;
        this.money = money;
        this.items = new ArrayList<>();
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    public void addItem(Item item){
        this.items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList giveItems(){
        return this.getItems();
    }
    public int giveMoney(){
        return this.getMoney();
    }
    public void clearMoney(){
        setMoney(0);
    }
    public void clearItems(){
        this.items.clear();
    }
}
