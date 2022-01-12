import java.util.Scanner
class Savings  extends  Account{
    var interest : Double = 0;

    // I am going to create a method to calculate interest
     var scan = new Scanner(System.in)
    def interestAmnt(): Unit = {
        
        println("Enter your account number: ")

        val accNum3 = scan.nextInt()
        val index13 = accountNum.indexOf(accNum3)
        interest = (currentBal(index13)*2)/100
        println("Your interest amount is: " + interest)
        println("-----------------end of Interest--------------")
    println("-------------end of Interest----------------")
    println("--------end of Interest------------")
    }
    // Method used to view the details of any particular account using method overriding
    override def print(): Unit = {
        println("Enter the your account ")
        val accNum4 = scan.nextInt()
        val index14 = accountNum.indexOf(accNum4)
        println("Name of customer is: "+ custName(index14) +
        "\nAccount Number is: " + accountNum(index14) +
        "\nAccount Balance is: " + currentBal(index14))
        println("-----------------end of details info--------------")
        println("-------------end of details info----------------")
        println("--------end of details info------------")
    }
  
}
