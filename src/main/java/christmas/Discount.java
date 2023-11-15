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
    int day;
    String inputDay;
    HashMap<String, Integer> cost = new HashMap<>();
    HashMap<String, Integer> menuMap = new HashMap<>();
    public void AllDiscount(){
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
    public boolean TotalAmount(HashMap<String, Integer> menuMap,String input, String inputDay){
        CostBoard();
        this.menuMap = menuMap;
        day = Integer.parseInt(input);
        this.inputDay = inputDay;
        for(String item : menuMap.keySet()){
            if(cost.containsKey(item)){
                total += (cost.get(item) * menuMap.get(item));
            }
            try{
                if(!cost.containsKey(item))
                    throw new IllegalArgumentException();
            } catch (IllegalArgumentException e){
                System.err.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요");
                return false;
            }
        }
        return true;
    }
    public void calculate(){
        OutputView.printTotal(total);
        getPresent(total); // 증정품을 받을 수 있는지 없는지
        if(total>=10000){
            AllDiscount(); // discount 계산
        }
        OutputView.printDiscount(christmasDiscount, weekendDiscount, weekdayDiscount, specialDiscount, present); // <혜택 내역>
        totalDiscount();
        OutputView.printTotalCost(totalDiscount,total,present);
        OutputView.printBadge(totalDiscount);
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
    public boolean onlyBeverage(){
        int beverage=0;
        if(menuMap.containsKey("제로콜라"))
            beverage+=1;
        if(menuMap.containsKey("레드와인"))
            beverage+=1;
        if(menuMap.containsKey("샴페인"))
            beverage+=1;
        return beverage == menuMap.size();
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
