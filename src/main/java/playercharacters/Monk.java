package playercharacters;

import behaviours.IDefend;
import behaviours.IHeal;
import items.Item;

import java.util.ArrayList;

public class Monk extends Player implements IHeal {
    private WeaponType currentWeapon;

    public Monk(String name, int money, int maxHealth, int health, int power, int magic, int clarity,WeaponType currentWeapon) {
        super(name, money, maxHealth, health, power, magic, clarity);
        this.currentWeapon = WeaponType.STAFF;
    }
    public WeaponType getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(WeaponType newWeapon){
        this.currentWeapon = newWeapon;
    }

    public void useHealSelf() {
        int healPayload = getCurrentWeapon().getClarity() + this.getClarity() * 2;
        if (this.getHealth() + healPayload >= this.getMaxHealth()){
            this.setHealth(this.getMaxHealth());
        }else{
            this.setHealth(this.getHealth() + healPayload);
        }
    }

    public void heal(Player player) {
        int healPayload = getCurrentWeapon().getClarity() + this.getClarity();
        if (player.getHealth() + healPayload >= player.getMaxHealth()){
            player.setHealth(player.getMaxHealth());
        }else{
            player.setHealth(player.getHealth() + healPayload);
        }
    }
    public void useSmite(IDefend defender){
        int payload = getCurrentWeapon().getMagic() + this.getMagic() / 2 + 10;
        defender.takeDamage(payload);
    }
}
