import java.util.ArrayList;
import java.util.List;

public class App {


    public static void main(String[] args) {
        Menu bugger = new Menu("Buggers");
        Menu drink = new Menu("Drinks");
        Menu dessert = new Menu("Desserts");
        bugger.setMenuItems(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        bugger.setMenuItems(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        bugger.setMenuItems(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        bugger.setMenuItems(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        bugger.setMenuItems(new MenuItem("MinSang'sBurger", 110.0, "민상님의 비밀레시피로 만들어진 특제버거"));
        bugger.setMenuItems(new MenuItem("ShackShackBurger", 6.9, "토마토, 양상추, 쉑소스가 두배!! 토핑된 치즈버거"));
        drink.setMenuItems(new MenuItem("shackDrink", 8.9, "쉑쉑의 메인드링크"));
        drink.setMenuItems(new MenuItem("coke", 6.9, "콜라"));
        drink.setMenuItems(new MenuItem("Tiger Drink", 5.4, "호랑이 기운이 용솟음 치는 음료"));
        drink.setMenuItems(new MenuItem("Dragon blood", 110.0, "용의 피"));
        bugger.setMenuItems(new MenuItem("Small-Burger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 스몰버거"));
        dessert.setMenuItems(new MenuItem("Devil's tail", 8.9, "악마 꼬리 절임"));
        dessert.setMenuItems(new MenuItem("Cookie", 6.9, "쿸히"));
        dessert.setMenuItems(new MenuItem("KKAKKA", 5.4, "까까"));
        dessert.setMenuItems(new MenuItem("NYAmNyam chocolate", 110.0, "냠냠 초콜렛"));
        Kiosk kiosk = new Kiosk(bugger);
        kiosk.addCategory(drink);
        kiosk.addCategory(dessert);
        kiosk.start();

    }
}
