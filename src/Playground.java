import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class Playground {
    public static void main(String[] args) throws IOException {
        CarsRepository cr = new CarsRepository();
        ArrayList<Car> carsList = new ArrayList<>();

        System.out.println(carsList);
        carsList.add(new Car("938c4dd6-c880-4a02-8a96-a71cb7badf8c", "Audi", 0, 2345000));
        carsList.add(new Car("15969665-5939-421a-baa8-3f7896c3869f", "Ford", 1500, 1458000));
        carsList.add(new Car("ceaccae3-11fd-43c7-bfcd-44231a00b35a", "BMW", 450, 850000));
        carsList.add(new Car("3d3a12e0-ec7a-40c0-be23-22446663ef30", "Toyota", 0, 4985000));
        carsList.add(new Car("3d3a12e0-ec7a-40c0-be23-22446663ef30", "Toyota", 0, 4985000));
        cr.saveCars(carsList);
        System.out.println(carsList);
        carsList = cr.loadCars();
        System.out.println(carsList);

       /*
        carsList.add(new Car("938c4dd6-c880-4a02-8a96-a71cb7badf8c", "Audi", 0, 2345000));
        carsList.add(new Car("15969665-5939-421a-baa8-3f7896c3869f", "Ford", 1500, 1458000));
        carsList.add(new Car("ceaccae3-11fd-43c7-bfcd-44231a00b35a", "BMW", 450, 850000));
        carsList.add(new Car("3d3a12e0-ec7a-40c0-be23-22446663ef30", "Toyota", 0, 4985000));
        carsList.add(new Car("3d3a12e0-ec7a-40c0-be23-22446663ef30", "Toyota", 0, 4985000));



        carsList = cr.loadCars();
        System.out.println(carsList);
        */



        /*
        938c4dd6-c880-4a02-8a96-a71cb7badf8c;Audi;0;2345000
        15969665-5939-421a-baa8-3f7896c3869f;Ford;1500;1458000
        ceaccae3-11fd-43c7-bfcd-44231a00b35a;BMW;450;850000
        3d3a12e0-ec7a-40c0-be23-22446663ef30;Toyota;0;4985000
         */

        /*
        "938c4dd6-c880-4a02-8a96-a71cb7badf8c", "Audi", 0, 2345000
        "15969665-5939-421a-baa8-3f7896c3869f", "Ford", 1500, 1458000
        "ceaccae3-11fd-43c7-bfcd-44231a00b35a", "BMW", 450, 850000
        "3d3a12e0-ec7a-40c0-be23-22446663ef30", "Toyota", 0, 4985000

         */

    }
}
