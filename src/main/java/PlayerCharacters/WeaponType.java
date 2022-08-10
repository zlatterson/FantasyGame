package PlayerCharacters;

public enum WeaponType {
    SWORD(10,0,0),
    AXE(12,0,0),
    WAND(1,10,0),
    STAFF(3,5,10);
    private final int power;
    private final int magic;
    private final int clarity;

    WeaponType(int power, int magic, int clarity) {
        this.power = power;
        this.magic = magic;
        this.clarity = clarity;
    }

    public int getPower() {
        return power;
    }

    public int getMagic() {
        return magic;
    }

    public int getClarity() {
        return clarity;
    }
}
