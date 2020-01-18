import com.sun.source.doctree.SummaryTree;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @date 2020/1/18-20:59
 */
public class Delete {
    private ArrayList<String> deleteway = new ArrayList<String>();
    private HashMap<String,Double> goodsdate = new HashMap<String, Double>();//商品和价格
    private HashMap<String,Integer> cartgoods = new HashMap<String, Integer>();//商品和个数

    public Delete(HashMap<String, Double> goodsdate, HashMap<String, Integer> cartgoods) {
        this.goodsdate = goodsdate;
        this.cartgoods = cartgoods;
        setDeleteway();
    }


    public void setDeleteway(){
        deleteway.add("删除所有商品");
        deleteway.add("删除一定数量的商品");
    }

    public double DeleteAll(double sum){
        goodsdate.clear();
        cartgoods.clear();
        return 0;
    }

    public double DeleteInNumber(int num,double sum,String name){
        int oldnum = cartgoods.get(name);
        double prize = goodsdate.get(name);
        boolean tip = true;
        if(num < oldnum)
        {
            cartgoods.put(name,oldnum - num);
        }
        else if(num == oldnum)
        {
            cartgoods.remove(name);
            goodsdate.remove(name);
        }

        sum -= prize*num;
        return sum;
    }

    public double DelCmd(double sum)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("有以下删除操作：");
        for (int i = 0; i < deleteway.size(); i++) {
            System.out.print((i)+"."+deleteway.get(i)+" ");
        }
        System.out.println("请输入以上编号：");
        int tip = -1;
        tip = in.nextInt();
        while (deleteway.size()<tip || tip < 0){
            System.out.println("编号输入错误请重新输入");
            tip = in.nextInt();
        }
        if(tip == 0)
        {
            sum = DeleteAll(sum);
            System.out.println("删除完毕！");
        }
        if (tip == 1)
        {
            String name = "";
            int num = 0;

            System.out.println("请输入要删除商品的名字：");
            in.nextLine();
            name = in.nextLine();

            while (!goodsdate.containsKey(name))
            {
                System.out.println("购物车内没有该商品，请重新输入");
                name = in.nextLine();
            }

            System.out.println("请输入要删除的个数：");
            num = in.nextInt();

            while (goodsdate.get(name) < num)
            {
                System.out.println("超出数量，请重新输入");
                num = in.nextInt();
            }

            sum = DeleteInNumber(num,sum,name);
            System.out.println("删除完毕");
        }
        return sum;
    }
}
