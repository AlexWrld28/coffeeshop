public class BeverageDirector {
    public Beverage createStandardDrink(
            BeverageBuilder builder,
            DrinkTemperature temperature,
            Size size,
            MilkType milkType,
            Sweetener sweetener
    ) {
        return builder
                .setTemperature(temperature)
                .setSize(size)
                .setMilkType(milkType)
                .setSweetener(sweetener)
                .build();
    }

    public Beverage createEspressoDrink(
            BeverageBuilder builder,
            DrinkTemperature temperature,
            Size size,
            MilkType milkType,
            Sweetener sweetener,
            int shots
    ) {
        return builder
                .setTemperature(temperature)
                .setSize(size)
                .setMilkType(milkType)
                .setSweetener(sweetener)
                .setShots(shots)
                .build();
    }
}
