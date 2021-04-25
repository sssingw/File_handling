package pr08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat.Field;

public class samsung2015 {

	public static void main(String[] args) throws IOException {
		
		File K15_f = new File("C:\\Users\\Seongwon\\Desktop\\Samsungstock.csv");
		//파일의 위치를 지정
		BufferedReader K15_br = new BufferedReader (new FileReader(K15_f));
		//BufferedReader을 이용해 파일을 읽음			
		File K15_f1 = new File ("C:\\Users\\Seongwon\\Desktop\\Samsungstock2015.csv");
		//쓸 파일의 위치 지정
		BufferedWriter K15_bw = new BufferedWriter (new FileWriter(K15_f1));
		//BufferedWriter을 이용해 파일을 씀
		String K15_readtxt;
		//문자열타입의 변수를 선언
		int K15_cnt = 0; 									//전체 반복 횟수
		int K15_wcnt = 0;									//파일을 쓸때 반복 횟수
		while((K15_readtxt = K15_br.readLine())!= null) {	//K15_readtxt의 값이 null이 아니면 반복
			StringBuffer K15_s = new StringBuffer();		//K15_s의 임시데이터 저장공간 생성
			String [] K15_field = K15_readtxt.split(",");	//K15_readtxt를 ,로 나누어 배열에 저장
			
			if(K15_field.length > 2 && K15_field[1].trim().substring(0).equals("20150112")) {
			//K15_field의 길이가 2보다 크고 K15_field[1]의 공백을 없애고 20150112와 같다면
				K15_s.append(K15_field[1].trim());
				//K15_s에 K15_field[1]의 공백을 없애서 저장
				for (int K15_j = 1; K15_j < K15_field.length; K15_j++) {
				//K15_j를 K15_field의 길이만큼 반복
					K15_s.append(","+K15_field[K15_j].trim());
					//K15_field[K15_j]의 공백을 없애 ,붙여 저장
				}
				K15_bw.write(K15_s.toString());  //K15_s를 String타입으로 변환해 씀
				K15_bw.newLine();				 //문장단위로 씀
				K15_wcnt++;						 //쓰며 1씩 더해 반복
			}
			
			K15_cnt++;							 //전체 반복하며 1씩 더해줌
		}
			K15_br.close();						 //다읽었으면 Bufferedreader을 닫음
			K15_bw.close();					     //다썼으면 Bufferedwriter을 닫음
			
			System.out.printf("Program ENd[%d][%d]records\n", K15_cnt, K15_wcnt); //전체 반복횟수와 파일을 쓴횟수를 출력
		
	}

	}