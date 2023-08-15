package services;

import entities.ChessPiece;

//Soyutlanmış mimari tasarım: Strategy (Behavioral Pattern)
//Bu arayüz sayesinde satranç taşları puanlaması yapılırken kullanılacak olan skorlama stratejisi tanımlanabilir.
public interface ScoringStrategy {

    double calculateScore(ChessPiece piece, ChessPiece[][] board, int row, int col);
    
}