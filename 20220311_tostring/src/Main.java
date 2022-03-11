import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    List<Player> players = new ArrayList<>();

        Player p1 = new Player();
        p1.name = "Spieler 1";
        p1.score = 100;
        p1.inventory.add("Diamanten");

        Player p2 = new Player();
        p2.name = "Spieler 2";
        p2.score = 200;
        p2.inventory.add("Diamanten");
        p2.inventory.add("Schwert");

        Player p3 = new Player();
        p3.name = "Spieler 3";
        p3.score = 1000;
        // leeres Inventar

        players.add(p1);
        players.add(p2);
        players.add(p3);

        System.out.println(players);
    }
}
