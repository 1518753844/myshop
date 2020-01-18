import jdk.swing.interop.SwingInterOpUtils;

import javax.sound.midi.Soundbank;
import java.net.SocketTimeoutException;
import java.util.Scanner;

/**
 * @date 2020/1/17-11:58
 */
public class Operate {
    //两个对象的交互
    public static void main(String[] args) {
        Cart cart = new Cart();
        Goods goods = new Goods();
        Scanner in = new Scanner(System.in);

        while (true)
        {
            int tip = 0;
            goods.display();
            while (true)
            {
                System.out.println("您有如下操作：");
                System.out.println("1.添加商品到购物车  2.查看购物车  （按下除了1，2数字为退出购物）");
                System.out.print("请选择您的操作：");
                tip = in.nextInt();
                if(tip == 1)
                {
                    while (true)
                    {
                        int num = 0;
                        System.out.print("请选择添加的商品序号(0则退出添加)：");
                        num = in.nextInt()-1;
                        if(num == -1)
                            break;
                        if (!goods.getGoodsName(num).equals(""))
                        {
                            System.out.print(goods.getGoodsName(num));
                            cart.Add(goods.getGoodsName(num),goods.getGoodsPrize(num));
                            System.out.print("添加完毕！");
                            cart.printnum();
                        }
                        else
                            System.out.println("没有对应商品请重新添加");
                    }

                }
                if(tip != 1)
                    break;
            }
            if(tip == 2)
            {
                int tip1 = 0;
                cart.displaycart();
                cart.setDeleteList();
                System.out.println();
                System.out.println("您有如下操作：");
                System.out.println("1.结算购物车  2.删除购物车内容  其他.退出");
                tip1 = in.nextInt();
                if(tip1 == 1)
                    cart.displaysettle();
                if(tip1 == 2)
                {
                    cart.printnum();
                    int tip2 = 0;
                    cart.DeleteListdisplay();
                    System.out.println("请选择指令：");
                    tip2 = in.nextInt()-1;
                    int num = 0;
                    String name = "";
                    System.out.println("请输入商品名字（删除全部请任意填写）：");
                    in.nextLine();
                    name =  in.nextLine();
                    System.out.println("请输入删除个数（删除全部请任意填写）：");
                    num = in.nextInt();
                    if (cart.Del(name,num,tip2))
                    {
                        System.out.println("操作成功！");
                    }
                    else
                        System.out.println("操作失败");

                }
            }
            if(tip!=2)
                break;
        }

    }
}
