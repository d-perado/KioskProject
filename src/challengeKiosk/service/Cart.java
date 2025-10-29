package challengeKiosk.service;


import challengeKiosk.domain.FoodItem;

import java.util.*;
import java.util.stream.Collectors;

public class Cart {
    //속성
    private final Map<FoodItem,Integer> cartItem = new LinkedHashMap<>();

    //기능
    public Map<FoodItem, Integer> getSelectedItems() {
        /* 선택한 물품 반환 */
        return this.cartItem;
    }

    public List<FoodItem> getItemsToList() {
        return cartItem.entrySet().stream()
                .map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public void add(FoodItem menuItem) {
        /* 상품 갯수하나 추가 */
        if (!this.cartItem.containsKey(menuItem)) {
            this.cartItem.put(menuItem, 1);
        } else {
            this.cartItem.put(menuItem, this.cartItem.get(menuItem) + 1);
        }
    }

    public void add(FoodItem menuItem, int i) {
        /* 상품 i개 추가 */
        if (!this.cartItem.containsKey(menuItem)) {
            this.cartItem.put(menuItem, i);
        } else {
            this.cartItem.put(menuItem, this.cartItem.get(menuItem) + i);
        }
    }

    public void removeItem(int i) {
        /* 물품 갯수 1개 줄이기 */
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

    public void clearItem(){
        /* 장바구니 비우기 */
            this.cartItem.clear();
    }

}
