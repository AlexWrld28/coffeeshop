public abstract class AbstractBeverageBuilder implements BeverageBuilder {
    protected DrinkTemperature temperature = DrinkTemperature.HOT;
    protected Size size = Size.MEDIUM;
    protected MilkType milkType = MilkType.WHOLE;
    protected Sweetener sweetener = Sweetener.NONE;
    protected Integer shots;

    @Override
    public BeverageBuilder setTemperature(DrinkTemperature temperature) {
        this.temperature = temperature;
        return this;
    }

    @Override
    public BeverageBuilder setSize(Size size) {
        this.size = size;
        return this;
    }

    @Override
    public BeverageBuilder setMilkType(MilkType milkType) {
        this.milkType = milkType;
        return this;
    }

    @Override
    public BeverageBuilder setSweetener(Sweetener sweetener) {
        this.sweetener = sweetener;
        return this;
    }

    @Override
    public BeverageBuilder setShots(int shots) {
        this.shots = shots;
        return this;
    }

    protected int requireValidShots() {
        if (shots == null) {
            return 1;
        }
        if (shots < 1 || shots > 3) {
            throw new IllegalArgumentException("Espresso drinks must have between 1 and 3 shots.");
        }
        return shots;
    }

    protected void rejectShots(String beverageName) {
        if (shots != null) {
            throw new IllegalArgumentException(beverageName + " does not support espresso shots.");
        }
    }
}
