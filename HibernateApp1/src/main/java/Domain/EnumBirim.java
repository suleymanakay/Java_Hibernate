package Domain;

public enum EnumBirim {
    ADET("Adet"),
    KILO("Kılo"),
    LITRE("Lıtre"),
    PORSIYON("Porsıyon"),
    PAKET("Paket");
    private final String birim;

    EnumBirim(String birim) {
        this.birim = birim;
    }

    public String getTuru() {
        return birim;
    }
}
