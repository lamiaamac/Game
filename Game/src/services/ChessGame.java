package services;

import entities.ChessPiece;

//Soyutlanmış mimari tasarım: Singleton (Creational Patterns)
//Bu Singleton class'ı Satranç oyununda kullanılacak fonksiyonları temsil etmektedir.
public class ChessGame {

    //Singleton instance(örneği)
    private static ChessGame instance; 

    //Kullanılacak skorlama stratejisi belirlenir.
    private ScoringStrategy scoringStrategy;  

    //Constructor
    private ChessGame() {

        //Örnekleme engellenir ve kullanılmak istenen puanlama stratejisi atanır.
        scoringStrategy = new DefaultScoringStrategy();

    }

    //Hangi Singleton örneğinde olduğunu gösteren fonksiyon
    public static ChessGame getInstance() {

        //Böyle bir örnek yoksa yenisi oluşturulur.
        if (instance == null) {

            instance = new ChessGame();

        }

        return instance;

    }

    //Kullanılacak puanlama stratejisini ayarlayan fonksiyon
    public void setScoringStrategy(ScoringStrategy scoringStrategy) {

        this.scoringStrategy = scoringStrategy;

    }

    //Anlık olarak incelediğimiz satranç taşının puanını hesaplayan fonksiyon
    public double calculateScore(ChessPiece piece, ChessPiece[][] board, int row, int col) {

        //Belirlenen strateji ile puan hesaplama
        if (scoringStrategy != null) {

            return scoringStrategy.calculateScore(piece, board, row, col);

        }

        //Bir strateji belirlenmemişse gösterilecek davranış.
        return 0;

    }

    //Belirtilen satranç taşının kısaltması ile adını döndüren fonksiyon
    public static String getNameByAbbreviation(String abbreviation) {

        switch (abbreviation) {
            
            case "p":
                return "Piyon";

            case "a":
                return "At";

            case "f":
                return "Fil";

            case "k":
                return "Kale";

            case "v":
                return "Vezir";

            case "s":
                return "Şah";

            default:
                return "Bilinmeyen Taş";

        }
    }

    //Belirtilen satranç taşının kısaltması ile sahip olduğu puanı döndüren fonksiyon
    public static int getPointsByAbbreviation(String abbreviation) {

        switch (abbreviation) {

            case "p":
                return 1;

            case "a":
                return 3;

            case "f":
                return 3;

            case "k":
                return 5;

            case "v":
                return 9;

            case "s":
                return 100;
                
            default:
                return 0;  //Bilinmeyen taşın puanı etkilememesi için 0 puan

        }
    }
}