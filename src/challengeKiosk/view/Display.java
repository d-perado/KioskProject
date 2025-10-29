package challengeKiosk.view;

import challengeKiosk.domain.Customer;
import challengeKiosk.domain.FoodItem;
import challengeKiosk.domain.Menu;
import challengeKiosk.service.Cart;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Display {

    public void displayMainMenu(List<Menu<? extends FoodItem>> categoryMenu, Cart cart) {
        /* 메인 메뉴 출력 */
        System.out.println("[ Main Menu ]");
        for (int i = 0; i < categoryMenu.size(); i++) {
            System.out.println((i + 1) + "." + categoryMenu.get(i).getCategory());
        }

        System.out.println("0.종료\t|\t종료");

        if (!cart.getSelectedItems().isEmpty()) {
            System.out.println();
            System.out.println("[ ORDER MENU ]");
            System.out.println((categoryMenu.size() + 1) + ".Orders | 장바구니를 확인후 주문합니다.");
            System.out.println((categoryMenu.size() + 2) + ".Cancel | 진행중인 주문을 취소합니다.");
        }
    }

    public void displayCartMenu(Cart cart, double totalPrice, double discount) {
        /* 장바구니 메뉴 출력 */
        System.out.println("[ Orders ]");
        int cnt = 1;
        /* 장바구니 물품 출력 */
        for (Map.Entry<FoodItem, Integer> key : cart.getSelectedItems().entrySet()) {
            System.out.printf("%2d. %10s | W %-5.1f | %d개 | %s\n", cnt++
                    , key.getKey().getName(), key.getKey().getPrice()
                    , key.getValue(), key.getKey().getInformation());
        }

        System.out.println();
        System.out.println("[ Total ]");
        System.out.printf("할인 적용 전 | W %3.1f\n", totalPrice);
        System.out.printf("할인 적용 후 | W %3.1f\n", totalPrice * discount);

    }

    public void displayAddCartItemConfirm(int selectMerchandise, Cart cart, Menu<? extends FoodItem>categoryMenu) {
        /* 장바구니 물품 추가 확정 */
        FoodItem Item = categoryMenu.getMenuItem(selectMerchandise - 1);
        cart.add(Item);
        System.out.println(Item.getName() + " 이 장바구니에 추가되었습니다.");
    }

    public void displayOrderComplete(Customer customer, Cart cart, double discountPrice) {
        /* 주문 확정 출력 */
        if (!customer.equals(Customer.NORMAL)) {
            System.out.println(customer.getOption() + "(" + (int)((1.0-customer.getDiscount())*100.0) + "%)의 할인율이 제공되었습니다.");
        }
        System.out.printf("주문이 완료되었습니다. 총 결제 금액은 W %3.1f 입니다.\n", discountPrice);
        cart.clearItem();
    }

    public void displayCustomerOption() {
        /* 할인 혜택 출력 */
        System.out.println("[ CustomerOptions ]");
        IntStream.range(0, Customer.values().length)
                .forEach(i -> System.out.println((i + 1) + ". " + Customer.values()[i].getOption()));
    }

    public <T extends FoodItem> void displayCategoryMenu(Menu<T> categoryMenu) {
        /* 선택한 카테고리 메뉴 출력 */
        System.out.println("=====" + categoryMenu.getCategory() + "=====");
        categoryMenu.printMenuItems();
        System.out.println("0. 뒤로가기");
    }

}
