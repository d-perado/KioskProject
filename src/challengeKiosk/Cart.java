package challengeKiosk;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    //속성
    private List<MenuItem> selectedItems = new ArrayList<>();



    //생성자


    //기능
    //게터
    //선택한 물품 반환
    public List<MenuItem> getSelectedItems() {
        return new ArrayList<>(this.selectedItems);
    }

    //세터
    public void addSelectedItem(MenuItem menuItem){
        selectedItems.add(menuItem);
    }

    //하나의 물품 삭제
    public void removeItem(int i) {
        if(selectedItems.size() > i){
            selectedItems.remove(i);
        }
    }

    //장바구니 비우기
    public void clearItem(){
        if(!selectedItems.isEmpty()){
            selectedItems.clear();
        }
    }

}
