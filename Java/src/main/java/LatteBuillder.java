public class LatteBuilder extends AbstractBeverageBuilder {
    @Override
    public Beverage build() {
        return new Latte(temperature, size, MilkType, sweetener, requireValidShots());}
}
