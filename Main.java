import javax.swing.*;

void main() {

    Player player = SaveManager.loadPlayer("saves/player.csv");

    if (player == null) {
        player = new Player(
                0.0,   // money
                0.01,  // moneyPerClick
                0.0,   // moneyPerSecond
                0      // nbBasicWorker
        );
    }
    Player player1 = player;
    Worker basicWorker = new Worker(0.01, 0.01, 1);
    SwingUtilities.invokeLater(() -> new GameUI(player1, basicWorker));

}
