package cinema


var income = 0
var rows: Int = 0
var seatsPerRow: Int = 0
var seats: Array<Array<String>> = arrayOf()
fun askTheaterSize() {
    println("Enter the number of rows:")
    rows = readln().toInt()
    println("Enter the number of seats in each row:");
    seatsPerRow = readln().toInt()

    seats = Array(rows) { row -> Array(seatsPerRow) { col -> "S" } }
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

    seats[row - 1][col - 1] = "B";
    return price;
}

fun showMenu() {
    println();

    while (true) {
        println("1. Show the seats")
        println("2. Buy a ticket")
        println("0. Exit")
        val option = readln().toInt()

        when (option) {
            1 -> printCinema()
            2 -> buyTicket()
            0 -> break
        }
    }
}

fun buyTicket() {
    println()
    println("Enter a row number:")
    val row = readln().toInt()
    println("Enter a seat number in that row:")
    val col = readln().toInt()

    println("Ticket price: $" + bookTicket(row, col))
    println();
}

fun main() {
    // write your code here
//    putSpace(seats)
//    printCinema(seats)

    askTheaterSize()
    showMenu()

//    if (rows * seatsPerRow <= 60) {
//        income = rows * seatsPerRow * 10;
//    } else {
//        var half = rows / 2;
//        if (rows % 2 == 0) {
//            income = half * seatsPerRow * 10;
//            income += half * seatsPerRow * 8;
//        } else {
//            income = half * seatsPerRow * 10;
//            income += (half + 1) * seatsPerRow * 8;
//
//        }
//    }
//
//    println("Total income:")
//    println("$$income")
}