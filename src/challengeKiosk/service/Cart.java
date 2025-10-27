package challengeKiosk.service;

import challengeKiosk.domain.MenuItem;

import java.util.*;
import java.util.stream.Collectors;

public class Cart {
    //속성
    private Map<MenuItem,Integer> selectedItems = new LinkedHashMap<>();

    //생성자


    //기능
    //선택한 물품 반환
    public HashMap<MenuItem,Integer> getSelectedItems() {
        return new LinkedHashMap<>(this.selectedItems);
    }

    public List<MenuItem> getItemsToList(){
        return selectedItems.entrySet().stream().map(Map.Entry::getKey).collect(Collectors.toList());
    }

    // 상품 갯수하나 추가
    public void add(MenuItem menuItem) {
        if (!this.selectedItems.containsKey(menuItem)) {
            this.selectedItems.put(menuItem, 1);
        } else {
            this.selectedItems.put(menuItem, this.selectedItems.get(menuItem) + 1);
        }
    }

    // 상품 i개 추가
    public void add(MenuItem menuItem, int i) {
        if (!this.selectedItems.containsKey(menuItem)) {
            this.selectedItems.put(menuItem, i);
        } else {
            this.selectedItems.put(menuItem, this.selectedItems.get(menuItem) + i);
        }
    }

    //물품 갯수 1개 줄이기
    public void removeItem(int i) {
        ArrayList<MenuItem> list = new ArrayList<>(getItemsToList());
        MenuItem target = list.get(i);

        selectedItems.entrySet().stream()
                .filter(entry -> entry.getKey().equals(target))
                .findFirst()
                .ifPresent(entry -> {
                    int newCount = entry.getValue() - 1;
                    if (newCount == 0) {
                        selectedItems.remove(entry.getKey());
                    } else {
                        selectedItems.replace(entry.getKey(), newCount);
                    }
                });
    }
    //장바구니 총액 계산
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (MenuItem key : this.selectedItems.keySet()){
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
