public class TeaBuilder extends Beverage {
    @Override
    public Beverage build() {
        rejectShots("Tea");
        return new Tea(temperature. size, milkType, sweetener);
    }
}
