import javax.swing.*;

public class Employés extends JFrame {
    private JPanel contentPane;
    private JLabel employéBase;
    private JButton Engager;
    private JLabel employéBaseDesc;

    private final Player player1;
    private final Worker basicWorker;

    public Employés(Player player1, Worker basicWorker) {
        this.player1 = player1;
        this.basicWorker = basicWorker;
        setTitle("IdleGame");
        setContentPane(contentPane);

        setSize(500, 200);
        setLocationRelativeTo(null);
        setVisible(true);

        employéBaseDesc.setText(String.format("Cout : %.2f", basicWorker.getCost()));

        Engager.addActionListener(e ->{
            if (player1.getMoney() >= basicWorker.getCost()) {
                player1.buyWorker(basicWorker);
                basicWorker.setCost((basicWorker.getCost() * 0.7) + basicWorker.getCost());
                employéBaseDesc.setText(String.format("Cout : %.2f", basicWorker.getCost()));
            }

        });
    }
}
