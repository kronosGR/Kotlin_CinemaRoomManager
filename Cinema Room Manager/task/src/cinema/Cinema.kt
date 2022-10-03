package cinema


fun putSpace(arr: Array<Array<String>>) {
    for (y in arr.indices) {
        for (x in arr[y].indices) {
            arr[y][x] = "S"
        }
    }
}

fun printCinema(arr: Array<Array<String>>) {
    println("Cinema:")
    println("  1 2 3 4 5 6 7 8")
    for (y in arr.indices) {
        print("${y + 1} ")
        for (x in arr[y].indices) {
            print(arr[y][x])
            if (x < arr[y].size - 1) {
                print(" ")
            }
        }
        println()
    }
}

fun main() {
    // write your code here
    val seats: Array<Array<String>> = Array(7) { row -> Array(8) { col -> "S" } }
//    putSpace(seats)
//    printCinema(seats)
    var income = 0

    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seatsPerRow = readln().toInt()

    if (rows * seatsPerRow <= 60) {
        income = rows * seatsPerRow * 10;
    } else {
        var half = rows / 2;
        if (rows % 2 == 0) {
            income = half * seatsPerRow * 10;
            income += half * seatsPerRow * 8;
        } else {
            income = half * seatsPerRow * 10;
            income += (half + 1) * seatsPerRow * 8;

        }
    }

    println("Total income:")
    println("$$income")
}