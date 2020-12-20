

import java.util.Vector;

public class PickNode {
	int picknum;  //要选取的点的个数
	Vector<Node> nodeVector = new Vector<>();  //存放所有结点信息
	Vector<Node> ChooseMaxODNodes = new Vector<>();  //存放已选择的出度最大点
	Vector<Node> ChooseMaxPODNodes = new Vector<>();  //存放已选择的正出度最大点

	public PickNode(Vector<Node> nodes, int num){
		this.nodeVector = nodes;
		this.picknum = num;
	}
	
	//设置要选择的点个数
	public void setNum(int num){
		this.picknum = num;
	}
	
	//选取出度最大的picknum个点
	public void pickMaxOD(Vector<Node> nodes){
		int i, maxOD, maxIdx;  //maxOD存放最大出度值，maxIdx存放出度最大点的编号
		Node maxnode;  //出度最大点
		this.nodeVector = nodes;
		boolean[] picked = new boolean[nodeVector.size()];  //标记点是否被选择
		
		System.out.println("正在选择出度最大的十个点");
		for(i = 1;i <= picknum;i++){
			maxOD = maxIdx = -1;  //点从0开始编号
			//遍历点集合，查找未选择的点中出度最大的点
			for(Node tn:nodeVector){  
				if(picked[tn.num]) continue;
				if(tn.getOutDegree(nodeVector, tn.num) > maxOD){
					maxOD = tn.getOutDegree(nodeVector, tn.num);
					maxIdx = tn.getNum();
				}
			}
			picked[maxIdx] = true;  //标记为已选择
			maxnode = nodeVector.get(maxIdx);
			ChooseMaxODNodes.add(maxnode);  //放入已选点集合中
			System.out.print("第" + i +"个点："+maxIdx);
			System.out.println("，它的出度为"+maxOD);

		}
	}
	
	//选取正出度最大的picknum个点
	public void PickMaxPOD(Vector<Node> nodes){
		int i, maxPOD, maxIdx;  ////maxPOD存放最大正出度值，maxIdx存放出度最大点的编号
		Node maxnode;  //正出度最大点
		this.nodeVector = nodes;
		boolean[] picked = new boolean[nodeVector.size()];  //标记点是否被选择
		
		System.out.println("正在选择正出度最大的十个点");
		for(i = 1;i <= picknum;i++){
			maxPOD = maxIdx = -1;
			//遍历点集合，查找未选择的点中正出度最大的点
			for(Node tn:nodeVector){
				if(picked[tn.num]) continue;
				if(tn.getPostiveOD(nodeVector, tn.num) > maxPOD){
					maxPOD = tn.getPostiveOD(nodeVector, tn.num);
					maxIdx = tn.getNum();
				}
			}
			picked[maxIdx] = true;  //标记为已选择
			maxnode = nodeVector.get(maxIdx);
			ChooseMaxPODNodes.add(maxnode);  //放入已选点集合中
			System.out.print("第" + i +"个点："+maxIdx);
			System.out.println("，它的正出度为"+maxPOD);

		}
	}
	
}
