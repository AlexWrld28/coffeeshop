public class Cappuccino  extends Beverage {
    public Cappuccino(
            Size size,
            MilkType milkType,
            Sweetener sweetener,
            int shots
    ) {
        super("Cappuccino", DrinkTemperature.HOT, size, milkType, sweetener, shots);
    }

    @Override
    public boolean supportsTemperature(DrinkTemperature temperature) {
        return temperature == DrinkTemperature.HOT;
    }

    @Override
    public boolean supportsShots() { return true;}

}
