import java.time.LocalDateTime;

public class Bill implements Invoice {
    private LocalDateTime addedDate;
    private double price;

    public Bill(LocalDateTime addedDate, double price) {
        this.addedDate = addedDate;
        this.price = price;
    }

    public LocalDateTime getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDateTime addedDate) {
        this.addedDate = addedDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
