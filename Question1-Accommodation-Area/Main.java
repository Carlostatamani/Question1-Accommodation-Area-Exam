import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccommodationArea activeArea = new GymArea(); // default to Gym

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("S – Select active area (G = Gym, P = Swimming)");
            System.out.println("W – Add occupants");
            System.out.println("X – Remove occupants");
            System.out.println("Y – Switch ON light");
            System.out.println("Z – Switch OFF light");
            System.out.println("R – Report status");
            System.out.println("Q – Quit");
            System.out.print("Enter command: ");
            String command = scanner.nextLine().toUpperCase();

            switch (command) {
                case "S":
                    System.out.print("Enter area (G for Gym, P for Swimming): ");
                    String area = scanner.nextLine().toUpperCase();
                    if (area.equals("G")) {
                        activeArea = new GymArea();
                        System.out.println("Active area set to Gym");
                    } else if (area.equals("P")) {
                        activeArea = new SwimmingArea();
                        System.out.println("Active area set to Swimming");
                    } else {
                        System.out.println("Invalid area selection");
                    }
                    break;
                case "W":
                    System.out.print("Enter number of occupants to add: ");
                    try {
                        int n = Integer.parseInt(scanner.nextLine());
                        activeArea.addOccupants(n);
                        System.out.println("Added " + n + " occupants");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number");
                    }
                    break;
                case "X":
                    System.out.print("Enter number of occupants to remove: ");
                    try {
                        int n = Integer.parseInt(scanner.nextLine());
                        activeArea.removeOccupants(n);
                        System.out.println("Removed " + n + " occupants");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number");
                    }
                    break;
                case "Y":
                    System.out.print("Enter light number (1-3) to switch ON: ");
                    try {
                        int light = Integer.parseInt(scanner.nextLine());
                        if (light >= 1 && light <= 3) {
                            activeArea.switchOnLight(light);
                            System.out.println("Light " + light + " switched ON");
                        } else {
                            System.out.println("Invalid light number");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number");
                    }
                    break;
                case "Z":
                    System.out.print("Enter light number (1-3) to switch OFF: ");
                    try {
                        int light = Integer.parseInt(scanner.nextLine());
                        if (light >= 1 && light <= 3) {
                            activeArea.switchOffLight(light);
                            System.out.println("Light " + light + " switched OFF");
                        } else {
                            System.out.println("Invalid light number");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number");
                    }
                    break;
                case "R":
                    System.out.println(activeArea.getStatus());
                    break;
                case "Q":
                    System.out.println("Exiting program");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }
}
