package pr08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat.Field;

public class samsungStock {

	public static void main(String[] args) throws IOException {
		
		File K15_f = new File("C:\\Users\\Seongwon\\Desktop\\day_data\\THTSKS010H00.dat");
		//파일의 위치를 지정
		BufferedReader K15_br = new BufferedReader (new FileReader(K15_f));
		//BufferedReader을 사용해 파일을 읽음
		File K15_f1 = new File ("C:\\Users\\Seongwon\\Desktop\\Samsungstock.csv");
		//쓸 파일의 위치를 지정
		BufferedWriter K15_bw = new BufferedWriter (new FileWriter(K15_f1));
		//BufferedWriter을 사용해 파일을 씀
		String K15_readtxt;
		//문자열 변수 선언
		int K15_cnt = 0; 										//전체 while문의 도는 횟수
		int K15_wcnt = 0;										//파일쓸때 도는 횟수
		while ((K15_readtxt = K15_br.readLine())!= null) {		//K15_readtxt의 값이 null이 아니면 반복
			StringBuffer K15_s = new StringBuffer();			//K15_s의 임시데이터 저장공간생성
			String []K15_field = K15_readtxt.split("%_%");		//K15_readtxt를 %_%로 나눠 배열에 저장
			
			if(K15_field.length>2 && K15_field[2].replace("^","").trim().substring(0).equals("A005930")) {
			//K15_field의 길이가 2보다 크고 K15_field[2]의 ^와 공백을 없애고, 전체 글자가 삼성전자코드 A005930와 같으면
					K15_s.append(K15_field[0].replace("^","").trim());	
					//K15_s에 K15_field[0]의 ^와 공백을 없앰
					for (int K15_j = 1; K15_j < K15_field.length; K15_j++) {       //K15_j를 K15_field의 길이만큼 반복돌림
						K15_s.append(","+K15_field[K15_j].replace("^","").trim()); //K15_s에 ,K15_field[K15_j]의 ^와 공백을 빼서 저장
					}
					K15_bw.write(K15_s.toString());								   //K15_s를 String타입으로 변환해 씀
					K15_bw.newLine();											   //BufferedWriter로 문장단위로 씀
					K15_wcnt++;													   //돌면서 1씩 더해줌
		}
			K15_cnt++;															   //전체 횟수를 돌며 1씩 더해줌
		
	}
			K15_br.close();														   //다 읽으면 Bufferedreader를 닫음
			K15_bw.close();														   //다 쓰면 BufferedWriter을 닫음
			
			System.out.printf("Program ENd[%d][%d]records\n", K15_cnt, K15_wcnt);  //완료시 전체반복횟수와 파일을 쓰면서 반복한 횟수를 출력
		
	}

	}
