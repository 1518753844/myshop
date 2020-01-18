import java.net.SocketTimeoutException;
import java.sql.SQLOutput;

/**
 * @date 2020/1/17-16:58
 */
public class Sale {
    private String salescontent = new String();

    public Sale(String salescontent) {
        this.salescontent = salescontent;
    }

    public boolean Satisfied(double sum)
    {
        return true;
    }

    public void PrintSalescontent() {
        System.out.print(salescontent);
    }

    public double finalsum(double sum) { return 0;}
}
