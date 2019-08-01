package interfaces;

import dto.*;
import enumerations.CarsReturnCode;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface IRentCompany extends Serializable {
	// Global config +
    int getGasPrice();
    void setGasPrice(int price);
    int getFinePercent();
    void setFinePercent(int finePercent);
    //Add Car -
    CarsReturnCode addModel(Model model); //-
    CarsReturnCode addCar(Car car); //+
    //Add Driver +
    CarsReturnCode addDriver(Driver driver);
    //Rent car +
    CarsReturnCode rentCar(String regNumber, long licenseId,
                           LocalDate rentDate, int rentDays);
    //Request -
    Model getModel(String modelName);
    Car getCar(String regNumber);
    Driver getDriver(long licenseId);
    List<Car> getCarsDriver(long licenseId); //-
    List<Driver>getDriversCar(String regNumber);//-
    List<Car> getCarsModel(String modelName);//returns cars (not removed and not in_use) of given model
    //Remove +
    CarsReturnCode removeCar(String regNumber);
    int removeModel(String modelName);
    //Return car +
    RentRecord returnCar(String regNumber,
                         long licenseId, LocalDate returnDate, int damages, int tankPercent);
    //Statistics
    List<RentRecord>getRentRecordsAtDates(LocalDate from, LocalDate to);
    List<String> getMostPopularCarModels(LocalDate fromDate,
                                         LocalDate toDate,int fromAge, int toAge);
    List<String> getMostProfitableCarModels(LocalDate fromDate,
                                            LocalDate toDate);
    List<Driver> getMostActiveDrivers();
    List<String> getModelNames();
}
