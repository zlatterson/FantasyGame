package nonplayercharacters;

import behaviours.IBasicAttack;
import behaviours.IDefend;

public class Monster implements IBasicAttack, IDefend {
    private String name;
    private int health;
    private int power;

    public Monster(String name, int health, int power) {
        this.name = name;
        this.health = health;
        this.power = power;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    public void attack(IDefend defender){
        defender.takeDamage(this.getPower());
    }
    public void takeDamage(int damage){
        int health = this.getHealth();
        health -= damage;
        if (health <= 0){
            this.setHealth(0);
        }else {
            this.setHealth(health);
        }

    }
}
