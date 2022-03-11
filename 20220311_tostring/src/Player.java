import java.util.ArrayList;
import java.util.List;

public class Player {
    String name;
    int score;
    List<String> inventory = new ArrayList<>();

    /*public String toString() {
        return "Der Spieler heißt "
                + this.name
                + " und hat "
                + this.score
                + " Punkte und "
                + this.inventory.size() + " Item(s) im Inventar.";
    }*/

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", inventory=" + inventory +
                '}';
    }
}
