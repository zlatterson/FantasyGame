package playercharacters;

import behaviours.IDefend;
import items.Item;

import java.util.ArrayList;

public class Knight extends Player {
    private WeaponType currentWeapon;

    public Knight(String name, int money, int maxHealth, int health, int power, int magic, int clarity, WeaponType currentWeapon) {
        super(name, money, maxHealth, health, power, magic, clarity);
        this.currentWeapon = currentWeapon;
    }

    public WeaponType getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(WeaponType newWeapon){
        this.currentWeapon = newWeapon;
    }

    public void useCleave(IDefend defender){
        int payload = this.getPower() + getCurrentWeapon().getPower() + SpellType.CLEAVE.getDamage();
        this.setHealth(this.getHealth() + SpellType.CLEAVE.getHeal());
        defender.takeDamage(payload);
    }

    public void useStab(IDefend defender){
        int payload = getCurrentWeapon().getPower() + SpellType.STAB.getDamage() * 2 - 20;
        defender.takeDamage(payload);
    }

}
