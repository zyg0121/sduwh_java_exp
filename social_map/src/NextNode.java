

//有向边相关信息
public class NextNode {
	int num;  //弧头结点编号
	double v;  //激活成功概率
	
	public NextNode(int num, double v){
		this.num = num;
		this.v = v;
	}
	public NextNode(){
		this(0,0);
	}
	
	//获得激活成功概率
	public double getV(){
		return this.v;
	}
	
	//获得弧头节点编号
	public int getNodenum(){
		return this.num;
	}
}
