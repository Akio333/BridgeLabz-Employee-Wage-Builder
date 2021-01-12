public class EmpWageBuilderArray {
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    // Variables
    private int numOfCompany = 0;
    private CompanyEmpWage[] companyEmpWageArray;

    // Constructer
    public EmpWageBuilderArray() {
        companyEmpWageArray = new CompanyEmpWage[5];
    }

    private void addCompanyEmpWage(String company, int empRatePerHr, int noOfWorkingDays, int maxHrsPeronth) {
        companyEmpWageArray[numOfCompany] = new CompanyEmpWage(company, empRatePerHr, noOfWorkingDays, maxHrsPeronth);
        numOfCompany++;
    }

    private void computeEmpWage() {
        for (int i = 0; i < numOfCompany; i++) {
            companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
            System.out.println(companyEmpWageArray[i]);
        }
    }

    // Compute Wage method
    public int computeEmpWage(CompanyEmpWage companyEmpWage) {
        // Variables
        int empHrs = 0;
        int totalEmpWage = 0;
        int totalWorkingDays = 0;
        int totalEmpHrs = 0;

        // Computation
        while (totalEmpHrs <= companyEmpWage.maxHrsPeronth && totalWorkingDays < companyEmpWage.noOfWorkingDays) {
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
        return totalEmpHrs * companyEmpWage.empRatePerHr;
    } // End computeEmpWage

    public static void main(String[] args) throws Exception {

        // Welcome message
        System.out.println("Welcome to Employee Wedge Builder...");
        System.out.println("************************************\n");

        // Objects
        EmpWageBuilderArray empWageBuilder = new EmpWageBuilderArray();
        empWageBuilder.addCompanyEmpWage("Dmart", 20, 2, 10);
        empWageBuilder.addCompanyEmpWage("Reliance", 10, 4, 20);

        // Method calls
        empWageBuilder.computeEmpWage();

    }// End main
}// End class EmpWageBuilder
