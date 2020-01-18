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

        while (true) {
            int tip = 0;
            goods.display();
            while (true) {
                System.out.println("您有如下操作：");
                System.out.println("1.添加商品到购物车  2.查看购物车  （按下除了1，2数字为退出购物）");
                System.out.print("请选择您的操作：");
                tip = in.nextInt();
                if (tip == 1) {
                    while (true) {
                        int num = 0;
                        System.out.print("请选择添加的商品序号(0则退出添加)：");
                        num = in.nextInt() - 1;
                        if (num == -1)
                            break;
                        if (!goods.getGoodsName(num).equals("")) {
                            System.out.print(goods.getGoodsName(num));
                            cart.Add(goods.getGoodsName(num), goods.getGoodsPrize(num));
                            System.out.print("添加完毕！");
                            cart.printnum();
                        } else
                            System.out.println("没有对应商品请重新添加");
                    }

                }
                if (tip != 1)
                    break;
            }
            if (tip == 2)
            {
                if (cart.hascontent())
                {
                    int tip1 = 0;
                    cart.displaycart();
                    System.out.println();
                    System.out.println("您有如下操作：");
                    System.out.println("1.结算购物车  2.删除购物车内容  （按下除了1，2数字为退出购物车）");
                    tip1 = in.nextInt();
                    if (tip1 == 1)
                        cart.displaysettle();
                    if (tip1 == 2)
                        cart.Del();
                }
                else
                {
                    System.out.println("购物车为空！请键入任意键后回车退出购物车");
                    in.next();
                    tip = 2;
                    break;
                }
            }
            if (tip != 2)
                break;

        }
    }
}