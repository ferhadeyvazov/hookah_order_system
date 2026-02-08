package hos.hookahordersystem.enums;

public enum OrderStatus {
    ALINDI("Sifariş Alındı"),
    HAZIRLANIR("Sifariş Hazırlanır"),
    GONDERILDI("Masaya Göndərildi"),
    VERILDI("Masaya Verildi");

    private final String orderStatus;

    OrderStatus(String a){
        this.orderStatus = a;
    };
    public String getOrderStatus(){
        return orderStatus;
    }

}
