import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Sms{
    // 1000 adet olmalı
    private int quota;
    private int smsCount;
    private ArrayList<Bill> totalDebts;
    private double debt;
    private LocalDateTime startingDate;

    public void setStartingDate(LocalDateTime startingDate) {
        this.startingDate = startingDate;
    }

    public ArrayList<Bill> getTotalDebts(){
        return totalDebts;
    }

//    public void setPackages(String[] packages) {
//        this.packages = packages;
//    }


    public String getStartingDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        return dtf.format(startingDate);
    }


    public Sms(LocalDateTime startingDate, Package newPackage) {
        this.totalDebts = new ArrayList<Bill>();
        this.totalDebts.add(new Bill(startingDate, newPackage.getPrice()));
        this.startingDate = startingDate;
        this.debt = 0;
    }

//    @Override
//    public ArrayList<Bill> getBills () {
//        return totalDebts;
//    }

    public void sendSmsToCustomers(String message, ArrayList<Customer> customers, Package selectedPackage) {
//        System.out.println(customers.get(0));
        customers.forEach((i) -> selectedPackage.sendMessage(message, i.getPhone()));
    }
    public void sendSms(Package selectedPackage, String message, String customerPhoneNumber) {
        if(this.isBlocked()) {
            System.out.println("Cannot send sms you're blocked");
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
//    public void setPackageType(Package newPackage) {
//        this.packageType = packageType;
//        this.smsCount = 0;
//        switch (packageType) {
//            case FLEX:
//                this.quota = 2000;
//                this.debt += 30;
//                this.totalDebts.add(new Bill(LocalDateTime.now(), 30));
//                break;
//            case FIXED:
//                this.quota = 1000;
//                this.debt += 20;
//                this.totalDebts.add(new Bill(LocalDateTime.now(), 20));
//                break;
//        }
//
//    }

//    public void topUp() {
//
//    }


    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public int getSmsCount() {
        return smsCount;
    }

    public void setSmsCount(int smsCount) {
        this.smsCount = smsCount;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }
}
