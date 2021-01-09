public class EmpWageBuilder {
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;
    public static final int EMP_RATE_PER_HR = 20;

    public static void main(String[] args) throws Exception {

        // Welcome message
        System.out.println("Welcome to Employee Wedge Builder...");
        System.out.println("************************************");

        // Variables
        int empHrs = 0;
        int empWage = 0;

        // Computation
        int empCheck = (int) Math.floor(Math.random() * 10) % 3;
        // Case Checking
        switch (empCheck) {
            case IS_PART_TIME:
                System.out.println("Employee is Present.");
                empHrs = 4;
                break;
            case IS_FULL_TIME:
                System.out.println("Employee is Present.");
                empHrs = 8;
                break;
            default:
                System.out.println("Employee is Absent.");
                empHrs = 0;
                break;
        }
        empWage = empHrs * EMP_RATE_PER_HR;
        System.out.println("Employee Wage : " + empWage);
    }
}