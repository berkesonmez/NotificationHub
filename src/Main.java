import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime now = LocalDateTime.now().minusMonths(3);
        FlexPackage newFlexPackage =  new FlexPackage(1000, 0.1);
        FixedPackage newFixedPackage =  new FixedPackage(1000, 10);
//        Sms sms = new Sms(now, newFlexPackage);
        Sms sms = new Sms(now, newFixedPackage);
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

        Email email = new Email(now, newFlexPackage);
//        Email email = new Email(now, newFixedPackage);
        sms.sendSmsToCustomers("Hello", trendyol.getCustomerList(), newFixedPackage);
        email.sendEmailToCustomers("Hello", trendyol.getCustomerList(), newFixedPackage);
        for (int i = 0; i < 3500; i++){
            sms.sendSms(newFixedPackage, "Hello World", customer1.getPhone());
            System.out.printf("Debt %f, Quota: %d, Sms Count: %d\n",newFixedPackage.getDebt(), newFixedPackage.getLimit(), newFixedPackage.getCount());
        }
        for (int i = 0; i < 3500; i++){
            email.sendEmail(newFixedPackage, "Hello World", customer1.getEmail());
            System.out.printf("Debt %f, Quota: %d, Sms Count: %d\n",newFixedPackage.getDebt(), newFixedPackage.getLimit(), newFixedPackage.getCount());
        }
        System.out.println(newFixedPackage.getDebt());




    }
}
