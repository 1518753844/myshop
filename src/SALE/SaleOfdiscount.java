/**
 * @date 2020/1/18-9:50
 */
public class SaleOfdiscount extends Sale{

    private double discount = 0;
    public SaleOfdiscount(String salescontent,double discount) {
        super(salescontent);
        this.discount = discount;
    }

    @Override
    public double finalsum(double sum)
    {
        return sum*discount;
    }


}
