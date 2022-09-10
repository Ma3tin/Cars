import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class Playground {
    public static void main(String[] args) throws IOException {
        CarsRepository cr = new CarsRepository();
        ArrayList<Car> carsList = new ArrayList<>();
        carsList = cr.loadCars();
        System.out.println(carsList);


    }
}
