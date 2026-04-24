public interface BeverageBuilder {
    BeverageBuilder setTemperature(DrinkTemperature temperature);

    BeverageBuilder setSize(Size size);

    BeverageBuilder setMilkType(MilkType milkType);

    BeverageBuilder setSweetener(Sweetener sweetener);

    BeverageBuilder setShots(int shots);

    Beverage build();

}
