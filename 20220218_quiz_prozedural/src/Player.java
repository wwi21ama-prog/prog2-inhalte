public class Player {
    static int nextId = 0;
    int id;
    String name;
    int score = 0;

    Player() {
        this.id = Player.nextId;
        Player.nextId++;
    }

    void printName() {
        System.out.println("Hallo, ich bin Spieler " + this.name);
    }

    void printScore() {
        System.out.println("Spieler " + this.name + " hat die Punktzahl " + this.score);
    }
}
