package Artist;


/**
 *
 * @author hp
 */
public class GroupArtist extends Artis {
    private final String genre;

    public GroupArtist(String nama, String tahunDebut, String genre) {
        super(nama, 0, genre, tahunDebut);  
        this.genre = genre;  
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public void specialTalent() {
        System.out.println("Grup artis dengan genre: " + genre);
    }
}
