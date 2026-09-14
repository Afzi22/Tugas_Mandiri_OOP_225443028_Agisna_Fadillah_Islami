# Sistem Manajemen Perpustakaan (Library Management System)

Aplikasi berbasis *Command Line Interface* (CLI) untuk mengelola operasional perpustakaan—mulai dari manajemen koleksi item, pendaftaran anggota, transaksi peminjaman dan pengembalian, hingga kalkulasi denda keterlambatan secara otomatis.

Proyek ini dibuat untuk memenuhi tugas mata kuliah **Pemrograman Berbasis Objek (OOP)** menggunakan bahasa pemrograman **Kotlin**.

---

## 👤 Identitas Pembuat

* **Nama**: Agisna Fadillah Islami
* **NIM**: 225443028
* **Program Studi**: Teknologi Rekayasa Informatika Industri
* **Jurusan**: Teknik Otomasi Manufaktur dan Mekatronika
* **Instansi**: Politeknik Manufaktur Bandung (Polman Bandung)

---

## 🛠️ Konsep OOP & Fitur Utama

Aplikasi ini mengimplementasikan konsep utama OOP serta fitur unggulan Kotlin:

* **Abstraction & Inheritance**: Kelas abstrak `Item` sebagai dasar yang diturunkan ke kelas spesifik `Book`, `Journal`, dan `DVD`.
* **Encapsulation**: Perlindungan data internal (seperti properti `isAvailable` pada `Item` dengan `private set`, serta variabel sensitif pada `Member`).
* **Polymorphism**: Override fungsi `calculateFinePerDay()`, `getItemType()`, dan `getMaxBorrowDays()` pada tiap jenis item sesuai aturan per-kategori.
* **Sealed Class**: Pemodelan hierarki status transaksi (`Borrowed`, `Returned`, `Overdue`, `Cancelled`) menggunakan `TransactionStatus`.
* **Smart Casting & Null Safety**: Penanganan tipe data dan ekspresi kondisi yang aman dari *null pointer exception*.
* **Fitur Aplikasi**:
  * Pendaftaran dan pencarian anggota.
  * Pengelolaan koleksi item (buku, jurnal, DVD).
  * Sistem transaksi peminjaman dan pengembalian item.
  * Perhitungan denda Keterlambatan berbasis tarif item per hari.
  * Laporan statistik ringkasan operasional perpustakaan.

---

## 📁 Struktur Direktori

```text
src/
└── perpustakaan/
    ├── Item.kt               # Abstract class dasar item perpustakaan
    ├── Book.kt               # Subclass untuk item Buku
    ├── Journal.kt            # Subclass untuk item Jurnal
    ├── DVD.kt                # Subclass untuk item DVD
    ├── Member.kt             # Class pengelolaan data anggota
    ├── Transaction.kt        # Class logika transaksi
    ├── TransactionStatus.kt  # Sealed class status transaksi
    ├── Library.kt            # Class utama sistem manajemen perpustakaan
    └── Main.kt               # Entry point program & skenario pengujian
