import javax.sound.midi.Soundbank;
import javax.xml.catalog.Catalog;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @date 2020/1/17-9:54
 */
public class Cart {

    private HashMap<String, Double> goodsdate = new HashMap<String, Double>();//商品和价格
    private HashMap<String, Integer> cartgoods = new HashMap<String, Integer>();//商品和个数
    private ArrayList<Sale> salesList = new ArrayList<Sale>();//折扣


    private double sum = 0;     //总额
    private double balance = 0; //金额
    Scanner in = new Scanner(System.in);

    //设置折扣和删除操作
    public Cart() {
        salesList.add(new SaleOfdiscount("打8折！", 0.8));
        salesList.add(new SaleOLimitDiscount("超100的打7折", 100, 0.7));
        salesList.add(new SalesOfLimit("超100减20", 100, 20));
    }


    //添加商品到购物车
    public void Add(String name, double prize) {
        if (cartgoods.containsKey(name)) {
            int num = cartgoods.get(name);
            num++;
            cartgoods.put(name, num);
        }
        if (!goodsdate.containsKey(name)) {
            goodsdate.put(name, prize);
            cartgoods.put(name, 1);
        }
        sum += prize;
    }


    //找零
    public double Change(double money) {
        balance += money;
        return balance - sum;
    }


    //展示购物车
    public void displaycart() {
        System.out.printf("您的购物车:\n");
        System.out.println("商品名称                    价格           数量");
        for (String name : goodsdate.keySet()) {
            double prize = goodsdate.get(name);
            int num = cartgoods.get(name);
            System.out.printf("%-25s\t%.2f         %d\n", name, prize, num);
        }
        System.out.printf("                                        总额 ： %.2f",sum);
    }

    //展示结账过程
    public void displaysettle() {
        int cnt = 1;
        System.out.println("您有如下折扣选择");
        for (int i = 0; i < salesList.size(); i++) {
            if (salesList.get(i).Satisfied(sum)) {
                System.out.print(cnt + ":");
                salesList.get(i).PrintSalescontent();
                System.out.printf(": 折算后总额为：%.2f",salesList.get(i).finalsum(sum));
                System.out.println();
            }
            cnt++;

        }

        System.out.println("请输入你的选择：");
        int select = in.nextInt();

        //折扣输入
        while (select <= 0 || select >= cnt) {
            System.out.println("没有该折扣选择，请重新输入");
            select = in.nextInt();
        }

        sum = salesList.get(select - 1).finalsum(sum);

        System.out.println("请出示您的金额：");
        //收钱
        double money = in.nextDouble();
        double change = Change(money);
        while (change < 0) {
            System.out.printf("您给的钱不够，您还需要给至少%.2f元，请再次输入您要交的金额：", -change);
            money = in.nextDouble();
            change = Change(money);
        }
        System.out.printf("收您： %.1f元\n",balance);
        System.out.printf("找您：%.1f元\n",change);
        System.out.println("购物车清空完毕，请键入任意键回车回到主页面");
        sum = 0;
        balance = 0;
        cartgoods.clear();
        goodsdate.clear();
        in.next();
    }

    //输出购物车内的商品数目
    public void printnum() {
        int cnt = 0;
        for (String s : cartgoods.keySet()) {
            cnt += cartgoods.get(s);
        }
        System.out.printf("\n        购物车内有%d件商品\n",cnt);
    }

    //判断购物车是否为空
    public boolean hascontent()
    {
        return (cartgoods.size()!=0);
    }

    //删除操作
    public void Del(){
        Delete delete = new Delete(goodsdate,cartgoods);
        sum = delete.DelCmd(sum);
    }
}


