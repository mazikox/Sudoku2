import java.util.Random;

public class Plansza {

    int oriPlansza[][] = new int[3][3];
    int copyPlansza[][] = new int[3][3];


    public Plansza() {
        Random random = new Random();
        oriPlansza[0][0] = 8;
        oriPlansza[0][1] = 0;
        oriPlansza[0][2] = 3;
        oriPlansza[1][0] = 0;
        oriPlansza[1][1] = 6;
        oriPlansza[1][2] = 9;
        oriPlansza[2][0] = 0;
        oriPlansza[2][1] = 5;
        oriPlansza[2][2] = 4;
        createCopy();
    }

    public int[][] createCopy(){
        for (int i = 0; i < copyPlansza.length; i++) {
            System.arraycopy(oriPlansza[i], 0, copyPlansza[i], 0, oriPlansza[1].length);
        }
        return oriPlansza;
    }


    public void showPlansza(){
        for (int[] ints : copyPlansza) {
            for (int j = 0; j < copyPlansza[0].length; j++) {
                System.out.print(ints[j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void showMozliwosci(){
        boolean isSomething = false;
        for (int i = 0; i < copyPlansza.length; i++) {
            for (int j = 0; j < copyPlansza[0].length; j++) {
                if(copyPlansza[i][j] == 0 ){
                    System.out.println("Mozliwe do zmiany: " + "[" + i + "] [" + j + "]");
                    isSomething = true;
                }
            }
        }
        if (!isSomething){
            System.out.println("Brak mozliwosci");
        }
    }

    public void createResults(){
        Random random = new Random();
        int counter = 0;
        int randomDigit;
        while(!isLegal()){
            for (int i = 0; i < copyPlansza.length; i++) {
                for (int j = 0; j < copyPlansza[0].length; j++) {
                    if(copyPlansza[i][j] == 0 ){
                        do{
                            randomDigit = random.nextInt(9) + 1; // GENERUJE LICZBE OD 1 DO 9
                            System.out.println(randomDigit);
                        }while(!checkIsItPossibleDigit(randomDigit));
                        copyPlansza[i][j] = randomDigit;

                    }
                }
            }
            counter++;
            if(!isLegal()){
                createCopy();
            }
        }
        System.out.println(counter);
    }

    public boolean checkIsItPossibleDigit(int digit){
        for (int i = 0; i < oriPlansza.length; i++) {
            for (int j = 0; j < oriPlansza[0].length; j++) {
                if(oriPlansza[i][j] == digit ){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean canChange(int a, int b, int value){
        for (int i = 0; i < copyPlansza.length; i++) {
            for (int j = 0; j < copyPlansza[0].length; j++) {
                if(copyPlansza[i][j] == 0 && i==a && j==b){
                    copyPlansza[i][j] = value;
                    return true;
                }
            }
        }
        return false;
    }




    public boolean isLegal(){
        return (copyPlansza[0][0] + copyPlansza[0][1] + copyPlansza[0][2] + copyPlansza[1][0] + copyPlansza[1][1] + copyPlansza[1][2]
                + copyPlansza[2][0] + copyPlansza[2][1] + copyPlansza[2][2]) == 45;
    }
}
