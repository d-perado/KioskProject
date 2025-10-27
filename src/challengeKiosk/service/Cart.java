package challengeKiosk.service;


import challengeKiosk.domain.Item;

import java.util.*;
import java.util.stream.Collectors;

public class Cart <T extends Item> {
    //속성
    private Map<T,Integer> selectedItems = new LinkedHashMap<>();

    //생성자


    //기능
    //선택한 물품 반환
    public Map<T, Integer> getSelectedItems() {
        return this.selectedItems; //깊은복사 얕은복사 차이 생각하면서 봐보기.
    }

    public List<T> getItemsToList() {
        return selectedItems.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());
    }

    // 상품 갯수하나 추가
    public void add(T menuItem) {
        if (!this.selectedItems.containsKey(menuItem)) {
            this.selectedItems.put(menuItem, 1);
        } else {
            this.selectedItems.put(menuItem, this.selectedItems.get(menuItem) + 1);
        }
    }

    // 상품 i개 추가
    public void add(T menuItem, int i) {
        if (!this.selectedItems.containsKey(menuItem)) {
            this.selectedItems.put(menuItem, i);
        } else {
            this.selectedItems.put(menuItem, this.selectedItems.get(menuItem) + i);
        }
    }

    //물품 갯수 1개 줄이기
    public void removeItem(int i) {
        ArrayList<Item> list = new ArrayList<>(getItemsToList());
        Item target = list.get(i);

        selectedItems.entrySet().stream()
                .filter(entry -> entry.getKey().equals(target))
                .findFirst()
                .ifPresent(entry -> {
                    int amount = entry.getValue() - 1;
                    if (amount == 0) {
                        selectedItems.remove(entry.getKey());
                    } else {
                        selectedItems.replace(entry.getKey(), amount - 1);
                    }
                });
    }
    //장바구니 총액 계산
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Item key : this.selectedItems.keySet()){
            totalPrice += this.selectedItems.get(key)*key.getPrice();
        }
        return totalPrice;
    }

    public double getTotalPriceAfterDiscount(double discount) {
        return getTotalPrice()*discount;
    }

    //장바구니 비우기
    public void clearItem(){
            this.selectedItems.clear();
    }

}
