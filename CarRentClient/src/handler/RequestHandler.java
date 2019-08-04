package handler;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import dto.Car;
import dto.Driver;
import dto.Model;
import dto.RentRecord;
import interfaces.IRequestHandler;
import tcp.ClientSocket;

public class RequestHandler implements IRequestHandler {
	
	ClientSocket socket;
	
	public RequestHandler() throws Exception {
		socket = ClientSocket.getSocket();
	}
	
	@Override
	public int getGasPrice() throws ClassNotFoundException, IOException {
		return (int) socket.sendGetRequest("GasPrice");
	}

	@Override
	public void setGasPrice(int price) throws IOException {
		socket.sendSetRequest("GasPrice", price);
	}

	@Override
	public int getFinePercent() throws ClassNotFoundException, IOException {
		return (int) socket.sendGetRequest("FinePercent");
	}

	@Override
	public void setFinePercent(int finePercent) throws IOException {
		socket.sendSetRequest("FinePercent", finePercent);
	}

	@Override
	public void addModel(Model model) throws IOException {
		socket.sendSetRequest("Model", model);
	}

	@Override
	public void addCar(Car car) throws IOException {
		socket.sendSetRequest("Car", car);
	}

	@Override
	public void addDriver(Driver driver) throws IOException {
		socket.sendSetRequest("Driver", driver);
	}

	@Override
	public void rentCar(String regNumber, long licenseId, LocalDate rentDate, int rentDays) {
		socket.sendSetRequest("Rent", driver);
	}

	@Override
	public Model getModel(String modelName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car getCar(String regNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Driver getDriver(long licenseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> getCarsDriver(long licenseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Driver> getDriversCar(String regNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Car> getCarsModel(String modelName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCar(String regNumber) {
		// TODO Auto-generated method stub

	}

	@Override
	public int removeModel(String modelName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RentRecord returnCar(String regNumber, long licenseId, LocalDate returnDate, int damages, int tankPercent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RentRecord> getRentRecordsAtDates(LocalDate from, LocalDate to) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getMostPopularCarModels(LocalDate fromDate, LocalDate toDate, int fromAge, int toAge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getMostProfitableCarModels(LocalDate fromDate, LocalDate toDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Driver> getMostActiveDrivers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getModelNames() {
		// TODO Auto-generated method stub
		return null;
	}

}
