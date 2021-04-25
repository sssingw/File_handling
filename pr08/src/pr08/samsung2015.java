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
		//������ ��ġ�� ����
		BufferedReader K15_br = new BufferedReader (new FileReader(K15_f));
		//BufferedReader�� �̿��� ������ ����			
		File K15_f1 = new File ("C:\\Users\\Seongwon\\Desktop\\Samsungstock2015.csv");
		//�� ������ ��ġ ����
		BufferedWriter K15_bw = new BufferedWriter (new FileWriter(K15_f1));
		//BufferedWriter�� �̿��� ������ ��
		String K15_readtxt;
		//���ڿ�Ÿ���� ������ ����
		int K15_cnt = 0; 									//��ü �ݺ� Ƚ��
		int K15_wcnt = 0;									//������ ���� �ݺ� Ƚ��
		while((K15_readtxt = K15_br.readLine())!= null) {	//K15_readtxt�� ���� null�� �ƴϸ� �ݺ�
			StringBuffer K15_s = new StringBuffer();		//K15_s�� �ӽõ����� ������� ����
			String [] K15_field = K15_readtxt.split(",");	//K15_readtxt�� ,�� ������ �迭�� ����
			
			if(K15_field.length > 2 && K15_field[1].trim().substring(0).equals("20150112")) {
			//K15_field�� ���̰� 2���� ũ�� K15_field[1]�� ������ ���ְ� 20150112�� ���ٸ�
				K15_s.append(K15_field[1].trim());
				//K15_s�� K15_field[1]�� ������ ���ּ� ����
				for (int K15_j = 1; K15_j < K15_field.length; K15_j++) {
				//K15_j�� K15_field�� ���̸�ŭ �ݺ�
					K15_s.append(","+K15_field[K15_j].trim());
					//K15_field[K15_j]�� ������ ���� ,�ٿ� ����
				}
				K15_bw.write(K15_s.toString());  //K15_s�� StringŸ������ ��ȯ�� ��
				K15_bw.newLine();				 //��������� ��
				K15_wcnt++;						 //���� 1�� ���� �ݺ�
			}
			
			K15_cnt++;							 //��ü �ݺ��ϸ� 1�� ������
		}
			K15_br.close();						 //���о����� Bufferedreader�� ����
			K15_bw.close();					     //�ٽ����� Bufferedwriter�� ����
			
			System.out.printf("Program ENd[%d][%d]records\n", K15_cnt, K15_wcnt); //��ü �ݺ�Ƚ���� ������ ��Ƚ���� ���
		
	}

	}