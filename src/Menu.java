import java.util.ArrayList;
import java.util.List;

public class Menu {

    //속성
    public String category;
    public List<MenuItem> menuItems= new ArrayList<>();

    //생성자
    Menu(String category) {
        this.category = category;
    }

    //기능
    //카테고리 출력
    public String getCategory() {
        return this.category;
    }

    //메뉴아이템 전체 출력
    public void printMenuItems() {
        int i=1;
        for(MenuItem menuItem : this.menuItems){
            System.out.printf("%2d. %-20s| W%-5.1f|\t%-5s\n", i++, menuItem.name
                    , menuItem.price
                    , menuItem.information);
        }
    }

    //메뉴아이템 전체리스트 반환 함수
    public List<MenuItem> getMenuItems(){
        return this.menuItems;
    }


}
