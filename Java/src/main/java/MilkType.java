public enum MilkType {
    WHOLE,
    SKIM,
    ALMOND,
    OAT,
    SOY;

    @Override
    public String toString() { return name().charAt(0) + name().substring(1).toLowerCase();}
}
