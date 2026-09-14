package perpustakaan

class Library(
    val name: String
) {
    private val items: MutableList<Item> = mutableListOf()
    private val members: MutableList<Member> = mutableListOf()
    private val transactions: MutableList<Transaction> = mutableListOf()

    val totalItems: Int
        get() = items.size

    val availableItems: Int
        get() = items.count { it.isAvailable }

    val totalMembers: Int
        get() = members.size

    val totalTransactions: Int
        get() = transactions.size

    fun addItem(item: Item) {
        items.add(item)
        println("Berhasil Menambahkan item '${item.title}'")
    }

    fun addItems(vararg newItems: Item) {
        for (item in newItems) {
            addItem(item)
        }
    }

    fun findItem(id: String): Item? {
        return items.find { it.id.equals(id, ignoreCase = true) }
    }

    fun searchItems(keyword: String): List<Item> {
        return items.filter {
            it.id.contains(keyword, ignoreCase = true) ||
                    it.title.contains(keyword, ignoreCase = true)
        }
    }

    fun registerMember(id: String, name: String, email: String, phone: String): Boolean {
        if (findMember(id) != null) {
            println("ID Anggota '$id' Sudah Digunakan")
            return false
        }

        val newMember = Member(id, name, email, phone)
        members.add(newMember)
        println("Berhasil Mendaftarkan Anggota '$name' (ID: $id)")
        return true
    }

    fun findMember(id: String): Member? {
        return members.find { it.id.equals(id, ignoreCase = true) }
    }

    fun borrowItem(memberId: String, itemId: String): Transaction? {
        val member = findMember(memberId)
        val item = findItem(itemId)

        if (member == null) {
            println("Error: Anggota dengan ID '$memberId' tidak ditemukan.")
            return null
        }

        if (item == null) {
            println("Error: Item dengan ID '$itemId' tidak ditemukan.")
            return null
        }

        val transaction = member.borrowItem(item)
        if (transaction != null) {
            transactions.add(transaction)
        }
        return transaction
    }

    fun returnItem(memberId: String, itemId: String, daysLate: Int = 0): Double {
        val member = findMember(memberId)
        val item = findItem(itemId)

        if (member == null) {
            println("Error: Anggota dengan ID '$memberId' tidak ditemukan.")
            return 0.0
        }

        if (item == null) {
            println("Error: Item dengan ID '$itemId' tidak ditemukan.")
            return 0.0
        }

        return member.returnItem(item, daysLate)
    }

    fun displayAllItems() {
        println("=== Daftar Semua Item ($name) ===")
        println("Total Item: $totalItems | Tersedia: $availableItems")
        println("----------------------------------------")
        if (items.isEmpty()) {
            println("Belum ada item di perpustakaan.")
            return
        }
        for (item in items) {
            item.displayInfo()
            println("----------------------------------------")
        }
    }

    fun displayAvailableItems() {
        println("=== Daftar Item Tersedia ===")
        val availableList = items.filter { it.isAvailable }
        if (availableList.isEmpty()) {
            println("Tidak ada item yang sedang tersedia.")
            return
        }
        for (item in availableList) {
            println("- [${item.id}] ${item.title} (${item.getItemType()})")
        }
    }

    fun displayAllMembers() {
        println("=== Daftar Anggota ($name) ===")
        if (members.isEmpty()) {
            println("Belum ada anggota terdaftar.")
            return
        }
        for (member in members) {
            member.displayInfo()
            println("----------------------------------------")
        }
    }

    fun displayAllTransactions() {
        println("=== Daftar Semua Transaksi ($name) ===")
        if (transactions.isEmpty()) {
            println("Belum ada transaksi di perpustakaan.")
            return
        }
        for (trx in transactions) {
            trx.displayTransaction()
            println("----------------------------------------")
        }
    }

    fun displayReport() {
        val borrowedItemsCount = totalItems - availableItems
        val totalFinesAllMembers = members.sumOf { it.totalFine }

        println("========================================")
        println("       LAPORAN RINGKASAN PERPUSTAKAAN   ")
        println("========================================")
        println("Nama Perpustakaan : $name")
        println("Total Item        : $totalItems")
        println("Item Tersedia     : $availableItems")
        println("Item Dipinjam     : $borrowedItemsCount")
        println("Total Anggota     : $totalMembers")
        println("Total Transaksi   : $totalTransactions")
        println("Total Denda       : Rp$totalFinesAllMembers")
        println("========================================")
    }
}