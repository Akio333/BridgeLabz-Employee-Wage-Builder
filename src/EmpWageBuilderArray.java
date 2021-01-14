import java.util.LinkedList;
import java.util.HashMap;
public class EmpWageBuilderArray implements EmpWageCalculation {
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    // Variables
    private LinkedList<CompanyEmpWage> companyEmpWageList;
    private HashMap<String,CompanyEmpWage> companyToEmpWage;

    // Constructer
    public EmpWageBuilderArray(int n) {
        companyEmpWageList = new LinkedList<>();
        companyToEmpWage = new HashMap<>();
    }

    public void addCompanyEmpWage(String company, int empRatePerHr, int noOfWorkingDays, int maxHrsPeronth) {
        CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHr, noOfWorkingDays, maxHrsPeronth);
        companyEmpWageList.add(companyEmpWage);
        companyToEmpWage.put(company,companyEmpWage);
    }

    public void computeEmpWage() {

        for (int i = 0; i < companyEmpWageList.size(); i++) {
            CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
            companyEmpWage.setTotalEmpWage(this.computeEmpWage(companyEmpWage));
            System.out.println("");
            companyEmpWage.printDailyWage();
            System.out.println("");
            System.out.println(companyEmpWage);
        }
    }

    public int getTotalWage(String company){
        return companyToEmpWage.get(company).totalEmpWage;
    }

    // Compute Wage method
    public int computeEmpWage(CompanyEmpWage companyEmpWage) {
        // Variables
        int empHrs = 0;
        int totalWorkingDays = 0;
        int totalEmpHrs = 0;
        companyEmpWage.dailyWage = new int[companyEmpWage.noOfWorkingDays];
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
            companyEmpWage.dailyWage[totalWorkingDays-1] = empHrs * companyEmpWage.empRatePerHr;
            System.out.println("Day: " + totalWorkingDays + "\tEmp Hr: " + empHrs);
        } // End While
        return totalEmpHrs * companyEmpWage.empRatePerHr;
    } // End computeEmpWage
}// End class EmpWageBuilder

