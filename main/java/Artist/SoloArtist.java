package Artist;

import Artist.Artis;

/**
 *
 * @author hp
 */
public class SoloArtist extends Artis {


    // Tambahkan genre sebagai parameter konstruktor
    public SoloArtist(String nama, int umur, String genre, String tahunDebut) {
        super(nama, umur, genre, tahunDebut); // Panggil constructor superclass
       
    }

    @Override
    public void specialTalent() {
  
        System.out.println("Solo artist " + getNama() );
    }
}

