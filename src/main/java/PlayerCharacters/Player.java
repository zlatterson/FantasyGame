package PlayerCharacters;

public abstract class Player {
    private String name;
    private int health;
    private int power;
    private int magic;
    private int clarity;

    public Player(String name, int health, int power, int magic, int clarity) {
        this.name = name;
        this.health = health;
        this.power = power;
        this.magic = magic;
        this.clarity = clarity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setPower(int power) {
        this.power = power;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getClarity() {
        return clarity;
    }

    public void setClarity(int clarity) {
        this.clarity = clarity;
    }
}
