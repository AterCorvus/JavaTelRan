package interfaces;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import dto.Car;
import dto.Driver;
import dto.Model;
import dto.RentRecord;
import dto.State;

public interface IRequestHandler {
	// Global config +
    int getGasPrice() throws ClassNotFoundException, IOException;
    void setGasPrice(int price) throws IOException;
    int getFinePercent() throws ClassNotFoundException, IOException;
    void setFinePercent(int finePercent) throws IOException;
    //Add Car -
    void addModel(String modelName, int gasTank, String country, int priceDay) throws IOException; //-
    void addCar(String regNumber, String color, State state, String modelName, boolean inUse, boolean  flRemoved) throws IOException; //+
    //Add Driver +
    void addDriver(long licenseId, String name, int birthYear, String phone) throws IOException;
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
    List<String> getMostPopularCarModels();
    List<String> getMostProfitableCarModels();
    List<Driver> getMostActiveDrivers();
    List<String> getModelNames();
}
