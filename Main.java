import javax.swing.*;

void main() {

    Player player = SaveManager.loadPlayer("saves/player.csv");
    Worker basicWorker = SaveManager.loadWorkers("saves/workers.csv");

    if (player == null) {
        player = new Player(
                0.0,   // money
                0.01,  // moneyPerClick
                0.0,   // moneyPerSecond
                0      // nbBasicWorker
        );
    }
    if (basicWorker == null) {
        basicWorker = new Worker(0.01,0.01,1);
    }
    Player player1 = player;
    Worker basicWorker1 = basicWorker;
    SwingUtilities.invokeLater(() -> new GameUI(player1, basicWorker1));

}
