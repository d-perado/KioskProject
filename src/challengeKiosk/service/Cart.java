package challengeKiosk.service;


import challengeKiosk.domain.FoodItem;

import java.util.*;
import java.util.stream.Collectors;

public class Cart {
    //속성
    private final Map<FoodItem,Integer> cartItem = new LinkedHashMap<>();
    //생성자


    //기능
    //선택한 물품 반환
    public Map<FoodItem, Integer> getSelectedItems() {
        return this.cartItem; //#깊은복사 얕은복사 차이 생각하면서 봐보기.
    }

    public List<FoodItem> getItemsToList() {
        return cartItem.entrySet().stream()
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }

    // 상품 갯수하나 추가
    public void add(FoodItem menuItem) {
        if (!this.cartItem.containsKey(menuItem)) {
            this.cartItem.put(menuItem, 1);
        } else {
            this.cartItem.put(menuItem, this.cartItem.get(menuItem) + 1);
        }
    }

    // 상품 i개 추가
    public void add(FoodItem menuItem, int i) {
        if (!this.cartItem.containsKey(menuItem)) {
            this.cartItem.put(menuItem, i);
        } else {
            this.cartItem.put(menuItem, this.cartItem.get(menuItem) + i);
        }
    }

    //물품 갯수 1개 줄이기
    public void removeItem(int i) {
        ArrayList<FoodItem> list = new ArrayList<>(getItemsToList());
        FoodItem target = list.get(i);

        cartItem.entrySet().stream()
                .filter(entry -> entry.getKey().equals(target))
                .findFirst()
                .ifPresent(entry -> {
                    int amount = entry.getValue() - 1;
                    if (amount == 0) {
                        cartItem.remove(entry.getKey());
                    } else {
                        cartItem.replace(entry.getKey(), amount - 1);
                    }
                });
    }


    //장바구니 비우기
    public void clearItem(){
            this.cartItem.clear();
    }

}
