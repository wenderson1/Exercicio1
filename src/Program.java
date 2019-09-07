import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter department's name: ");
		String departmentName = sc.nextLine();
		
		System.out.println("Enter worker data:");
		
		System.out.println("Name: ");
		String workerName = sc.nextLine();
		
		System.out.println("Level: ");
		String workerLevel = sc.nextLine();
		
		System.out.println("Base Salary: ");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker (workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.println("How many contracts to this worker?");
		int n = sc.nextInt();
		
		for (int i=1; i <= n; i++) {
			System.out.println("Enter contract #" + i + "data");
			System.out.print("Date (DD/MM/YY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerhour = sc.nextDouble();
			System.out.println("Duration (hours):");
			int hours = sc.nextInt();		
			
			HourContract contract  = new HourContract(contractDate, valuePerhour, hours);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.println("Enther month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0,2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + " : " + String.format("%.2f", worker.income(year, month)));
		
		
		
		sc.close();

	}

}
