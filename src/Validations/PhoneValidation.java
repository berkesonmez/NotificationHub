public class PhoneValidation {
    private int phoneNumber;

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static String startsWithZero(String phoneNumber){
        String result = phoneNumber;
        if(phoneNumber.startsWith("0")){
            result = phoneNumber.substring(1);
        }
        return result;
    }





}
