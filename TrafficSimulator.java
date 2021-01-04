import java.util.*;
import java.io.*;

// written by kyra lee 2019
public class TrafficSimulator
{
   public static char randomLetter()
   {
      int num = (int)(Math.random() * 26);
      if(Math.random() < 0.5)
         return (char)('a' + num);
      return (char)('A' + num);
   }
   public static void main (String [] args) throws IOException
   {
      int[] list = new int[4];	
      Scanner input = new Scanner(new FileReader("TrafficSimFile.txt"));
      int i=0;											
      int line;	
      while (input.hasNextLine())				
      {
         line = input.nextInt();					
         list[i]= line;								
         i++;											
      }
      input.close();	
      
      int mainLight = list[0];
      int mainProb = list[1];
      int mapleLight = list[2];
      int mapleProb = list[3];
      
      MyQueue <String> mainQueue = new MyQueue();
      MyQueue <String> mapleQueue = new MyQueue();
      
      Scanner in = new Scanner (System.in);
      System.out.println("How many light cycles do you want?");
      int lightCycles = in.nextInt();
      
      for(int t = 0; t < lightCycles; t++)
      {
         int totalCars = 0;
         for(int main = 0; main < mainLight; main++) // main st light
         {
            System.out.println("Main Street (GREEN):" + mainQueue.toString());
            System.out.println("Maple Street (RED):" + mapleQueue.toString());
            if((int)(Math.random() * 100) < mainProb)
            {
               totalCars++;
               Car x = new Car(String.valueOf(randomLetter()));
               mainQueue.add(x.name());
            }
            if((int)(Math.random() * 100) < mapleProb)
            {
               totalCars++;
               Car x = new Car(String.valueOf(randomLetter()));
               mapleQueue.add(x.name());
            }
            if(!(mainQueue.isEmpty()))
               mainQueue.remove();
         }
         for(int maple = 0; maple < mapleLight; maple++) // main st light
         {
            System.out.println("Main Street (RED):" + mainQueue.toString());
            System.out.println("Maple Street (GREEN):" + mapleQueue.toString());
            if((int)(Math.random() * 100) < mainProb)
            {
               totalCars++;
               Car x = new Car(String.valueOf(randomLetter()));
               mainQueue.add(x.name());
            }
            if((int)(Math.random() * 100) < mapleProb)
            {
               totalCars++;
               Car x = new Car(String.valueOf(randomLetter()));
               mapleQueue.add(x.name());
            }
            if(!(mapleQueue.isEmpty()))
               mapleQueue.remove();
         }
         System.out.println("Total cars that made it through the intersection: " + totalCars);
      }
   }
}


