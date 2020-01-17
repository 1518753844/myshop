import java.util.ArrayList;
import java.util.HashMap;

/**
 * @date 2020/1/17-9:27
 */
public class goods {
    private HashMap<String,Integer> goodsDate = new HashMap<String, Integer>();
    private ArrayList<String> goods = new ArrayList<String>();

    public goods() {
        String[] goodsname = {"Crazy Java","algorithms 4th","Core Java Volume I","Basketball","Football"} ;
        int[] prize = {100,80,60,40,40};

        for (int i = 0; i < prize.length; i++) {
            goodsDate.put(goodsname[i],prize[i]);
            goods.add(goodsname[i]);
        }
    }

    public void display(){
        System.out.println("number   goods name                     prize");
        for (int i = 0; i < goods.size(); i++) {
            int prize = goodsDate.get(goods.get(i));
            String name = goods.get(i);
            System.out.printf("%05d   %-31s%5d元",i,name,prize);
        }
    }
}
