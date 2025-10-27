package challengeKiosk.domain;

public class BuggerItem extends Item{
    //속성
    private String name;
    private double price;
    private String information;

    //생성자
    public BuggerItem(String name, double price, String information) {
        super(name,price,information);
    }
}
