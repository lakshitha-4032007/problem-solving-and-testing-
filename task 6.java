import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
abstract class Vehicle {
    protected double ratePerKm;
    public Vehicle(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }
    public abstract double calculateFare(double distance);
}
class Bike extends Vehicle {
    public Bike() { super(5.0); }
    @Override
    public double calculateFare(double distance) { return distance * ratePerKm; }
}
class Auto extends Vehicle {
    public Auto() { super(12.0); }
    @Override
    public double calculateFare(double distance) { return distance * ratePerKm; }
}
class Cab extends Vehicle {
    public Cab() { super(12.0); }
    @Override
    public double calculateFare(double distance) { return distance * ratePerKm; }
}
class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) { super(message); }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) return;
        int n = Integer.parseInt(line.trim());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            line = br.readLine();
            if (line == null || line.trim().isEmpty()) { i--; continue; }
            StringTokenizer st = new StringTokenizer(line);
            String type = st.nextToken();
            double distance = Double.parseDouble(st.nextToken());
            try {
                Vehicle vehicle;
                switch (type.toLowerCase()) {
                    case "bike": vehicle = new Bike(); break;
                    case "auto": vehicle = new Auto(); break;
                    case "cab": vehicle = new Cab(); break;
                    default: throw new InvalidBookingException("Invalid ride type");
                }
                sb.append((int) vehicle.calculateFare(distance)).append("\n");
            } catch (InvalidBookingException e) {
                sb.append(e.getMessage()).append("\n");
            }
        }
        System.out.print(sb);
    }
}