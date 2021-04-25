package pr08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class samsung_maxmin {

	public static void main(String[] args) throws IOException {
		File K15_f = new File("C:\\Users\\Seongwon\\Desktop\\Samsungstock.csv");
		//파일의 위치 지정
		BufferedReader K15_br = new BufferedReader (new FileReader(K15_f));
		//BufferedReader을 이용해 파일을 읽음
		String K15_readtxt;
		//문자열타입의 변수 선언
		int price = 0;										//가격을 넣을 변수 선언
		int K15_max = Integer.MIN_VALUE;					//최대값을 넣을 변수
		int K15_min = Integer.MAX_VALUE;					//최소값을 넣을 변수
		
		
		while((K15_readtxt = K15_br.readLine()) != null) {	//K15_readtxt의 값이 null이 아니면 반복
																				
			String [] K15_field = K15_readtxt.split(",");   //K15_readtxt를 ,로 나누어 배열에 저장
				
		  if(K15_field[1].contains("2015")) {				//K15_field[1]이 2015를 포함하고 있으면
			
				price = Integer.parseInt(K15_field[3]);		//price 변수에 K15_field[3](종가)를 정수로 변환해 넣음
					if(K15_min > price) {					//price가 최소값보다 작으면 
						K15_min = price;					//최소값에 price저장
											
					} else if (K15_max < price) {			//price가 최대값보다 크면
						K15_max = price;					//최대값에 price저장																				
					}		
		  }
		}		  
		System.out.printf("최소값 : %d\n", K15_min);		//최소값을 출력
		System.out.printf("최대값 : %d\n", K15_max);		//최대값을 출력							 
		K15_br.close();										//다 읽으면 BufferedReader을 닫음
	}
}

		
