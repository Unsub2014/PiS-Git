package blatt2.aufgabe2;

public class Teilnehmer {
    String name;
    int telefon;

    public Teilnehmer(String name, int telefonnummer){
        this.name = name;
        this.telefon = telefonnummer;
    }

    public String getName() {
        return name;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefonnummer) {
        this.telefon = telefonnummer;
    }

    public void setName(String name) {
        this.name = name;
    }
}
