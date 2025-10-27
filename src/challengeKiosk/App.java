package challengeKiosk;

import challengeKiosk.domain.BuggerItem;
import challengeKiosk.domain.DessertItem;
import challengeKiosk.domain.DrinkItem;
import challengeKiosk.domain.Menu;
import challengeKiosk.service.Kiosk;

public class App {


    public static void main(String[] args) {
        Menu burger = new Menu("Burgers");
        Menu drink = new Menu("Drinks");
        Menu dessert = new Menu("Desserts");
        burger.addMenuItems(new BuggerItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burger.addMenuItems(new BuggerItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burger.addMenuItems(new BuggerItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burger.addMenuItems(new BuggerItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        burger.addMenuItems(new BuggerItem("MinSang'sBurger", 110.0, "민상님의 비밀레시피로 만들어진 특제버거"));
        burger.addMenuItems(new BuggerItem("ShackShackBurger", 6.9, "토마토, 양상추, 쉑소스가 두배!! 토핑된 치즈버거"));
        drink.addMenuItems(new DrinkItem("shackDrink", 8.9, "쉑쉑의 메인드링크"));
        drink.addMenuItems(new DrinkItem("coke", 6.9, "콜라"));
        drink.addMenuItems(new DrinkItem("Tiger Drink", 5.4, "호랑이 기운이 용솟음 치는 음료"));
        drink.addMenuItems(new DrinkItem("Dragon blood", 110.0, "용의 피"));
        burger.addMenuItems(new BuggerItem("Small-Burger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 스몰버거"));
        dessert.addMenuItems(new DessertItem("Devil's tail", 8.9, "악마 꼬리 절임"));
        dessert.addMenuItems(new DessertItem("Cookie", 6.9, "쿸히"));
        dessert.addMenuItems(new DessertItem("KKAKKA", 5.4, "까까"));
        dessert.addMenuItems(new DessertItem("NYAmNyam chocolate", 110.0, "냠냠 초콜렛"));
        Kiosk kiosk = new Kiosk(burger);
        kiosk.addCategory(drink);
        kiosk.addCategory(dessert);
        kiosk.start();

    }
}
