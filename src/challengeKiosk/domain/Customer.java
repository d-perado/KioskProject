package challengeKiosk.domain;

public enum Customer {
    NORMAL("일반인",1),
    SOLDIER("군인",0.7),
    STUDENT("학생",0.8),
    NATIONAL_MERIT("국가유공자",0.5);

    private String option;
    private double discount;

    Customer(String option, double discount){
        this.option = option;
        this.discount = discount;
    }

    public double getDiscount(){
        return this.discount;
    }

    public String getOption(){
        return this.option;
    }
}
