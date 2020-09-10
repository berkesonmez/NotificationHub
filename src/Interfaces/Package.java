public interface Package {
    void setDebt(double debt);
    void increaseCount();
    void increaseDebt();
    double getDebt();
    double getPrice();
    void sendMessage(String message, String customerPhoneNumber);
}
