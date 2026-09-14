package perpustakaan

class DVD(
    id: String,
    title: String,
    year: Int,
    val director: String,
    val duration: String,
    val genre: String
) : Item(id, title, year) {

    override fun calculateFinePerDay(): Double {
        return 5000.0
    }

    override fun getItemType(): String {
        return "DVD"
    }

    override fun getMaxBorrowDays(): Int {
        return 3
    }

    override fun displayInfo() {
        super.displayInfo()
        println("Sutradara : $director")
        println("Durasi    : $duration")
        println("Genre DVD : $genre")
    }
}