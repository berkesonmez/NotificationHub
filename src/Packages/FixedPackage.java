public class FixedPackage implements Package {
    private double price;
    private int limit;
    private int count;
    private double debt;

    public FixedPackage(int limit, double price) {
        this.setDebt(price);
        this.setLimit(limit);
        this.setPrice(price);
        this.count = 0;
    }

    public void sendMessage(String customerInfo , String message) {
        this.increaseCount();
        System.out.printf("%s sent to %s \n", message, customerInfo);
    }

    public int getCount() {
        return count;
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
        this.debt += this.price;
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
