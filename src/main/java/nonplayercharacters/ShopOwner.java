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

    public int hasItem(Item item){
        for(Item shopItem : this.items){
            if (shopItem.getName() == item.getName()){
                return shopItem.getValue();
            }
        }
        return 0;
    }

}
