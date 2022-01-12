import java.util.Scanner
class OverAccount extends Account {
  var Overdraft: Int = 2000

  //using method overriding to withdrew a money
  var scan = new Scanner(System.in)
  override def withdrew(): Unit = {
    println("Enter your account Number:")
    val accNum5 = scan.nextInt()
    val index15 = accountNum.indexOf(accNum5)
    println("Enter the amount you want to withdrew:")
    var withdrewAmnt = scan.nextInt()

    if (currentBal(index15) - withdrewAmnt < 2000) {
      println("Overdraft limit exceeded!")
    } else {
      currentBal(index15) -= withdrewAmnt
      println(
        "Transaction successful\n" + "" + "Remaining balance is: " + currentBal(
          index15
        )
      )
      println("-----------------No More overdraft--------------")
      println("-------------No More overdraft----------------")
      println("--------No More overdraft------------")
    }
  }

}
