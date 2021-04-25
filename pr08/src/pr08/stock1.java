package pr08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class stock1 {

	public static void main(String[] args) throws IOException{
		
		File K15_f = new File("C:\\Users\\Seongwon\\Desktop\\day_data\\THTSKS010H00.dat");
		//파일의 위치를 지정
		BufferedReader K15_br = new BufferedReader (new FileReader(K15_f));
		//BufferedReader를 이용해 파일을 읽음
		String K15_readtxt;												//문자열타입의 변수 선언
		int K15_LineCnt = 0;											//반복횟수 변수선언
		int K15_n = -1;													//int타입의 변수선언과 초기화
		StringBuffer K15_s = new StringBuffer();						//K15_s의 임시 데이터 저장 공간 생성
		while(true) {													//무한 반복
				
			char[] K15_ch = new char[1000];								//char형의 배열에 크기를1000으로 지정
			K15_n = K15_br.read(K15_ch);								//K15_br를 이용해 배열을 읽고 K15_n에 저장
			if (K15_n == -1) 											//K15_n이 -1이 되면(더이상 내용이 없으면)
				break;													//break 끝낸다
			
			for (char K15_c : K15_ch) {									//char형의 K15_c에 K15_ch를 넣고 반복
				if (K15_c == '\n') {									//K15_c가 \n(줄건너뜀)이면
					System.out.printf("[%s]***\n", K15_s.toString());	//K15_s를 String타입으로 변환한 것을 출력
					K15_s.delete(0, K15_s.length());					//K15_s의 0부터 K15_s의 길이까지 삭제
				} else {												//줄건너뜀이 아니면
					K15_s.append(K15_c);								//K15_s에 K15_c를 저장
				}
			}
			
			K15_LineCnt++;												//반복횟수를 1씩 더해줌
 		}
			System.out.printf("[%s]***\n",K15_s.toString());			//K15_s의 값을 String으로 변환해 출력
			K15_br.close();												//다읽었으면 BufferedReader를 닫음
	}

}
