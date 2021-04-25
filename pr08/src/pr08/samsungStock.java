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
		//������ ��ġ�� ����
		BufferedReader K15_br = new BufferedReader (new FileReader(K15_f));
		//BufferedReader�� ����� ������ ����
		File K15_f1 = new File ("C:\\Users\\Seongwon\\Desktop\\Samsungstock.csv");
		//�� ������ ��ġ�� ����
		BufferedWriter K15_bw = new BufferedWriter (new FileWriter(K15_f1));
		//BufferedWriter�� ����� ������ ��
		String K15_readtxt;
		//���ڿ� ���� ����
		int K15_cnt = 0; 										//��ü while���� ���� Ƚ��
		int K15_wcnt = 0;										//���Ͼ��� ���� Ƚ��
		while ((K15_readtxt = K15_br.readLine())!= null) {		//K15_readtxt�� ���� null�� �ƴϸ� �ݺ�
			StringBuffer K15_s = new StringBuffer();			//K15_s�� �ӽõ����� �����������
			String []K15_field = K15_readtxt.split("%_%");		//K15_readtxt�� %_%�� ���� �迭�� ����
			
			if(K15_field.length>2 && K15_field[2].replace("^","").trim().substring(0).equals("A005930")) {
			//K15_field�� ���̰� 2���� ũ�� K15_field[2]�� ^�� ������ ���ְ�, ��ü ���ڰ� �Ｚ�����ڵ� A005930�� ������
					K15_s.append(K15_field[0].replace("^","").trim());	
					//K15_s�� K15_field[0]�� ^�� ������ ����
					for (int K15_j = 1; K15_j < K15_field.length; K15_j++) {       //K15_j�� K15_field�� ���̸�ŭ �ݺ�����
						K15_s.append(","+K15_field[K15_j].replace("^","").trim()); //K15_s�� ,K15_field[K15_j]�� ^�� ������ ���� ����
					}
					K15_bw.write(K15_s.toString());								   //K15_s�� StringŸ������ ��ȯ�� ��
					K15_bw.newLine();											   //BufferedWriter�� ��������� ��
					K15_wcnt++;													   //���鼭 1�� ������
		}
			K15_cnt++;															   //��ü Ƚ���� ���� 1�� ������
		
	}
			K15_br.close();														   //�� ������ Bufferedreader�� ����
			K15_bw.close();														   //�� ���� BufferedWriter�� ����
			
			System.out.printf("Program ENd[%d][%d]records\n", K15_cnt, K15_wcnt);  //�Ϸ�� ��ü�ݺ�Ƚ���� ������ ���鼭 �ݺ��� Ƚ���� ���
		
	}

	}
