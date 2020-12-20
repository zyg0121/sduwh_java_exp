
import java.util.Vector;
import java.util.ArrayDeque;
import java.util.Queue;

//模拟扩散模型
public class ICModel {
	int total;  //扩散网络中点总数
    Vector<Node> nodeVector = new Vector<>();  //存放所有结点信息
    PickNode picks = new PickNode(nodeVector,10);  //选择10个点
    
    public ICModel(int total, int picknum){
    	this.total = total;
    	picks.setNum(picknum);
    }
    
    public void loadNodes(String path){
    	ReadFile readfiles = new ReadFile(total);
    	readfiles.loadLinks(path, this.nodeVector);  //从文件中导入所有点信息
    }
    
    //出度最大点集的影响力计算
    public int ODInfluences(){
    	int cnt = 0;
    	int nextnum;
    	double nextv;
    	Queue<Integer> q = new ArrayDeque<>();  //用队列存储被激活点集
    	boolean[] activated = new boolean[total];  //标记是否被激活
    	double[] pvalue = new double[total];  //正负激活
    	
    	//标记已选点为激活态并压入队列中
    	for(Node tnode: picks.ChooseMaxODNodes){
    		activated[tnode.getNum()] = true;
    		pvalue[tnode.getNum()] = 1;
    		q.offer(tnode.getNum());
    	}
    	
    	//模拟扩散
    	while(!q.isEmpty()){
    		Node pNode = nodeVector.get(q.poll());
    		//遍历该点邻接点，尝试激活
    		for(NextNode next:pNode.next){
    			nextnum = next.getNodenum();
    			nextv = next.getV();
    			//激活模拟
    			if(!activated[nextnum] && Math.abs(nextv)>= Math.random()){
    				activated[next.getNodenum()] = true;
    				pvalue[nextnum] = pvalue[pNode.getNum()] * nextv > 0 ? 1 : -1 ;  //正负激活值	
    				q.offer(nextnum);  //将激活点压入队列中
    			}
    		}
    	}
    	//计算激活点数量作为影响力
    	for(int i = 0;i < total;i++){
    		if(activated[i] && pvalue[i] == 1){
    			cnt++;
    		}
    	}
    	return cnt;
    }
    
    public int ODIC(){
    	int calnum = 20000; //扩散模拟次数
    	int inf = 0;
    	picks.pickMaxOD(this.nodeVector);
    	for(int i = 1;i <= calnum;i++){
    		inf += ODInfluences();
    	}
    	inf /= calnum;
    	return inf;
    	
    }
    
    //正出度最大点集的影响力计算
    public int PODInfluences(){	
    	int cnt = 0;
    	int nextnum;
    	double nextv;
    	Queue<Integer> q = new ArrayDeque<>();  //用队列存储被激活点集
    	boolean[] activated = new boolean[total];  //标记是否被激活
    	double[] pvalue = new double[total];  //正负激活
    	
    	//标记已选点为激活态并压入队列中
    	for(Node tnode: picks.ChooseMaxPODNodes){
    		activated[tnode.getNum()] = true;
    		pvalue[tnode.getNum()] = 1;
    		q.offer(tnode.getNum());
    	}
    	
    	//模拟扩散
    	while(!q.isEmpty()){
    		Node pNode = nodeVector.get(q.poll());
    		//遍历该点邻接点，尝试激活
    		for(NextNode next:pNode.next){
    			nextnum = next.getNodenum();
    			nextv = next.getV();
    			//激活模拟
    			if(!activated[nextnum] && Math.abs(nextv)>= Math.random()){
    				activated[next.getNodenum()] = true;
    				pvalue[nextnum] = pvalue[pNode.getNum()] * nextv > 0 ? 1 : -1 ;   //正负激活值			
    				q.offer(nextnum);  //将激活点压入队列中
    			}
    		}
    	}
    	//计算激活点数量作为影响力
    	for(int i = 0;i < total;i++){
    		if(activated[i] && pvalue[i] == 1){
    			cnt++;
    		}
    	}
    	return cnt;
    }
    
    public int PODIC(){
    	int calnum = 20000; //扩散模拟次数
    	int inf = 0;
    	picks.PickMaxPOD(this.nodeVector);
    	for(int i = 1;i <= calnum;i++){
    		inf += PODInfluences();
    	}
    	inf /= calnum;
    	return inf;
    }
}
