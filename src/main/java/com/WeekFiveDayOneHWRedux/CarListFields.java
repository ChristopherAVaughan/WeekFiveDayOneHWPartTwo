package com.WeekFiveDayOneHWRedux;

public class CarListFields {


	private int year = 0;
	private String carMake = null;
	private String carModel = null;
	private int numOfCylinders = 0;
	private int horsePower = 0;
	private double engDisplacement = 0.0;

	public CarListFields() {
		super();
	}

	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCarMake() {
		return carMake;
	}

	public void setCarMake(String carMake) {
		this.carMake = carMake;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public int getNumOfCylinders() {
		return numOfCylinders;
	}

	public void setNumOfCylinders(int numOfCylinders) {
		this.numOfCylinders = numOfCylinders;
	}

	public int getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(int horsePower) {
		this.horsePower = horsePower;
	}

	public double getEngDisplacement() {
		return engDisplacement;
	}

	public void setEngDisplacement(double engDisplacement) {
		this.engDisplacement = engDisplacement;
	}

	@Override
	public String toString() {
		return "CarList [year=" + year + ", carMake=" + carMake + ", carModel="
				+ carModel + ", numOfCylinders=" + numOfCylinders + ", horsePower=" + horsePower + ", engDisplacement="
				+ engDisplacement + "]";
	}

}
