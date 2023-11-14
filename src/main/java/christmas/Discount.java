package christmas;

import org.mockito.internal.matchers.Null;

import java.util.HashMap;

public class Discount {
    int christmasDiscount;
    int total=0;
    HashMap<String, Integer> cost = new HashMap<>();
    public Discount(String input, String inputDay){
        int day = Integer.valueOf(input);
        if(day<26){
            //1일 1000원 2일 1100원 3일 1200원
            christmasDiscount=(day-1)*100+1000;
        }
    }
    public void TotalAmount(HashMap<String, Integer> menuMap){
        CostBoard();
        for(String item : menuMap.keySet()){
            if(cost.containsKey(item)){
                total += (cost.get(item) * menuMap.get(item));
            }
            // 메뉴에 없는 주문 예외처리
        }
        OutputView.printTotal(total);
        getPresent(total);
    }
    static void getPresent(int total){
        boolean present = false;
        if(total >= 120000){
            present = true;
        }
        OutputView.printPresent(present);
    }
    public void CostBoard(){
        cost.put("양송이수프",6000);
        cost.put("타파스",5500);
        cost.put("시저샐러드",8000);
        cost.put("티본스테이크",55000);
        cost.put("바베큐립",54000);
        cost.put("해산물파스타",35000);
        cost.put("크리스마스파스타",25000);
        cost.put("초코케이크",15000);
        cost.put("아이스크림",5000);
        cost.put("제로콜라",3000);
        cost.put("레드와인",60000);
        cost.put("샴페인",25000);
    }
}
