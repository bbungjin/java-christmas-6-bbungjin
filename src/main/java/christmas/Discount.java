package christmas;

public class Discount {
    int christmasDiscount;
    public Discount(String input, String inputDay){
        int day = Integer.valueOf(input);
        if(day<26){
            //1일 1000원 2일 1100원 3일 1200원
            christmasDiscount=(day-1)*100+1000;
        }
    }

}
