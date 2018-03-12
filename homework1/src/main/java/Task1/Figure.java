package Task1;

/**
 * Created by prokhorind on 09.03.2018.
 */
public class Figure {

    public void drawRectangle(int x, int y) {

        for (int i = 0; i < y; i++) {

            System.out.println();

            for (int j = 0; j < x; j++) {

                if ((j == 0 || j == (x - 1)) || (i == 0 || i == (y - 1))) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
        }
    }


    public void drawRightTriangle(int x, int y) {
        y += 1;

        double step;
        if (y > x) {
            step = (double) y / x;
        } else {
            step = (double) x / y;
        }

        for (int i = 0; i < y; i++) {
            System.out.println();



            for (int j = 0; j < i; j += step) {

                if ((i > 1 && i < (y - 1)) && (j > 0 && j < (i -1))) {
                    System.out.print("  ");
                } else {
                    System.out.print("* ");
                }
            }
        }
    }

    public void drawEquilateralTriangle(int x) {
        x++;
        for (int i = 0; i < x; i++) {
            System.out.println();

                System.out.print("  ");

            for (int j = x; j > i; j--)
            {
                System.out.print(" ");
            }

            for (int j = 0; j < i; j++) {
                if(j==0||j==i-1||i==x-1) {
                    System.out.print("* ");
                } else{
                    System.out.print("  ");
                }

            }
        }
    }

    void drawRhomb(int x){
        int c, k, space = 1;


        space = x - 1;

        for (k = 1; k<=x; k++)
        {
            for (c = 1; c<=space; c++) {
                System.out.print("  ");
            }

            space--;

            for (c = 1; c<= 2*k-1; c++) {
                if(c==1||c==2*k-1) {
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.print("\n");
        }

        space = 1;

        for (k = 1; k<= x - 1; k++)
        {
            for (c = 1; c<= space; c++) {
                System.out.print("  ");
            }

            space++;

            for (c = 1 ; c<= 2*(x-k)-1; c++)
                if(c==1||c==2*(x-k)-1) {
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }

            System.out.println("  ");
        }





        }
    }


