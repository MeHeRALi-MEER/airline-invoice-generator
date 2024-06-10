
import java.util.Scanner;

public class Assignment4 {

    static Scanner scan = new Scanner(System.in);

    static void transport() {
        int noOfPassengers, busTicketPrice, driverSalary, petrolPrice, fuelConsumptionPerHour,
                fuelConsumptionPerDay, dailyExpense, monthlyExpense, dailyIncome,
                monthlyIncome;
        String className;
        float taxPercentage, taxAmount, totalPrice;
        driverSalary = 25000;

        System.out.print("enter no of passengers = ");
        noOfPassengers = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter Class Name = ");
        className = scan.next();
        scan.nextLine();
        System.out.print("enter Petrol Price = ");
        petrolPrice = scan.nextInt();
        System.out.print("enter Fuel Consumption Per hour(in litres) = ");
        fuelConsumptionPerHour = scan.nextInt();
        System.out.print("enter Fuel Consumption Per Day(in litres) = ");
        fuelConsumptionPerDay = scan.nextInt();
        System.out.print("enter Daily Expennse = ");
        dailyExpense = scan.nextInt();

        System.out.print("Daily Income = ");
        dailyIncome = scan.nextInt();

        if (className != "economy") {
            busTicketPrice = 1500;
            taxPercentage = 0.31f;
        } else {
            busTicketPrice = 1300;
            taxPercentage = 0.2f;
        }
        taxAmount = busTicketPrice * taxPercentage;
        monthlyIncome = dailyIncome * 30;
        monthlyExpense = dailyExpense * 30;

        totalPrice = busTicketPrice + taxAmount;
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(
                "--------------------------------------------------------BUS TRANSPORT---------------------------------------------------------------------------------------------------------");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(
                "No of Passengers \t Driver Salary \t Class Name \t Petrol Price \t\t Fuel Consumption Per hour(in litres) \t\t Fuel Consumption Per Day(in litres) \t Daily Expennse    Monthly Expennse \t Net Monthly Expennse \t Daily Income \t Monthly Income \t Net Income");
        System.out.println(noOfPassengers + "\t\t\t" + driverSalary + "\t\t" + className + "\t\t"
                + petrolPrice + "\t\t\t" + fuelConsumptionPerHour + "\t\t\t" + fuelConsumptionPerDay
                + "\t\t" + dailyExpense + "\t\t" + monthlyExpense + "\t\t"
                + dailyIncome + "\t\t" + monthlyIncome);
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t Bus Ticket Price: " + busTicketPrice);
        System.out.println("\t\t\t Tax Amount: " + taxAmount);
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t Total Price: " + totalPrice);
    }

