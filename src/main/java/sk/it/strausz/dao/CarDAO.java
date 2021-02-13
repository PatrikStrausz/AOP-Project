package sk.it.strausz.dao;

import org.springframework.stereotype.Component;
import sk.it.strausz.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDAO {

    public void addCar(Car car){

        System.out.println(getClass() + ": ADDING A CAR");
    }


    public List<Car> findCars(){
        List<Car> carList = new ArrayList<>();

        Car temp1 = new Car("Mazda",5000 );
        Car temp2 = new Car("AUDI", 10000);
        Car temp3 = new Car("BMW", 8800);

        carList.add(temp1);
        carList.add(temp2);
        carList.add(temp3);

        return carList;
    }

    public List<Car> findCars(boolean tripWire){

        if(tripWire){
            throw new RuntimeException("No car have been found");
        }

        List<Car> carList = new ArrayList<>();

        Car temp1 = new Car("Mazda",5000 );
        Car temp2 = new Car("AUDI", 10000);
        Car temp3 = new Car("BMW", 8800);

        carList.add(temp1);
        carList.add(temp2);
        carList.add(temp3);

        return carList;
    }

}
