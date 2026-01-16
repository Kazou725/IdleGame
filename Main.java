import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Worker[] allWorkers = WorkerLoader.loadWorkers("saves/workers.csv");

        Player player = SaveManager.loadPlayer("saves/player.csv", allWorkers.length);
        if (player == null) {
            player = new Player(0.0, 0.01, 0.0, allWorkers.length);
        }

        Player finalPlayer = player;
        SwingUtilities.invokeLater(() ->
                new GameUI(finalPlayer, allWorkers)
        );
    }
}
