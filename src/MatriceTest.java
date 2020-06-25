/*************
 *
 * Developped by: YASSER EL BACHIRI
 * E-mail: yasser.elbachiri@gmail.com
 *
 *
 */



import java.util.*;


public class MatriceTest {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Nombre de ligne Matrice A: ");
        int N = scan.nextInt();
        System.out.print("Nombre de colonne Matrice A: ");
        int M = scan.nextInt();
        int[][] matriceA = new int[N][M];                    // Matrice A
        Random r = new Random();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matriceA[i][j] = r.nextInt(10);
            }
        }
        System.out.println();

        System.out.println("Valeurs de matrice A aléatoires :");
        for (int i = 0; i < N; i++) {                    //Afficher Matrice
            for (int j = 0; j < M; j++) {
                System.out.print(matriceA[i][j] + " | ");
            }
            System.out.println();
        }

        System.out.println();
        System.out.print("Nombre de ligne Matrice B: ");
        int N1 = scan.nextInt();
        System.out.print("Nombre de colonne Matrice B: ");
        int M1 = scan.nextInt();
        int[][] matriceB = new int[N1][M1];                // Matrice B

        for (int i = 0; i < N1; i++) {
            for (int j = 0; j < M1; j++) {
                matriceB[i][j] = r.nextInt(10);
            }
        }
        System.out.println();

        System.out.println("Valeurs de matrice B aléatoires :");
        for (int i = 0; i < N1; i++) {                    //Afficher Matrice
            for (int j = 0; j < M1; j++) {
                System.out.print(matriceB[i][j] + " | ");
            }
            System.out.println();
        }


        System.out.println();

        int[][] result1 = new int[N][M1]; //Initialisation Resultat ProduitMatricielle Single-Thread
        int[][] result2 = new int[N][M1]; //Initialisation Resultat ProduitMatricielle Multi-Thread

//        ProduitMatricielle Single-Thread
        if (M == N1) {
            for (int i = 0; i < N; i++) {                    //Multiplication
                for (int j = 0; j < M1; j++) {
                    for (int k = 0; k < N; k++) {
                        result1[i][j] += matriceA[i][k] * matriceB[k][j];
                    }
                }
            }

            System.out.println("Resultat Matrice Single-Thread size "+N+"X"+M1+" :");
            for (int i = 0; i < N; i++) {                    //Afficher Matrice
                for (int j = 0; j < M1; j++) {
                    System.out.print(result1[i][j] + " | ");
                }
                System.out.println();
            }
            System.out.println();



//        ProduitMatricielle Multi-Thread

        System.out.println("Calcul Matrice Multi-Thread...");
        ProduitMatricielle[][] thread = new ProduitMatricielle[N][M1];

        for(int i=0;i<N;i++) {
            for(int j=0;j<M1;j++) {
                thread[i][j]=new ProduitMatricielle(matriceA,matriceB,result2,i,j,M);
                thread[i][j].start();
            }
        }

        for(int i=0;i<N;i++) {
                for(int j=0;j<M1;j++) {
                    try{
                        thread[i][j].join();
                    } catch(InterruptedException e){
                        e.getStackTrace();
                    }
                }
        }

        System.out.println();
        System.out.println();
        System.out.println("Resultat Matrice Multi-Thread size "+N+"X"+M1+" :");
            for (int i = 0; i < N; i++) {                    //Afficher Matrice
                for (int j = 0; j < M1; j++) {
                    System.out.print(result2[i][j] + " | ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Math Error: Nous ne pouvons pas faire le produit matriciel!");
        }

    }
}