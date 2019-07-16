package dto;

public class Man implements Comparable<Man>{
	private double money;

	public Man(double money) {
		super();
		this.money = money;
	}

	public double getMoney() {
		return money;
	}

	@Override
	public int compareTo(Man other) {		
		return Double.compare(money, other.money);
	}

	@Override
	public String toString() {
		return "Man [money=" + money + "]";
	}
	
	
}
