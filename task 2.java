import java.util.*;
import java.util.stream.Collectors;
public class SensorAnalytics {
    static class SensorReading {
        String id;
        double temperature;
        SensorReading(String id, double temperature) {
            this.id = id;
            this.temperature = temperature;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<SensorReading> readings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String sensorId = scanner.next();
            double temp = scanner.nextDouble();
            readings.add(new SensorReading(sensorId, temp));
        }
        readings.stream()
            .filter(r -> r.temperature > 50)
            .collect(Collectors.groupingBy(
                r -> r.id,
                Collectors.averagingDouble(r -> r.temperature)
            ))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .forEach(entry -> System.out.printf("%s %.1f\n", entry.getKey(), entry.getValue()));
        scanner.close();
    }
}