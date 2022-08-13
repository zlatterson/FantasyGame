package items;

import behaviours.IGiveItems;
import behaviours.IGiveMoney;

import java.util.ArrayList;

public enum Chests implements IGiveMoney {
    SMALL_CHEST(50),
    LARGE_CHEST(100),
    LEGENDARY_CHEST(1000);
    private int money;

    Chests(int money ) {
        this.money = money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void clearMoney(){
        this.setMoney(0);
    }

    public int giveMoney() {
        return this.money;
    }
}
