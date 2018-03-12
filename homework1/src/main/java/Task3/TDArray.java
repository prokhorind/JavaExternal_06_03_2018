package Task3;

/**
 * Created by kleba on 10.03.2018.
 */
public class TDArray {

    private int[][] input;
    private int x;
    private int y;



    public TDArray(int x, int y) {
        this.x=x;
        this.y=y;
        input= new int[y][x];
    }



    public int[][] getInput() {
        return input;
    }

    public void setInput(int[][] input) {
        this.input = input;
    }

    public void initialize(int min,int max){

        for(int i=0;i<y;i++){
            for(int j=0;j<x;j++){
                input[i][j]= (int) (min+ max* Math.random());
            }
        }

    }

    public void compareLines() {
        int currentLine=0;
        int nextLine=0;
        int n=0;
        for (int i = 0; i < y; i++) {

            currentLine = numberOfMaxEqualElements(i);
            for (int j = 0; j < y; j++) {

               nextLine=numberOfMaxEqualElements(j);

                if (currentLine > nextLine) {
                    changeLines(i,j);



                }

            }



        }



    }

    public void changeLines(int y,int j){

        if(y==0) {
            return;
        }
        else {

            int change = 0;
            for (int i = 0; i < x; i++) {

                change = input[y][i];
                input[y][i] = input[j][i];
                input[j][i] = change;

            }
        }

    }

    private int  numberOfMaxEqualElements(int k){
        int current=0;

        int currentCounter=0;
        int previousCounter=0;
        int result=0;



        for(int i=0;i<x;i++){
            currentCounter=0;

            for(int j=0;j<x;j++){

                if(input[k][i]==input[k][j]){
                    currentCounter++;
                }

            }

            if (currentCounter>previousCounter){
                previousCounter=currentCounter;

                result=previousCounter;
            }


        }

        return result;
    }

    public void sort(){
        boolean check=false;
        int i=0;
        int sum=0;
        double av=0;
        double prevAv=0;
        for (int j = 0; j < x;) {

            while(i<y) {
                sum+=input[i][j];
                i++;
            }
            prevAv=av;
            av=(double)sum/y;

            if((av>prevAv)&&j!=0){
                check=true;
                for(int d=0;d<y;d++) {

                    int change = input[d][j];
                    input[d][j] = input[d][j - 1];
                    input[d][j - 1] = change;
                }
                check=true;


            }
            j++;
            i=0;
            sum=0;
        }

        if(check==false){
            return;
        }
        else{
            sort();
        }


        }


        public void selectValuesByHelix(){

            int l=0;
            int w=x-1;
            int i=0,j=0;

            for(int m=0;m<y;m++) {
                for (int n = 0; n < x; n++)
                {
                    System.out.print(input[i][j]);
                    if ((i == (l + 1)) && (j == l)) {
                        w--;
                        l++;
                    }
                    if ((j == w) && (i < w)) {
                        i++;
                        continue;
                    }
                    if ((j < w) && (i == l)) {
                        j++;
                        continue;
                    }
                    if ((i == w) && (j > l)) {
                        j--;
                        continue;
                    }
                    if ((j == l) && (i > l)) {
                        i--;
                        continue;
                    }

                }
            }

            return ;

        }



    public void print(){
        for(int i=0;i<y;i++){

            for(int j=0;j<x;j++){
                System.out.print(input[i][j]);

            }
            System.out.println();
        }
    }


}
