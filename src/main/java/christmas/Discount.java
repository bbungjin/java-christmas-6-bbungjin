package christmas;

import org.mockito.internal.matchers.Null;

import java.util.HashMap;

public class Discount {
    int christmasDiscount=0;
    int weekendDiscount=0;
    int weekdayDiscount=0;
    int specialDiscount=0;
    int total=0;
    boolean present=false;
    int totalDiscount=0;
    HashMap<String, Integer> cost = new HashMap<>();
    HashMap<String, Integer> menuMap = new HashMap<>();
    public void AllDiscount(String input, String inputDay){
        int day = Integer.valueOf(input);
        ChristmasDiscount(day);
        if((inputDay == "금") || (inputDay=="토")){
            WeekendDiscount();
        }
        if((inputDay != "금") && (inputDay != "토")){
            WeekdayDiscount();
        }
        if((inputDay == "일") || (day == 25)){
            SpecialDiscount();
        }
    }
    public void ChristmasDiscount(int day){
        if(day<26){
            //1일 1000원 2일 1100원 3일 1200원
            this.christmasDiscount=(day-1)*100+1000;
        }
    }
    public void WeekendDiscount(){
        if(menuMap.containsKey("티본스테이크")){
            this.weekendDiscount += (2023 * menuMap.get("티본스테이크"));
        }
        if(menuMap.containsKey("바비큐립")){
            this.weekendDiscount += (2023 * menuMap.get("바비큐립"));
        }
        if(menuMap.containsKey("해산물파스타")){
            this.weekendDiscount += (2023 * menuMap.get("해산물파스타"));
        }
        if(menuMap.containsKey("크리스마스파스타")){
            this.weekendDiscount += (2023 * menuMap.get("크리스마스파스타"));
        }
    }
    public void WeekdayDiscount(){
        if(menuMap.containsKey("초코케이크")){
            this.weekdayDiscount += (2023 * menuMap.get("초코케이크"));
        }
        if(menuMap.containsKey("아이스크림")){
            this.weekdayDiscount += (2023 * menuMap.get("아이스크림"));
        }
    }
    public void SpecialDiscount(){
        this.specialDiscount+=1000;
    }
    public void TotalAmount(HashMap<String, Integer> menuMap,String input, String inputDay){
        this.menuMap = menuMap;
        CostBoard();
        for(String item : menuMap.keySet()){
            if(cost.containsKey(item)){
                total += (cost.get(item) * menuMap.get(item));
            }
            // 메뉴에 없는 주문 예외처리
        }
        calculate(input,inputDay);
    }
    public void calculate(String input, String inputDay){
        OutputView.printTotal(total);
        getPresent(total);
        AllDiscount(input,inputDay);
        OutputView.printDiscount(christmasDiscount, weekendDiscount, weekdayDiscount, specialDiscount, present);
        totalDiscount();
        OutputView.printTotalCost(totalDiscount,total,present);
    }
    public void totalDiscount(){
        totalDiscount = christmasDiscount+weekdayDiscount+weekendDiscount+specialDiscount;
        if(present){
            totalDiscount+=25000;
        }
        OutputView.printTotalDiscount(totalDiscount);
    }
    public boolean getPresent(int total){
        present = false;
        if(total >= 120000){
            present = true;
        }
        OutputView.printPresent(present);
        return present;
    }
    public void CostBoard(){
        cost.put("양송이수프",6000);
        cost.put("타파스",5500);
        cost.put("시저샐러드",8000);
        cost.put("티본스테이크",55000);
        cost.put("바비큐립",54000);
        cost.put("해산물파스타",35000);
        cost.put("크리스마스파스타",25000);
        cost.put("초코케이크",15000);
        cost.put("아이스크림",5000);
        cost.put("제로콜라",3000);
        cost.put("레드와인",60000);
        cost.put("샴페인",25000);
    }
}
