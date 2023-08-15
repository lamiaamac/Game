package services;

import entities.ChessPiece;

//Default (varsayılan) skorlama stratejisi bu class ile uygulanabilir.
public class DefaultScoringStrategy implements ScoringStrategy {
    
    @Override
    public double calculateScore(ChessPiece piece, ChessPiece[][] board, int row, int col) {

        //Eğer taş tehdit altındaysa yarı puan, değilse tam puan verilir.
        if (piece.isThreatened(board, row, col)) {

            return piece.getPoints() / 2.0;
            
        } else {

            return piece.getPoints();

        }
    }
}