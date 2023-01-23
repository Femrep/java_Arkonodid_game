package Arkonoid;

import java.io.FileWriter;
import java.io.IOException;

public class Score_Write {
	public Score_Write(String all){
		FileWriter writer;
	    try {
	      writer = new FileWriter("ScoreFile.txt",true);
	     // char c = 'A';
	     // writer.write(c);
	     // String tmp = " hello cse 212\nasdasdas";
	      writer.write(all+"\n");
	      writer.close();
	    } catch (IOException rr) {
	      // TODO Auto-generated catch block    	
	      rr. printStackTrace();
	    }
}
}
