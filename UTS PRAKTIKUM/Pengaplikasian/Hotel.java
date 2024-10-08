package Pengaplikasian;

import Class.Kamar;
import Class.Suite;
import Class.Reservasi;
import java.util.Scanner;

public class Hotel implements Reservasi {
    private Kamar kamar101;
    private Kamar kamar102;
    private Suite suite101;
    private String detailPesanan;

    public Hotel() {
        kamar101 = new Kamar("101", 500000);
        kamar102 = new Kamar("102", 600000);
        suite101 = new Suite("201", 1200000, "Kolam Renang");
        detailPesanan = "";
    }

    public void menuAdmin(Scanner scanner) {
        boolean isAdminRunning = true;
        while (isAdminRunning) {
            System.out.println("\n--- Menu Admin ---");
            System.out.println("1. Cek Ketersediaan Kamar");
            System.out.println("2. Ubah Status Kamar");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            int adminMenu = scanner.nextInt();
            scanner.nextLine();

            switch (adminMenu) {
                case 1:
                    cekKetersediaanKamar();
                    break;
                case 2:
                    ubahStatusKamar(scanner);
                    break;
                case 3:
                    isAdminRunning = false;
                    System.out.println("Keluar dari menu admin.");
                    break;
                default:
                    System.out.println("Menu tidak valid. Silakan coba lagi.");
            }
        }
    }

    public void ubahStatusKamar(Scanner scanner) {
        System.out.print("Masukkan nomor kamar yang ingin diubah statusnya (101/102/201): ");
        String nomorKamar = scanner.nextLine();

        if (nomorKamar.equals("101")) {
            kamar101.setTersedia(!kamar101.isTersedia());
            System.out.println("Status Kamar 101 berhasil diubah.");
        } else if (nomorKamar.equals("102")) {
            kamar102.setTersedia(!kamar102.isTersedia());
            System.out.println("Status Kamar 102 berhasil diubah.");
        } else if (nomorKamar.equals("201")) {
            suite101.setTersedia(!suite101.isTersedia());
            System.out.println("Status Suite 201 berhasil diubah.");
        } else {
            System.out.println("Nomor kamar tidak valid.");
        }
    }

    public void cekKetersediaanKamar() {
        System.out.println("\n--- Ketersediaan Kamar ---");
        System.out.println("Kamar 101: " + (kamar101.isTersedia() ? "Tersedia" : "Tidak Tersedia") + " - Harga: " + kamar101.getHarga());
        System.out.println("Kamar 102: " + (kamar102.isTersedia() ? "Tersedia" : "Tidak Tersedia") + " - Harga: " + kamar102.getHarga());
        System.out.println("Suite 201: " + (suite101.isTersedia() ? "Tersedia" : "Tidak Tersedia") + " - Harga: " + suite101.getHarga() + " - Fasilitas: " + suite101.getFasilitas());
    }

    public void pesanKamar(Scanner scanner) {
        System.out.print("Masukkan nomor kamar yang ingin dipesan (101/102/201): ");
        String nomorKamar = scanner.nextLine();

        if (nomorKamar.equals("101") && kamar101.isTersedia()) {
            kamar101.setTersedia(false);
            detailPesanan = "Kamar 101, Harga: " + kamar101.getHarga();
            System.out.println("Anda berhasil memesan " + detailPesanan);
        } else if (nomorKamar.equals("102") && kamar102.isTersedia()) {
            kamar102.setTersedia(false);
            detailPesanan = "Kamar 102, Harga: " + kamar102.getHarga();
            System.out.println("Anda berhasil memesan " + detailPesanan);
        } else if (nomorKamar.equals("201") && suite101.isTersedia()) {
            suite101.setTersedia(false);
            detailPesanan = "Suite 201, Harga: " + suite101.getHarga() + ", Fasilitas: " + suite101.getFasilitas();
            System.out.println("Anda berhasil memesan " + detailPesanan);
        } else {
            System.out.println("Kamar tidak tersedia atau sudah dipesan.");
        }
    }

    @Override
    public void lihatDetailPesanan() {
        if (detailPesanan.isEmpty()) {
            System.out.println("Belum ada pesanan.");
        } else {
            System.out.println("Detail Pesanan Anda: " + detailPesanan);
        }
    }

    @Override
    public void pesanKamar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
