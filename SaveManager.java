import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveManager {
    private static final String HEADERWORKER =
            "name,lastName,potential,overall,moneyPerSecond,moneyPerClick,Cost";

    private static final String HEADER_PLAYER = "money,moneyPerClick,moneyPerSecond,workers";

    public static void savePlayer(Player player, String filePath) {
        try {
            Path path = Paths.get(filePath);
            Files.createDirectories(path.getParent());

            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                writer.write(HEADER_PLAYER);
                writer.newLine();

                // convertir int[] -> "3|1|0|0|2"
                int[] arr = player.getWorkers();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arr.length; i++) {
                    if (i > 0) sb.append("|");
                    sb.append(arr[i]);
                }

                writer.write(player.getMoney() + "," +
                        player.getMoneyPerClick() + "," +
                        player.getMoneyPerSecond() + "," +
                        sb);
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println("Erreur sauvegarde player: " + e.getMessage());
        }
    }
    public static Player loadPlayer(String filePath, int workerCount) {
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

            int[] workers = new int[workerCount]; // taille = nb workers dans le catalogue

            // "3|1|0|0|2"
            String[] owned = p[3].split("\\|");
            for (int i = 0; i < Math.min(owned.length, workerCount); i++) {
                workers[i] = Integer.parseInt(owned[i]);
            }

            return new Player(money, mpc, mps, workers);

        } catch (Exception e) {
            System.out.println("Erreur chargement: " + e.getMessage());
            return null;
        }
    }

    public static void saveWorkers(Worker Worker, String filePath) {
        try {
            Path path = Paths.get(filePath);
            Files.createDirectories(path.getParent());

            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                writer.write(HEADERWORKER);
                writer.newLine();
                writer.write(
                        Worker.getID() + "," +
                        Worker.getName() + "," +
                                Worker.getLastName() + "," +
                                Worker.getPotential() + "," +
                                Worker.getOverall() + "," +
                                Worker.getMoneyPerSecond() + "," +
                                Worker.getMoneyPerClick() + "," +
                                Worker.getCost());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erreur sauvegarde: " + e.getMessage());
        }
    }
    public static Worker loadWorkers(String filePath) {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) return null;

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            reader.readLine(); // header
            String line = reader.readLine();
            if (line == null || line.isBlank()) return null;

            String[] p = line.split(",");
            if (p.length < 8) return null;

            int id = Integer.parseInt(p[0]);
            String name = p[1];
            String lastName = p[2];
            int potential = Integer.parseInt(p[3]);
            int overall = Integer.parseInt(p[4]);
            Double moneyPerSecond = Double.parseDouble(p[5]);
            Double moneyPerClick = Double.parseDouble(p[6]);
            Double cost = Double.parseDouble(p[7]);

            return new Worker(id,name, lastName, potential, overall, moneyPerSecond, moneyPerClick, cost);

        } catch (Exception e) {
            System.out.println("Erreur chargement: " + e.getMessage());
            return null;
        }
    }
}
