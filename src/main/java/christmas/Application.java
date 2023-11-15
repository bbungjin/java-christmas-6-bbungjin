package christmas;

import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView input = new InputView();
        Discount discount = new Discount();
        OutputView output = new OutputView();
        input.readDate();
        while(true) {
            List<String> a = input.readMenu();
            HashMap<String,Integer> idx = output.setHash(a);
            boolean test = discount.TotalAmount(idx, input.input, input.inputDay);
            if(test){
                if(discount.onlyBeverage())
                    System.err.println("[ERROR] 음료만 주문할 수 없습니다.");
                if(!discount.onlyBeverage())
                    break;
            }
        }
        discount.calculate();
    }
}
