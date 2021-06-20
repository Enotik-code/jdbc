package by.jrr.jdbc.part1.repos.parents;

public class App {
    public static void main(String[] args) {
        Rodetel rodetel = new Rodetel(12);
        Dochka dochka = new Dochka( 14);
        System.out.println(dochka.toString());
        System.out.println(rodetel.toString());
    }
}
