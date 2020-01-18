import java.util.ArrayList;
import java.util.HashMap;

/**
 * @date 2020/1/17-9:27
 */
public class Goods {
    private HashMap<String,Double> goodsDate = new HashMap<String, Double>();
    private ArrayList<String> goods = new ArrayList<String>();

    public Goods() {
        String[] goodsnames = {"Crazy Java","algorithms 4th","Core Java Volume I","Basketball","Football"} ;
        double[] prize = {100.1,80.1,60.5,40.9,40.8};

        for (int i = 0; i < prize.length; i++) {
            goodsDate.put(goodsnames[i],prize[i]);
            goods.add(goodsnames[i]);
        }
    }

    public void display(){
        System.out.println("商品列表如下：");
        System.out.println("编号    商品名称                        价格");
        for (int i = 0; i < goods.size(); i++) {
            double prize = goodsDate.get(goods.get(i));
            String name = goods.get(i);
            System.out.printf("%03d      %-28s%5.2f元\n",i+1,name,prize);
        }
    }


    public String getGoodsName(int i)
    {
        String name = "";
        if(goods.size() > i)
            name = goods.get(i);
        return name;
    }

    public double getGoodsPrize(int i)
    {
        return goodsDate.get(goods.get(i));
    }

    public static void main(String[] args) {
        Goods goods = new Goods();
        goods.display();
    }
}
