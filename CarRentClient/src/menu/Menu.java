package menu;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import handler.RequestHandler;

public class Menu {
	
	Menu(){
		main();
	}
	
	private void main() {
		int swValue;
		System.out.println("|     Car Rent Company     |");
		System.out.println("| Choose action:           |");
		System.out.println("|        1. Rent a car     |");
		System.out.println("|        2. Return Car     |");
		System.out.println("|        3. Statistic      |");
		System.out.println("|        4. Configurations |");
		swValue = Keyin.inInt(" Select option: ");

		switch (swValue) {
		case 1:
			rentCar("", 0, LocalDate.now(), 0);
			break;
		case 2:
			returnCar("", 0, LocalDate.now(), 0, 0);
			break;
		case 3:
			System.out.println("Exit selected");
			break;
		default:
			System.out.println("Invalid selection");
		}
	}

	private void rentCar(String regNumber, long licenseId, LocalDate rentDate, int rentDays) {
		int swValue;

		System.out.println("|     Car Rent Company            |");
		System.out.println("| Rent car                        |");
		System.out.println("| Fill all cells:                 |");
		System.out.println("|        1. Registration Number   |" + regNumber);
		System.out.println("|        2. Driver license number |" + licenseId);
		System.out.println("|        3. Rent date             |" + rentDate);
		System.out.println("|        4. Rent duration (days)  |" + rentDays);
		System.out.println("|        5. Add Driver            |");
		System.out.println("|        6. Approve               |");
		System.out.println("|        7. Cancele               |");
		swValue = Keyin.inInt(" Select option: ");

		switch (swValue) {
		case 1:
			Keyin.printPrompt(" Enter Registration Number: ");
			regNumber = Keyin.inString();
			rentCar(regNumber, licenseId, rentDate, rentDays);
			break;
		case 2:
			licenseId = Keyin.inLong("Enter Driver license number:");
			rentCar(regNumber, licenseId, rentDate, rentDays);
			break;
		case 3:
			Keyin.printPrompt(" Enter Rent date (like this 2016-08-16): ");
			try {
				rentDate = LocalDate.parse(Keyin.inString());
			} catch (DateTimeParseException e) {
				System.out.print("Wrong data entry");
			}
			rentCar(regNumber, licenseId, rentDate, rentDays);
			break;
		case 4:
			rentDays = Keyin.inInt(" Enter Rent duration (days): ");
			rentCar(regNumber, licenseId, rentDate, rentDays);
			break;
		case 5:
			addDriver(licenseId, "", 0, "");
			break;
		case 6:
			try {
				if ((regNumber != "") && (licenseId != 0) && (rentDays != 0)) {
					RequestHandler rh = new RequestHandler();
					rh.rentCar(regNumber, licenseId, rentDate, rentDays);
				} else {
					System.out.print("Please fill all cells");
					rentCar(regNumber, licenseId, rentDate, rentDays);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 7:
			main();
			break;
		default:
			System.out.println("Invalid selection");
			main();
		}
	}

	public void returnCar(String regNumber, long licenseId, LocalDate returnDate, int damages, int tankPercent) {
		int swValue;
		System.out.println("|     Car Rent Company            |");
		System.out.println("| Return car                      |");
		System.out.println("| Please fill all cells:          |");
		System.out.println("|        1. Registration Number   |" + regNumber);
		System.out.println("|        2. Driver license number |" + licenseId);
		System.out.println("|        3. Return date           |" + returnDate);
		System.out.println("|        4. Damages number        |" + damages);
		System.out.println("|        5. Tank filled percentage|" + tankPercent);
		System.out.println("|        6. Approve               |");
		System.out.println("|        7. Cancele               |");
		swValue = Keyin.inInt(" Select option: ");

		switch (swValue) {
		case 1:
			Keyin.printPrompt(" Enter Registration Number: ");
			regNumber = Keyin.inString();
			returnCar(regNumber, licenseId, returnDate, damages, tankPercent);
			break;
		case 2:
			Keyin.printPrompt(" Enter Driver license number: ");
			licenseId = Long.parseLong(Keyin.inString());
			returnCar(regNumber, licenseId, returnDate, damages, tankPercent);
			break;
		case 3:
			Keyin.printPrompt(" Enter Return date (like this 2016-08-16): ");
			try {
				returnDate = LocalDate.parse(Keyin.inString());
			} catch (DateTimeParseException e) {
				System.out.print("Wrong data entry");
			}
			returnCar(regNumber, licenseId, returnDate, damages, tankPercent);
			break;
		case 4:
			damages = Keyin.inInt(" Enter Damages number: ");
			returnCar(regNumber, licenseId, returnDate, damages, tankPercent);
			break;
		case 5:
			tankPercent = Keyin.inInt(" Enter Tank filled percentage: ");
			returnCar(regNumber, licenseId, returnDate, damages, tankPercent);
			break;
		case 6:
			try {
				if ((regNumber != "") && (licenseId != 0) && (tankPercent > 0) && (tankPercent <= 100)) {
					RequestHandler rh = new RequestHandler();
					rh.returnCar(regNumber, licenseId, returnDate, damages, tankPercent);
				} else {
					System.out.print("Please fill all cells");
					returnCar(regNumber, licenseId, returnDate, damages, tankPercent);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 7:
			main();
			break;
		default:
			System.out.println("Invalid selection");
			returnCar(regNumber, licenseId, returnDate, damages, tankPercent);
		}
	}

	private void statistic() {
		int swValue;
		System.out.println("|     Car Rent Company            |");
		System.out.println("| Statistic                       |");
		System.out.println("| Please choose request:          |");
		System.out.println("|        1. Rent Records At Dates |");
		System.out.println("|        2. Most PopularCarModels |");
		System.out.println("|        3. Most Profitable Car Models |");
		System.out.println("|        4. Most Active Drivers        |");
		System.out.println("|        5. Model Names           |");
		System.out.println("|        6. Back                  |");
		swValue = Keyin.inInt(" Select option: ");

		switch (swValue) {
		case 1:
			try {
				System.out.println(" Enter First date (like this 2016-08-16): ");
				LocalDate from = LocalDate.parse(Keyin.inString());
				System.out.println(" Enter Last date (like this 2016-08-16): ");
				LocalDate to = LocalDate.parse(Keyin.inString());
				if (from.isBefore(to) || from.isEqual(to)) {
					RequestHandler rh = new RequestHandler();
					System.out.println(rh.getRentRecordsAtDates(from, to));
				} else {
					System.out.print("Please enter correct dates");
					statistic();
				}
			} catch (DateTimeParseException e) {
				System.out.print("Wrong data entry");
			} catch (Exception e) {
				e.printStackTrace();
			}
			statistic();
			break;
		case 2:
			try {
				RequestHandler rh = new RequestHandler();
				System.out.println(rh.getMostPopularCarModels());
			} catch (Exception e) {
				e.printStackTrace();
			}
			statistic();
			break;
		case 3:
			try {
				RequestHandler rh = new RequestHandler();
				System.out.println(rh.getMostProfitableCarModels());
			} catch (Exception e) {
				e.printStackTrace();
			}
			statistic();
			break;
		case 4:
			try {
				RequestHandler rh = new RequestHandler();
				System.out.println(rh.getMostActiveDrivers());
			} catch (Exception e) {
				e.printStackTrace();
			}
			statistic();
			break;
		case 5:
			try {
				RequestHandler rh = new RequestHandler();
				System.out.println(rh.getModelNames());
			} catch (Exception e) {
				e.printStackTrace();
			}
			statistic();
			break;
		case 6:
			main();
			break;
		default:
			System.out.println("Invalid selection");
			statistic();
		}
	}

	private void config(int gasPrice, int finePercent) {
		int swValue;
		System.out.println("|     Car Rent Company            |");
		System.out.println("| Configurations                  |");
		System.out.println("| Gas price: " + gasPrice + "/litr              |");
		System.out.println("| Fine Percent:" + finePercent + "%                   |");
		System.out.println("| Please choose request:          |");
		System.out.println("|        1. Change Gas Price      |");
		System.out.println("|        2. Change Fine Percent   |");
		System.out.println("|        3. Add car 			  |");
		System.out.println("|        4. Add driver 			  |");
		System.out.println("|        5. Add model 			  |");
		System.out.println("|        6. Car info              |");
		System.out.println("|        7. Driver info           |");
		System.out.println("|        8. Model info            |");
		System.out.println("|        9. Remove Car            |");
		System.out.println("|        10. Remove Model           |");
		System.out.println("|        11. Back            	  |");
		swValue = Keyin.inInt(" Select option: ");

		switch (swValue) {
		case 1:
			gasPrice = Keyin.inInt(" Enter Gas Price: ");
			try {
				RequestHandler rh = new RequestHandler();
				rh.setGasPrice(gasPrice);
			} catch (Exception e) {
				e.printStackTrace();
			}
			config(gasPrice, finePercent);
			break;
		case 2:
			finePercent = Keyin.inInt(" Enter Fine Percent: ");
			try {
				RequestHandler rh = new RequestHandler();
				rh.setFinePercent(finePercent);
			} catch (Exception e) {
				e.printStackTrace();
			}
			config(gasPrice, finePercent);
			break;
		case 3:
			try {
				RequestHandler rh = new RequestHandler();
				System.out.println(rh.getMostProfitableCarModels());
			} catch (Exception e) {
				e.printStackTrace();
			}
			statistic();
			break;
		case 4:
			try {
				RequestHandler rh = new RequestHandler();
				System.out.println(rh.getMostActiveDrivers());
			} catch (Exception e) {
				e.printStackTrace();
			}
			statistic();
			break;
		case 5:
			try {
				RequestHandler rh = new RequestHandler();
				System.out.println(rh.getModelNames());
			} catch (Exception e) {
				e.printStackTrace();
			}
			statistic();
			break;
		case 6:
			main();
			break;
		default:
			System.out.println("Invalid selection");
			statistic();
		}
	}
	
	private void addDriver(long licenseId, String name, int birthYea, String phone) {
		int swValue;
		System.out.println("|     Car Rent Company            |");
		System.out.println("| Add Driver                      |");
		System.out.println("| Please fill all cells:          |");
		System.out.println("|        1. license Number        |" + licenseId);
		System.out.println("|        2. Full Name             |" + name);
		System.out.println("|        3. Birth Year 			  |" + birthYea);
		System.out.println("|        4. Phone Number          |" + phone);
		System.out.println("|        5. Add                   |");
		System.out.println("|        9. Cancele            	  |");
		swValue = Keyin.inInt(" Select option: ");

		switch (swValue) {
		case 1:
			Keyin.printPrompt(" Enter Driver license number: ");
			licenseId = Long.parseLong(Keyin.inString());
			addDriver(licenseId, name, birthYea, phone);
			break;
		case 2:
			Keyin.printPrompt(" Enter Full Name: ");
			name = Keyin.inString();
			addDriver(licenseId, name, birthYea, phone);
			break;
		case 3:
			birthYea = Keyin.inInt(" Enter Birth Year: ");
			addDriver(licenseId, name, birthYea, phone);
			break;
		case 4:
			Keyin.printPrompt(" Enter Phone Number: ");
			name = Keyin.inString();
			addDriver(licenseId, name, birthYea, phone);
			break;
		case 5:
			try {
				RequestHandler rh = new RequestHandler();
				rh.addDriver(licenseId, name, birthYea, phone);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 6:
			main();
			break;
		default:
			System.out.println("Invalid selection");
			statistic();
		}
	}
	
}
