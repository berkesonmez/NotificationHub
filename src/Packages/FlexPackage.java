public class FlexPackage implements Package {

    private double price;
    private int limit;
    private int count;
    private double debt;
    private double increment;



    public FlexPackage(int limit, double price, double increment) {
        this.setDebt(price);
        this.setLimit(limit);
        this.setPrice(price);
        this.increment = increment;
        this.count = 0;
    }

    public int getCount() {
        return count;
    }

    public void sendMessage(String customerInfo, String message) {
        this.increaseCount();
        System.out.printf("%s sent to %s \n", message, customerInfo);
    }

    public void increaseCount() {
        if(this.count + 1 >= this.limit) {
            this.increaseDebt();
            this.count = 0;
        } else {
            ++this.count;
        }
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public void increaseDebt() {
        this.debt += this.increment;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
