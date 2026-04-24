public class CoffeeBuilder extends AbstractBeverageBuilder {
    @Override
    public Beverage build() {
        rejectShots("Coffee");
        return new Coffee(temperature, size, MilkType, sweetener);
    }
}
