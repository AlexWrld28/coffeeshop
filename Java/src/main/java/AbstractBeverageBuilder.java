public abstract class Beverage {
    private final String name;
    private final DrinkTemperature temperature;
    private final Size size;
    private final MilkType milkType;
    private final Sweetener sweetener;
    private final Integer shots;

    protected Beverage(
            String name,
            DrinkTemperature temperature,
            Size size,
            MilkType milkType,
            Sweetener sweetener,
            Integer shots
    ) {
        this.name = name;
        this.temperature = temperature;
        this.size = size;
        this.milkType = milkType;
        this.sweetener = sweetener;
        this.shots = shots;
    }

    public String getName() {
        return name;
    }

    public DrinkTemperature getTemperature() {
        return temperature;
    }

    public Size getSize() {
        return size;
    }

    public MilkType getMilkType() {
        return milkType;
    }

    public Sweetener getSweetener() {
        return sweetener;
    }

    public Integer getShots() {
        return shots;
    }

    public abstract boolean supportsTemperature(DrinkTemperature temperature);

    public abstract boolean supportsShots();

    public String getDescription() {
        StringBuilder description = new StringBuilder();
        description.append(size).append(" ").append(temperature).append(" ").append(name);
        description.append(" with ").append(milkType).append(" milk");
        description.append(", sweetener: ").append(sweetener);
        if (shots != null) {
            description.append(", shots: ").append(shots);
        }
        return description.toString();
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
