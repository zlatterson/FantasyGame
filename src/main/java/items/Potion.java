package items;

import behaviours.IHeal;
import playercharacters.Player;

public class Potion extends Item implements IHeal {
    private int healAmount;
    private int volume;

    public Potion(String name, int value, int healAmount, int volume) {
        super(name, value);
        this.healAmount = healAmount;
        this.volume = volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    public int getVolume() {
        return volume;
    }

    public int getHealAmount() {
        return healAmount;
    }
    public void heal(Player player){
        if(this.getVolume() >= 100){
            this.setVolume(0);
            this.setValue(this.getValue() - this.getValue());
            int healPayload = player.getHealth() + this.getHealAmount();
            if (healPayload >= player.getMaxHealth()){
                player.setHealth(player.getMaxHealth());
            }else{
                player.setHealth(healPayload);
            }
        }
    }
}
