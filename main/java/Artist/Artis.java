package Artist; 


/**
 *
 * @author hp
 */
public abstract class Artis {
    private String nama;
    private int umur;
    private String genre; 
    private final String tahun_debut; 
    
    public Artis(String nama, int umur, String genre, String tahun_debut) {
        this.nama = nama;
        this.umur = umur;
        this.genre = genre;
        this.tahun_debut = tahun_debut;
    }

    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getGenre() {
        return genre; 
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public final String getTahunDebut() {
        return tahun_debut;  // Getter for the final field
    }

    public void displayInfo() {
        System.out.println("Name: " + nama);
        System.out.println("Age: " + umur);
        System.out.println("Genre: " + genre);
        System.out.println("Tahun Debut: " + tahun_debut);
    }

    public abstract void specialTalent();
}
