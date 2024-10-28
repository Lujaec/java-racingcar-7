package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarRace {
    private List<Car> cars;
    private Long currentTryCnt;
    private Long totalTryCnt;

    public CarRace(List<String> names, Long totalTryCnt){
        this.cars = new ArrayList<>();

        for (String name : names) {
            this.cars.add(new Car(name));
        }

        this.totalTryCnt = totalTryCnt;
        this.currentTryCnt = 0L;
    }

    public Boolean checkTryCnt(){
        return this.currentTryCnt < this.totalTryCnt;
    }

    public List<Car> process() {
        if (checkTryCnt()) {
            for (Car car : cars) {
                car.run();
            }

            this.currentTryCnt += 1;
        }

        return getCars();
    }

    public List<Car> getCars() {
        return List.copyOf(this.cars);
    }
}