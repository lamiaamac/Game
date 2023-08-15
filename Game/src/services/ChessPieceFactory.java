package services;

import entities.ChessPiece;

//Soyutlanmış mimari tasarım: Factory (Creational Patterns)
//Satranç taşları (Piyon, kale, fil...) için nesne oluşturulan sınıf (Fabrika sınıfı)
public class ChessPieceFactory {

    public ChessPiece createChessPiece(String abbreviation, String fullAbbreviation) {

        //Taşın kısaltması ("a", "f", "p"...) ile ait olduğu taş (At, Fil, Piyon...) puanı elde edilir.
        int piecePoints = ChessGame.getPointsByAbbreviation(abbreviation);

        //Yeni bir ChessPiece nesnesi (Satranç taşı) oluşturulur
        return new ChessPiece(ChessGame.getNameByAbbreviation(abbreviation), fullAbbreviation, piecePoints);
        
    }
}