package Arkonoid;



import java.util.Comparator;


public class Sort_arrlist implements Comparator<Scoress> {
		public int compare(Scoress a,Scoress b) {
			if(a.scor>b.scor) {
				return -1;
			}
			else if(a.scor== b.scor) {
				return 0;
				
			}
			else
				return 1;
		}
		
}
