/**
 * Created by Emil on 2017-09-15.
 */
public class CustomerFinanceResearch implements FinancialStatus {
    private int financeRating;
    Customer customer;

    @Override
    public int financialRating(int userId) {
        //Download some finance report..
        return 3;
    }
}
