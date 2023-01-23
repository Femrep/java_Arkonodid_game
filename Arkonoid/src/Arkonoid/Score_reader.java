package Arkonoid;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Score_reader {
	
	public Score_reader(ArrayList<Scoress> S_line,String sc )  {
		BufferedReader reader;
		
		try {
			reader=new BufferedReader(new FileReader(sc+".txt"));
			String line=reader.readLine();
			while(line!=null) {
				String[] lines=line.split(" ");
				String part1=lines[0];
				String part2=lines[1];
				String part3=lines[2];
				
				int scpart=Integer.parseInt(part2);
				Scoress a=new Scoress(part1, scpart,part3);
				S_line.add(a);
				line=reader.readLine();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	

}
