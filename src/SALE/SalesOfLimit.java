/**
 * @date 2020/1/18-9:59
 */
public class SalesOfLimit extends Sale{

    private int decrease = 0;
    private int limit = 0;
    public SalesOfLimit(String salescontent,int limit,int decrease) {
        super(salescontent);
        this.decrease = decrease;
        this.limit = limit;
    }


    //判断是否满足资格
    @Override
    public boolean Satisfied(double sum) {
        boolean satisfied = true;
        if(sum < limit)
            satisfied = false;
        return satisfied;
    }

    @Override
    public double finalsum(double sum)
    {
        return sum-decrease;
    }
}
