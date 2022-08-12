package playercharacters;

import behaviours.IDefend;

public class Knight extends Player {
//    private ArrayList<SpellType> spells;
    private WeaponType currentWeapon;
    public Knight(String name, int healthMax, int health, int power, int magic, int clarity, WeaponType currentWeapon) {
        super(name, healthMax, health, power, magic, clarity);
        this.currentWeapon = currentWeapon;
//        this.spells = new ArrayList<>();
//        spells.add(SpellType.CLEAVE);
//        spells.add(SpellType.STAB);
    }

    public WeaponType getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(WeaponType newWeapon){
        this.currentWeapon = newWeapon;
    }

    public void useCleave(IDefend defender){
        int payload = this.getPower() + this.currentWeapon.getPower() + SpellType.CLEAVE.getDamage();
        this.setHealth(this.getHealth() + SpellType.CLEAVE.getHeal());
        defender.takeDamage(payload);
    }

    public void useStab(IDefend defender){
        int payload = this.currentWeapon.getPower() + SpellType.STAB.getDamage() * 2 - 20;
        defender.takeDamage(payload);
    }

}
