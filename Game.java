public class Game {
    private Player playerA;
    private Player playerB;

    public Game(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
    }

    public void play() {
        Player attacker = playerA.getHealth() < playerB.getHealth() ? playerA : playerB;
        Player defender = attacker == playerA ? playerB : playerA;

        while (playerA.isAlive() && playerB.isAlive()) {
            int diceRoll = attacker.rollDice();
            attacker.attack(defender, diceRoll);
            // Switch attacker and defender for the next turn
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        if (playerA.isAlive()) {
            System.out.println("Player A wins!");
        } else {
            System.out.println("Player B wins!");
        }
    }

    public static void main(String[] args) {
        // Test Case
        Player playerA = new Player(50, 5, 10); 
        Player playerB = new Player(100, 10, 5);
        Game game = new Game(playerA, playerB);
        game.play();
    }
}
