import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isKiosk = true;

        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        menuItems.add(new MenuItem("MinSang'sBurger", 110.0, "민상님의 비밀레시피로 만들어진 특제버거"));
        while (isKiosk) {
            System.out.println("[ SHAKESHACK MENU ]");
            
            //메뉴 출력
            int i = 1; //메뉴 앞 숫자
            for(MenuItem menuItem : menuItems){
                System.out.printf("%2d. %-20s| W%-5.1f|\t%-5s\n",i++,menuItem.name
                        ,menuItem.price
                        ,menuItem.information);
            }

            System.out.println("메뉴를 선택하세요");

            int input = sc.nextInt();

            //종료
            if(input == 0) {
                isKiosk = false;
                continue;
            }

            //사용자 입력에 따른 출력변화
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

            }
            System.out.println();
        }
    }
}