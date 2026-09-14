package perpustakaan

sealed class TransactionStatus {
    abstract fun display(): String

    fun isFinal(): Boolean {
        return this is Returned || this is Cancelled
    }
}

object Borrowed : TransactionStatus() {
    override fun display() = "Borrowed"
}

object Returned : TransactionStatus() {
    override fun display() = "Returned"
}

data class Overdue(val daysLate: Int) : TransactionStatus() {
    override fun display() = "Overdue ($daysLate hari)"
}

object Cancelled : TransactionStatus() {
    override fun display() = "Cancelled"
}