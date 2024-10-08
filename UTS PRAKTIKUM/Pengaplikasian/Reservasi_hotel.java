package Pengaplikasian;

import java.util.Scanner;

public class Reservasi_hotel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();
        mainMenu(scanner, hotel);
        scanner.close();
    }

    private static void mainMenu(Scanner scanner, Hotel hotel) {
        System.out.println("\nSelamat datang di Aplikasi Reservasi Hotel!");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Customer");
        System.out.println("3. Keluar");
        System.out.print("Pilih menu: ");
        
        int menu = scanner.nextInt();
        scanner.nextLine();

        switch (menu) {
            case 1:
                hotel.menuAdmin(scanner);
                mainMenu(scanner, hotel); // Mengulangi menu utama setelah admin selesai
                break;
            case 2:
                customerMenu(scanner, hotel);
                break;
            case 3:
                System.out.println("Terima kasih telah menggunakan Aplikasi Reservasi Hotel.");
                return; // Keluar dari program
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                mainMenu(scanner, hotel); // Mengulangi menu utama jika input tidak valid
        }
    }

    private static void customerMenu(Scanner scanner, Hotel hotel) {
        System.out.println("\n--- Menu Customer ---");
        System.out.println("1. Pesan Kamar");
        System.out.println("2. Cek Ketersediaan Kamar");
        System.out.println("3. Lihat Detail Pesanan");
        System.out.println("4. Keluar");
        System.out.print("Pilih menu: ");

        int customerMenu = scanner.nextInt();
        scanner.nextLine();

        switch (customerMenu) {
            case 1:
                hotel.pesanKamar(scanner);
                customerMenu(scanner, hotel); // Mengulangi menu customer setelah selesai memesan
                break;
            case 2:
                hotel.cekKetersediaanKamar();
                customerMenu(scanner, hotel); // Mengulangi menu customer setelah mengecek ketersediaan
                break;
            case 3:
                hotel.lihatDetailPesanan();
                customerMenu(scanner, hotel); // Mengulangi menu customer setelah melihat detail
                break;
            case 4:
                System.out.println("Keluar dari menu customer.");
                return; // Keluar dari menu customer
            default:
                System.out.println("Menu tidak valid. Silakan coba lagi.");
                customerMenu(scanner, hotel); // Mengulangi menu customer jika input tidak valid
        }
    }
}
