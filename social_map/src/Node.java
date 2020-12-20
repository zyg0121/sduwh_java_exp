
import java.util.HashMap;
import java.util.Objects;
import java.util.Vector;

public class Node {
	int num;  //弧尾结点编号
	Vector<NextNode> next = new Vector<>();  //存放以num为弧尾的各有向边信息
	
	public Node(int num){
		this.num = num;
	}
	
	//将以num为弧尾的新有向边信息加入到动态数组中
	public void addNextNode(int nextnum, double v){
		this.next.add(new NextNode(nextnum,v));
	}
	
	//打印邻接表信息
	public void printNext(){
		System.out.println("打印编号为"+this.getNum()+"的邻接表信息");
		for(NextNode node:this.next){
			System.out.println("("+node.getNodenum()+","+node.getV()+")");
		}
		System.out.println("===========================================");
	}
	
	//获得弧尾结点编号
	public int getNum(){
		return this.num;
	}
	
	//计算num结点的出度
	public int getOutDegree(Vector<Node> NodeTable,int num){
		return NodeTable.get(num).next.size();
	}
	
	//计算num结点的正出度
	public int getPostiveOD(Vector<Node> NodeTable,int num){
		int cnt = 0;
		for(NextNode node: NodeTable.get(num).next){
			if(node.getV() > 0) cnt++;
		}
		return cnt;
	}
}
