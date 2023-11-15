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
            if(discount.onlyBeverage())
                System.err.println("[ERROR] 음료만 주문 시, 주문할 수 없습니다.");
            if(discount.overQuantiy())
                System.err.println("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다");
            if(test && (!discount.onlyBeverage()) && (!discount.overQuantiy()))
                break;
            }
        discount.calculate();
    }
}
