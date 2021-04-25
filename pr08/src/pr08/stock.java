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
		//������ ����ϱ� ���� ��ü�� �����ϰ� ������ġ�� ����
		BufferedReader K15_br = new BufferedReader (new FileReader(K15_f));
		//������ �б����� bufferedreader�� ����
		File K15_f1 = new File("C:\\Users\\Seongwon\\Desktop\\StockDailyPrice.csv");
		//������ �о �� ������ ��ġ ����
		BufferedWriter K15_bw = new BufferedWriter (new FileWriter(K15_f1));
		//������ ���� ���� Bufferedwriter�� ����
		String K15_readtxt;
		//���ڿ� ���� ����
		
		int K15_cnt = 0; 										//��ü while���� ���� Ƚ��
		int K15wcnt = 0;										//������ ���� ���� Ƚ��
		while((K15_readtxt = K15_br.readLine())!= null) {		//K15_readtxt�� ������ null�� �ƴϸ� �ݺ�
			StringBuffer K15_s = new StringBuffer();			//�ӽ÷� �����͸� �����ϴ� ���� ����
			String [] K15_field = K15_readtxt.split("%_%");		//K15_readtxt�� %_%�� ������ �迭�� ����
			
			if(K15_field.length > 2 && K15_field[2].replace("^","").trim().substring(0,1).equals("A")) {
				//K15_field�� ���̰� 2���� ũ�� K15_field[2]�� ^�κа� ������ ���ְ� ù��°�κ��� A�̸�
				K15_s.append(K15_field[0].replace("^","").trim());
				//K15_s�� K15_field[0]�κ��� ^�� ������ ����
				for (int K15_j = 1; K15_j < K15_field.length; K15_j++) {		 //K15_field�迭�� ���̸�ŭ �ݺ���
					K15_s.append(","+K15_field[K15_j].replace("^","").trim());	 //K15_s�� ", K15_field[K15_j]�� ^�� �������
				}
				K15_bw.write(K15_s.toString());									 //Bufferedwriter�� K15_s�� StringŸ������ ��
				K15_bw.newLine();												 //Bufferedwriter�� ��������� ��		
				K15wcnt++;														 //���� Ƚ���� 1�� �����ָ� �ݺ�
			}
			
			K15_cnt++;															 //��ü while���� ���� Ƚ���� �����ָ� �ݺ�
		}
		
		K15_br.close();															 //���о����� Bufferedreader�� ����
		K15_bw.close();															 //���о����� Bufferedwriter�� ����

		System.out.printf("Program ENd[%d][%d]records\n", K15_cnt, K15wcnt);	 //�Ϸ� �� ���� ����� ���� �ݺ��ߴ��� ���
	}	

}
