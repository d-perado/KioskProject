import java.util.Scanner;

public class App {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isKiosk = true;
        while (isKiosk) {
            System.out.println("[ SHAKESHACK MENU ]");
            System.out.println("1.\tShackBurger\t|\tW 6.9\t|\t토마토, 양상추, 쉑소스가 토핑된 치즈버거");
            System.out.println("2.\tSmokeShack\t|\tW 8.9\t|\t베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
            System.out.println("3.\tCheeseburger\t|\tW 6.9\t|\t포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
            System.out.println("4.\tHamburger\t|\tW 5.4\t|\t비프패티를 기반으로 야채가 들어간 기본버거");
            System.out.println("0.\t종료\t|\t종료");

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