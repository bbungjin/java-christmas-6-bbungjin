package christmas;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    public HashMap<String, Integer> printMenu(List<String> menu) {
        System.out.println("<주문 메뉴>");
        HashMap<String, Integer> menuMap = setHash(menu);
        for (HashMap.Entry<String, Integer> entry : menuMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue()+"개");
        }
        return menuMap;
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
}
