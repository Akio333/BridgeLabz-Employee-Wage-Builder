public class EmpWageBuilderArray implements EmpWageCalculation {
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    // Variables
    private int numOfCompany = 0;
    private CompanyEmpWage[] companyEmpWageArray;

    // Constructer
    public EmpWageBuilderArray(int n) {
        companyEmpWageArray = new CompanyEmpWage[n];
    }

    public void addCompanyEmpWage(String company, int empRatePerHr, int noOfWorkingDays, int maxHrsPeronth) {
        companyEmpWageArray[numOfCompany] = new CompanyEmpWage(company, empRatePerHr, noOfWorkingDays, maxHrsPeronth);
        numOfCompany++;
    }

    public void computeEmpWage() {
        for (int i = 0; i < numOfCompany; i++) {
            companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
            System.out.println(companyEmpWageArray[i]);
        }
    }

    // Compute Wage method
    public int computeEmpWage(CompanyEmpWage companyEmpWage) {
        // Variables
        int empHrs = 0;
        int totalWorkingDays = 0;
        int totalEmpHrs = 0;

        // Computation
        System.out.println("Calculating Wage for Company: " + companyEmpWage.company);
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
}// End class EmpWageBuilder

