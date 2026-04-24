public enum ServiceType {
    DINE_IN,
    DINE_OUT,
    MOBILE;

    @Override
    public String toString() {
        return name().replace("_", " ").charAt(0)
        + name().replace('_', ' ').substring(1).toLowerCase();
    }
}
