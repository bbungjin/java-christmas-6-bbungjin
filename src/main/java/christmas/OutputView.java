package christmas;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    public HashMap<String, Integer> printMenu(List<String> menu) {
        System.out.println("<주문 메뉴>");
        HashMap<String, Integer> menuMap = setHash(menu);
        for (HashMap.Entry<String, Integer> entry : menuMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue()+"개");
        }
        System.out.println();
        return menuMap;
    }
    public HashMap<String, Integer> setHash(List<String> menu){
        HashMap<String, Integer> menuMap = new HashMap<>();
        for (String item : menu) {
            String[] parts = item.split("-");
            String menuIdx = parts[0];
            int count = Integer.parseInt(parts[1]);
            menuMap.put(menuIdx,count);
        }
        return menuMap;
    }
    static void printTotal(int total){
        System.out.println("<할인 전 총주문 금액>");
        String str = String.format("%,d",total);
        System.out.println(str);
        System.out.println();
    }
    static void printPresent(boolean present){
        System.out.println("<증정 메뉴>");
        if(present){
            System.out.println("샴페인 1개");
        }
        if(!present){
            System.out.println("없음");
        }
        System.out.println();
    }
    static void printDiscount(int christmasDiscount, int weekendDiscount, int weekdayDiscount,int specialDiscount, boolean present){
        System.out.println("<혜택 내역>");
        String str;
        if(christmasDiscount != 0 ){
            str = String.format("%,d",christmasDiscount);
            System.out.println("크리스마드 디데이 할인: -"+str+"원");
        } if(weekdayDiscount != 0 ){
            str = String.format("%,d",weekdayDiscount);
            System.out.println("평일 할인: -"+str+"원");
        } if(specialDiscount != 0 ){
            str = String.format("%,d",specialDiscount);
            System.out.println("특별 할인: -"+str+"원");
        } if(present)
            System.out.println("증정 이벤트: -25,000원");
    }
    static void printTotalDiscount(int totalDiscount){
        System.out.println();
        System.out.println("<총혜택 금액>");
        String str = String.format("%,d",totalDiscount);
        System.out.println("-"+str+"원");
        System.out.println();
    }
    static void printTotalCost(int totalDiscount, int total, boolean present){
        System.out.println("<할인 후 예상 결제 금액>");
        if(present){
            total+=25000;
        }
        String str = String.format("%,d",total-totalDiscount);
        System.out.println(str+"원");
        System.out.println();
    }
}
