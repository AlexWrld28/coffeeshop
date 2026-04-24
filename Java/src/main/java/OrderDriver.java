public class OrderDriver {
    public static void main(String[] args) {
        BeverageDirector director = new BeverageDirector();

        Order mobileOrder = new Order("Order 1", ServiceType.MOBILE);
        mobileOrder.addBeverage(director.createEspressoDrink(
                new LatteBuilder(),
                DrinkTemperature.ICED,
                Size.LARGE,
                MilkType.OAT,
                Sweetener.HONEY,
                2
        ));
        mobileOrder.addBeverage(director.createStandardDrink(
                new TeaBuilder(),
                DrinkTemperature.HOT,
                Size.SMALL,
                MilkType.SOY,
                Sweetener.NONE
        ));

        Order dineInOrder = new Order("Order 2", ServiceType.DINE_IN);
        dineInOrder.addBeverage(director.createStandardDrink(
                new CoffeeBuilder(),
                DrinkTemperature.HOT,
                Size.MEDIUM,
                MilkType.WHOLE,
                Sweetener.SUGAR
        ));
        dineInOrder.addBeverage(director.createEspressoDrink(
                new CappuccinoBuilder(),
                DrinkTemperature.HOT,
                Size.SMALL,
                MilkType.ALMOND,
                Sweetener.STEVIA,
                3
        ));

        Order takeoutOrder = new Order("Order 3", ServiceType.TAKEOUT);
        takeoutOrder.addBeverage(director.createStandardDrink(
                new TeaBuilder(),
                DrinkTemperature.ICED,
                Size.LARGE,
                MilkType.SKIM,
                Sweetener.HONEY
        ));
        takeoutOrder.addBeverage(director.createStandardDrink(
                new CoffeeBuilder(),
                DrinkTemperature.ICED,
                Size.SMALL,
                MilkType.OAT,
                Sweetener.NONE
        ));

        System.out.println("Pattern note: This solution uses the Builder pattern. "
                + "The director controls construction steps while concrete builders "
                + "create each beverage type with valid customizations.");
        System.out.println();
        System.out.println(mobileOrder);
        System.out.println(dineInOrder);
        System.out.println(takeoutOrder);
    }
}

}
