
import java.util.HashMap;
import java.util.Objects;
import java.util.Vector;

public class Node {
	int num;  //��β�����
	Vector<NextNode> next = new Vector<>();  //�����numΪ��β�ĸ��������Ϣ
	
	public Node(int num){
		this.num = num;
	}
	
	//����numΪ��β�����������Ϣ���뵽��̬������
	public void addNextNode(int nextnum, double v){
		this.next.add(new NextNode(nextnum,v));
	}
	
	//��ӡ�ڽӱ���Ϣ
	public void printNext(){
		System.out.println("��ӡ���Ϊ"+this.getNum()+"���ڽӱ���Ϣ");
		for(NextNode node:this.next){
			System.out.println("("+node.getNodenum()+","+node.getV()+")");
		}
		System.out.println("===========================================");
	}
	
	//��û�β�����
	public int getNum(){
		return this.num;
	}
	
	//����num���ĳ���
	public int getOutDegree(Vector<Node> NodeTable,int num){
		return NodeTable.get(num).next.size();
	}
	
	//����num����������
	public int getPostiveOD(Vector<Node> NodeTable,int num){
		int cnt = 0;
		for(NextNode node: NodeTable.get(num).next){
			if(node.getV() > 0) cnt++;
		}
		return cnt;
	}
}
