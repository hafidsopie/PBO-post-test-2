package Management;

import Artist.*;
import management.management; 
import java.util.Scanner;
/**
 *
 * @author hp
 */
public class main { 

    private static Object tahun_debut;
    public static void main(String[] args) {
        management management = new management(); 
        try (Scanner scanner = new Scanner(System.in)) {
            boolean berjalan = true;
            while (berjalan) {
                System.out.println("+======================================+");
                System.out.println("|          Menu Manajemen KPOP         |");
                System.out.println("+======================================+");
                System.out.println("|1. Tambah Solo Artis          ");
                System.out.println("|2. Tambah Grup Artis");
                System.out.println("|3. Lihat Semua Artis");
                System.out.println("|4. Hapus Artis");
                System.out.println("|5. Update Data Artis");
                System.out.println("|6. Keluar");
                System.out.println("=======================================");
                System.out.print("Pilih opsi: ");
                int opsi = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (opsi) {
                    case 1 -> {
                        System.out.println("=========| Tambah Solo Artis |=========");
                        System.out.print("Masukkan nama solo artis: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan umur artis: ");
                        int umur = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Masukkan genre musik: ");
                        String genre = scanner.nextLine();
                        
                        Artis artisBaru = new SoloArtist(nama, umur, genre, ""); 
                        management.addArtist(artisBaru);
                        System.out.println("Solo artis berhasil ditambahkan.");
                        System.out.println("=======================================");
                    }
                    
                    case 2 -> {
                        System.out.println("=========| Tambah Grup Artis |=========");
                        System.out.print("Masukkan nama grup: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan tahun debut: ");
                        String tahunDebut = scanner.nextLine();
                        System.out.print("Masukkan genre musik: ");
                        String genre = scanner.nextLine();
                        
                        
                        Artis artisBaru = new GroupArtist(nama, tahunDebut, genre);
                        management.addArtist(artisBaru);
                        System.out.println("Grup artis berhasil ditambahkan.");
                        System.out.println("=======================================");
                    }
                    
                    case 3 -> {
                        System.out.println("===========| Daftar Artis |============");
                        management.displayAllArtists();
                        
                    }
                    
                    case 4 -> {
                        System.out.println("==========| Menghapus Artis |===========");
                        System.out.print("Masukkan nama artis yang ingin dihapus: ");
                        String namaArtis = scanner.nextLine();
                        management.deleteArtist(namaArtis); // Pastikan metode deleteArtist sudah terdefinisi
                        System.out.println("Artis berhasil dihapus.");
                        System.out.println("========================================");
                    }
                    
                   case 5 -> {
                        System.out.println("=========| Memperbarui Data Artis |=========");
                        System.out.print("Masukkan nama artis yang ingin diupdate: ");
                        String namaUpdate = scanner.nextLine();

                        boolean ditemukan = false;  

                        for (Artis artist : management.daftarArtis) { 
                            if (artist.getNama().equalsIgnoreCase(namaUpdate)) {
                                ditemukan = true;
                                if (artist instanceof SoloArtist) {
                                    System.out.print("Masukkan umur baru: ");
                                    int umurBaru = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.print("Masukkan genre baru: ");
                                    String genreBaru = scanner.nextLine();
                                    scanner.nextLine();
                                    artist.setGenre(genreBaru);
                                    artist.setUmur(umurBaru); 
                                    System.out.println("Data solo artis berhasil diperbarui.");
                                } else if (artist instanceof GroupArtist) {
                                    System.out.print("Masukkan genre musik baru: ");
                                    String genreBaru = scanner.nextLine();
                                    ((GroupArtist) artist).setGenre(genreBaru); 
                                    System.out.println("Data grup artis berhasil diperbarui.");
                                }
                                break; // Keluar dari loop setelah ditemukan dan diperbarui
                            }
                        }

                        if (!ditemukan) {
                            System.out.println("Artis tidak ditemukan!");
                        }

                        System.out.println("=============================================");
                    }

                    case 6 -> {
                        berjalan = false;
                        System.out.println("+==================================================+");
                        System.out.println("|  TERIMA KASIH SAMPAI JUMPA LAGI, TATA TITI TUTU  |");
                        System.out.println("+==================================================+");
                    }
                    
                    default -> System.out.println("Opsi tidak valid. Silakan pilih lagi.");
                }
            }
        }
    }
}
