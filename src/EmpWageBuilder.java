public class EmpWageBuilder {
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    // Compute Wage method
    public static int computeEmpWage(String company, int empRatePerHr, int noOfWorkingDays, int maxHrsPeronth) {
        // Variables
        int empHrs = 0;
        int empWage = 0;
        int totalEmpWage = 0;
        int totalWorkingDays = 0;
        int totalEmpHrs = 0;

        // Computation
        while (totalEmpHrs <= maxHrsPeronth && totalWorkingDays < noOfWorkingDays) {
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            // Case Checking
            switch (empCheck) {
                case IS_PART_TIME:
                    empHrs = 4;
                    break;
                case IS_FULL_TIME:
                    empHrs = 8;
                    break;
                default:
                    empHrs = 0;
                    break;
            }
            totalEmpHrs += empHrs;
            System.out.println("Day: " + totalWorkingDays + "\tEmp Hr: " + empHrs);
        }
        totalEmpWage = totalEmpHrs * empRatePerHr;
        System.out.println("Total Employee Wage for company " + company + ": " + totalEmpWage + "\n");
        return totalEmpWage;
    } // End computeEmpWage

    public static void main(String[] args) throws Exception {

        // Welcome message
        System.out.println("Welcome to Employee Wedge Builder...");
        System.out.println("************************************\n");
        computeEmpWage("Dmart", 20, 2, 10);
        computeEmpWage("Reliance", 10, 4, 20);
    }// end main
}// end class EmpWageBuilder