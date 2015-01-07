package IntroToObjsClasses;

/**
 * Use classes to create objects. 
 * 
 * @author Emil Tan
 */
public class Run {
	public static void main(String[] args) {
		Student studentA = new Student("Emil", 25, "M");
		studentA.changeDepartment("Computer Science");
		System.out.println(studentA.getName() + ", " + studentA.getAge() + ", " + studentA.getGender() + ", Department of " + studentA.getDepartment()); 
		
		studentA.changeDepartment("Information Security");
		System.out.println(studentA.getName() + "'s department has been to Department of " + studentA.getDepartment());
		
		System.out.println(); 
		
		Student studentB = new Student("Filippo", 20, "M", "Computer Science"); 
		System.out.println(studentB.getName() + ", " + studentB.getAge() + ", " + studentB.getGender() + ", Department of " + studentB.getDepartment());
		studentB.yearOlder();
		System.out.println(studentB.getName() + " is now " + studentB.getAge());
		
		System.out.println("--- --- --- --- --- ---");
		
		StudentBankAccount studentC = new StudentBankAccount("Alice", 21, "F", "Economics");
		System.out.println(studentC.getName() + ", " + studentC.getAge() + ", " + studentC.getGender() + ", Department of " + studentC.getDepartment());
		System.out.println("Balance: " + studentC.getBankAcct().getBalance());
		studentC.getBankAcct().deposit(100);
		System.out.println("Balance after deposit: " + studentC.getBankAcct().getBalance());
		
		System.out.println();
		
		StudentBankAccount studentD = new StudentBankAccount("Bob", 21, "M", 100); 
		System.out.println(studentD.getName() + ", " + studentD.getAge() + ", " + studentD.getGender());
		System.out.println("Balance " + studentD.getBankAcct().getBalance());
		studentD.getBankAcct().withdraw(20);
		System.out.println("Balance after withdrawal: " + studentD.getBankAcct().getBalance());
	}
}
