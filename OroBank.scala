import java.util.Scanner
import java.sql.DriverManager
import java.sql.Connection
object OroBank {
  def main(args: Array[String]): Unit = {
    var scan = new Scanner(System.in)

    // Object of all classes
    val obj1 = new Account()
    val obj2 = new Savings()
    val obj3 = new OverAccount()
    val obj4 = new Bank()

    val driver = "com.mysql.cj.jdbc.Driver"
    val url =
      "jdbc:mysql://localhost:3306/bankapp1" // Modify for whatever port you are running your DB on
    val username = "root"
    val password = "Reva2021!@my" // Update to include your password

    var connection: Connection = null

    println(
      "Enter 1 for account details, " +
        "2 for SavingsAccount, " +
        "3 for OverAccount and " +
        "4 for bank"
    )

    val choice = readInt()
    if (choice == 1) {
      obj1.print()
    }

    if (choice == 2) {
      println(
        "Enter 1 for checking the interest " +
          "amount and 2 if you want to see the " +
          "details of any particular account: "
      )

      val choice1 = readInt()
      if (choice1 == 1) {
        obj2.interestAmnt()

        try {
          // make the connection
          Class.forName(driver)
          connection = DriverManager.getConnection(url, username, password)

          //println("Welcome to Bank Of America")

          println("Please Enter your account number for confrimation:")

          var accNumb = scan.nextInt()
          scan.nextLine()
          println("Enter interest amount you see above :")
          var amount = scan.nextInt()

          println("Enter Balance you see above:")
          var balance = scan.nextInt()

          // create the statement, and run the select query
          val statement = connection.createStatement()
          var query =
            "Insert into interestList(AccNumb, Interest, Balance) values (" + accNumb + ", " + amount + ", " + balance + ");"
          println(query)
          statement.executeUpdate(
            query
          ) //("Insert into deposits(AccNumb, Deposit, Balance) values (" + accNumb + ", " + amount + ", " + balance + ");"
          val resultSet = statement.executeQuery(
            "SELECT * FROM interestList;"
          ) // Change query to your table
          while (resultSet.next()) {
            print(
              resultSet.getString(1) + " " + resultSet.getString(
                2
              ) + " " + resultSet.getString(3)
            )
            println()

          }

        } catch {
          case e: Exception => e.printStackTrace
        }

      } else if (choice == 2) {
        obj2.print()

      }

    }

    if (choice == 3) {
      println("Enter 1 for deposit and 2 for withdraw: ")
      val choice2 = readInt()

      if (choice2 == 1) {
        obj3.deposit()

        try {
          // make the connection
          Class.forName(driver)
          connection = DriverManager.getConnection(url, username, password)

          println("-------Store Deposit in the dbs depo1 table------------")

          println("Please Enter your account number for confirmation:")

          var accNumb = scan.nextInt()
          scan.nextLine()
          println("Please confirm your deposit:")
          var amount = scan.nextInt()

          println("Enter the balance you see above:")
          var balance = scan.nextInt()

          // create the statement, and run the select query
          val statement = connection.createStatement()
          var query =
            "Insert into depo1(AccNumb, Deposit, Balance) values (" + accNumb + ", " + amount + ", " + balance + ");"
          println(query)
          statement.executeUpdate(
            query
          ) //("Insert into deposits(AccNumb, Deposit, Balance) values (" + accNumb + ", " + amount + ", " + balance + ");"
          val resultSet = statement.executeQuery(
            "SELECT * FROM depo1;"
          ) // Change query to your table
          while (resultSet.next()) {
            print(
              resultSet.getString(1) + " " + resultSet.getString(
                2
              ) + " " + resultSet.getString(3)
            )
            println()

          }

        } catch {
          case e: Exception => e.printStackTrace
        }
        //connection.close()
      }

      if (choice2 == 2) {
        obj3.withdrew()

        try {
          // make the connection
          Class.forName(driver)
          connection = DriverManager.getConnection(url, username, password)

          println("---------Store WithDraw in the dbs withdraw table----------")

          println("Please Enter your account number for confirmation:")

          var accNumb = scan.nextInt()
          scan.nextLine()
          println("Please confirm your withdraw amount:")
          var amount = scan.nextInt()

          println("Enter the balance you see above:")
          var balance = scan.nextInt()

          // create the statement, and run the select query
          val statement = connection.createStatement()
          var query =
            "Insert into withdraw(AccNumb, Deposit, Balance) values (" + accNumb + ", " + amount + ", " + balance + ");"
          println(query)
          statement.executeUpdate(
            query
          )
          val resultSet = statement.executeQuery(
            "SELECT * FROM withdraw;"
          ) // Change query to your table
          while (resultSet.next()) {
            print(
              resultSet.getString(1) + " " + resultSet.getString(
                2
              ) + " " + resultSet.getString(3)
            )
            println()

          }

        } catch {
          case e: Exception => e.printStackTrace
        }
        //connection.close()
      }

    }
    if (choice == 4) {
      println(
        "Enter 1 for opening account " +
          "and 2 for closing an account: "
      )

      val choice3 = readInt()
      if (choice3 == 1) {
        obj4.opening()

        try {
          // make the connection
          Class.forName(driver)
          connection = DriverManager.getConnection(url, username, password)

          println(
            "---------Store Opening account in the dbs newAcct table----------"
          )

          println("Please Enter your account number for confirmation:")

          var accNumb = scan.nextInt()
          scan.nextLine()
          println("Please enter you name:")
          var name = scan.nextLine()

          println("Enter your opening balance :")
          var balance = scan.nextInt()

          // create the statement, and run the select query
          val statement = connection.createStatement()
          var query =
            "Insert into newAcct(AccNumb, Name, Balance) values (" + accNumb + ", " + name + ", " + balance + ");"
          println(query)
          statement.executeUpdate(
            query
          )
          val resultSet = statement.executeQuery(
            "SELECT * FROM newAcct;"
          ) // Change query to your table
          while (resultSet.next()) {
            print(
              resultSet.getString(1) + " " + resultSet.getString(
                2
              ) + " " + resultSet.getString(3)
            )
            println()

          }

        } catch {
          case e: Exception => e.printStackTrace
        }
        //connection.close()

      } else {
        obj4.closing()

        try {
          // make the connection
          Class.forName(driver)
          connection = DriverManager.getConnection(url, username, password)

          println(
            "---------Store Closing account in the dbs closeAcct table----------"
          )

          println("Please Enter your account number for confirmation:")

          var accNumb = scan.nextInt()
          scan.nextLine()
          println("Please enter you name:")
          var name = scan.nextLine()

          println("Enter your close balance :")
          var balance = scan.nextInt()

          // create the statement, and run the select query
          val statement = connection.createStatement()
          var query =
            "Insert into closeAcct(AccNumb, Name, Balance) values (" + accNumb + ", " + name + ", " + balance + ");"
          println(query)
          statement.executeUpdate(
            query
          )
          val resultSet = statement.executeQuery(
            "SELECT * FROM closeAcct;"
          ) // Change query to your table
          while (resultSet.next()) {
            print(
              resultSet.getString(1) + " " + resultSet.getString(
                2
              ) + " " + resultSet.getString(3)
            )
            println()

          }

        } catch {
          case e: Exception => e.printStackTrace
        }
        connection.close()
      }

    }

  }
}
