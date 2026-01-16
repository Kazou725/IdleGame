import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WorkerLoader {

    public static Worker[] loadWorkers(String path) {
        List<Worker> list = new ArrayList<>();

        try (BufferedReader r = Files.newBufferedReader(Paths.get(path))) {
            r.readLine(); // header
            String line;

            while ((line = r.readLine()) != null) {
                String[] p = line.split(",");

                Worker w = new Worker(
                        Integer.parseInt(p[0]),
                        p[1],
                        p[2],
                        Integer.parseInt(p[3]),
                        Integer.parseInt(p[4]),
                        Double.parseDouble(p[5]),
                        Double.parseDouble(p[6]),
                        Double.parseDouble(p[7])
                );

                list.add(w);
            }
        } catch (Exception e) {
            System.out.println("Erreur workers: " + e.getMessage());
        }

        return list.toArray(new Worker[0]);
    }
}

