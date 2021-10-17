public class BuddyInfo {

    private static String name;
    private static String address;
    private static String phoneNumber;
    private String bud;

    public static String getName() {
        return name;
    }
    public static String getAddress() { return address;}
    public static String getPhoneNumber() { return phoneNumber; }

    public BuddyInfo(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.bud = "Name: " + name + "  " + "Address: " + address + "   " + "Phone #: " + phoneNumber;
    }
    
    public BuddyInfo() {
        this("Razem", "Ottawa", "500");
    }
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        new BuddyInfo();
        System.out.println("Hello " + BuddyInfo.getName());
        new BuddyInfo("John", "Toronto", "710");
        System.out.println("Hello " + getName());
        System.out.println("Your address: " + getAddress());
        System.out.println("Your phone number: " + getPhoneNumber());
    }

    @Override
    public String toString() {
        return bud;
    }
}
