import java.util.ArrayList;
import java.util.List;

public class Order {
    private final String orderName;
    private final ServiceType serviceType;
    private final List<Beverage> beverages;

    public Order(String orderName, ServiceType serviceType) {
        this.orderName = orderName;
        this.serviceType = serviceType;
        this.beverages = new ArrayList<>();
    }

    public void addBeverage(Beverage beverage) {
        beverages.add(beverage);
    }

    public List<Beverage> getBeverages() {
        return beverages;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(orderName)
                .append(" (")
                .append(serviceType)
                .append(")")
                .append(System.lineSeparator());

        for (int i = 0; i < beverages.size(); i++) {
            output.append("  ")
                    .append(i + 1)
                    .append(". ")
                    .append(beverages.get(i).getDescription())
                    .append(System.lineSeparator());
        }

        return output.toString();
    }
}
