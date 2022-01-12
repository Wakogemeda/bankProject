import java.util.Scanner
class Bank extends Account {

  // To open method for open account
  //
  def opening(): Unit = {
    var scan = new Scanner(System.in)
    var newCustomerName = scan.nextLine()
    custName += newCustomerName
    println("Enter the Opening Balance amount: ")
    var openingBalance = scan.nextInt()
    currentBal += openingBalance
    accountNum += 1908
    println("Good Job! added successfully")
    println("-----------------New acct--------------")
    println("-------------New acct----------------")
    println("--------New acct------------")

  }

  def closing(): Unit = {
    var scan = new Scanner(System.in)
    println("Enter your account Number: ")
    val accNum6 = scan.nextInt()
    val index16 = accountNum.indexOf(accNum6)
    custName -= custName(index16)
    currentBal -= currentBal(index16)
    accountNum -= accountNum(index16)
    println("I am sorry the account is removed.")
    println("-----------------Remove of acct--------------")
    println("-------------Remove of acct----------------")
    println("--------Remove of acct------------")
  }

}
