package pr08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class stock1 {

	public static void main(String[] args) throws IOException{
		
		File K15_f = new File("C:\\Users\\Seongwon\\Desktop\\day_data\\THTSKS010H00.dat");
		//������ ��ġ�� ����
		BufferedReader K15_br = new BufferedReader (new FileReader(K15_f));
		//BufferedReader�� �̿��� ������ ����
		String K15_readtxt;												//���ڿ�Ÿ���� ���� ����
		int K15_LineCnt = 0;											//�ݺ�Ƚ�� ��������
		int K15_n = -1;													//intŸ���� ��������� �ʱ�ȭ
		StringBuffer K15_s = new StringBuffer();						//K15_s�� �ӽ� ������ ���� ���� ����
		while(true) {													//���� �ݺ�
				
			char[] K15_ch = new char[1000];								//char���� �迭�� ũ�⸦1000���� ����
			K15_n = K15_br.read(K15_ch);								//K15_br�� �̿��� �迭�� �а� K15_n�� ����
			if (K15_n == -1) 											//K15_n�� -1�� �Ǹ�(���̻� ������ ������)
				break;													//break ������
			
			for (char K15_c : K15_ch) {									//char���� K15_c�� K15_ch�� �ְ� �ݺ�
				if (K15_c == '\n') {									//K15_c�� \n(�ٰǳʶ�)�̸�
					System.out.printf("[%s]***\n", K15_s.toString());	//K15_s�� StringŸ������ ��ȯ�� ���� ���
					K15_s.delete(0, K15_s.length());					//K15_s�� 0���� K15_s�� ���̱��� ����
				} else {												//�ٰǳʶ��� �ƴϸ�
					K15_s.append(K15_c);								//K15_s�� K15_c�� ����
				}
			}
			
			K15_LineCnt++;												//�ݺ�Ƚ���� 1�� ������
 		}
			System.out.printf("[%s]***\n",K15_s.toString());			//K15_s�� ���� String���� ��ȯ�� ���
			K15_br.close();												//���о����� BufferedReader�� ����
	}

}
