package perpustakaan

class Book(
    id: String,
    title: String,
    year: Int,
    val author: String,
    val pages: Int,
    val genre: String
) : Item(id, title, year) {

    override fun calculateFinePerDay(): Double {
        return 2000.0
    }

    override fun getItemType(): String {
        return "Buku"
    }

    override fun getMaxBorrowDays(): Int {
        return 14
    }

    override fun displayInfo() {
        super.displayInfo()
        println("Penulis     : $author")
        println("Halaman Buku: $pages")
        println("Genre       : $genre")
    }
}