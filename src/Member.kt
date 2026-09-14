package perpustakaan

class Member(
    val id: String,
    val name: String,
    private val email: String,
    private val phone: String
) {
    private val transactions: MutableList<Transaction> = mutableListOf()

    val transactionCount: Int
        get() = transactions.size

    val totalFine: Double
        get() = transactions.sumOf { trx ->
            val currentStatus = trx.status
            if (currentStatus is Overdue) {
                currentStatus.daysLate * trx.item.calculateFinePerDay()
            } else {
                0.0
            }
        }

    val activeBorrow: Int
        get() = transactions.count { it.status is Borrowed }

    fun getEmail(): String = email
    fun getPhone(): String = phone

    fun borrowItem(item: Item): Transaction? {
        if (!item.isAvailable) {
            println("Item '${item.title}' sedang tidak tersedia")
            return null
        }

        item.borrow()

        val transactionId = "TRX-${System.currentTimeMillis()}"
        val newTransaction = Transaction(
            id = transactionId,
            item = item,
            member = this
        )

        transactions.add(newTransaction)
        println("Berhasil Meminjam '${item.title}'. ID Transaksi: $transactionId")
        return newTransaction
    }

    fun returnItem(item: Item, daysLate: Int = 0): Double {
        val targetTrx = transactions.find { it.item == item && it.status is Borrowed }

        if (targetTrx == null) {
            println("Tidak ditemukan peminjaman aktif untuk item '${item.title}'")
            return 0.0
        }

        return targetTrx.returnItem(daysLate)
    }

    fun getTransactions(): List<Transaction> = transactions.toList()

    fun displayInfo() {
        println("=== Detail Anggota ===")
        println("ID           : $id")
        println("Nama         : $name")
        println("Email        : $email")
        println("Telepon      : $phone")
        println("Total Pinjam : $transactionCount")
        println("Pinjam Aktif : $activeBorrow")
        println("Total Denda  : Rp$totalFine")
    }

    fun displayTransactions() {
        println("=== Transaksi Anggota ($name) ===")
        if (transactions.isEmpty()) {
            println("Belum Ada Riwayat Transaksi")
            return
        }
        for (trx in transactions) {
            trx.displayTransaction()
            println("------------------------------")
        }
    }
}