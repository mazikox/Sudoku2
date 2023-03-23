public class Main {
    public static void main(String[] args) {

        Plansza plansza = new Plansza();


        plansza.showPlansza();
//        plansza.showMozliwosci();

        System.out.println(plansza.checkIsItPossibleDigit(6));

        plansza.createResults();


        System.out.println(plansza.isLegal());

        plansza.showPlansza();
    }
}