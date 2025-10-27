package challengeKiosk.domain;

public class Item {
    String name = "";
    double price = 0.0;
    String information = "";

    Item(String name, double price, String information){
        this.name = name;
        this.price = price;
        this.information = information;
    }

    public double getPrice() {
        return price;
    }

    public String getInformation() {
        return information;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return this.name+"| W " + this.getPrice()+"\t|"+this.information + "\n";
    }



}
