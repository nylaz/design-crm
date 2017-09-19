/**
 * Created by Emil on 2017-09-15.
 */
public class ResearchFacade {
    CustomerFinanceResearch customerFinanceResearch = new CustomerFinanceResearch();
    CustomerSocialMediaResearch customerSocialMediaResearch = new CustomerSocialMediaResearch();
    CustomerWeatherResearch customerWeatherResearch = new CustomerWeatherResearch();
    Customer customer;

    public ResearchFacade(Customer customer){
        this.customer = customer;
        ResearchCustomer(customer);
    }

    public void ResearchCustomer(Customer customer){
        customerFinanceResearch.financialRating(customer.getId());
        customerSocialMediaResearch.currentSocialMediaSummary(customer.getId());
        customerWeatherResearch.currentWeatherSummary(customer.getLatitude(), customer.getLongitude());
        //todo:Return some research view?
    }

}
