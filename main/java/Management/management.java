package management; 

import Artist.*;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public final class management implements CRUD {
    public  ArrayList<Artis> daftarArtis = new ArrayList<>();
    public static int jumlahArtis = 0;
    private Iterable<Artis> artists;
    private String genreBaru;

  
    @Override
    public void addArtist(Artis artist) {
        daftarArtis.add(artist);
        jumlahArtis++;
        System.out.println(artist.getNama() + " telah ditambahkan.");
    }

    
    @Override
    public void displayAllArtists() {
        if (daftarArtis.isEmpty()) {
            System.out.println("Tidak ada artis yang terdaftar.");
        } else {
            for (Artis artist : daftarArtis) {
                if (artist instanceof SoloArtist soloArtist) {
                    System.out.println("Solo Artis : " + soloArtist.getNama() );
                    System.out.println("Umur       : " + soloArtist.getUmur() );
                    System.out.println("Genre musik: " + soloArtist.getGenre());
                    System.out.println("=======================================");
                } else if (artist instanceof GroupArtist groupArtist) {
                    System.out.println("Grup Artis : " + groupArtist.getNama()); 
                    System.out.println("Tahun Debut: " + groupArtist.getTahunDebut()); 
                    System.out.println("Genre musik: " + groupArtist.getGenre());
                    System.out.println("=======================================");
                }
            }
        }
    }

    
    @Override
    public void deleteArtist(String nama) {
        boolean ditemukan = false;
        for (Artis artist : daftarArtis) {
            if (artist.getNama().equalsIgnoreCase(nama)) {
                daftarArtis.remove(artist);
                jumlahArtis--;
                System.out.println(nama + " telah dihapus.");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Artis tidak ditemukan!");
        }
    }

    @Override
    public void updateArtist(String nama, int umurBaru, String tahunDebutAtauGenre) {
        boolean ditemukan = false;
        for (Artis artist : daftarArtis) {
            if (artist.getNama().equalsIgnoreCase(nama)) {
                if (artist instanceof SoloArtist soloArtist) {
                    soloArtist.setGenre(genreBaru);
                    soloArtist.setUmur(umurBaru);
                    System.out.println("Data solo artis " + nama );
                    System.out.println("Telah diperbarui dengan umur baru: " + umurBaru );
                    System.out.println("Telah diperbarui dengan genre baru: " + genreBaru);
                } else if (artist instanceof GroupArtist groupArtist) {
                    // Jika GroupArtist, perbarui genre musik
                    groupArtist.setGenre(tahunDebutAtauGenre);
                    System.out.println("Data grup artis " + nama );
                    System.out.println(" telah diperbarui dengan genre baru: " + tahunDebutAtauGenre);
                }
                ditemukan = true;
                break;
            }
        }
    if (!ditemukan) {
        System.out.println("Artis tidak ditemukan!");
    }
}
    public static int getJumlahArtis() {
        return jumlahArtis;
    }
}
