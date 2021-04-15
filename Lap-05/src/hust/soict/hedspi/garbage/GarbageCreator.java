package hust.soict.hedspi.garbage;

import java.io.BufferedReader; 
import java.io.File;
import java.io.FileReader;

public class GarbageCreator {
 public static void main(String[] args) {
   try {
    
     File f = new File("C:\\\\Users\\\\ADMIN\\\\eclipse-workspace\\\\H-Example\\\\ABC.txt");
     FileReader fr = new FileReader(f);
     
     BufferedReader br = new BufferedReader(fr);
     String line;
     String textString = "";
     while ((line = br.readLine()) != null){
       //textString = textString.concat("\n"+line);
       textString = textString + "\n" + line;
     }
     
     System.out.println(textString);
     
     fr.close();
     br.close();
    } catch (Exception ex) {
      System.out.println("Loi doc file: "+ex);
  }
 }
}