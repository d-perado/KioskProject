import java.util.ArrayList;
import java.util.List;

public class Menu {

    //속성
    private String category;
    private List<MenuItem> menuItems= new ArrayList<>();

    //생성자
    public Menu(String category) {
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
        for(MenuItem menuItem : this.menuItems) {
            System.out.printf("%2d. %-20s| W%-5.1f|\t%-5s\n", i++, menuItem.getName()
                    , menuItem.getPrice()
                    , menuItem.getInformation());
        }
    }

    //메뉴아이템 전체리스트 반환 함수
    public List<MenuItem> getMenuItems() {
        return new ArrayList<>(this.menuItems);
    }
    
    //메뉴아이템추가
    public void addMenuItems(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }


}
