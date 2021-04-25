package pr08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class stock {

	public static void main(String[] args) throws IOException{
		
		File K15_f = new File ("C:\\Users\\Seongwon\\Desktop\\day_data\\THTSKS010H00.dat");
		//파일을 사용하기 위해 객체를 생성하고 파일위치를 지정
		BufferedReader K15_br = new BufferedReader (new FileReader(K15_f));
		//파일을 읽기위해 bufferedreader을 생성
		File K15_f1 = new File("C:\\Users\\Seongwon\\Desktop\\StockDailyPrice.csv");
		//파일을 읽어서 쓸 파일의 위치 지정
		BufferedWriter K15_bw = new BufferedWriter (new FileWriter(K15_f1));
		//파일을 쓰기 위해 Bufferedwriter을 생성
		String K15_readtxt;
		//문자열 변수 선언
		
		int K15_cnt = 0; 										//전체 while문의 도는 횟수
		int K15wcnt = 0;										//파일을 쓸때 도는 횟수
		while((K15_readtxt = K15_br.readLine())!= null) {		//K15_readtxt의 내용이 null이 아니면 반복
			StringBuffer K15_s = new StringBuffer();			//임시로 데이터를 저장하는 공간 생성
			String [] K15_field = K15_readtxt.split("%_%");		//K15_readtxt를 %_%로 나누어 배열에 저장
			
			if(K15_field.length > 2 && K15_field[2].replace("^","").trim().substring(0,1).equals("A")) {
				//K15_field의 길이가 2보다 크고 K15_field[2]의 ^부분과 공백을 없애고 첫번째부분이 A이면
				K15_s.append(K15_field[0].replace("^","").trim());
				//K15_s에 K15_field[0]부분의 ^과 공백을 없앰
				for (int K15_j = 1; K15_j < K15_field.length; K15_j++) {		 //K15_field배열의 길이만큼 반복함
					K15_s.append(","+K15_field[K15_j].replace("^","").trim());	 //K15_s에 ", K15_field[K15_j]의 ^와 공백없앰
				}
				K15_bw.write(K15_s.toString());									 //Bufferedwriter에 K15_s를 String타입으로 씀
				K15_bw.newLine();												 //Bufferedwriter로 문장단위로 씀		
				K15wcnt++;														 //도는 횟수를 1씩 더해주며 반복
			}
			
			K15_cnt++;															 //전체 while문의 도는 횟수를 더해주며 반복
		}
		
		K15_br.close();															 //다읽었으면 Bufferedreader를 닫음
		K15_bw.close();															 //다읽었으면 Bufferedwriter을 닫음

		System.out.printf("Program ENd[%d][%d]records\n", K15_cnt, K15wcnt);	 //완료 후 각각 몇번씩 돌며 반복했는지 출력
	}	

}
