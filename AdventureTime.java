import java.io.*;
import java.util.Scanner;





public class AdventureTime {

   static Scanner userInput = new Scanner(System.in);

   
   
   
   public static void main (String[] args) throws IOException { 
      
      // Methods to be called in chronological order
      double PercentageFirstPart = FirstPart();
      
      double PercentageSecondPart = SecondPart();
      
      double UserPerf = ((PercentageFirstPart + PercentageSecondPart)/2);
      
      System.out.println("Grand master wizard says over all ur percentage is: " + (PercentageFirstPart + PercentageSecondPart)/2 + 
                         "\nYour progress has angered him, prepare to face the consequences");
      
      // sends user performance data to the third part, helps with boss fight depending on how well they did on the previous two parts
      ThirdPart(UserPerf);
      
   }
   
   
   
   
   
      
   public static double FirstPart()throws IOException {
      //these are variables to track stats about user performance
      BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
      double CorrectAnswers = 0;
      double FalseAnswers = 0;
      //base number increases the base number that the user multiplies with
      int BaseNumber = 0;
      double PercentageCorrect = 0;
      System.out.println("Enter the correct answer 5 times and you will be permitted to proceed.");
         //loop runs until user answers correctly 5 times
         while (CorrectAnswers < 5) {
         
         userInput = new Scanner(System.in);
         int RNG1 = (int)(Math.random() * 10 + BaseNumber);
         int RNG2 = (int)(Math.random() * 10 + BaseNumber);
         int Answer = RNG1 * RNG2;
         System.out.println("What is " + RNG1 + "*" + RNG2 + " equal to?" + Answer);
            
            if (userInput.hasNextInt()){
            
            int UserAnswerInt = userInput.nextInt();
            
               if (UserAnswerInt == Answer) {
               
               CorrectAnswers++;
               BaseNumber += 2;
               System.out.println("Correct! You have " + CorrectAnswers + " correct answers");
               
               }
               
               else {
                
               FalseAnswers++;
                  
                  if (BaseNumber >= 0) {
                  
                  BaseNumber -= 1;
                  
                  }
                  
               System.out.println("Incorrect! You have " + CorrectAnswers + " correct answers");
               
               }
          
            }
            
            else {
            // to catch incorrect inputs
            System.out.println("Incorrect input, answer with an integer next time.");
            
            }
            
         }
         
         //end loop
         // this calculates on a percentage basis user performance and returns it to the main method
         PercentageCorrect = (CorrectAnswers/(CorrectAnswers + FalseAnswers))*100;
         System.out.println("Percentage correct: " + PercentageCorrect + "% \nCorrect: " + CorrectAnswers + "\nFalse: " + FalseAnswers);
         
            if (PercentageCorrect >= 66) {
            
            System.out.println("wow ur pretty smart");
            System.out.println("------------------------------------");
            
            }
            
            else if (PercentageCorrect <= 33) {
            
            System.out.println("wow ur actually not that smart");
            System.out.println("------------------------------------");
            
            }
            
            else if (PercentageCorrect > 33 && PercentageCorrect < 66) {
            
            System.out.println("ur intelligence is quite average");
            System.out.println("------------------------------------");
            
            }
            return PercentageCorrect;
      
      }     
       
      
      
      
      
      public static double SecondPart()throws IOException {
      //user stats and the list of countries and capitals 
      BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
      double CorrectAnswers = 0;
      double FalseAnswers = 0;
      double PercentageCorrect = 0;
      int RNG = 0; 
      String[] Countries = {"Denmark", "Greece", "England", "Antigua and Barbuda", "Argentina", "Oman", "Romania", "Rwanda", "South Korea", "Spain", "Sudan", "Germany", "Hungary"};
      String[] Capitals = {"Copenhagen", "Athens", "London", "Saint John's", "Buenos Aires", "Muscat", "Bucharest", "Kigali", "Seoul", "Madrid", "Khartoum", "Berlin", "Budapest"};
      int NumberOfCountries = Countries.length;
      int LoopCounter = 0;
         //this loop asks the user the capital of a country 
         while (LoopCounter < NumberOfCountries) {
         
         System.out.println("What is the capital of " + Countries[LoopCounter] + "?");
         String UserAnswer = br.readLine();
         
            if (UserAnswer.equals(Capitals[LoopCounter])) {
            
            LoopCounter++;
            CorrectAnswers++;
            System.out.println("Correct!");
            
            }
            
            else {
            
            LoopCounter++;
            FalseAnswers++;
            System.out.println("False!");
            
            }
         
         }
         //end loop 
         //determine user performance and return to main method 
         PercentageCorrect = (CorrectAnswers/(CorrectAnswers + FalseAnswers))*100;
         System.out.println("Percentage correct: " + PercentageCorrect + "% \nCorrect: " + CorrectAnswers + "\nFalse: " + FalseAnswers);
         System.out.println("------------------------------------");

      
      
      return PercentageCorrect;
      }
      
      


