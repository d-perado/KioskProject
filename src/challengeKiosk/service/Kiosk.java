package challengeKiosk.service;

import challengeKiosk.domain.*;
import challengeKiosk.view.Display;

import java.util.*;

public class Kiosk {
    // 속성
    private final Scanner sc = new Scanner(System.in);

    private static final int EXIT = 0;
    private Customer customer = Customer.NORMAL;

    private final List<Menu<? extends FoodItem>> categoryMenu = new ArrayList<>();
    private final Cart cart = new Cart();

    private static final Display display = new Display();
    // 생성자
    public Kiosk(Menu<? extends FoodItem> categoryMenu) {
        this.categoryMenu.add(categoryMenu);
    }

    // 기능
    public void start() {
        /* 키오스크 시작 */
        int selectCategory = -1;
        boolean isKiosk = true;
        while (isKiosk) {
                /* 메인 메뉴 출력 */
                display.displayMainMenu(categoryMenu, cart);
                /* Cart에 상품이 담겨있는지에 따라 출력 변화 */
                if (cart.getSelectedItems().isEmpty()) {
                    selectCategory = getUserInput("카테고리를 선택해주세요. : ",0,categoryMenu.size());
                } else {
                    selectCategory = getUserInput("카테고리를 선택해주세요. : " ,0,categoryMenu.size()+2);
                } //다른쪽으로 빼보는게 어떨까

                if (selectCategory == EXIT) {
                    isKiosk = false;
                    continue;
                } else if (selectCategory == categoryMenu.size() + 1) {
                    /* 장바구니 물품 주문하기 */
                    System.out.println("아래와 같이 주문하시겠습니까?");
                    double totalPrice = getTotalPrice();
                    display.displayCartMenu(cart, totalPrice, customer.getDiscount());

                    System.out.println();
                    System.out.printf("%d. 주문\n",cart.getSelectedItems().size()+1);
                    System.out.printf("%d. 할인혜택보기\n",cart.getSelectedItems().size()+2);
                    System.out.println("0. 메뉴판으로 돌아가기");

                    System.out.println("============================");
                    int deleteItemOption = getUserInput("취소할 상품을 선택하시거나,\n원하시는 메뉴를 선택하세요. : ",0
                            ,cart.getSelectedItems().size() + 2);

                    if (deleteItemOption == cart.getSelectedItems().size() + 1) {
                        /* 주문 확정 출력 */
                        display.displayOrderComplete(customer,cart,totalPrice);
                        continue;
                    } else if (deleteItemOption==cart.getSelectedItems().size() + 2){
                        /* 할인 혜택 변경 */
                        display.displayCustomerOption();

                        int customerOption = getUserInput("할인혜택을 선택하세요. : ",1,Customer.values().length);

                        selectCustomerOption(customerOption);
                        continue;
                    } else if (deleteItemOption == 0 ) {
                        continue;

                    } else {
                        /* 물품 한개 취소 */
                        cart.removeItem(deleteItemOption-1);
                        System.out.println("선택하신 물품이 1개 제거되었습니다.");
                        continue;
                    }

                } else if (selectCategory == categoryMenu.size() + 2) {
                    /* 주문 전체 취소 선택 */
                    int cancelOrder = getUserInput("주문을 전체 취소하시겠습니까? 1.취소 2.아니오 : ",1,2);

                    if ( cancelOrder == 1 ){
                        cart.clearItem();
                        System.out.println("주문이 취소되었습니다.");
                        continue;
                    }
                } else {
                    /* 선택한 카테고리의 상품 출력 */
                    display.displayCategoryMenu(categoryMenu.get(selectCategory-1));
                }

                /* 상품 선택하기 */
                int selectMerchandise = getUserInput("상품을 선택해주세요. : ",0, categoryMenu.get(selectCategory - 1).getMenuItems().size());

                if (selectMerchandise == 0) {
                    continue;
                }
                System.out.println("======================================\n");
                System.out.println(categoryMenu.get(selectCategory - 1).getMenuItems().get(selectMerchandise - 1).toString());

                int choiceAddItem = getUserInput("위의 메뉴를 장바구니에 추가하시겠습니까? 1.예 2.아니오 : ",1,2);

                if (choiceAddItem == 1) {
                    display.displayAddCartItemConfirm(selectMerchandise, cart,categoryMenu.get(selectCategory - 1));
                }
            System.out.println();
        }
    }

    //기능이 있는 메서드 집합
    public <T extends FoodItem> void addCategory(Menu<T> menu) {
        /* 키오스크 카테고리메뉴 추가 */
        this.categoryMenu.add(menu);
    }

    private void selectCustomerOption(int customerOption){
        /* 할인 혜택 변경 */
        Arrays.stream(Customer.values())
                .filter(option -> option.ordinal() == customerOption - 1)
                .findFirst()
                .ifPresent(this::setCustomer);
    }

    private void setCustomer(Customer customer) {
        /* 할인 혜택 설정 */
        System.out.printf("고객님의 할인 유형이 %s로 전환됩니다.\n", customer.getOption());
        this.customer = customer;
    }


    public double getTotalPrice() {
        /* 장바구니 총액 계산 */
        double totalPrice = 0.0;
                for (Map.Entry<FoodItem, Integer> cartItem : cart.getSelectedItems().entrySet()) {
                        totalPrice += cartItem.getKey().getPrice() * cartItem.getValue();
                        break;
            }
        return totalPrice;
    }

    //입력 메서드
    private int getUserInput(String message, int min, int max) {
        /* 사용자 int값 입력 */
        System.out.println();
        while (true) {
            try {
                System.out.print(message);
                int input = sc.nextInt();
                if (input < min || input > max) throw new InputMismatchException();
                System.out.println();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("올바른 숫자를 입력하세요.");
                sc.nextLine();
            }
        }
    }
}
