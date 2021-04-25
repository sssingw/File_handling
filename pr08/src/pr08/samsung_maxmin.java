package pr08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class samsung_maxmin {

	public static void main(String[] args) throws IOException {
		File K15_f = new File("C:\\Users\\Seongwon\\Desktop\\Samsungstock.csv");
		//������ ��ġ ����
		BufferedReader K15_br = new BufferedReader (new FileReader(K15_f));
		//BufferedReader�� �̿��� ������ ����
		String K15_readtxt;
		//���ڿ�Ÿ���� ���� ����
		int price = 0;										//������ ���� ���� ����
		int K15_max = Integer.MIN_VALUE;					//�ִ밪�� ���� ����
		int K15_min = Integer.MAX_VALUE;					//�ּҰ��� ���� ����
		
		
		while((K15_readtxt = K15_br.readLine()) != null) {	//K15_readtxt�� ���� null�� �ƴϸ� �ݺ�
																				
			String [] K15_field = K15_readtxt.split(",");   //K15_readtxt�� ,�� ������ �迭�� ����
				
		  if(K15_field[1].contains("2015")) {				//K15_field[1]�� 2015�� �����ϰ� ������
			
				price = Integer.parseInt(K15_field[3]);		//price ������ K15_field[3](����)�� ������ ��ȯ�� ����
					if(K15_min > price) {					//price�� �ּҰ����� ������ 
						K15_min = price;					//�ּҰ��� price����
											
					} else if (K15_max < price) {			//price�� �ִ밪���� ũ��
						K15_max = price;					//�ִ밪�� price����																				
					}		
		  }
		}		  
		System.out.printf("�ּҰ� : %d\n", K15_min);		//�ּҰ��� ���
		System.out.printf("�ִ밪 : %d\n", K15_max);		//�ִ밪�� ���							 
		K15_br.close();										//�� ������ BufferedReader�� ����
	}
}

		
