import java.util.Random;
public class TotalWithin extends Thread {
   String ThreadID = "";
   int No_of_Darts = 0;
   int dartsWithinRange = 0;
   public TotalWithin(int No_of_Darts, String ThreadID){
      this.No_of_Darts = No_of_Darts;
      this.ThreadID = ThreadID;
      System.out.println("Initialize" + " " + ThreadID + " " + "Thread" + " " + "and start it");
   }

   public void run(){
      Random r = new Random();
      for(int a = 0; a < No_of_Darts; a++){
         double x = r.nextDouble();
         double y = r.nextDouble();

         double dartDistance = Math.sqrt((x * x) + (y * y));
         if(dartDistance < 1){
            dartsWithinRange++;
         }
      }
   }

   public int getDartsWithinRange() {
      return dartsWithinRange;
   }
}
