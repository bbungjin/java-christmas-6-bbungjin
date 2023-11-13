package christmas;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        String[] day = {"목","금","토","일","월","화","수"};
        String inputDay = day[Integer.valueOf(input)% 7];
        Discount discount = new Discount(input,inputDay);
    }
}

