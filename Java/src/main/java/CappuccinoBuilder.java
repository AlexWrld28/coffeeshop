public class CappuccinoBuilder extends AbstractBeverageBuilder {
    @Override
    public Beverage build() {
        if (temperature != DrinkTemperature.HOT) {
            throw new IllegalStateException("Can't build Cappuccino with temperature ICED");
        }
        return new Cappuccino(size, milkType, sweetener, requireValidShots());
    }
}
