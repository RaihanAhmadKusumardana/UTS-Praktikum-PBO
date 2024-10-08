package Class;

public class Kamar {
    private String nomorKamar;
    private double harga;
    private boolean tersedia;

    public Kamar(String nomorKamar, double harga) {
        this.nomorKamar = nomorKamar;
        this.harga = harga;
        this.tersedia = true;
    }

    public String getNomorKamar() {
        return nomorKamar;
    }

    public double getHarga() {
        return harga;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }
}
