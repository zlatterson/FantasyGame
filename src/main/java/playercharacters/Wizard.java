package playercharacters;

import behaviours.IDefend;

public class Wizard extends Player{
    private WeaponType currentWeapon;
    private PetType currentPet;
    public Wizard(String name, int money, int maxHealth, int health, int power, int magic, int clarity, WeaponType weaponType) {
        super(name, money, maxHealth, health, power, magic, clarity);
        this.currentWeapon = WeaponType.WAND;
    }
    public WeaponType getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(WeaponType newWeapon){
        this.currentWeapon = newWeapon;
    }

    public PetType getCurrentPet() {
        return currentPet;
    }

    public void setCurrentPet(PetType newPet) {
        this.currentPet = newPet;
    }

    public void useFireball(IDefend defender) {
        int payload = getCurrentWeapon().getMagic() + getMagic() * 3 - 20;
        defender.takeDamage(payload);
    }
    public void usePetAttack(IDefend defender){
        int payload = 0;
        if(getCurrentPet() != null){
            payload += currentPet.getPower();
        }
        defender.takeDamage(payload);
    }
}
