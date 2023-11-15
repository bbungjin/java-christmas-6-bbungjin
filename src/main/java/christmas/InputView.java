package christmas;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InputView {
    String input;
    String inputDay;
    List<String> menu;
    public int readDate() {
        while(true){
            try {
                System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
                input = Console.readLine();
                if(!(Integer.parseInt(input)>=1 && Integer.parseInt(input)<=31)){
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IllegalArgumentException e){
                System.err.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            }
        }
        String[] day = {"목","금","토","일","월","화","수"};
        inputDay = day[Integer.parseInt(input)% 7];
        return 1;
    }

    public List<String> readMenu(){
        String inputMenu;
        while(true){
            try {
                System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
                inputMenu = Console.readLine();
                if(!inputMenu.contains("-"))
                    throw new IllegalArgumentException();
                break;
            }catch (IllegalArgumentException ex){
                System.err.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
        menu = new ArrayList<>(List.of(inputMenu.split(",")));
        return menu; //
    }
}

