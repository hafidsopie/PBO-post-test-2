package management; 

import Artist.Artis;

/**
 *
 * @author hp
 */
public interface CRUD {
    void addArtist(Artis artist);
    void displayAllArtists();
    void deleteArtist(String name);
    void updateArtist(String nama, int umurBaru, String tahunDebutAtauGenre);
}