    static void employee() {

        String Name, Gender, Designation, Address;
        int Emp_ID, CNIC, Salary, Phone_No, Extra_work_hour_per_day, Overtime_salary, overtime_salary_per_month;
        float tax, Salary_after_tax_deducted, Final_Salary;
        // Scanner scan = new Scanner (System.in);
        System.out.print("Enter Name of Employee :");
        Name = scan.nextLine();

        System.out.print("Enter Gender of Employee :");
        Gender = scan.nextLine();

        System.out.print("Enter Designation of Employee :");
        Designation = scan.nextLine();

        System.out.print("Enter address of Employee :");
        Address = scan.nextLine();

        System.out.print("Enter ID of Employee :");
        Emp_ID = scan.nextInt();

        System.out.print("Enter CNIC of Employee :");
        CNIC = scan.nextInt();

        System.out.print("Enter salary of Employee :");
        Salary = scan.nextInt();

        System.out.print("Enter phone no of Employee :");
        Phone_No = scan.nextInt();

        System.out.print("Enter employee extra work hours per day :");
        Extra_work_hour_per_day = scan.nextInt();

        if (Salary > 90000) {
            tax = Salary * .07f;
        } else if (Salary > 70000) {
            tax = Salary * .05f;
        } else if (Salary > 50000) {
            tax = Salary * .03f;
        } else {
            tax = Salary * .02f;
        }
        Salary_after_tax_deducted = Salary - tax;
        Overtime_salary = 800 * Extra_work_hour_per_day;
        overtime_salary_per_month = Overtime_salary * 26;
        Final_Salary = 12 * (Salary_after_tax_deducted + overtime_salary_per_month);
        System.out.println(
                "=================================================================================================================================================================");
        System.out.println("/t/tPIA AIRLINE EMPLOYEE INFORMATION");
        System.out.println(
                "=================================================================================================================================================================");
        System.out.println("Name" + "\t\t" + "Gender" + "\t\t" + "Designation" + "\t\t" + "Address" + "\t\t" + "Emp_ID"
                + "\t\t" + "CNIC" + "\t\t" + "Salary" + "\t\t" + "Phone_No" + "\t\t" + "Extra_work_hour_per_day");
        System.out.println(Name + "\t\t " + Gender + "\t\t" + Designation + "\t\t\t" + Address + "\t\t" + Emp_ID
                + "\t\t" + CNIC + "\t\t" + Salary + "\t\t" + Phone_No + "\t\t\t" + Extra_work_hour_per_day);
        System.out.println(
                "=================================================================================================================================================================");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "Tax: -" + tax);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "Overtime salary: +" + overtime_salary_per_month);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "Final salary" + Final_Salary);
    }

    static float taxCal(float taxPercent, int ammount) {
        float calculation = taxPercent / 100 * ammount;
        return calculation;
    }

    static int subtract(int a, int b) {
        int sum = a - b;
        return sum;
    }

    static float subtract(float a, float b) {
        float sum = a - b;
        return sum;
    }

    static int mul(int a, int b) {
        int mult = a * b;
        return mult;
    }

    static void addFlight() {
        // Scanner scan = new Scanner(System.in);
        float[] flightTax = new float[10];
        float[] calculatedTax = new float[10];
        float[] final_earning = new float[10];
        int[] total_seats = new int[10];
        int[] booked_seats = new int[10];
        int[] flight_number = new int[10];
        int[] flightStaffWages = new int[10];
        int[] available_seats = new int[10];
        int[] fuel_consumedL = new int[10];
        int[] fuel_consumedP = new int[10];
        int[] priceperSeat = new int[10];
        int[] net_earning = new int[10];
        int[] flight_earnings = new int[10];
        int[] final_earning1 = new int[10];
        String[] aircraft_type = new String[10];
        String[] departure_airport = new String[10];
        String[] arrival_airport = new String[10];
        System.out.print("Enter number of data to add : ");
        int addData = scan.nextInt();
        for (int i = 0; i < addData; i++) {
            System.out.print("Enter flight number : ");
            flight_number[i] = scan.nextInt();
            scan.nextLine();
            System.out.print("Enter Aircraft type : ");
            aircraft_type[i] = scan.nextLine();
            System.out.print("Enter arrival airport : ");
            arrival_airport[i] = scan.nextLine();
            System.out.print("Enter departure airport : ");
            departure_airport[i] = scan.nextLine();
            System.out.print("Enter total number of seats : ");
            total_seats[i] = scan.nextShort();
            System.out.print("Enter number of booked seats : ");
            booked_seats[i] = scan.nextShort();
            available_seats[i] = subtract(total_seats[i], booked_seats[i]);
            int fuel_price = 290;
            System.out.print("Enter fuel consumed by flight in liters : ");
            fuel_consumedL[i] = scan.nextInt();
            fuel_consumedP[i] = mul(fuel_consumedL[i], fuel_price);
            System.out.print("Enter price per seat : ");
            priceperSeat[i] = scan.nextInt();
            net_earning[i] = mul(priceperSeat[i], booked_seats[i]);
            flight_earnings[i] = subtract(net_earning[i], fuel_consumedP[i]);
            System.out.print("Enter flight staff wages : ");
            flightStaffWages[i] = scan.nextInt();
            final_earning1[i] = subtract(flight_earnings[i], flightStaffWages[i]);
            if (net_earning[i] > 8000000) {
                flightTax[i] = 4.5f;
                calculatedTax[i] = taxCal(flightTax[i], net_earning[i]);
            } else {
                flightTax[i] = 2.5f;
                calculatedTax[i] = taxCal(flightTax[i], net_earning[i]);
            }
            final_earning[i] = subtract(final_earning1[i], calculatedTax[i]);
        }
        System.out.println("\t\t\t**Flights Information**\n");
        System.out.println(
                "Flight no.   Aircraft type   Departure airport   Arrival airport   Total seats   Available seats   Seat price   Fuel Consumed   Staff wages   Flight Tax   Total earning");
        for (int i = 0; i < addData; i++) {
            System.out.println(flight_number[i] + "     | " + aircraft_type[i] + "     | " + departure_airport[i]
                    + "             | " + arrival_airport[i] + "          | " + total_seats[i] + "         | "
                    + available_seats[i] + "              | " + priceperSeat[i] + " \t| " + fuel_consumedP[i]
                    + "       | " + flightStaffWages[i] + "      | " + calculatedTax[i] + "  | " + final_earning[i]);
        }

    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int x;
        char y = 'y';

        while (y == 'y') {

            System.out.println("---Main Menu---");
            System.out.println("Press 1 to Book a ticket");
            System.out.println("Press 2 to Add Employee");
            System.out.println("Press 3 to Add Flight");
            System.out.println("Press 4 to Add Transport");
            System.out.println("Press 5 to Exit");

            x = scan.nextInt();

            while (y == 'y') {

                System.out.println("---Main Menu---");
                System.out.println("Press 1 to Book a ticket");
                System.out.println("Press 2 to Add Employee");
                System.out.println("Press 3 to Add Flight");
                System.out.println("Press 4 to Add Transport");
                System.out.println("Press 5 to Exit");
    
                x = scan.nextInt();
    
                switch (x) {
                    case 1:
                        Ticket.main(args);
                        break;
                        
                    case 2:
                    employee();
                        break;
    
                    case 3:
                       addFlight();
                       break;
    
                    case 4:
                    transport();   
                    break;
                    
                    case 5:
                        System.exit(0);
                
                    default:
                    System.out.println("you have pressed wrong number.");
                        break;
            }
        }
        scan.close();
    }
}
}