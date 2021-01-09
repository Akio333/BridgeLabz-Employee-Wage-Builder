public class EmpWageBuilder {
    public static void main(String[] args) throws Exception {

        // Welcome message
        System.out.println("Welcome to Employee Wedge Builder...");
        System.out.println("************************************");

        // Contains
        final int IS_FULL_TIME = 1;

        // Computation
        double empCheck = Math.floor(Math.random() * 10) % 2;
        System.out.println(empCheck);
        // Case Checking
        if (empCheck == IS_FULL_TIME) {
            System.out.println("Employee is Present.");
        } else {
            System.out.println("Employee is Absent.");
        }
    }
}