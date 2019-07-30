import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
//Mohammed Chowdhury 
public class Main {

	static String location =""; 
	static int point; 
	static ArrayList<Node> listOfPoint = new  ArrayList<>(); 

	static Node targetPoint; 

	public static void main(String[] args) throws IOException {

		location = args[0]; 
		point  = Integer.parseInt(args[1]);

		//location = "/Users/mohammedchowdhury/Desktop/locations.txt"; //linking the file 
		//point = 1;

		if(point<0 || point>5000) {
			System.out.println("Not a Valid Point");
			return; 
		}

		readData();
	} 

	public static void WriteToFile()throws IOException {
		String outputFile = location.replace("locations.txt", "OutPutLocations.txt"); 
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
		String str =""; 
		for(int a=0 ;a<point;a++) {
			str = str + listOfPoint.get(a).getX()+" ,"+listOfPoint.get(a).getY()+" ,"+listOfPoint.get(a).getDistance()+"\n"; 
		}
		writer.write(str);
		writer.close();
	}

	public static void readData() throws IOException {

		File file = new File(location); 
		String[] arrOfStr = new String[2]; 
		int counter = 0; 
		String st; 

		try {
			BufferedReader br = new BufferedReader(new FileReader(file)); 

			while ((st = br.readLine()) != null) {

				arrOfStr = st.split(" ");
				arrOfStr[0].replaceAll(" ",""); 
				arrOfStr[1].replaceAll(" ",""); 

				String x = arrOfStr[0]; 
				String y = arrOfStr[1]; 

				if(counter==0) {
					targetPoint = new Node(x,y); 
					counter++; 
				}
				else {	
					Node newNode = new Node(x, y); 
					getDistance(newNode);
					listOfPoint.add(newNode); 
				}
			}

		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}

		MergeSort sort = new  MergeSort(); 
		sort.sort(listOfPoint, 0, listOfPoint.size()-1); 
		WriteToFile();
	}

	public static void getDistance(Node a) {
		double x = (double) a.getX(); 
		double y = (double) a.getY(); 

		double tPX = targetPoint.getX(); 
		double tPY = targetPoint.getY(); 

		double ans = Math.hypot( (x-tPX), (y-tPY)); 
		a.setDistance(ans);
	}

}
//Mohammed Chowdhury 
