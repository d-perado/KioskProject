import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    //속성
    List<MenuItem> menuItems = new ArrayList<>();
    boolean isKiosk = true;
    Scanner sc = new Scanner(System.in);
    //생성자
    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
    //기능
    public void start() {
        while (this.isKiosk) {
            System.out.println("[ SHAKESHACK MENU ]");
            //메뉴 출력
            int i = 1; //메뉴 앞 숫자
            for (MenuItem menuItem : menuItems) {
                System.out.printf("%2d. %-20s| W%-5.1f|\t%-5s\n", i++, menuItem.name
                        , menuItem.price
                        , menuItem.information);
            }

            System.out.println("메뉴를 선택하세요");
            int input = -1;

            try {
                input = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("올바른 숫자를 입력하세요.");
                sc.nextLine();
            }
            switch (input) {
                case 1 -> {
                    System.out.println("1.ShackBurger 주문완료");
                }
                case 2 -> {
                    System.out.println("2.SmokeShack 주문완료");
                }
                case 3 -> {
                    System.out.println("3.Cheeseburger 주문완료");
                }
                case 4 -> {
                    System.out.println("4.Hamburger  주문완료");
                }
                case 0 -> {
                    exit();
                }
            }
            //종료


            //사용자 입력에 따른 출력변화

            System.out.println();
        }

    }

    //키오스크 종료
    public void exit(){
        isKiosk = false;
    }
}
