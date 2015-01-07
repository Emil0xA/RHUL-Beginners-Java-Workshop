package IntroToObjsClasses;

/**
 * Extension class of Student, including Bank accounts. 
 * 
 * @author Emil Tan
 */
public class StudentBankAccount extends Student {
	private BankAccount bankAcct; 
	
	public StudentBankAccount(String stuName, int stuAge, String stuGender) {
		super(stuName, stuAge, stuGender);
		bankAcct = new BankAccount(); 
	}
	
	public StudentBankAccount(String stuName, int stuAge, String stuGender, String stuDepartment) {
		super(stuName, stuAge, stuGender, stuDepartment);
		bankAcct = new BankAccount(); 
	}

	public StudentBankAccount(String stuName, int stuAge, String stuGender, int initialBankDeposit) {
		super(stuName, stuAge, stuGender);
		bankAcct = new BankAccount(initialBankDeposit); 
	}
	
	public StudentBankAccount(String stuName, int stuAge, String stuGender, String stuDepartment, int initialBankDeposit) {
		super(stuName, stuAge, stuGender, stuDepartment);
		bankAcct = new BankAccount(initialBankDeposit); 
	}
	
	public BankAccount getBankAcct() {
		return bankAcct; 
	}
}
