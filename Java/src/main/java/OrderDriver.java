public class OrderDriver {
    public static void main(String[] args) {
        BeverageDirector director = new BeverageDirector();

        Order mobileOrder = new Order("Order 1", ServiceType.MOBILE);
        mobileOrder.addBeverage(director.createEspressoDrink(
                new latteBuilder(),
                DrinkTemperature.ICED,
                Size.Large,
                MIlkType.OAT,
                Sweetener.HONEY,
                2
        ));
        mobileOrder.addBeverage(director.createEspressoDrink(
                new TeaBuilder(),
                DrinkTemperature.HOT,
                Size.Small,
                MilkType.SOY,
                Sweetener.NONE
        ));
    }
}
