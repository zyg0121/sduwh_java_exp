
public class Main {
	public static void main(String[] args){
		int ODIF, PODIF;  //�ֱ�洢���ȷ��������ȷ�����Ӱ�������
		ICModel IC = new ICModel(20000,10);
        String path = "links.txt"; // �����ļ�·��
        IC.loadNodes(path);
        
        System.out.println("���ڼ����������10�����Ӱ����");
        ODIF = IC.ODIC();
		System.out.println("Ӱ������ֵΪ��"+ ODIF);
//        System.out.println((endTime1 - startTime1) / 1000 + "seconds"); // �������ʱ��(����Ϊ��λ)
        
        System.out.println("==================================");

        System.out.println("���ڼ�������������10�����Ӱ����");
        PODIF = IC.PODIC();
		System.out.println("Ӱ������ֵΪ��"+ PODIF);
	}
}
