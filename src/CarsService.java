import java.util.ArrayList;

public class CarsService {

    private ArrayList<Car> carsList = new ArrayList<>();

    public void addCar(Car car) {
        carsList.add(car);
    }

    public void removeCar(String id, Car car) {
        int sizeBefore = carsList.size();
        for (int i = carsList.size() - 1; i >= 0; i--) {
            if (carsList.get(i).getId().equals(id)) {
                carsList.remove(car);
            }
        }
        if (sizeBefore == carsList.size())
            throw new CarNotFoundException("This car with this id was not found");
    }

    public ArrayList<Car> getAll() {
        return carsList;
    }

}
