import scala.collection.mutable.ListBuffer
import java.util.Scanner
import scala.io.StdIn.{readInt, readLine}

class Account {

  var custName = new ListBuffer[String]()
  custName += ("me", "you", "we")
  var currentBal = new ListBuffer[Int]()
  currentBal += (20000, 30000, 40000)
  var accountNum = new ListBuffer[Int]()
  accountNum += (1234, 5678, 9101)

  // details() method is used to show
  // the details of all customer
  def print(): Unit = {
    println(
      "Details of customer is\nNames of customer: " + custName +
        "\nBalance list" + "is respectively: " + currentBal +
        "\nAccount number is : " + accountNum +
        "\n--------------End of Information details--------------" +
        "\n--------------End of Information details--------------"
    )

  }

  // Used to add money to a particular account
  def deposit(): Unit = {
    var depositAmnt: Int = 0
    println("Enter the account number you want to deposit in: ")

    // readInt is used to take integer
    // value as input from user
    val acc_num1 = readInt()

    // indexOf() method returns the index
    // of particular element
    val index1 = accountNum.indexOf(acc_num1)
    println("Enter the amount you want to deposit: ")
    depositAmnt = readInt()
    currentBal(index1) += depositAmnt
    println(
      "Amount added successfully\nNew Balance is: " +
        currentBal(index1)
    )
    println("-----------------end of deposits--------------")
    println("-------------end of deposits----------------")
    println("--------end of deposits------------")
  }

  // Used to withdraw money from an account
  def withdrew(): Unit = {
    var withdramAmnt: Int = 0
    println(
      "Enter the account number " +
        "you want to withdraw from: "
    )
    val acc_num2 = readInt()
    val index2 = accountNum.indexOf(acc_num2)
    println("Enter the amount you want to withdraw: ")

    withdramAmnt = readInt()
    currentBal(index2) -= withdramAmnt
    println(
      "Money withdrawn successfully\n" +
        "Remaining balance is: " +
        currentBal(index2)
    )
    println("-----------------end of deposits--------------")
    println("-------------end of deposits----------------")
    println("--------end of deposits------------")
   
  }
}
