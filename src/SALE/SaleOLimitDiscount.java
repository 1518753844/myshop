/**
 * @date 2020/1/18-10:03
 */
public class SaleOLimitDiscount extends Sale{
    private int limit = 0;
    private double sale = 0;

    public SaleOLimitDiscount(String saleContent,int limit, double sale) {
        super(saleContent);
        this.limit = limit;
        this.sale = sale;
    }


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
        return sum-((sum-limit)*sale);
    }
}
