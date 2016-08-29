package com.WeekFiveDayOneHWRedux;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class DAOWeekFourHW {

	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "sesame";

	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;

	public static void connToDB() {

		try {
			System.out.println("Connecting to the database.");
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connected to DB.");

		} catch (SQLException e) {
			System.out.println("Connection failed!");
			e.printStackTrace();
		}
	}

	public static void readFromDB() {

		connToDB();

		ArrayList<CarListFields> myCars = new ArrayList<>();

		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM von_cars.filetobeimported;");

			while (RES_SET.next()) {
				CarListFields carsInDB = new CarListFields();

				carsInDB.setYear(RES_SET.getInt("Year"));
				carsInDB.setCarMake(RES_SET.getString("Make"));
				carsInDB.setCarModel(RES_SET.getString("Model"));
				carsInDB.setNumOfCylinders(RES_SET.getInt("Num of Cylinders"));
				carsInDB.setHorsePower(RES_SET.getInt("Horsepower"));
				carsInDB.setEngDisplacement(RES_SET.getDouble("Eng Displacement"));

				myCars.add(carsInDB);

			}

			for (CarListFields cars : myCars) {
				System.out.println(cars.toString());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void addToDB() {

		CarListFields carToAdd = new CarListFields();

		carToAdd = aboutTheCar();

		connToDB();

		try {
			PREP_STMT = CONN.prepareStatement(insertIntoTable);

			PREP_STMT.setInt(1, carToAdd.getYear());
			PREP_STMT.setString(2, carToAdd.getCarMake());
			PREP_STMT.setString(3, carToAdd.getCarModel());
			PREP_STMT.setInt(4, carToAdd.getNumOfCylinders());
			PREP_STMT.setInt(5, carToAdd.getHorsePower());
			PREP_STMT.setDouble(6, carToAdd.getEngDisplacement());

			System.out.println(PREP_STMT);
			
			PREP_STMT.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String insertIntoTable = "INSERT INTO `von_cars`.`cardatabase`"
			+ "(`Year`, `Make`, `Model`, `Num of Cylinders`, `Horsepower`, `Eng Displacement`)" + "VALUES "
			+ "(?, ?, ?, ?, ?, ?)";

	private static CarListFields aboutTheCar() {

		Scanner sc = new Scanner(System.in);

		CarListFields carToAdd = new CarListFields();

		System.out.println("Enter in the year of the vehicle:");
		String yearOFCar = sc.nextLine();
		carToAdd.setYear(Integer.parseInt(yearOFCar));

		System.out.println("Enter in the make of the vehicle:");
		carToAdd.setCarMake(sc.nextLine());

		System.out.println("Enter in the model of the vehicle:");
		carToAdd.setCarModel(sc.nextLine());

		System.out.println("Enter in the number of the engine's cylinders:");
		String carCylinders = sc.nextLine();
		carToAdd.setNumOfCylinders(Integer.parseInt(carCylinders));

		System.out.println("Enter in the engines horsepower output (at the crank):");
		String carHP = sc.nextLine();
		carToAdd.setHorsePower(Integer.parseInt(carHP));

		System.out.println("Enter in the engine's displacement:");
		String engDis = sc.nextLine();
		carToAdd.setEngDisplacement(Double.parseDouble(engDis));

		return carToAdd;

	}
}