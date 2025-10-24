package challengeKiosk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    //속성
    private Map<MenuItem,Integer> selectedItems = new HashMap<>();



    //생성자


    //기능
    //게터
    //선택한 물품 반환
    public HashMap<MenuItem,Integer> getSelectedItems() {
        return new HashMap<>(this.selectedItems);
    }

    //세터

    // 상품 갯수하나 추가
    public void add(MenuItem menuItem){
        if (!selectedItems.containsKey(menuItem)) {
            selectedItems.put(menuItem,1);
        } else {
            selectedItems.put(menuItem,selectedItems.get(menuItem)+1);
        }
    }

    // 상품 i개 추가
    public void add(MenuItem menuItem,int i){
        if (!selectedItems.containsKey(menuItem)) {
            selectedItems.put(menuItem,i);
        } else {
            selectedItems.put(menuItem, selectedItems.get(menuItem)+i);
        }
    }

    //하나의 물품 삭제
    public void removeItem(MenuItem menuItem) {
        if (selectedItems.containsKey(menuItem)) {
            if (selectedItems.get(menuItem) < 2) {
                selectedItems.remove(menuItem);
            } else {
                selectedItems.put(menuItem,selectedItems.get(menuItem)-1);
            }
        }
    }

    //장바구니 비우기
    public void clearItem(){
            selectedItems.clear();
    }

}
