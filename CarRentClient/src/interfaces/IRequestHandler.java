package interfaces;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import dto.Car;
import dto.Driver;
import dto.Model;
import dto.RentRecord;

public interface IRequestHandler {
	// Global config +
    int getGasPrice() throws ClassNotFoundException, IOException;
    void setGasPrice(int price) throws IOException;
    int getFinePercent() throws ClassNotFoundException, IOException;
    void setFinePercent(int finePercent) throws IOException;
    //Add Car -
    void addModel(Model model) throws IOException; //-
    void addCar(Car car) throws IOException; //+
    //Add Driver +
    void addDriver(Driver driver) throws IOException;
    //Rent car +
    void rentCar(String regNumber, long licenseId,
                           LocalDate rentDate, int rentDays);
    //Request -
    Model getModel(String modelName);
    Car getCar(String regNumber);
    Driver getDriver(long licenseId);
    List<Car> getCarsDriver(long licenseId); //-
    List<Driver>getDriversCar(String regNumber);//-
    List<Car> getCarsModel(String modelName);//returns cars (not removed and not in_use) of given model
    //Remove +
    void removeCar(String regNumber);
    int removeModel(String modelName);
    //Return car +
    RentRecord returnCar(String regNumber,
                         long licenseId, LocalDate returnDate, int damages, int tankPercent);
    //Statistics -
    List<RentRecord>getRentRecordsAtDates(LocalDate from, LocalDate to);
    List<String> getMostPopularCarModels(LocalDate fromDate,
                                         LocalDate toDate,int fromAge, int toAge);
    List<String> getMostProfitableCarModels(LocalDate fromDate,
                                            LocalDate toDate);
    List<Driver> getMostActiveDrivers();
    List<String> getModelNames();
}
