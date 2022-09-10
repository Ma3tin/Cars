import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        CarsService carsService = new CarsService();
        int choice = getChoice();
        while (choice != 4) {
            if (choice == 1) {
                carsService.addCar(createCar());
                System.out.println();
            } else if (choice == 2) {
                removeCar(carsService);
                System.out.println();
            } else if (choice == 3) {
                printCars(carsService);
                System.out.println();
            }
            choice = getChoice();
        }
        System.out.println("Zatím nashledanout, těšíme se na vás příště! :)");
    }

    public static int getChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Vítejte v automobilce Mareš");
        System.out.println("Co by jste si přál dneska?");
        System.out.println("1. Koupit si auto");
        System.out.println("2. Prodat auto");
        System.out.println("3. Informace všech aut co jste si u nás koupil");
        System.out.println("4. Odejít");
        System.out.print("Zadejte vaší volbu...");
        int choice = Integer.parseInt(sc.nextLine());
        System.out.println();
        while (choice <= 0 || choice >= 5) {
            System.out.println("Něco je špatně, zkuste to znovu. Číslo je buď ve špatném formátu nebo je moc malé nebo velké.");
            System.out.println("1. Koupit si auto");
            System.out.println("2. Prodat auto");
            System.out.println("3. Informace všech aut co jste si u nás koupil");
            System.out.println("4. Odejít");
            System.out.print("Zadejte vaší volbu...");
            choice =  Integer.parseInt(sc.nextLine());
            System.out.println();
        }
        return choice;
    }

    public static Car createCar() {
        Random getPrice = new Random();
        Scanner sc = new Scanner(System.in);
        String id = UUID.randomUUID().toString(); //Generates random UUID
        System.out.println("Vybral jste si tedy, že chcete auto, jaké bude značky?");
        System.out.print("Zadejte jméno značky...");
        String carBrand = sc.nextLine();
        System.out.println("Hmm... " + carBrand + " dobrá volba! A chtěl by jste auto ojeté nebo zcela nové?");
        System.out.print("Zadejte počet najetých kilometrů...");
        int kmsDriven = Integer.parseInt(sc.nextLine());
        if (kmsDriven == 0) {
            System.out.println("Dobře nové auto, to bude trošku dražší, pojdme se mrknout na cenu.");
            int priceOfNewCar = (getPrice.nextInt(5000-1000) + 1000) * 1000;
            System.out.println("Cena vás tedy vychází na " + priceOfNewCar + ",-. Pojdme vyřešit papíry a auto je vaše. :)");
            return new Car(id, carBrand, kmsDriven, priceOfNewCar);
        }
        else {
            System.out.println("Ojeté auto to bude asi levnější zaležitost pojdmě se mrknout na cenu.");
            int priceOfDrivenCar = (getPrice.nextInt(2000-200) + 200) * 1000;
            System.out.println("Cena vás tedy vychází na " + priceOfDrivenCar + ",-. Pojdme vyřešit papíry a auto je vaše. :)");
            return new Car(id, carBrand, kmsDriven, priceOfDrivenCar);
        }
    }

    public static void removeCar(CarsService carsService) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dobrý den chcete tedy prodat auto.");
        if (carsService.getAll().size() == 0)
            System.out.println("Zatim nevlastníte žádné auto, proto taky žádné nemůžete prodat");
        printAllOwnedCars(carsService);
        System.out.println("Jaký auto chcete prodat?");
        System.out.print("Zadejte číslo...");
        int choiceOfCar = Integer.parseInt(sc.nextLine());
        if (choiceOfCar > carsService.getAll().size() || choiceOfCar < 1) {
            System.out.println("Něco je špatně, číslo je bud ve špatném fromátu nebo je moc malé nebo moc velké. :(");
            while (choiceOfCar > carsService.getAll().size() || choiceOfCar < 1) {
                printAllOwnedCars(carsService);
                System.out.println("Jaký auto chcete prodat?");
                System.out.print("Zadejte číslo...");
                choiceOfCar = Integer.parseInt(sc.nextLine());
            }
        }
        Car sellingCar = carsService.getAll().get(choiceOfCar - 1);
        System.out.println("Vaše auto má hodnotu " + sellingCar.getPrice() + ",-, což vám pošleme na účet.");
        carsService.removeCar(sellingCar.getId(), sellingCar);
        System.out.println("Vaše auto bylo prodáno. :)");
    }

    public static void printCars(CarsService carsService) {
        if (carsService.getAll().size() == 0) System.out.println("Zatim nevlastníte žádné auto, proto taky žádné nemůžete prodat");
        else {
            printAllOwnedCars(carsService);
        }
    }

    public static void printAllOwnedCars(CarsService carsService) {
        for (int i = 0; i < carsService.getAll().size(); i++) {
            System.out.println((i + 1) + ";"
                    + carsService.getAll().get(i).getCarBrand() + ";"
                    + carsService.getAll().get(i).getPrice() + ";"
                    + carsService.getAll().get(i).getTotalKms() + ";"
                    + carsService.getAll().get(i).getId());
        }
    }
}