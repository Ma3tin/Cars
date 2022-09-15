import java.io.*;
import java.util.ArrayList;

public class CarsRepository {
    public ArrayList<Car> loadCars() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cars.txt"));
        ArrayList<Car> cars = new ArrayList<>();
        String line = br.readLine();
        while (line != null) {
            String[] elements = line.split(";");
            cars.add(new Car(elements[0], elements[1], Integer.parseInt(elements[2]), Integer.parseInt(elements[3])));
            line = br.readLine();
        }
        return cars;
    }


    public void saveCars(ArrayList<Car> cars) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("cars.txt"));
        for (int i = 0; i < cars.size(); i++) {

            bw.write(cars.get(i).getId() + ";" + cars.get(i).getCarBrand() + ";" + cars.get(i).getTotalKms() + ";" + cars.get(i).getPrice());
            bw.newLine();
        }
        bw.close();
    }

}
