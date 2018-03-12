package Task2;

/**
 * Created by prokhorind on 10.03.2018.
 */
public class Sort {
    public   int[] sort(int[] array ){

        int lastNegative= findNubmerOfNegativeValues(array);
       int[] input=dividePosAndNegValues(array,lastNegative);

        for(int i=0;i<input.length;i++){
            for(int j=0;j<input.length;j++){

                if(input[i]<0&&input[j]<0){

                    if(input[i]<input[j]){
                        int change=input[i];
                        input[i]=input[j];
                        input[j]=change;
                    }
                }
                else if(input[i]>0&&input[j]>0){

                    if(input[i]>input[j]){

                        int change=input[i];
                        input[i]=input[j];
                        input[j]=change;
                    }
                }

            }
        }

        return input;
    }

    private int[] dividePosAndNegValues(int[] input ,int lastNegative){
        for(int i=0;i<lastNegative;i++) {
            for (int j = i+1; j < input.length; j++) {

                if(input[j]<0){

                    int change=input[i];
                    input[i]=input[j];
                    input[j]=change;
                }
            }
        }
        return  input;
    }



    public int findNubmerOfNegativeValues(int[] input){
        int lastNegative=0;
        for(int i=0;i<input.length;i++) {
            if (input[i] < 0) {
                lastNegative += 1;
            }
        }
        return lastNegative;
    }


}
