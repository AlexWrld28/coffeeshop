public class Latte extends Beverage {
    public Latte(
            DrinkTemperature temperature,
            Size size,
            MilkType milkType,
            Sweetener sweetener,
            int shots
    ) {
        super("Latte", temperature, size, milkType, sweetener, shots);
    }

    @Override
    public boolean supportsTemperature(DrinkTemperature temperature) {
        return temperature == DrinkTemperature.HOT || temperature == DrinkTemperature.ICED;
    }

    @Override
    public boolean supportsShots() {
        return true;
    }
}
