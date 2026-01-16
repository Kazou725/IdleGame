import javax.swing.*;

public class Employés extends JFrame {
    private JPanel contentPane;
    private JLabel employéBase;
    private JButton Engager;
    private JLabel employéBaseDesc;
    private JLabel employeStats;

    private final Player player1;
    private final Worker[] basicWorker;
    private Timer frames;

    public Employés(Player player1, Worker[] basicWorker) {
        this.player1 = player1;
        this.basicWorker = basicWorker;
        setTitle("IdleGame");
        setContentPane(contentPane);

        setSize(500, 200);
        setLocationRelativeTo(null);
        setVisible(true);

        frames = new Timer (10, e->{
            updateCostLabel();
            updateStatsLabel();
        });
        frames.start();

        employéBase.setText(basicWorker[0].getName() + " " + basicWorker[0].getLastName());
        employeStats.setText("Potentiel : " + basicWorker[0].getPotential() + " || Overall : " + basicWorker[0].getOverall());
        employéBaseDesc.setText(String.format("Cout : %.2f", basicWorker[0].getCost()));

        Engager.addActionListener(e ->{
            if (player1.getMoney() >= basicWorker[0].getCost()) {
                player1.buyWorker(basicWorker[0]);
                employéBaseDesc.setText(String.format("Cout : %.2f", basicWorker[0].getCost()));
                Engager.setText("Ameliorer.");
            }

        });
    }
    public void updateCostLabel(){
        employéBaseDesc.setText(String.format("Cout : %.2f", basicWorker[0].getCost()));
    }
    private void updateStatsLabel() {
        employeStats.setText("Potentiel : " + basicWorker[0].getPotential() + " || Overall : " + basicWorker[0].getOverall());
    }
}
