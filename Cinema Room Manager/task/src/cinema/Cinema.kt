package cinema

var rows: Int = 0
var seatsPerRow: Int = 0
var seats: Array<Array<String>> = arrayOf()
var totalSeats = 0
var currentIncome = 0

fun askTheaterSize() {
    println("Enter the number of rows:")
    rows = readln().toInt()
    println("Enter the number of seats in each row:");
    seatsPerRow = readln().toInt()

    seats = Array(rows) { row -> Array(seatsPerRow) { col -> "S" } }
    totalSeats = rows * seatsPerRow
}


fun printCinema() {
    println()
    println("Cinema:")
    print("  ")
    for (i in seats[0].indices) {
        print(i + 1)
        if (i < seats[0].size - 1) {
            print(" ")
        }
    }
    println()

    for (y in seats.indices) {
        print("${y + 1} ")
        for (x in seats[y].indices) {
            print(seats[y][x])
            if (x < seats[y].size - 1) {
                print(" ")
            }
        }
        println()
    }
    println()
}

fun bookTicket(row: Int, col: Int): Int {
    var price = 0

    if (rows * seatsPerRow <= 60) {
        price = 10;
    } else {
        var half = rows / 2
        if (row <= half) {
            price = 10;
        } else {
            price = 8;
        }
    }

    if (row < 1 || row > seats.size || col < 1 || col > seats[0].size) {
        return -1;
    } else if (seats[row - 1][col - 1] == "S") {
        seats[row - 1][col - 1] = "B";
        currentIncome += price;
        return price;
    }
    return 0;
}

fun getTotalBooked(): Int {
    var totalBooked = 0;

    for (y in seats.indices) {
        for (x in seats.indices) {
            if (seats[y][x].equals("B")) {
                totalBooked++;
            }
        }
    }
    return totalBooked;
}

fun calcTotalIncome(): Int {
    if (rows * seatsPerRow <= 60) {
        return totalSeats * 10;
    } else {
        var half = rows / 2;
        var totalPrice = rows / 2 * seatsPerRow * 10;
        totalPrice += ((rows / 2) + 1) * seatsPerRow * 8;
        return totalPrice;
    }
}

fun showMenu() {
    println();

    while (true) {
        println("1. Show the seats")
        println("2. Buy a ticket")
        println("3. Statistics")
        println("0. Exit")
        val option = readln().toInt()

        when (option) {
            1 -> printCinema()
            2 -> buyTicket()
            3 -> showStatistics()
            0 -> break
        }
    }
}

fun buyTicket() {
    while (true) {
        println()
        println("Enter a row number:")
        val row = readln().toInt()
        println("Enter a seat number in that row:")
        val col = readln().toInt()

        var price = bookTicket(row, col)
        if (price != 0 && price != -1) {
            println("Ticket price: $" + price)
            break;
        } else if (price == -1) {
            println("Wrong input!")
        } else {
            println("That ticket has already been purchased!")
        }

        System.out.println();
    }
}

fun showStatistics() {
    var totalBooked = getTotalBooked()

    println("Number of purchased tickets: " + totalBooked)
    if (totalBooked == 0) {
        println("Percentage: 0.00%")
    } else {
        var per = (totalBooked.toFloat() / totalSeats * 100)
        var msg = String.format("Percentage: %3.2f%%", per)
        println(msg)
    }
    println("Current income: $" + currentIncome)
    println("Total income: $" + calcTotalIncome())
    println()

}

fun main() {
    askTheaterSize()
    showMenu()

}
