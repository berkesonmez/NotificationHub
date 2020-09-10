import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Email{
    // 1000 adet olmalı
    private int quota;
    private int emailCount;
    private ArrayList<Bill> totalDebts;
    private double debt;
    private LocalDateTime startingDate;

    public void setStartingDate(LocalDateTime startingDate) {
        this.startingDate = startingDate;
    }

    public ArrayList<Bill> getTotalDebts(){
        return totalDebts;
    }



    public String getStartingDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        return dtf.format(startingDate);
    }


    public Email(LocalDateTime startingDate, Package newPackage) {
        this.totalDebts = new ArrayList<Bill>();
        this.totalDebts.add(new Bill(startingDate, newPackage.getPrice()));
        this.startingDate = startingDate;
        this.debt = 0;
    }



    public void sendEmailToCustomers(String message, ArrayList<Customer> customers, Package selectedPackage) {
        customers.forEach((i) -> selectedPackage.sendMessage(message, i.getEmail()));
    }
    public void sendEmail(Package selectedPackage, String message, String customerPhoneNumber) {
        if(this.isBlocked()) {
            System.out.println("Cannot send email you're blocked");
        }else {
            this.totalDebts.add(new Bill(LocalDateTime.now(), selectedPackage.getPrice()));
            selectedPackage.sendMessage(customerPhoneNumber, message);
        }


    }

    public void payDebt(){
        this.setDebt(0);
        System.out.println("Paid debt");
    }

    public Boolean isBlocked() {
        double totalDebt = 0;
        for (Bill i : totalDebts) {
            totalDebt += i.getPrice();
        }
        int months = LocalDateTime.now().getMonthValue() - this.startingDate.getMonthValue();
        System.out.println(months);
        return totalDebt > 0 && months >= 2;
    }

    public void addPackage(Package newPackage) {
        this.totalDebts.add((Bill) newPackage);
    }



    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public int getEmailCount() {
        return emailCount;
    }

    public void setEmailCount(int emailCount) {
        this.emailCount = emailCount;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }
}
