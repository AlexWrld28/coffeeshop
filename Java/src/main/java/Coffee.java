public class Coffee extends Beverage {
    public Coffee(
            DrinkTemperature temperature,
            Size size,
            MilkType milkType,
            Sweetener sweetener
    ) {
        super("Coffee", temperature, size, milkType, sweetener, null);
    }

    @Override
    public boolean supportsTemperature(DrinkTemperature temperature) {
        return temperature == DrinkTemperature.HOT || temperature == DrinkTemperature.ICED;
    }

    @Override
    public boolean supportsShots() {
        return false;
    }
}


