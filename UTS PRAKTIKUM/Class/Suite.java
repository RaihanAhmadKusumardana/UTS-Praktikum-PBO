package Class;

public class Suite extends Kamar {
    private String fasilitas;

    public Suite(String nomorKamar, double harga, String fasilitas) {
        super(nomorKamar, harga);
        this.fasilitas = fasilitas;
    }

    public String getFasilitas() {
        return fasilitas;
    }
}
