import java.util.HashMap;

/**
 * @date 2020/1/18-16:01
 */
public class DeleteInNumber extends Delete{
    public DeleteInNumber(HashMap<String, Double> goodsdate, HashMap<String, Integer> cartgoods,
                                    double sum, String deletecontent) {
        super(goodsdate, cartgoods, sum, deletecontent);
    }

    @Override
    public boolean delCmd(String name,int num)
    {
        boolean tip = true;
        if(goodsdate.containsKey(name))
        {
            if (cartgoods.get(name)>num)
            {
                int oldnum = cartgoods.get(name);
                sum = sum - (oldnum-num)*goodsdate.get(name);
                cartgoods.put(name,oldnum - num);
            }
            else if (cartgoods.get(name) == num)
            {
                sum -= num*goodsdate.get(name);
                cartgoods.remove(name);
                goodsdate.remove(name);
            }
            else
                tip = false;
        }
        else
            tip = false;
        return tip;
    }

}
