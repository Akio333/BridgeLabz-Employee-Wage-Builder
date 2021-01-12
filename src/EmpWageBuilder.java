public class EmpWageBuilder {
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    // Variables
    private final String company;
    private final int empRatePerHr;
    private final int noOfWorkingDays;
    private final int maxHrsPeronth;

    // Constructer
    public EmpWageBuilder(String company, int empRatePerHr, int noOfWorkingDays, int maxHrsPeronth) {
        this.company = company;
        this.empRatePerHr = empRatePerHr;
        this.noOfWorkingDays = noOfWorkingDays;
        this.maxHrsPeronth = maxHrsPeronth;
    }// End of Constructer

    // Compute Wage method
    public void computeEmpWage() {
        // Variables
        int empHrs = 0;
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
            }// End Case
            totalEmpHrs += empHrs;
            System.out.println("Day: " + totalWorkingDays + "\tEmp Hr: " + empHrs);
        } // End While
        totalEmpWage = totalEmpHrs * empRatePerHr;
        System.out.println("Total Employee Wage for company " + company + ": " + totalEmpWage + "\n");

    } // End computeEmpWage

    public static void main(String[] args) throws Exception {

        // Welcome message
        System.out.println("Welcome to Employee Wedge Builder...");
        System.out.println("************************************\n");

        // Objects
        EmpWageBuilder dMart = new EmpWageBuilder("Dmart", 20, 2, 10);
        EmpWageBuilder reliance = new EmpWageBuilder("Reliance", 10, 4, 20);

        // Method calls
        dMart.computeEmpWage();
        reliance.computeEmpWage();

    }// End main
}// End class EmpWageBuilder