package PlayerCharacters;

import java.util.ArrayList;

public class Knight extends Player {
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

    public void useCleave(IDefend defender){
        int payload = this.getPower() + this.currentWeapon.getPower() + SpellType.CLEAVE.getDamage();
        defender.takeDamage(payload);
    }

    public void useStab(IDefend defender){
        int payload = this.currentWeapon.getPower() * 2;
        defender.takeDamage(payload);
    }

    public void die(IAttack attacker){

    }
}
