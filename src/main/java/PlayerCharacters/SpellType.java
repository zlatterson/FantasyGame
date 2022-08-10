package PlayerCharacters;

public enum SpellType {
    STAB(20,0),
    CLEAVE(10,10),
    FIREBALL(10,0),
    SMITE(0,0),
    HEAL(0,20);
    private final int damage;
    private final int heal;

    SpellType(int damage, int heal) {
        this.damage = damage;
        this.heal = heal;
    }

    public int getDamage() {
        return damage;
    }

    public int getHeal() {
        return heal;
    }
}
