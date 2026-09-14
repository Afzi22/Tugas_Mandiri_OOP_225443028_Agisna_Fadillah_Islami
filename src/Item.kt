package perpustakaan

abstract class Item(
    val id: String,
    val title: String,
    val year: Int
) {
    var isAvailable: Boolean = true
        private set

    abstract fun calculateFinePerDay(): Double
    abstract fun getItemType(): String
    abstract fun getMaxBorrowDays(): Int

    fun borrow(): Boolean {
        return if (isAvailable) {
            isAvailable = false
            println("Item '$title' berhasil dipinjam")
            true
        } else {
            println("Item '$title' sedang tidak tersedia")
            false
        }
    }

    fun returnItem() {
        if (!isAvailable) {
            isAvailable = true
            println("Item '$title' berhasil dikembalikan")
        } else {
            println("Peringatan: Item '$title' tidak sedang dipinjam")
        }
    }

    open fun displayInfo() {
        println("=== Informasi Item ===")
        println("ID           : $id")
        println("Judul        : $title")
        println("Tahun        : $year")
        println("Jenis        : ${getItemType()}")
        println("Status       : ${if (isAvailable) "Tersedia" else "Dipinjam"}")
        println("Maks Pinjam  : ${getMaxBorrowDays()} hari")
        println("Denda / Hari : Rp${calculateFinePerDay()}")
    }
}