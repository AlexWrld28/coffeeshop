public class TeaBuilder extends AbstractBeverageBuilder {
    @Override
    public Beverage build() {
        rejectShots("Tea");
        return new Tea(temperature, size, milkType, sweetener);
    }
}
