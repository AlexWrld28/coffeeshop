import java.util.Scanner;

public class OrderDriver {
    private enum DrinkChoice {
        COFFEE("Coffee", false, null),
        TEA("Tea", false, null),
        LATTE("Latte", true, null),
        CAPPUCCINO("Cappuccino", true, DrinkTemperature.HOT);

        private final String label;
        private final boolean requiresShots;
        private final DrinkTemperature fixedTemperature;

        DrinkChoice(String label, boolean requiresShots, DrinkTemperature fixedTemperature) {
            this.label = label;
            this.requiresShots = requiresShots;
            this.fixedTemperature = fixedTemperature;
        }

        public boolean requiresShots() {
            return requiresShots;
        }

        public DrinkTemperature fixedTemperature() {
            return fixedTemperature;
        }

        public BeverageBuilder createBuilder() {
            return switch (this) {
                case COFFEE -> new CoffeeBuilder();
                case TEA -> new TeaBuilder();
                case LATTE -> new LatteBuilder();
                case CAPPUCCINO -> new CappuccinoBuilder();
            };
        }

        @Override
        public String toString() {
            return label;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BeverageDirector director = new BeverageDirector();

        System.out.println("Welcome to the Coffee Shop.");
        System.out.println("Build your order step by step in the terminal.");
        System.out.println();

        String orderName = promptForText(scanner, "Enter a name for this order: ");
        ServiceType serviceType = promptForOption(scanner, "Choose a service type:", ServiceType.values());
        Order order = new Order(orderName, serviceType);

        int beverageNumber = 1;
        boolean addAnother = true;
        while (addAnother) {
            System.out.println("Configuring beverage #" + beverageNumber + ".");
            Beverage beverage = promptForBeverage(scanner, director);
            order.addBeverage(beverage);

            System.out.println();
            System.out.println("Added: " + beverage.getDescription());
            addAnother = promptForYesNo(scanner, "Add another beverage? (y/n): ");
            System.out.println();
            beverageNumber++;
        }

        System.out.println("Pattern note: This solution still uses the Builder pattern.");
        System.out.println("The director applies the user's choices while the concrete builders create each drink.");
        System.out.println();
        System.out.println("Order complete:");
        System.out.println(order);
    }

    private static Beverage promptForBeverage(Scanner scanner, BeverageDirector director) {
        while (true) {
            try {
                DrinkChoice drinkChoice = promptForOption(scanner, "Choose a drink:", DrinkChoice.values());
                DrinkTemperature temperature = promptForTemperature(scanner, drinkChoice);
                Size size = promptForOption(scanner, "Choose a size:", Size.values());
                MilkType milkType = promptForOption(scanner, "Choose a milk type:", MilkType.values());
                Sweetener sweetener = promptForOption(scanner, "Choose a sweetener:", Sweetener.values());

                if (drinkChoice.requiresShots()) {
                    int shots = promptForInt(scanner, "Choose the number of espresso shots (1-3): ", 1, 3);
                    return director.createEspressoDrink(
                            drinkChoice.createBuilder(),
                            temperature,
                            size,
                            milkType,
                            sweetener,
                            shots
                    );
                }

                return director.createStandardDrink(
                        drinkChoice.createBuilder(),
                        temperature,
                        size,
                        milkType,
                        sweetener
                );
            } catch (IllegalArgumentException | IllegalStateException ex) {
                System.out.println();
                System.out.println("That combination is not available: " + ex.getMessage());
                System.out.println("Let's try that beverage again.");
                System.out.println();
            }
        }
    }

    private static DrinkTemperature promptForTemperature(Scanner scanner, DrinkChoice drinkChoice) {
        if (drinkChoice.fixedTemperature() != null) {
            System.out.println("Choose a temperature:");
            System.out.println("  " + drinkChoice + " is available as " + drinkChoice.fixedTemperature() + " only.");
            return drinkChoice.fixedTemperature();
        }
        return promptForOption(scanner, "Choose a temperature:", DrinkTemperature.values());
    }

    private static String promptForText(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Please enter a value.");
        }
    }

    private static boolean promptForYesNo(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim().toLowerCase();
            if (value.equals("y") || value.equals("yes")) {
                return true;
            }
            if (value.equals("n") || value.equals("no")) {
                return false;
            }
            System.out.println("Please enter y or n.");
        }
    }

    private static int promptForInt(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Please enter a number from " + min + " to " + max + ".");
        }
    }

    private static <T> T promptForOption(Scanner scanner, String prompt, T[] options) {
        while (true) {
            System.out.println(prompt);
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            int selection = promptForInt(scanner, "Selection: ", 1, options.length);
            return options[selection - 1];
        }
    }
}
