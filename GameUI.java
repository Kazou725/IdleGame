import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameUI extends JFrame {
    private JPanel contentPane;
    private JButton addMoneyButton;
    private JLabel moneyLabel;
    private JLabel moneyPerSecondLabel;
    private JButton workerShop;

    private final Player player1;
    private final Worker[] basicWorker;
    private Timer timer;
    private Timer frames;


    public GameUI(Player player1, Worker[] basicWorker) {
        this.player1 = player1;
        this.basicWorker = basicWorker;
        setTitle("IdleGame");
        setContentPane(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        frames = new Timer (10, e->{
            updateMoneyLabel();
            updateMoneyPerSecondLabel();
        });
        frames.start();

        timer = new Timer(1000, e -> {
            player1.addMoneyPerSecond();
            updateMoneyLabel();
            updateMoneyPerSecondLabel();
        });
        timer.start();

        addMoneyButton.addActionListener(e ->{
            player1.addMoneyPerClick();
            updateMoneyLabel();
        });
        workerShop.addActionListener(e ->{
            SwingUtilities.invokeLater(() -> new Employés(player1, basicWorker));
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (timer != null) timer.stop();
                SaveManager.savePlayer(player1, "saves/player.csv");
                SaveManager.saveWorkers(basicWorker[0], "saves/workers.csv");
                dispose();
                System.exit(0);
            }
        });

    }
    public void updateMoneyLabel(){
        moneyLabel.setText(String.format("Argent : %.2f $", player1.getMoney()));
    }
    private void updateMoneyPerSecondLabel() {
        moneyPerSecondLabel.setText(String.format("Argent par seconde : %.2f $", player1.getMoneyPerSecond()));
    }
}
