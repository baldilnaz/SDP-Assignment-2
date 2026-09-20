import abstractfactory.GUIFactory;
import abstractfactory.MacOSFactory;
import abstractfactory.WindowsFactory;
import factorymethod.Logistics;
import factorymethod.RoadLogistics;
import factorymethod.SeaLogistics;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String deliveryType = readChoice(
                scanner,
                "Enter delivery type (ROAD/SEA): ",
                "ROAD",
                "SEA"
        );

        String platform = readChoice(
                scanner,
                "Enter platform (WINDOWS/MACOS): ",
                "WINDOWS",
                "MACOS"
        );

        String cargo = readRequiredInput(
                scanner,
                "Enter cargo: "
        );

        String destination = readRequiredInput(
                scanner,
                "Enter destination: "
        );

        Logistics logistics = createLogistics(deliveryType);
        GUIFactory guiFactory = createGuiFactory(platform);

        DeliveryApplication application =
                new DeliveryApplication(guiFactory, logistics);

        application.run(cargo, destination);

        scanner.close();
    }

    private static String readChoice(
            Scanner scanner,
            String message,
            String firstOption,
            String secondOption
    ) {
        while (true) {
            System.out.print(message);

            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals(firstOption) || input.equals(secondOption)) {
                return input;
            }

            System.out.println(
                    "Invalid input. Please enter "
                            + firstOption + " or " + secondOption + "."
            );
        }
    }

    private static String readRequiredInput(
            Scanner scanner,
            String message
    ) {
        while (true) {
            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty.");
        }
    }

    private static Logistics createLogistics(String deliveryType) {
        if (deliveryType.equals("ROAD")) {
            return new RoadLogistics();
        }

        return new SeaLogistics();
    }

    private static GUIFactory createGuiFactory(String platform) {
        if (platform.equals("WINDOWS")) {
            return new WindowsFactory();
        }

        return new MacOSFactory();
    }
}