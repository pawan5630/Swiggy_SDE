public class Player {
    private int health;
    private int strength;
    private int attack;

    public Player(int health, int strength, int attack) {
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    public void attack(Player opponent, int diceRoll) {
        int damage = attack * diceRoll;
        opponent.defend(damage);
    }

    public void defend(int damage) {
        int damageTaken = Math.max(0, damage - (strength * rollDice()));
        health -= damageTaken;
    }

    public boolean isAlive() {
        return health > 0;
    }

    private int rollDice() {
        return (int) (Math.random() * 6) + 1; // 1 to 6-sided dice
    }
}

