public class EmpWageBuilder {
    public static void main(String[] args) throws Exception {

        // Welcome message
        System.out.println("Welcome to Employee Wedge Builder...");
        System.out.println("************************************");

        // Contains
        final int IS_FULL_TIME = 1;
        final int EMP_RATE_PER_HR = 20;

        // Variables
        int empHrs = 0;
        int empWage = 0;

        // Computation
        double empCheck = Math.floor(Math.random() * 10) % 2;
        System.out.println(empCheck);
        // Case Checking
        if (empCheck == IS_FULL_TIME) {
            System.out.println("Employee is Present.");
            empHrs = 8;
        } else {
            System.out.println("Employee is Absent.");
            empHrs = 0;
        }
        empWage = empHrs * EMP_RATE_PER_HR;
        System.out.println("Employee Wage : " + empWage);
    }
}