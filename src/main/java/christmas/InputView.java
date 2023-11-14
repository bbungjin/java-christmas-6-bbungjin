package christmas;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InputView {
    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        String[] day = {"목","금","토","일","월","화","수"};
        String inputDay = day[Integer.parseInt(input)% 7];
        Discount discount = new Discount(input,inputDay);
        discount.TotalAmount(readMenu(Integer.parseInt(input)));
        return 1;
    }

    public HashMap<String, Integer> readMenu(int day){
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1");
        String inputMenu = Console.readLine();
        System.out.println("12월 "+day+"일에 우테코 식당에서 받을 이벤트 해택 미리보기!");
        List<String> menu = new ArrayList<>(List.of(inputMenu.split(",")));
        OutputView outputView = new OutputView();
        return outputView.printMenu(menu);
    }
}

