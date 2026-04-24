public class Coffee extends Beverage {
    public Coffee(
            DrinkTemperature temperature,
            Size size,
            MilkType milkType,
            Sweetener sweetener
    ) {
        super("Coffee", temperature, size, milkType, sweetener, null);
    }

}


