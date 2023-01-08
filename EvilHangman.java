import java.io.*;
import java.util.*;

public class EvilHangman
{
   //this method will return the "--e-"
   //family that the word belongs to.  Used in building 
   //the map.
   
	public static String getFamily(String word, char c)
   {
      String str = "";
      //Map<String, Integer 
      for(int i=0; i<word.length(); i++)
      {
         if(word.substring(i,i+1).equals(c+""))
            str += c;
         else
            str += "-";
      }
      return str;

      // should return o--- or -o-- or -oo- or --o- 
   }	
   public static void main(String[] args) throws Exception
   {
      boolean x = true;
      while (x = true)
      {
         Scanner imput = new Scanner(System.in);
         System.out.println("Would you like to use debug mode?");
         System.out.println("Y/N");
         String a = imput.next();
         boolean debug = false;
         if(a.equals("y") || a.equals("Y"))
         debug = true;
         ArrayList<String> words = new ArrayList<>();
            
         Scanner letters = new Scanner(System.in);
         boolean b = false;
         int size = 0;
         while (b==false)
         {
            Scanner scan = new Scanner( new File("dictionary.txt"));
            System.out.println("How many letters?");
            int length = letters.nextInt();
               
            while(scan.hasNextLine())
            {
               String line = scan.nextLine();
               if(line.length()==length)
               {          
                  words.add(line);
               }
            }
            if(words.size()==0)                                         //find the longest word
            System.out.println("Type a different word length-");
            else
            {
               size = length;
               b = true;
            }
         }
            
         System.out.println("How many guesses?");
         int guesses = letters.nextInt();
         if(guesses < 1)
         System.out.println("Type a different number of guesses-");

            
         int guess = 0;
         ArrayList<Character> letterGuess = new ArrayList<Character>();
            ArrayList<String> hangman = new ArrayList<>();
            for(int i = 0; i < size; i++)
            {
               hangman.add("-");
            }
            boolean win = false;
            while(guess < guesses)
            {  
               char firstLetter = 0;
               boolean k = false;


                  Scanner scanner = new Scanner(System.in);
                  System.out.println("Guess a letter- ");
                  firstLetter = scanner.findInLine(".").charAt(0);
                  boolean u = true;

               Map<String, ArrayList<String>> map = new TreeMap<>();
               for(int i = 0; i < words.size(); i++)
               {
                  String w = getFamily(words.get(i), firstLetter);
                  if(map.containsKey(w))
                  {
                     ArrayList<String> list = map.get(w);
                     list.add(words.get(i));
                     map.put(w, list);
                  }
                  else
                  {
                     ArrayList<String> list = new ArrayList<>();
                     list.add(words.get(i));
                     map.put(w,list);
                  }
               }

               words.clear();
               String q = "";
                        
            for(String key: map.keySet())
            {            
               ArrayList<String> list = map.get(key);
               if(list.size()>words.size() && key.contains("-"))
               {
                  words = list;
                  q=key;
               }
            }
            for(int i=0; i<hangman.size(); i++)
            {
               if(!q.substring(i,i+1).equals("-"))
               {
                  hangman.set(i, q.substring(i,i+1));
               }
            }
            
            boolean z = true;
            for(int i=0; i<hangman.size(); i++)
            {
               if(hangman.get(i).equals("-"))
                  z=false;
            }
            if(z == true)
            {
               System.out.println("You Win!");
               System.out.println(words.get(0));
               win = true;
               break;
            }

            letterGuess.add(firstLetter);
            System.out.println("Guesses "+ guess);           
            guess++;
            System.out.println("You have " + (guesses - guess) +" guesses left");
               
            for(int i=0; i<hangman.size(); i++)
            {
               System.out.print(hangman.get(i));
            }
            System.out.println();
            //System.out.println();
            
            if(debug == true)
               System.out.println("Words remaining: " + words.size());
         }
         if(!win)
         {
            System.out.println("You Lose");
            int ran = (int)(Math.random() * words.size());
            System.out.println(words.get(ran));  
         }   
            Scanner imput2 = new Scanner(System.in);
            System.out.println("Would you like to play again?");
            System.out.println("Y/N");
            String z = imput2.next();
            if(z.equals("n") || z.equals("N"))
                  x = false;
         

      }
   }
}
   /*
      Scanner scan = new Scanner( new File("dictionary.txt"));
      Scanner imput = new Scanner(System.in);
      String yesOrNo;
      ArrayList<String> words = new ArrayList<>();
      int counter = 1;
      char letter = 0;
      Map<String, Integer> familyMap = new TreeMap<>();
      //int length = imput.nextInt();
      System.out.println("Please enter the length of the word you want to guess");
      int length = imput.nextInt();
      /*
      while(scan.hasNextLine())
      {
         words.add(scan.next());
      }
      System.out.println(words);
      
      System.out.println("Please enter a letter");
      letter = imput.next().charAt(0);
      
      while(scan.hasNextLine())
      {
         String temp = scan.next();
         int tempSize = temp.length();
         if(tempSize == (length))
            familyMap.put(getFamily(temp,letter), counter++);            
      }
      System.out.println(familyMap);
      System.out.println("Do you want to play a game?");
      yesOrNo = imput.next();
      
      /*
      while (isDone(yesOrNo) = false)
      {
         
         
         System.out.println("Try again Y/N?");
         String s = imput.next();
      }
      /*
      //ArrayList list = new ArrayList(); 
      Map<String, ArrayList> family = new TreeMap<>();
      while(scan.hasNextLine())
      {
         String line = scan.nextLine();
         for(String s : scan.getFamily)
         {
            if(family.containsKey(s) )
            {
               //int val = family.get(s+"");
               family.put(s,list.add(val));
            }
            else
            {
               family.put(s, 1);
            }
         }     
      }
      */
      
   
   /*
      public static boolean isDone(String s)
      {
         if(s = "y" || s = "Y")
            {
               return true;
            }
            return false;
      }
      */
