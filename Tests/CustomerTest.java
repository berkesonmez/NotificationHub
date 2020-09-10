import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {



    @Test
    void it_should_return_phoneNumber_without_zero_on_front() {
        Customer test = new Customer();
        test.setPhone("05325320000");
        assert(test.getPhone()).equals("5325320000");
    }
}