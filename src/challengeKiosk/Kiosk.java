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
    private Customer customer = Customer.NORMAL;
    private double totalPrice = 0.0;
    private final int EXIT = 0;

    //생성자
    public Kiosk(Menu categoryMenu) {
        this.categoryMenu = new ArrayList<>();
        this.categoryMenu.add(categoryMenu);
    }
    public Kiosk() {
        this.categoryMenu = new ArrayList<>();
    }

    //기능
    public void start() {
        int selectCategory = -1;

        while (this.isKiosk) {
            /* 메인 메뉴 출력 */
                displayMainMenu();

                /* Cart에 상품이 담겨있는지에 따라 출력 변화 */
                if (cart.getSelectedItems().isEmpty()) {
                    selectCategory = getUserInput("카테고리를 선택해주세요. :",0,categoryMenu.size());
                } else {
                    selectCategory = getUserInput("카테고리를 선택해주세요.:" ,0,categoryMenu.size()+2);
                }

                if (selectCategory == EXIT) {
                    exit();
                    continue;
                } else if (selectCategory == categoryMenu.size() + 1) {
                    /* 장바구니 물품 주문하기 */
                    displayCartMenu();

                    int orderOption = getUserInput("1. 주문\t2. 할인혜택보기\t3.메뉴판으로 돌아가기 : ",1,3);

                    if (orderOption == 1) {
                        /* 주문 확정 출력 */
                        displayOrderComplete();
                        continue;
                    } else if (orderOption==2){
                        /* 할인 혜택 변경 */
                        displayCustomerOption();

                        int customerOption = getUserInput("할인혜택을 선택하세요.",1,Customer.values().length);

                        selectCustomerOption(customerOption);
                        continue;
                    }

                } else if (selectCategory == categoryMenu.size() + 2) {
                    /* 주문 취소 선택*/
                    int cancelOrder = getUserInput("주문을 취소하시겠습니까? 1.취소 2.아니오 : ",1,2);

                    if ( cancelOrder == 1 ){
                        displayCartCancel();
                        continue;
                    }
                } else {
                    /* 선택한 카테고리의 상품 출력 */
                    displayCategoryMenu(selectCategory);
                }

                /* 상품 선택하기 */
                int selectMerchandise = getUserInput("상품을 선택해주세요. :",0,categoryMenu.get(selectCategory - 1).getMenuItems().size());

                if (selectMerchandise == 0) {
                    continue;
                }

                System.out.println("======================================");
                System.out.println(categoryMenu.get(selectCategory - 1).getMenuItems().get(selectMerchandise - 1).toString());

                int choiceAddItem = getUserInput("위의 메뉴를 장바구니에 추가하시겠습니까? 1.예 2.아니오",1,2);

                if (choiceAddItem == 1) {
                    /* 카트 물품 추가 확정 */
                    addCartItem(selectCategory,selectMerchandise);
                }

            System.out.println();
        }
    }

    //키오스크 종료
    private void exit() {
        isKiosk = false;
    }

    //키오스크 카테고리메뉴 추가
    public void addCategory(Menu menu) {
        this.categoryMenu.add(menu);
    }

    //할인 혜택 설정
    private void setCustomer(Customer customer) {
        System.out.printf("고객님의 할인 유형이 %s로 전환됩니다.\n", customer.getOption());
        this.customer = customer;
    }

    //출력 부
    //MainMenu 출력
    private void displayMainMenu() {
        System.out.println("[ Main Menu ]");
        for (int i = 0; i < categoryMenu.size(); i++) {
            System.out.println((i + 1) + "." + categoryMenu.get(i).getCategory());
        }
        System.out.println("0.종료\t|\t종료");
        System.out.println();

        if (!cart.getSelectedItems().isEmpty()) {
            System.out.println("[ ORDER MENU ]");
            System.out.println((categoryMenu.size() + 1) + ".Orders | 장바구니를 확인후 주문합니다.");
            System.out.println((categoryMenu.size() + 2) + ".Cancel | 진행중인 주문을 취소합니다.");
        }
    }

    //카트 메뉴 출력
    private void displayCartMenu() {
        System.out.println("아래와 같이 주문하시겠습니까?");
        System.out.println("[ Orders ]");
        int cnt = 1;

        /* 장바구니 물품 출력 */
        for (MenuItem key : cart.getSelectedItems().keySet()) {
            System.out.printf("%2d. %10s | W %-5.1f | %d개 | %s\n", cnt++, key.getName(), key.getPrice(), cart.getSelectedItems().get(key), key.getInformation());
            totalPrice += cart.getSelectedItems().get(key)*key.getPrice();
        }
        System.out.println();
        System.out.println("[ Total ]");
        System.out.printf("할인 적용 전 | W %3.1f\n", totalPrice);
        System.out.printf("할인 적용 후 | W %3.1f\n", totalPrice * customer.getDiscount());

    }

    //주문 확정 출력
    private void displayOrderComplete(){
        if(!this.customer.equals(Customer.NORMAL)){
            System.out.println(this.customer.getOption()+"("+(int)((1.0-this.customer.getDiscount())*100.0)+"%)의 할인율이 제공되었습니다.");
        }
        System.out.printf("주문이 완료되었습니다. 총 결제 금액은 W %3.1f 입니다.\n", this.totalPrice*customer.getDiscount());
        this.totalPrice = 0.0;
        cart.clearItem();
    }

    //할인 혜택 출력
    private void displayCustomerOption(){
        System.out.println("[ CustomerOptions ]");
        int i = 1;
        for(Customer option : Customer.values()){
            System.out.println(i + ". " + option.getOption());
            i++;
        }
    }
    
    //할인 혜택 변경
    private void selectCustomerOption(int customerOption){
        for(Customer option : Customer.values()){
            if(option.ordinal() == customerOption-1){
                setCustomer(option);
            }
        }
    }

    //선택한 카테고리 메뉴 출력
    private void displayCategoryMenu(int selectCategory){
        System.out.println("=====" + categoryMenu.get(selectCategory - 1).getCategory() + "=====");
        for (Menu menu : categoryMenu) {
            /* 선택한 카테고리 출력 */
            if (menu.getCategory().equals(categoryMenu.get(selectCategory - 1).getCategory())) {
                menu.printMenuItems();
            }
        }
        System.out.println("0. 뒤로가기");
    }

    //
    private void addCartItem(int selectCategory,int selectMerchandise){
        cart.add(categoryMenu.get(selectCategory - 1).getMenuItems().get(selectMerchandise - 1));
        System.out.println(categoryMenu.get(selectCategory - 1).getMenuItems().get(selectMerchandise - 1).getName()+" 이 장바구니에 추가되었습니다.");
    }

    private void displayCartCancel(){
        System.out.println("주문이 취소되었습니다.");
        cart.clearItem();
    }
    //사용자 입력 예외처리
    private int getUserInput(String message, int min, int max) {
        while (true) {
            try {
                System.out.print(message);
                int input = sc.nextInt();
                if (input < min || input > max) throw new InputMismatchException();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("올바른 숫자를 입력하세요.");
                sc.nextLine();
            }
        }
    }
}
