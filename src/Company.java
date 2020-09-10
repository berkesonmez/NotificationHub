import java.util.ArrayList;

public class Company {

    private ArrayList<Customer> customerList;
    private ArrayList<Package> addedPackages;

    public Company() {
        this.customerList = new ArrayList<>();
    }

    public void addPackages(Package newPackage) {
        addedPackages.add(newPackage);
    }


    public ArrayList<Package> getPackages() {
        return addedPackages;
    }
    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void addToCustomerList(Customer customer) {
        this.customerList.add(customer);
    }




}
