import java.util.HashMap;
import java.util.Scanner;

/**
 * @date 2020/1/17-9:54
 */
public class cart {
    //基本属性
    private HashMap<String,Integer> goodsdate = new HashMap<String, Integer>();
    private HashMap<String,Integer> cartgoods = new HashMap<String, Integer>();
    private int sum = 0;
    private int balance = 0;
    private int cnt = 0;
    Scanner in = new Scanner(System.in);

    //折扣部分
    static private final int limit = 200;
    static private final int decrease = 20;
    static private final double sales = 0.7;
    static private final int salesLimit = 100;
    static private final double saleInLimit = 0.6;


    //添加商品
    public void Add(String name,int prize)
    {
        if(cartgoods.containsKey(name))
        {
            int num = cartgoods.get(name);
            num++;
            cartgoods.put(name,num);
        }
        if(!goodsdate.containsKey(name))
        {
            goodsdate.put(name,prize);
        }
        cnt++;
        sum += prize;
    }

    //删除商品或清空
    public void Del(String name, int tip)
    {
        if (tip == 1) //删除商品
        {
            sum -= goodsdate.get(name)*cartgoods.get(name);
            cartgoods.remove(name);
            goodsdate.remove(name);
        }
        if (tip == 2) //减少商品数量
        {
            int num = cartgoods.get(name);
            num--;
            cartgoods.put(name,num);
            sum -= goodsdate.get(num);
        }
    }

    //找零
    public int Change(int money)
    {
        balance += money;
        return  balance - sum;
    }

    //TODO make a function decrease the output
    public  boolean Sale(int tip) {
        boolean flag = true;
        switch(tip)
        {
            case 1: sum *= sales;
                    break;
            case 2: if(sum >= limit)
                        sum -= decrease;
                    else
                         flag = false;
                    break;
            case 3: if(sum >= salesLimit)
                        sum -= (sum-salesLimit)*saleInLimit;
                    else
                        flag = false;
        }
        return flag;
    }

    //展示购物车
    public void displaycart()
    {
        System.out.printf("Shopping Cart:\n\n");
        System.out.println("name           prize      num");
        for(String name : goodsdate.keySet())
        {
            int prize = goodsdate.get(name);
            int num = cartgoods.get(name);
            System.out.printf("%-31s%05d      %2d",name,prize,num);
        }
    }

    public int getSum()
    {
        return sum;
    }
    //展示结账过程
    public  void displaysettle()
    {
        System.out.println("您有4个折扣选择");
        System.out.printf("0. 打%f折  1. 满%d减%d 2.超过%d部分打%f折 其他选项为不打折\n",
                                            sales,limit,decrease,salesLimit,saleInLimit);
        System.out.println("请输入你的选择：");

        //折扣输入
        while(!Sale(in.nextInt()))
            System.out.println("您不满足该折扣，请重新选择");
        System.out.println("优惠折扣后您的总额为："+getSum()+"元");

        //收钱
        int money = in.nextInt();
        int change = Change(money);
        while( change < 0)
        {
            System.out.printf("您给的钱不够，您还需要给至少%d元，请再次输入你要交的金额：",-change);
            money = in.nextInt();
            change = Change(money);
        }
        System.out.println("购物车清空完毕，请继续购物");
    }

    //todo make del goods function
}
