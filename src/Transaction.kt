package perpustakaan

import java.time.LocalDate

class Transaction(
    val id: String,
    val item: Item,
    val member: Member,
    val borrowDate: String = LocalDate.now().toString(),
    var status: TransactionStatus = Borrowed
) {

    fun returnItem(daysLate: Int): Double {
        if (status.isFinal()) {
            println("Error: Transaksi dengan ID '$id' sudah tidak bisa diubah")
            return 0.0
        }

        item.returnItem()

        val fine = if (daysLate > 0) {
            status = Overdue(daysLate)
            daysLate * item.calculateFinePerDay()
        } else {
            status = Returned
            0.0
        }

        return fine
    }

    fun cancel() {
        if (status.isFinal()) {
            println("Error: Transaksi dengan ID '$id' Sudah Final dan Tidak Dapat Dibatalkan")
            return
        }

        status = Cancelled
        item.returnItem()
        println("Transaction '$id' Berhasil Dibatalkan")
    }

    fun displayTransaction() {
        println("=== Detail Transaksi ===")
        println("ID Transaksi : $id")
        println("Tanggal      : $borrowDate")
        println("Status       : ${status.display()}")
        println("Peminjam     : ${member.name}")
        println("Item         : ${item.title} (${item.getItemType()})")
    }
}