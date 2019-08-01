package interfaces;

import dto.*;
import enumerations.CarsReturnCode;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface IRentCompany extends Serializable {
    int getGasPrice();
    void setGasPrice(int price);
    int getFinePercent();
    void setFinePercent(int finePercent);
    CarsReturnCode addModel(Model model);
    Model getModel(String modelName);
    CarsReturnCode addCar(Car car);
    Car getCar(String regNumber);
    CarsReturnCode addDriver(Driver driver);
    Driver getDriver(long licenseId);
    CarsReturnCode rentCar(String regNumber, long licenseId,
                           LocalDate rentDate, int rentDays);
    List<Car> getCarsDriver(long licenseId);
    List<Driver>getDriversCar(String regNumber);
    List<Car> getCarsModel(String modelName);//returns cars (not removed and not in_use) of given model
    List<RentRecord>getRentRecordsAtDates(LocalDate from, LocalDate to);
    CarsReturnCode removeCar(String regNumber);
    int removeModel(String modelName);
    RentRecord returnCar(String regNumber,
                         long licenseId, LocalDate returnDate, int damages, int tankPercent) ;
    List<String> getMostPopularCarModels(LocalDate fromDate,
                                         LocalDate toDate,int fromAge, int toAge);
    List<String> getMostProfitableCarModels(LocalDate fromDate,
                                            LocalDate toDate);
    List<Driver> getMostActiveDrivers();
    List<String> getModelNames();
}
