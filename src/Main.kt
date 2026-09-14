package perpustakaan

fun main() {
    // 1. Inisialisasi
    println("==================================================")
    println("1. INISIALISASI PERPUSTAKAAN")
    println("==================================================")
    val library = Library("Perpustakaan Kampus")

    // 2. Tambah Item
    println("\n==================================================")
    println("2. TAMBAH ITEM")
    println("==================================================")
    val book1 = Book("B001", "Pemrograman Kotlin", 2023, "Budi Santoso", 350, "Programming")
    val book2 = Book("B002", "Dasar-Dasar OOP", 2022, "Siti Rahayu", 280, "Education")

    val journal1 = Journal("J001", "Jurnal Teknologi Informasi", 2023, "ITB", 15, 2)
    val journal2 = Journal("J002", "Jurnal Pendidikan", 2022, "UGM", 10, 1)

    val dvd1 = DVD("D001", "Inception", 2010, "Christopher Nolan", "148 menit", "Sci-Fi")
    val dvd2 = DVD("D002", "The Matrix", 1999, "Wachowski", "136 menit", "Action")

    library.addItems(book1, book2, journal1, journal2, dvd1, dvd2)

    // 3. Registrasi Anggota
    println("\n==================================================")
    println("3. REGISTRASI ANGGOTA")
    println("==================================================")
    library.registerMember("M001", "Ahmad Fauzi", "ahmad@email.com", "08123456789")
    library.registerMember("M002", "Dewi Lestari", "dewi@email.com", "08129876543")
    library.registerMember("M003", "Rizky Pratama", "rizky@email.com", "08125678901")

    // 4. Tampilkan Semua Item
    println("\n==================================================")
    println("4. TAMPILKAN SEMUA ITEM")
    println("==================================================")
    library.displayAllItems()

    // 5. Peminjaman (Skenario A)
    println("\n==================================================")
    println("5. PEMINJAMAN (SKENARIO A)")
    println("==================================================")
    library.borrowItem("M001", "B001") // Ahmad meminjam "Pemrograman Kotlin"
    library.borrowItem("M001", "D001") // Ahmad meminjam "Inception"
    library.borrowItem("M002", "J001") // Dewi meminjam "Jurnal Teknologi Informasi"
    library.borrowItem("M003", "B002") // Rizky meminjam "Dasar-Dasar OOP"

    // 6. Tampilkan Item Tersedia
    println("\n==================================================")
    println("6. TAMPILKAN ITEM TERSEDIA")
    println("==================================================")
    library.displayAvailableItems()

    // 7. Tampilkan Transaksi Anggota
    println("\n==================================================")
    println("7. TAMPILKAN TRANSAKSI ANGGOTA")
    println("==================================================")
    val ahmad = library.findMember("M001")
    val dewi = library.findMember("M002")

    ahmad?.displayTransactions()
    dewi?.displayTransactions()

    // 8. Pengembalian (Skenario B)
    println("\n==================================================")
    println("8. PENGEMBALIAN (SKENARIO B)")
    println("==================================================")
    library.returnItem("M001", "B001", daysLate = 0)
    library.returnItem("M002", "J001", daysLate = 3)

    // 9. Tampilkan Transaksi Setelah Pengembalian
    println("\n==================================================")
    println("9. TAMPILKAN TRANSAKSI SETELAH PENGEMBALIAN")
    println("==================================================")
    ahmad?.displayTransactions()
    dewi?.displayTransactions()

    // 10. Demonstrasi Polimorfisme
    println("\n==================================================")
    println("10. DEMONSTRASI POLIMORFISME")
    println("==================================================")
    val sampleItems: List<Item> = listOf(book1, journal1, dvd1)
    for (item in sampleItems) {
        println("${item.getItemType()} - Denda/hari: Rp ${item.calculateFinePerDay().toInt()}")
    }

    // 11. Demonstrasi Sealed Class
    println("\n==================================================")
    println("11. DEMONSTRASI SEALED CLASS")
    println("==================================================")
    val statusList: List<TransactionStatus> = listOf(
        Borrowed,
        Returned,
        Overdue(5),
        Cancelled
    )

    for (status in statusList) {
        val output = when (status) {
            is Borrowed -> status.display()
            is Returned -> status.display()
            is Overdue -> status.display()
            is Cancelled -> status.display()
        }
        println(output)
    }

    // 12. Demonstrasi Smart Casting
    println("\n==================================================")
    println("12. DEMONSTRASI SMART CASTING")
    println("==================================================")
    val targetItem: Item? = library.findItem("B001")

    if (targetItem != null) {
        when (targetItem) {
            is Book -> println("Item ${targetItem.id} adalah Buku")
            is Journal -> println("Item ${targetItem.id} adalah Jurnal")
            is DVD -> println("Item ${targetItem.id} adalah DVD")
        }

        val dvdCast = targetItem as? DVD
        println("Hasil casting '${targetItem.title}' ke DVD: $dvdCast")
    }

    // 13. Demonstrasi Enkapsulasi
    println("\n==================================================")
    println("13. DEMONSTRASI ENKAPSULASI")
    println("==================================================")
    println("[Bukti Enkapsulasi Protecting Data]")
    println("1. Properti 'isAvailable' pada Item tidak bisa diubah langsung dari luar (private set).")
    println("2. Properti 'email' pada Member tidak bisa diakses langsung dari luar (private val). Akses wajib melalui getter: '${ahmad?.getEmail()}'")

    // 14. Tampilkan Laporan Akhir
    println("\n==================================================")
    println("14. TAMPILKAN LAPORAN AKHIR")
    println("==================================================")
    library.displayReport()
}