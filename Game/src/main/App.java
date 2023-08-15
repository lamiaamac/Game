package main;

import entities.ChessPiece;
import services.ChessGame;
import services.DefaultScoringStrategy;
import services.ChessPieceFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Uygulamanın ana sınıfı
public class App {
    public static void main(String[] args) {

        //Kullanıcıdan dosya ismini elde etme
        System.out.println("Lütfen satranç tahtasının bilgilerini içeren dosyanın adını giriniz (.txt uzantısı olmadan):");
        String fileName;
        Scanner scan = new Scanner(System.in);
        fileName = scan.nextLine();
        scan.close();

        try {

            // Dosya okuma işlemi
            File inputFile = new File(fileName + ".txt");
            Scanner scanner = new Scanner(inputFile);

            //Tahtanın boyutunu ölçme (Örn. 8x8)
            Scanner tempScanner = new Scanner(inputFile);
            int boardSize = 0;

            while (tempScanner.hasNext()) {

                tempScanner.nextLine();
                boardSize++;

            }

            tempScanner.close();

            //Satranç tahtasını temsil eden matris
            ChessPiece[][] board = new ChessPiece[boardSize][boardSize];

            //Dosya satırlarını okuyarak satranç tahtasını(matrisi) doldurma
            for (int i = 0; i < boardSize; i++) {

                String inputLine = scanner.nextLine();
                String[] pieces = inputLine.split(" ");

                for (int j = 0; j < boardSize; j++) {

                    if (!pieces[j].equals("--")) {

                        //Taşın tipinin kısaltması
                        String pieceAbbreviation = pieces[j].substring(0, 1);

                        //Taşın bütün kısaltması
                        String fullAbbreviation = pieces[j];

                        //Taş nesnesinin oluşturulması
                        ChessPieceFactory factory = new ChessPieceFactory();
                        ChessPiece piece = factory.createChessPiece(pieceAbbreviation, fullAbbreviation);
                        board[i][j] = piece;

                    }
                }
            }

            //Satranç oyunu örneği oluşturma (Sadece 1 örnek: Singleton)
            ChessGame chessGame = ChessGame.getInstance();
            //Satranç oyunu puan hesaplama stratejisinin belirlenmesi
            chessGame.setScoringStrategy(new DefaultScoringStrategy());

            double whiteScore = 0;
            double blackScore = 0;

            //Tahtadaki bütün taşları puanlama
            for (int row = 0; row < boardSize; row++) {

                for (int col = 0; col < boardSize; col++) {

                    //Belirlenen satranç taşı
                    ChessPiece piece = board[row][col];

                    if (piece != null) {

                        double pieceScore = chessGame.calculateScore(piece, board, row, col);

                        //Belirlenen taş hangi renge aitse o rengin skorunu arttırma
                        if (piece.getAbbreviation().substring(1).equals("b")) {

                            whiteScore += pieceScore;

                        } else if (piece.getAbbreviation().substring(1).equals("s")) {

                            blackScore += pieceScore;

                        }
                    }
                }
            }

            //Sonuçlar
            System.out.println("Beyaz Puanı: " + whiteScore);
            System.out.println("Siyah Puanı: " + blackScore);

            scanner.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();
            
        }
    }
}