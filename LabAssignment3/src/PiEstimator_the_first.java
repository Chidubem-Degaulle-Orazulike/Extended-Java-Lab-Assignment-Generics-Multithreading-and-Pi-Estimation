public class PiEstimator_the_first {
    public static void main(String[] args) throws InterruptedException{
        float billion_Darts = 1000000000f;
        TotalWithin Thread1 = new TotalWithin((int) (billion_Darts/4), "First");
        TotalWithin Thread2 = new TotalWithin((int) (billion_Darts/4), "Second");
        TotalWithin Thread3 = new TotalWithin((int) (billion_Darts/4), "Third");
        TotalWithin Thread4 = new TotalWithin((int) (billion_Darts/4), "Fourth");

        Thread1.start();
        Thread2.start();
        Thread3.start();
        Thread4.start();

        Thread1.join();
        Thread2.join();
        Thread3.join();
        Thread4.join();
        System.out.println(Thread1.getDartsWithinRange() + Thread2.getDartsWithinRange() + Thread3.getDartsWithinRange() + Thread4.getDartsWithinRange());
        int TotalSum = Thread1.getDartsWithinRange() + Thread2.getDartsWithinRange() + Thread3.getDartsWithinRange() + Thread4.getDartsWithinRange();

        double Pi_Estimation = (double)TotalSum/billion_Darts * 4;
        System.out.println("Pi estimation is approximately" + " " + Pi_Estimation);
    }
}