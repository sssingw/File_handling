package pr08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class wifi1 {

	public static void main(String[] args) throws IOException {
		File K15_f = new File("C:\\Users\\Seongwon\\Desktop\\���������������ǥ�ص�����.txt");        
		 //������ ����ϱ� ���� ���� ��ġ ����
		BufferedReader K15_br = new BufferedReader (new FileReader(K15_f));			
		 //BufferedReader Ŭ���� ����ؼ� K15_f�б�
		String K15_readtxt;																																 														
		//������ ���� readtxt����	
		if ((K15_readtxt = K15_br.readLine()) == null) {	  
		//null�̸� �������Դϴ� ��� �� return;
			System.out.printf("�� �����Դϴ�\n");											
			return;
		}
		//�������� ����ϱ� ���� 
		String [] K15_field_name = K15_readtxt.split("\t");		//K15_field_name �迭�� K15_readtxt�� tab���� ���� ���� ����								 
			
		double K15_lat = 37.3860521;         					//�д� ������� ����				
		double K15_lng = 127.1214038;							//�д� ������� �浵
		double K15_min = Double.MAX_VALUE;						//K15_min�� doubleMax_value���� ����
		double K15_max = Double.MIN_VALUE;						//K15_max�� doubleMin_value���� ����
		String K15_short_dist = null;							//K15_short_dist���� ����
		String K15_long_dist = null;							//K15_long_dist ���� ����
		
		int K15_LineCnt = 0;									//K15_Linecnt �ʱ�ȭ						 		
		while((K15_readtxt = K15_br.readLine()) != null) {		//K15_readtxt�� null�� ���� ���� ���� �ݺ�
			String [] K15_field = K15_readtxt.split("\t");		//tab���� ������ K15_field�迭�� ����
			System.out.printf("**[%d��° �׸�]************s**************\n", K15_LineCnt);		//���� Ƚ���� �׸��� ���� �־� ���
			System.out.printf(" %s : %s\n", K15_field_name[9], K15_field[9]);					//K15_field[9]�� �����ּҸ� ���				  		
			System.out.printf(" %s : %s\n", K15_field_name[12], K15_field[12]);					//K15_field[12]�� ������ ���
			System.out.printf(" %s : %s\n", K15_field_name[13], K15_field[13]);					//K15_field[13]�� �浵�� ���
			if (K15_field[12].isEmpty() || K15_field[13].isEmpty()) {   						//���� K15_field�� 12���� 13�� ���������
				continue;																		//continue�� �ٽ� �ö�
			}				
		
			double K15_dist = Math.sqrt( Math.pow(Double.parseDouble(K15_field[12]) - K15_lat,2)	//��Ÿ����� ������ �̿��� �Ÿ����
								+ Math.pow(Double.parseDouble(K15_field[13]) - K15_lng,2));			
			System.out.printf(" ���������� �Ÿ�  : %f\n", K15_dist);								//������������ �Ÿ��� ���
			System.out.println("************************************");								//�ٶ���� ���� ���
			K15_LineCnt++;																			//�������� 1�� ����
		}
			K15_br.close();																			//���о����� BufferedReader����
}
}
