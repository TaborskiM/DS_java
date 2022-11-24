import java.util.Scanner;
public class SudukoSolver {
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        //Création de la matrice Puzzle :
        int[][] Puzzle = new int[9][9];
        for(int i = 0; i < Puzzle.length; i++){
            Puzzle[i] = new int[9];
        }
        // un boucle do while pour repeter le remplissage de puzzle jusqu'a
        // l'utilisateur donne une puzzle correct
        do{
        //Remplissage de matrice Puzzle par l’utilisateur : 
        for(int i = 0; i < Puzzle.length; i++){
            for(int j = 0; j < Puzzle[i].length; j++){
                // On appelle la méthode nextInt() de l'objet scanner, qui retourne l'entier que l'on frappe au clavier.
                System.out.print(String.format("Entrez a[%d][%d] : ", i+1, j+1));
                Puzzle[i][j] = sc.nextInt();
            }
        }
        
        printSol(Puzzle);
        // une condition d'affichage si le puzzle est solvée :
        if (SolvePuzzle (Puzzle)){
            System.out.println("le solution de Matrice Puzzle est :");
            System.out.println("-----------------------------------");
        }
        // une condition d'affichage si le puzzle est impossible de solvée :
        else{
            System.out.println("\t \t le solution de Matrice Puzzle est Impossible !!!");
            System.out.println("-------------------------------------------------------");
        }
        printSol(Puzzle);
        }while(!SolvePuzzle (Puzzle));
        }
     // une methode pour l'affichage de puzzle :   
    private static void printSol(int[][] Puzzle){
        for(int row = 0; row < 9; row++){
            //ajouter des tire entre chaque ligne sauf ligne 0
            if(row %3 == 3 && row !=0){
                System.out.println("------------");
            }
            for(int col = 0; col < 9; col++){
            //ajouter de separation entre chaque colonne
                if(col %3 == 3 && col !=0){
                System.out.println("|");
            }
               System.out.print(Puzzle[row][col] + " ") ;
            }
            System.out.println();
         }
    }
    //une methode qui verifie si un nombre existe dans la ligne ;
    //qui return true si existe et false si non ;
    private static boolean isNumberInRow(int[][] Puzzle,int Nbre,int row){
        for(int i = 0; i < 9; i++){
            if (Puzzle[row][i] == Nbre){
                return true;
            }
        }
        return false;
    }
    //une methode qui verifie si un nombre existe dans la colonne ;
    //qui return true si existe et false si non ;
    private static boolean isNumberInCol(int[][] Puzzle,int Nbre,int col){
        for(int i = 0; i < 9; i++){
            if (Puzzle[i][col] == Nbre){
                return true;
            }
        }
        return false;
    }
    //une methode qui verifie si un nombre existe dans la matrice de taille 3*3 ;
    //qui return true si existe et false si non ;
    private static boolean isNumberInGrid(int[][] Puzzle,int Nbre,int row,int col){
       int currentRow = row - row % 3;
       int currentCol = col - col % 3;
       for(int i =currentRow ; i < currentRow + 3; i++){
           for(int j =currentCol ; j < currentCol + 3; j++){
               if (Puzzle[i][j] == Nbre){
                   return true;
               }
           } 
       }
       return false;
    }
    //une methode qui verifie si un nombre est valide dans ce place;
    private static boolean isValid(int[][] Puzzle,int Nbre,int row,int col){
    return !isNumberInRow(Puzzle, Nbre, row) && 
            !isNumberInCol(Puzzle , Nbre, col) && 
            !isNumberInGrid(Puzzle ,Nbre , row, col);
}
    // une methode qui solve le matrice puzzle introduire par l'utilisateur;
    // c'est une fonction recurssive
    private static boolean SolvePuzzle(int[][] Puzzle){
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                if (Puzzle[row][col] == 0){
                    for(int k = 1; k <= 9; k++){
                        if(isValid(Puzzle, k, row, col)){
                            Puzzle[row][col] = k ;
                            
                            if(SolvePuzzle(Puzzle)){
                                return true ;
                            }
                            else{
                                Puzzle[row][col] = 0 ;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
        
