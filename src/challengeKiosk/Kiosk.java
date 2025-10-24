package challengeKiosk;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    //속성
    private List<Menu> categoryMenu;
    private boolean isKiosk = true;
    private Scanner sc = new Scanner(System.in);
    private Cart cart = new Cart();
    
    //생성자
    public Kiosk(Menu categoryMenu) {
        this.categoryMenu = new ArrayList<>();
        this.categoryMenu.add(categoryMenu);
    }

    //기능
    public void start() {
        while (this.isKiosk) {
            /* 메뉴 카테고리 출력 */
            System.out.println("[ Main Menu ]");
            for (int i = 0; i < categoryMenu.size(); i++) {
                System.out.println((i + 1) + "." + categoryMenu.get(i).getCategory());
            }

            int selectCategory = -1; // 카테고리 사용자 입력
            System.out.println("0.종료\t|\t종료");
            System.out.println();
            if (!cart.getSelectedItems().isEmpty()) {
                System.out.println("[ ORDER MENU ]");
                System.out.println((categoryMenu.size()+1)+".Orders | 장바구니를 확인후 주문합니다.");
                System.out.println((categoryMenu.size()+2)+".Cancel | 진행중인 주문을 취소합니다.");

            }
            try {
                selectCategory = sc.nextInt();
                if (selectCategory == 0) {
                    exit();
                    continue;
                }else if(selectCategory == categoryMenu.size()+1){
                    /* 장바구니 물품 주문하기 */
                    System.out.println("아래와 같이 주문하시겠습니까?");
                    System.out.println("[ Orders ]");
                    double totalPrice = 0;
                    for (int i = 0; i < cart.getSelectedItems().size(); i++) {
                        System.out.println((i+1)+". "+cart.getSelectedItems().get(i).getName()+"\t| W"
                        + cart.getSelectedItems().get(i).getPrice() + "\t|"
                        + cart.getSelectedItems().get(i).getInformation());
                        totalPrice += cart.getSelectedItems().get(i).getPrice();
                    }
                    System.out.println();
                    System.out.println("[ Total ]");
                    System.out.printf("W %3.1f\n",totalPrice);
                    System.out.println("1. 주문\t2.메뉴판");
                    int order = sc.nextInt();
                    if( order==1 ) {
                        System.out.printf("주문이 완료되었습니다. 금액은 W %4.1f 입니다.\n",totalPrice);
                        cart.clearItem();
                        continue;
                    }

                }else if(selectCategory == categoryMenu.size()+2){
                    System.out.println("주문을 취소하시겠습니까?");
                    System.out.println("1.취소\t아무키나 입력할시 다시 진행됩니다.");
                    int cancelOrder = sc.nextInt();
                    if ( cancelOrder == 1 ){
                        System.out.println("주문이 취소되었습니다.");
                        cart.clearItem();
                        continue;
                    }
                } else {
                    System.out.println("=====" + categoryMenu.get(selectCategory - 1).getCategory() + "=====");
                    for (Menu menu : categoryMenu) {
                        /* 선택한 카테고리 출력 */
                        if (menu.getCategory().equals(categoryMenu.get(selectCategory - 1).getCategory())) {
                            menu.printMenuItems();
                        }
                    }
                }
            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                System.out.println("올바른 숫자를 입력하세요.");
                sc.nextLine();
                continue;
            }


            //상품 장바구니에 담기
            int selectMerchandise = -1;
            try {
                selectMerchandise = sc.nextInt();
                
                System.out.println(
                        categoryMenu.get(selectCategory - 1).getMenuItems().get(selectMerchandise - 1).getName() + "\t| W"
                                + categoryMenu.get(selectCategory - 1).getMenuItems().get(selectMerchandise -1).getPrice() + "\t|"
                                + categoryMenu.get(selectCategory - 1).getMenuItems().get(selectMerchandise - 1).getInformation());
                System.out.println("위의 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1.확인\t2.취소");
                int choiceAddItem = sc.nextInt();

                if(choiceAddItem==1){
                    cart.addSelectedItem(categoryMenu.get(selectCategory -1).getMenuItems().get(selectMerchandise-1));
                    System.out.println(categoryMenu.get(selectCategory - 1).getMenuItems().get(selectMerchandise - 1).getName()+" 이 장바구니에 추가되었습니다.");
                }
            } catch (InputMismatchException | IndexOutOfBoundsException e) {
                System.out.println("올바른 숫자를 입력하세요.\n");
                sc.nextLine();
                continue;
            }

            //사용자 입력에 따른 출력변화

            System.out.println();
        }

    }

    //키오스크 종료
    public void exit() {
        isKiosk = false;
    }

    //키오스크 카테고리메뉴 추가
    public void addCategory(Menu menu) {
        this.categoryMenu.add(menu);
    }
}
