package entities;

//Bu class satranç taşlarını temsil eder ve bilgilerini barındırır.
public class ChessPiece {

    //Satranç taşının adı
    private String name;

    //Satranç taşının kısaltması
    private String abbreviation;

    //Satranç taşının puanı
    private int points;  

    //Constructor
    //Satranç taşının adı, kısaltması ve puanı ile oluşturulur
    public ChessPiece(String name, String abbreviation, int points) {

        this.name = name;
        this.abbreviation = abbreviation;
        this.points = points;

    }

    //Satranç taşının elde edildiği fonksiyon
    public String getName() {
        
        return name;

    }

    //Satranç taşının kısaltmasının elde edildiği fonksiyon
    public String getAbbreviation() {

        return abbreviation;

    }

    //Satranç taşının puanının elde edildiği fonksiyon
    public int getPoints() {

        return points;

    }

    //Bu fonksiyon ile satranç taşının tehdit altında olup olmadığı belirlenir.
    public boolean isThreatened(ChessPiece[][] board, int row, int col) {

        //Kontrol edilen satranç taşı
        ChessPiece piece = board[row][col];

        //Satranç taşının rengi
        String pieceColor = piece.getAbbreviation().substring(1);

        //Bütün rakip taşların kontrol edilmesi
        for (int r = 0; r < board.length; r++) { //Row

            for (int c = 0; c < board[0].length; c++) { //Column

                //Rakip taş
                ChessPiece opponentPiece = board[r][c];

                //Kontrol edilen taş ile rakip taş aynı renkte değilse kontrol edilir.
                if (opponentPiece != null && !opponentPiece.getAbbreviation().substring(1).equals(pieceColor)) {

                    //Rakip taşın, kontrol edilen taşı tehdit edip edememesinin kontrolü
                    if (canThreaten(opponentPiece, r, c, row, col, board)) {

                        return true;

                    }
                }
            }
        }

        return false;

    }

    //Rakip taşın (Sadece Piyon, At ve Vezir için), kontrol edilen taşı tehdit edip edememesini kontrol eden fonksiyon
    private boolean canThreaten(ChessPiece attacker, int attackerRow, int attackerCol, int targetRow, int targetCol, ChessPiece[][] board) {

        //Rakip taş ve kontrol edilen taşın satırları arasındaki fark
        int rowDiff = Math.abs(targetRow - attackerRow);

        //Rakip taş ve kontrol edilen taşın sütunları arasındaki fark
        int colDiff = Math.abs(targetCol - attackerCol);

        //Rakip taşın tipine göre (Piyon, At ve Vezir) tehdit durumunu kontrol etme
        switch (attacker.getAbbreviation().charAt(0)) {

            case 'p':

                // Piyon tehdit kontrolü
                if (rowDiff == 1 && colDiff == 1) {

                    return true;

                }

                break;

            case 'a':

                // At tehdit kontrolü
                if ((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2)) {

                    return true;

                }

                break;

            case 'v':

                // Vezir tehdit kontrolü
                if (attackerRow == targetRow || attackerCol == targetCol || rowDiff == colDiff) {

                    // Attacker ile hedef arasındaki taşları kontrol et
                    int rowStep = (targetRow > attackerRow) ? 1 : ((targetRow < attackerRow) ? -1 : 0);
                    int colStep = (targetCol > attackerCol) ? 1 : ((targetCol < attackerCol) ? -1 : 0);

                    int currentRow = attackerRow + rowStep;
                    int currentCol = attackerCol + colStep;

                    while (currentRow != targetRow || currentCol != targetCol) {

                        if (board[currentRow][currentCol] != null) {

                            //Rakip taş ile kontrol edilen taşın arasında başka bir taş varsa tehdit yoktur
                            return false;

                        }

                        currentRow += rowStep;
                        currentCol += colStep;

                    }

                    return true;

                }

                break;

        }

        return false;

    }
}