package sk.it.strausz;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.it.strausz.dao.CarDAO;
import sk.it.strausz.service.CarService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        CarDAO carDAO = context.getBean("carDAO", CarDAO.class);

        Car car = new Car("Toyota", 6000);

        CarService carService = context.getBean("carService", CarService.class);

        carDAO.addCar(car);


        List<Car> carList = carDAO.findCars();

        System.out.println("\n\nMain Program: AfterReturningDemoApp");
        System.out.println("----------------------------------------");

        System.out.println(carList);


        List<Car> carList1 = null;

        try{
            boolean tripWire = false;
            carList1 =  carDAO.findCars(tripWire);


            System.out.println("\n\nMain Program: AfterThrowingDemoApp");
            System.out.println("----------------------------------------");

            System.out.println(carList1);

            System.out.println();

        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("HINT: " +carService.getHint());


        context.close();

    }
}
