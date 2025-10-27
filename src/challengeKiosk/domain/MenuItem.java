package challengeKiosk.domain;

public class MenuItem {

    //속성
    private String name;
    private double price;
    private String information;

    //생성자
    public MenuItem(String name, double price, String information) {
        this.name = name;
        this.price = price;
        this.information = information;
    }

    //기능
    //게터
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getInformation() {
        return information;
    }

    public String toString() {
        return this.name+"| W " + this.getPrice()+"\t|"+this.information + "\n";
    }
}
