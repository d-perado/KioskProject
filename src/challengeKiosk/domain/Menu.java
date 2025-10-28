package challengeKiosk.domain;

import java.util.ArrayList;
import java.util.List;

public class Menu <T extends FoodItem> {

    //속성
    private final String category;
    private final List<T> menuItems = new ArrayList<>();

    //생성자
    public Menu(String category) {
        this.category = category;
    }

    //기능
    //게터
    public String getCategory() {
        return this.category;
    }

    //메뉴아이템 전체 출력
    public void printMenuItems() {
        int i = 1;
        for (T menuItem : this.menuItems) {
            System.out.printf("%2d. %-20s| W%-5.1f|\t%-5s\n", i++, menuItem.getName()
                    , menuItem.getPrice()
                    , menuItem.getInformation());
        }
    }
    //메뉴아이템 하나 반환
    public T getMenuItem(int i){
        return menuItems.get(i);
    }


    //메뉴아이템 전체리스트 반환 함수
    public List<T> getMenuItems() {
        return new ArrayList<>(this.menuItems);
    }

    //메뉴아이템추가
    public void addMenuItems(T menuItem) {
        this.menuItems.add(menuItem);
    }

}
