public enum DrinkTemperature {
    HOT,
    ICED;

    @Override
    public String toString() { return name().charAt(0) + name().substring(1).toLowerCase(); }
}
