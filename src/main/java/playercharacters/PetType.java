package playercharacters;

public enum PetType {
    LIZARD(5),
    FOX(10),
    AGGRESSIVE_PIGEON(20),
    DRAGON(100);
    private final int power;

    PetType(int power) {
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
