package nonplayercharacters;

import items.Item;
import items.Potion;

import java.util.ArrayList;

public class ShopOwner {
    private String name;
    private int money;
    private ArrayList<Item> items;
    Potion potion;

    public ShopOwner(String name, int money) {
        this.name = name;
        this.money = money;
        this.items = new ArrayList<>();
        potion = new Potion("Health Potion",105,20,100);
        items.add(potion);
    }
    public int getTotalStock(){
        return this.items.size();
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
    public void addItems(ArrayList<Item> items){
        this.items.addAll(items);
    }

    public boolean hasItem(Item item){
        for(Item shopItem : this.items){
            if (shopItem.getName() == item.getName() && shopItem.getValue() == item.getValue()){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
