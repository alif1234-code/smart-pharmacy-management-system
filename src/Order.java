public class Order {

    String medicineName;
    String pharmacyName;
    String customerName;
    int quantity;

    public Order(String medicineName,
                 String pharmacyName,
                 String customerName,
                 int quantity) {

        this.medicineName = medicineName;
        this.pharmacyName = pharmacyName;
        this.customerName = customerName;
        this.quantity = quantity;
    }
}