

//����������Ϣ
public class NextNode {
	int num;  //��ͷ�����
	double v;  //����ɹ�����
	
	public NextNode(int num, double v){
		this.num = num;
		this.v = v;
	}
	public NextNode(){
		this(0,0);
	}
	
	//��ü���ɹ�����
	public double getV(){
		return this.v;
	}
	
	//��û�ͷ�ڵ���
	public int getNodenum(){
		return this.num;
	}
}