   public static double ThirdPart(double UserPerformance)throws IOException {
   //player and boss stats 
   BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
   int WizardHealth = 1000;
   int PlayerHealth = 1000;
   int WizardAttack = 10;
   int PlayerAttack = 10;
   int AttackGained = 0;
   System.out.println("You have angered grand master wizard and he will now fight you to the death" +
                      "\nWizard Health: " + WizardHealth +
                      "\nYour Health: " + PlayerHealth + 
                      "\nWizard Attack: " + WizardAttack + 
                      "\nYour Attack: " + PlayerAttack + 
                      "\n------------------------------------------------------------------------");
   
      //start boss fight loop 
      while (WizardHealth > 0) {
      // variables to determine whether wizard will attack or charge his attack 
      int WizardStanceRNG = (int)(Math.random()*2);
      boolean WizardChargingAttack = false;
      boolean WizardAttacking = false;
      
         if (WizardStanceRNG > 0) {
         
            WizardChargingAttack = true;
            WizardAttacking = false;
         
         }
         
         else if (WizardStanceRNG == 0) {
         
            WizardChargingAttack = false;
            WizardAttacking = true;
         
         }
         
         if (WizardChargingAttack == true) {
            //if the wizard is charging his attack the player can either attack him or charge his own attack 
            System.out.println("The wizard is charging his attack!");
            System.out.println("Press 1 to attack him for " + PlayerAttack + " damage." +
                               "\nPress 2 to charge your own special powers and gain attack power.");
            String UserAnswer = br.readLine();
            String NOne = "1";
            String NTwo = "2";
               
               if (UserAnswer.equals(NOne)) {
                  
                  WizardHealth -= PlayerAttack;
                  System.out.println("You have chosen to attack! You Deal: " + PlayerAttack + " damage to the wizard." + 
                                     "\nHe now has: " + WizardHealth + " health left."); 
                  
               
               }
               
               else if (UserAnswer.equals(NTwo)) {
                  
                     if (UserPerformance > 66) {   
                     
                     AttackGained = 15;
                     PlayerAttack += AttackGained;
                     
                     }
                     
                     else { 
                     
                     AttackGained = 10;
                     PlayerAttack +=AttackGained;
                     
                     }
                    
                  WizardAttack += 10;
                  System.out.println("You have chosen to wait, you gain " + AttackGained + " attack points. The wizard also gains 10 attack points." + 
                                     "\nWizard Attack: " + WizardAttack + 
                                     "\nYour Attack: " + PlayerAttack);
                                 
               }
         
         }
         
         else if (WizardAttacking = true) {
               //the wizard attacks the player and the player can either choose to take the full damage of the attack or mitigate
               //by losing his own attack damage
               if (PlayerHealth <= 0) {
               
               System.out.println("You died." + 
                                  "\nThe wizard had: " + WizardHealth + " left.");
               break;
               
               }
            
               else {
               
               System.out.println("The wizard attacks you!" + 
                                  "\nPress 1 to block his attack but at the same time lose 5 attack power." + 
                                  "\nPress 2 to take the wizards attack like a man and lose " + WizardAttack + " health.");
               String UserAnswer = br.readLine();   
                  
                  if (UserAnswer.equals("2")) {
                  
                  PlayerHealth -= WizardAttack;
                  System.out.println("The wizard attacks you for: " + WizardAttack + " damage. You have: " + PlayerHealth + " health left.");
               
                  }
                  
                  else if(UserAnswer.equals("1")) {
                  
                  PlayerAttack -= 5;
                  System.out.println("You have blocked the wizards attack of " + WizardAttack + " damage." + 
                                     "\nHowever you have also lost 5 attack power and now have " + PlayerAttack + " attack power left."); 
                  
                  }
               
               }
         
         }
      
      System.out.println("---------------------------------------------------");   
      
      }
      //end loop 
   System.out.println("You have defeated the grand master wizard! You take his place as the righftul heir!");
   return WizardHealth;
   
   }
   
   
   
   
   















}

   