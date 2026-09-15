# 📚 Sistem Manajemen Perpustakaan

Aplikasi berbasis **CLI (Command Line Interface)** yang dibangun menggunakan bahasa pemrograman **Kotlin** untuk membantu mengelola operasional perpustakaan.

Aplikasi ini mencakup pengelolaan koleksi item, pendaftaran anggota, transaksi peminjaman dan pengembalian, serta perhitungan denda keterlambatan secara otomatis.

> Proyek ini dibuat untuk memenuhi tugas mata kuliah **Pemrograman Berbasis Objek (OOP)**.

---

## 👤 Identitas Pembuat

| Informasi | Keterangan |
|---|---|
| Nama | Agisna Fadillah Islami |
| NIM | 225443028 |
| Program Studi | Teknologi Rekayasa Informatika Industri |
| Jurusan | Teknik Otomasi Manufaktur dan Mekatronika |
| Instansi | Politeknik Manufaktur Bandung (Polman Bandung) |

---

## ✨ Fitur Utama

Aplikasi ini memiliki beberapa fitur utama sebagai berikut:

- ✅ **Pendaftaran Anggota**  
  Menambahkan data anggota dan mencari anggota berdasarkan informasi tertentu.

- ✅ **Pengelolaan Koleksi Item**  
  Mengelola berbagai jenis koleksi perpustakaan, yaitu buku, jurnal, dan DVD.

- ✅ **Transaksi Peminjaman dan Pengembalian**  
  Mencatat proses peminjaman dan pengembalian item beserta status transaksinya.

- ✅ **Perhitungan Denda Keterlambatan**  
  Menghitung denda secara otomatis berdasarkan lama keterlambatan dan tarif denda per hari untuk setiap jenis item.

- ✅ **Laporan Statistik Perpustakaan**  
  Menampilkan ringkasan operasional perpustakaan, seperti jumlah item, anggota, transaksi, dan informasi terkait lainnya.

---

## 🧠 Konsep OOP dan Fitur Kotlin yang Digunakan

Aplikasi ini mengimplementasikan berbagai konsep utama dalam **Object-Oriented Programming (OOP)** serta memanfaatkan beberapa fitur penting dalam Kotlin.

| Konsep | Implementasi | Keterangan |
|---|---|---|
| **Abstraction & Inheritance** | Kelas abstrak `Item` diturunkan menjadi `Book`, `Journal`, dan `DVD` | Setiap jenis item memiliki aturan masing-masing, seperti lama peminjaman dan denda per hari. |
| **Encapsulation** | Properti penting seperti `isAvailable` pada `Item` menggunakan `private set` | Data internal objek lebih terlindungi dan tidak dapat diubah secara sembarangan. |
| **Polymorphism** | Override fungsi seperti `calculateFinePerDay()`, `getItemType()`, dan `getMaxBorrowDays()` | Setiap subclass dapat memiliki perilaku yang berbeda meskipun dipanggil melalui referensi yang sama. |
| **Sealed Class** | `TransactionStatus` memiliki subclass `Borrowed`, `Returned`, `Overdue`, dan `Cancelled` | Membatasi kemungkinan status transaksi sehingga lebih aman dan mudah dikelola. |
| **Null Safety** | Penggunaan tipe nullable dan penanganan null pada Kotlin | Menghindari error seperti `NullPointerException`. |
| **Smart Casting** | Digunakan pada pengecekan tipe data dan ekspresi kondisi | Mempermudah penanganan objek berdasarkan tipe atau status tertentu. |

---

## 📁 Struktur Direktori

Berikut adalah struktur proyek secara umum:

```text
src/
└── perpustakaan/
    ├── Item.kt               # Kelas abstrak dasar untuk item perpustakaan
    ├── Book.kt               # Subclass untuk item bertipe buku
    ├── Journal.kt            # Subclass untuk item bertipe jurnal
    ├── DVD.kt                # Subclass untuk item bertipe DVD
    ├── Member.kt             # Class untuk pengelolaan data anggota
    ├── Transaction.kt        # Class untuk logika transaksi peminjaman dan pengembalian
    ├── TransactionStatus.kt  # Sealed class untuk status transaksi
    ├── Library.kt            # Class utama sistem manajemen perpustakaan
    └── Main.kt               # Entry point program dan skenario pengujian
```

---

## 🔄 Status Transaksi

Status transaksi dimodelkan menggunakan `sealed class` agar lebih aman dan terstruktur.

| Status | Keterangan |
|---|---|
| `Borrowed` | Item sedang dipinjam oleh anggota. |
| `Returned` | Item telah dikembalikan oleh anggota. |
| `Overdue` | Peminjaman telah melewati batas waktu pengembalian. |
| `Cancelled` | Transaksi dibatalkan. |

---

## 💰 Aturan Denda

Perhitungan denda dibuat secara otomatis dengan ketentuan sebagai berikut:

- Denda dihitung ketika item dikembalikan melewati tanggal jatuh tempo.
- Lama keterlambatan dihitung dari selisih hari antara tanggal pengembalian dan tanggal jatuh tempo.
- Setiap jenis item dapat memiliki tarif denda per hari yang berbeda.
- Tarif denda per hari ditentukan melalui implementasi metode `calculateFinePerDay()` pada masing-masing subclass.

---

## 🚀 Cara Menjalankan Program

### 1. Menggunakan IntelliJ IDEA

Cara termudah untuk menjalankan program ini adalah melalui IDE seperti **IntelliJ IDEA**.

Langkah-langkah:

1. Buka proyek di IntelliJ IDEA.
2. Pastikan plugin Kotlin sudah aktif.
3. Buka file `Main.kt` pada folder `src/perpustakaan`.
4. Jalankan fungsi `main()` dengan menekan tombol **Run**.

### 2. Menggunakan Terminal (Opsional)

Jika Kotlin compiler sudah terpasang di sistem, program dapat dikompilasi melalui terminal.

Contoh perintah:

```bash
kotlinc src/perpustakaan/*.kt -include-runtime -d perpustakaan.jar
java -jar perpustakaan.jar
```

> Catatan: Jika struktur proyek atau konfigurasi compiler berbeda, sesuaikan perintah dengan lingkungan pengembangan yang digunakan.

---

## 🧪 Contoh Skenario Pengujian

Beberapa skenario yang dapat diuji pada aplikasi ini antara lain:

1. Mendaftarkan anggota baru ke dalam sistem.
2. Menambahkan koleksi item berupa buku, jurnal, dan DVD.
3. Melakukan peminjaman item oleh anggota.
4. Memeriksa perubahan status ketersediaan item setelah dipinjam.
5. Mengembalikan item tepat waktu atau terlambat.
6. Melihat perhitungan denda jika pengembalian melewati batas waktu.
7. Menampilkan laporan ringkasan operasional perpustakaan.

---

## 📌 Catatan

Proyek ini dibuat sebagai implementasi konsep **Object-Oriented Programming (OOP)** menggunakan Kotlin, dengan fokus pada:

- Struktur kelas yang jelas,
- Enkapsulasi data,
- Pewarisan dan polimorfisme,
- Pemanfaatan sealed class,
- Serta penggunaan fitur null safety dari Kotlin.
