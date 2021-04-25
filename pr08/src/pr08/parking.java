package pr08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class parking {

	public static void main(String[] args) throws IOException {
		File K15_f = new File("C:\\Users\\Seongwon\\Desktop\\�ѱ������������_������������������_20191224.txt");   
		//������ ����ϱ� ���� ���� ��ġ ����
		BufferedReader K15_br = new BufferedReader (new FileReader(K15_f));		
		//BufferedReader Ŭ���� ����ؼ� K15_f�б�									
		String K15_readtxt;																																 //������ ���� readtxt����															
		//������ ���� ����
		if ((K15_readtxt = K15_br.readLine()) == null) {									  // ������ null�̸�																					//
			System.out.printf("�� �����Դϴ�\n");										   	  //�� �����Դϴٸ� ����� return							
			return;											
		}	
		String [] K15_field_name = K15_readtxt.split("\t");				
		//ù��°���� �׸��� ����ϱ� ���� ������ ���� ����
			
		double K15_lat = 37.3860521;           												 //�д� ������� ����
		double K15_lng = 127.1214038;														 //�д� ������� �浵
		double K15_min = Double.MAX_VALUE;													 //���� min���� �ִ밪���� ����
		double K15_max = Double.MIN_VALUE;													 //���� max���� �ּҰ����� ����
		String K15_short_dist = null;														 //�ִܰŸ� ���� ���� �ʱ�ȭ
		String K15_long_dist = null;														 //����Ÿ� ���� ���� �ʱ�ȭ
		
		
		int K15_LineCnt = 0;																 //���ư� Ƚ�� ���� ����� �ʱ�ȭ											 		
		while((K15_readtxt = K15_br.readLine()) != null) {									 //������ null�� �ƴϸ� ��� �ݺ�
			String [] K15_field = K15_readtxt.split("\t");									 //K15_readtxt�� tab���� ���� �迭�� ����			
			if (K15_field[2].isEmpty() || K15_field[3].isEmpty()) {							 //K15_field�� 2��°�� 3��°�� ���������
				continue;																	 //continue�� ���ư�
			}
			
			System.out.printf("**[%d��° �׸�]**************************\n", K15_LineCnt);	 	//���� Ƚ���� �׸��� ���� �־� ���			
			System.out.printf(" %s : %s\n", K15_field_name[6], K15_field[6]);					//K15_field[6]�� �����ּҸ� ���							  
			System.out.printf(" %s : %s\n", K15_field_name[3], K15_field[3]);					//K15_field[12]�� ������ ���
			System.out.printf(" %s : %s\n", K15_field_name[2], K15_field[2]);					//K15_field[13]�� �浵�� ���
		
			double K15_dist = Math.sqrt( Math.pow(Double.parseDouble(K15_field[3]) - K15_lat,2) //��Ÿ����� ������ �̿��� �Ÿ����
								+ Math.pow(Double.parseDouble(K15_field[2]) - K15_lng,2));		
			System.out.printf(" ���������� �Ÿ�  : %f\n", K15_dist);							//������������ �Ÿ��� ���
			System.out.println("************************************");							//�ٶ���� ���� ���
			
			K15_LineCnt++;																		//�������� 1�� ����
			for (int K15_i=0; K15_i < K15_readtxt.length(); K15_i++) {							//K15_i�� K15_readtxt���̸�ŭ ����
				if(K15_min > K15_dist) {														//����Ÿ��� min������ ������	
					K15_min = K15_dist;															//min������ ����Ÿ��� ����
					if(K15_min == K15_dist) {													//min���� ����Ÿ��� ������
						K15_short_dist = K15_field[7];											//�ִܰŸ��� K15_field�� 7��° ����
						
					}
				} else if (K15_max < K15_dist) {												//����Ÿ��� max������ ũ��
					K15_max = K15_dist;															//max������ ����Ÿ��� ����
					if(K15_max == K15_dist) {													//max���� ����Ÿ��� ������
						K15_long_dist = K15_field[7];											//����Ÿ��� K15_field�� 7��° ����
									
				}
			}		
			}
		}
			System.out.printf("�д� ������� ���� ����� �� : %s", K15_short_dist);				//�ִܰŸ��� ���
			System.out.printf(", �Ÿ����� : %f\n", K15_min);									//�ִܰŸ��϶��� �Ÿ����� ���		  
			System.out.printf("�д� ������� ���� �� �� : %s", K15_long_dist);					//����Ÿ��� ���
			System.out.printf(", �Ÿ����� : %f\n", K15_max);									//����Ÿ��϶��� �Ÿ����� ���
								
		K15_br.close();																			//���о����� BufferedReader����
	}
}
