package christmas;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    HashMap<String, Integer> menuMap;
    static HashMap<String, Integer> printMenu(HashMap<String, Integer> menuMap) {
        System.out.println("<주문 메뉴>");
        //menuMap = setHash(menu);
        for (HashMap.Entry<String, Integer> entry : menuMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue()+"개");
        }
        System.out.println();
        return menuMap;
    }
    static void printPreview(int day){
        System.out.println("12월 "+day+"일에 우테코 식당에서 받을 이벤트 해택 미리보기!");
        System.out.println();
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
        if(christmasDiscount+weekendDiscount+weekdayDiscount+specialDiscount == 0)
            System.out.println("없음");
    }
    static void printTotalDiscount(int totalDiscount){
        System.out.println();
        System.out.println("<총혜택 금액>");
        String str = String.format("%,d",totalDiscount);
        if(totalDiscount !=0)
            System.out.println("-"+str+"원");
        if(totalDiscount ==0)
            System.out.println("0원");
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
    static void printBadge(int totalDiscount){
        String badge="없음";
        if(totalDiscount >= 5000){
            badge = "별";
        }
        if(totalDiscount >= 10000){
            badge = "트리";
        }
        if(totalDiscount >= 20000){
            badge = "산타";
        }
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge);
    }
}
