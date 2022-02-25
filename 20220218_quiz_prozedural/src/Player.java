public class Player {
    String name;

    int score = 0;

    void printName() {
        System.out.println("Hallo, ich bin Spieler " + this.name);
    }

    void printScore() {
        System.out.println("Spieler " + this.name + " hat die Punktzahl " + this.score);
    }
}
