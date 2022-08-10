package PlayerCharacters;

import java.util.ArrayList;

public class Knight extends Player implements IAttack,IDefend{
    private ArrayList<SpellType> spells;
    private WeaponType currentWeapon;
    public Knight(String name, int health, int power, int magic, int clarity, WeaponType currentWeapon) {
        super(name, health, power, magic, clarity);
        this.currentWeapon = currentWeapon;
        this.spells = new ArrayList<>();
        spells.add(SpellType.CLEAVE);
        spells.add(SpellType.STAB);
    }

    public WeaponType getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(WeaponType newWeapon){
        this.currentWeapon = newWeapon;
    }
    public void attack(IDefend defender){
        defender.takeDamage(this.currentWeapon.getPower());
    }
    public void takeDamage(int damage){
        int health = this.getHealth();
        health -= damage;
        this.setHealth(health);
    }
}
