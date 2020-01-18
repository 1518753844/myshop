import java.util.HashMap;

/**
 * @date 2020/1/18-16:01
 */
public class DeleteAll extends Delete{

    public DeleteAll(HashMap<String, Double> goodsdate, HashMap<String, Integer> cartgoods,
                                double sum, String deletecontent) {
        super(goodsdate, cartgoods, sum, deletecontent);
    }


    @Override
    public boolean delCmd(String name,int num)
    {
        cartgoods.clear();
        goodsdate.clear();
        sum = 0;
        return true;
    }
}
