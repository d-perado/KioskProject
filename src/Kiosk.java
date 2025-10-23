import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    //속성
    List<Menu> categoryMenu;
    boolean isKiosk = true;
    Scanner sc = new Scanner(System.in);

    //생성자
    public Kiosk(Menu categoryMenu) {
        this.categoryMenu = new ArrayList<>();
        this.categoryMenu.add(categoryMenu);
    }

    //기능
    public void start() {
        while (this.isKiosk) {
            //메뉴 카테고리 출력
            System.out.println("[ Main Menu ]");
            for (int i = 0; i < categoryMenu.size(); i++){
                System.out.println((i+1)+"."+categoryMenu.get(i).category);
            }

            int selectCategory = -1; // 카테고리 사용자 입력
            System.out.println("0.종료\t|\t종료");
            try {
                selectCategory = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("올바른 숫자를 입력하세요.");
                sc.nextLine();
            }
            if (selectCategory == 0){
                exit();
                continue;
            }
            for (Menu menu : categoryMenu) {
                if(menu.category.equals(categoryMenu.get(selectCategory-1).category)){
                    menu.printMenuItems();
                }
            }

            System.out.println("=======구매할 물품을 골라주세요=======");

            //
            int selectMerchandise = -1;
            try {
                selectMerchandise = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("올바른 숫자를 입력하세요.");
                sc.nextLine();
            }

            System.out.println("선택한 품목 :\t"
                    + categoryMenu.get(selectCategory-1).menuItems.get(selectMerchandise-1).name + "| W"
                    + categoryMenu.get(selectCategory-1).menuItems.get(selectMerchandise-1).price + "|\t"
                    + categoryMenu.get(selectCategory-1).menuItems.get(selectMerchandise-1).information);


            //사용자 입력에 따른 출력변화

            System.out.println();
        }

    }

    //키오스크 종료
    public void exit() {
        isKiosk = false;
    }

    //키오스크 카테고리메뉴 추가
    public void addCategory(Menu menu){
        this.categoryMenu.add(menu);
    }
}
