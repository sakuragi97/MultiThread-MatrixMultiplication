/*************
 *
 * Developped by: YASSER EL BACHIRI
 * E-mail: yasser.elbachiri@gmail.com
 *
 *
 */

public class ProduitMatricielle extends Thread{

    private int[][] matriceA;
    private int[][] matriceB;
    private int[][] result;
    private int ligne,col;
    private int dim;

    public ProduitMatricielle(int[][] matriceA, int[][] matriceB, int[][] result, int ligne, int col, int dim) {
        this.matriceA = matriceA;
        this.matriceB = matriceB;
        this.result = result;
        this.ligne = ligne;
        this.col = col;
        this.dim = dim;
    }


    public void run()
    {

        for(int i=0;i<dim;i++){
            result[ligne][col]+=matriceA[ligne][i]*matriceB[i][col];
        }
        System.out.println("** Thread "+ligne+","+col+" terminé **");
    }

}
