public class Latte extends Beverage{
    public Latte(
            DrinkTemperature temperature,
            Size size,
            MilkType milkType,
            Sweetener sweetener,
            int shots
            ) {
        super("Latte", temperature, size, milkType, sweetener, shots);
    }
}
