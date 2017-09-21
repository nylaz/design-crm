import javax.swing.*;

/**
 * Created by Emil on 2017-09-15.
 */
public class ResearchFacade {
    CustomerFinanceResearch customerFinanceResearch = new CustomerFinanceResearch();
    CustomerSocialMediaResearch customerSocialMediaResearch = new CustomerSocialMediaResearch();
    CustomerWeatherResearch customerWeatherResearch = new CustomerWeatherResearch();
    private static final ResearchFacade instance = new ResearchFacade();

    private ResearchFacade(){
    }

    public static ResearchFacade getInstance(){
            return instance;
    }

    public void researchCustomer(Customer customer){
        customerFinanceResearch.financialRating(customer.getId());
        customerSocialMediaResearch.currentSocialMediaSummary(customer.getId());
        customerWeatherResearch.currentWeatherSummary(customer.getLatitude(), customer.getLongitude());
    }

}
