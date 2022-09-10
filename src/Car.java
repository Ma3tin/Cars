public class Car {
    private String id;
    private String carBrand;
    private int totalKms;
    private int price;

    public Car(String id, String carBrand, int totalKms, int price) {
        this.id = id;
        this.carBrand = carBrand;
        this.totalKms = totalKms;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public int getTotalKms() {
        return totalKms;
    }

    public int getPrice() {
        return price;
    }
}
