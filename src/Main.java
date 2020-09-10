import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime now = LocalDateTime.now().minusMonths(3);
        FlexPackage smsFlex =  new FlexPackage(2000, 30, 0.1);
        FixedPackage smsFixedPackage =  new FixedPackage(1000, 20);

        FlexPackage emailFlex =  new FlexPackage(2000, 7.5, 0.03);
        FixedPackage emailFixedPackage =  new FixedPackage(1000, 10);
//        Sms sms = new Sms(now, newFlexPackage);
        Sms sms = new Sms(now, smsFixedPackage);
        sms.setStartingDate(now);


        Company trendyol = new Company();


        Customer customer1 = new Customer();
        customer1.setName("Melissa");
        customer1.setSurname("Little");
        customer1.setEmail("melissa.little@example.com");
        customer1.setPhone("05455533001");

        Customer customer2 = new Customer();
        customer2.setName("Duane");
        customer2.setSurname("Clark");
        customer2.setEmail("duane.clark@example.com");
        customer2.setPhone("05455533002");

        trendyol.addToCustomerList(customer1);
        trendyol.addToCustomerList(customer2);
        trendyol.getCustomerList().forEach((i) -> System.out.println(i.getEmail() + " " + i.getPhone()));

        sms.sendSmsToCustomers("Hello", trendyol.getCustomerList(), smsFixedPackage);

        Email email = new Email(now, emailFixedPackage);
//        Email email = new Email(now, newFixedPackage);
        email.sendEmailToCustomers("Hello", trendyol.getCustomerList(), emailFixedPackage);
        for (int i = 0; i < 1100; i++){
            sms.sendSms(smsFixedPackage, "Hello World", customer1.getPhone());
            System.out.printf("Debt %f, Quota: %d, Sms Count: %d\n",smsFixedPackage.getDebt(), smsFixedPackage.getLimit(), smsFixedPackage.getCount());
        }
        for (int i = 0; i < 3500; i++){
            email.sendEmail(emailFixedPackage, "Hello World", customer1.getEmail());
            System.out.printf("Debt %f, Quota: %d, Sms Count: %d\n",emailFixedPackage.getDebt(), emailFixedPackage.getLimit(), emailFixedPackage.getCount());
        }
        System.out.println(emailFixedPackage.getDebt());




    }
}
