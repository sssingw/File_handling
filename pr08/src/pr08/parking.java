package pr08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class parking {

	public static void main(String[] args) throws IOException {
		File K15_f = new File("C:\\Users\\Seongwon\\Desktop\\한국교통안전공단_전국공영주차장정보_20191224.txt");   
		//파일을 사용하기 위해 저장 위치 설정
		BufferedReader K15_br = new BufferedReader (new FileReader(K15_f));		
		//BufferedReader 클래스 사용해서 K15_f읽기									
		String K15_readtxt;																																 //문장형 변수 readtxt선언															
		//문장형 변수 선언
		if ((K15_readtxt = K15_br.readLine()) == null) {									  // 내용이 null이면																					//
			System.out.printf("빈 파일입니다\n");										   	  //빈 파일입니다를 출력후 return							
			return;											
		}	
		String [] K15_field_name = K15_readtxt.split("\t");				
		//첫번째줄의 항목을 출력하기 위해 한줄을 먼저 읽음
			
		double K15_lat = 37.3860521;           												 //분당 융기원의 위도
		double K15_lng = 127.1214038;														 //분당 융기원의 경도
		double K15_min = Double.MAX_VALUE;													 //변수 min값을 최대값으로 지정
		double K15_max = Double.MIN_VALUE;													 //변수 max값을 최소값으로 지정
		String K15_short_dist = null;														 //최단거리 변수 선언 초기화
		String K15_long_dist = null;														 //최장거리 변수 선언 초기화
		
		
		int K15_LineCnt = 0;																 //돌아갈 횟수 변수 선언과 초기화											 		
		while((K15_readtxt = K15_br.readLine()) != null) {									 //내용이 null이 아니면 계속 반복
			String [] K15_field = K15_readtxt.split("\t");									 //K15_readtxt를 tab으로 나눠 배열에 저장			
			if (K15_field[2].isEmpty() || K15_field[3].isEmpty()) {							 //K15_field의 2번째와 3번째가 비어있으면
				continue;																	 //continue로 돌아감
			}
			
			System.out.printf("**[%d번째 항목]**************************\n", K15_LineCnt);	 	//도는 횟수를 항목의 수로 넣어 출력			
			System.out.printf(" %s : %s\n", K15_field_name[6], K15_field[6]);					//K15_field[6]인 지번주소를 출력							  
			System.out.printf(" %s : %s\n", K15_field_name[3], K15_field[3]);					//K15_field[12]인 위도를 출력
			System.out.printf(" %s : %s\n", K15_field_name[2], K15_field[2]);					//K15_field[13]인 경도를 출력
		
			double K15_dist = Math.sqrt( Math.pow(Double.parseDouble(K15_field[3]) - K15_lat,2) //피타고라스의 정리를 이용해 거리계산
								+ Math.pow(Double.parseDouble(K15_field[2]) - K15_lng,2));		
			System.out.printf(" 현재지점과 거리  : %f\n", K15_dist);							//현재지점과의 거리를 출력
			System.out.println("************************************");							//줄띄움을 위해 출력
			
			K15_LineCnt++;																		//돌때마다 1씩 증가
			for (int K15_i=0; K15_i < K15_readtxt.length(); K15_i++) {							//K15_i가 K15_readtxt길이만큼 돌며
				if(K15_min > K15_dist) {														//현재거리가 min값보다 작으면	
					K15_min = K15_dist;															//min값으로 현재거리를 저장
					if(K15_min == K15_dist) {													//min값과 현재거리가 같으면
						K15_short_dist = K15_field[7];											//최단거리에 K15_field의 7번째 넣음
						
					}
				} else if (K15_max < K15_dist) {												//현재거리가 max값보다 크면
					K15_max = K15_dist;															//max값으로 현재거리를 저장
					if(K15_max == K15_dist) {													//max값과 현재거리가 같으면
						K15_long_dist = K15_field[7];											//최장거리에 K15_field의 7번째 넣음
									
				}
			}		
			}
		}
			System.out.printf("분당 융기원과 가장 가까운 곳 : %s", K15_short_dist);				//최단거리를 출력
			System.out.printf(", 거리차이 : %f\n", K15_min);									//최단거리일때의 거리값을 출력		  
			System.out.printf("분당 융기원과 가장 먼 곳 : %s", K15_long_dist);					//최장거리를 출력
			System.out.printf(", 거리차이 : %f\n", K15_max);									//최장거리일때의 거리값을 출력
								
		K15_br.close();																			//다읽었으면 BufferedReader닫음
	}
}
