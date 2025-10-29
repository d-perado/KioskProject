package challengeKiosk.domain;

public abstract class FoodItem implements Item{
    String name = "";
    double price = 0.0;
    String information = "";

    FoodItem(String name, double price, String information){
        this.name = name;
        this.price = price;
        this.information = information;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getInformation() {
        return information;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name + "| W " + this.getPrice() + "\t|" + this.information + "\n";
    }

}
