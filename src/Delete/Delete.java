import java.util.HashMap;

/**
 * @date 2020/1/18-15:54
 */
public class Delete {
    protected HashMap<String,Double> goodsdate = new HashMap<String, Double>();//商品和价格
    protected HashMap<String,Integer> cartgoods = new HashMap<String, Integer>();//商品和个数
    protected double sum = 0;
    private String Deletecontent;

    public Delete(HashMap<String, Double> goodsdate, HashMap<String, Integer> cartgoods,double sum,String deletecontent) {
        this.goodsdate = goodsdate;
        this.cartgoods = cartgoods;
        this.sum = sum;
        Deletecontent = deletecontent;
    }

    public boolean delCmd(String name,int num){return true;}

    public double getSum() { return sum; }

    public void PrintDeletescontent() {
        System.out.print(Deletecontent);
    }
}
