import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveManager {
    private static final String HEADER =
            "money,moneyPerClick,moneyPerSecond,nbBasicWorker";

    public static void savePlayer(Player player, String filePath) {
        try {
            Path path = Paths.get(filePath);
            Files.createDirectories(path.getParent());

            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                writer.write(HEADER);
                writer.newLine();
                writer.write(
                        player.getMoney() + "," +
                                player.getMoneyPerClick() + "," +
                                player.getMoneyPerSecond() + "," +
                                player.getNbBasicWorker()
                );
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erreur sauvegarde: " + e.getMessage());
        }
    }
    public static Player loadPlayer(String filePath) {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) return null;

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            reader.readLine(); // header
            String line = reader.readLine();
            if (line == null || line.isBlank()) return null;

            String[] p = line.split(",");
            if (p.length < 4) return null;

            double money = Double.parseDouble(p[0]);
            double mpc = Double.parseDouble(p[1]);
            double mps = Double.parseDouble(p[2]);
            int nbWorker = Integer.parseInt(p[3]);

            return new Player(money, mpc, mps, nbWorker);

        } catch (Exception e) {
            System.out.println("Erreur chargement: " + e.getMessage());
            return null;
        }
    }
}
