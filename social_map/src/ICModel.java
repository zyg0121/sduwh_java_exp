
import java.util.Vector;
import java.util.ArrayDeque;
import java.util.Queue;

//ģ����ɢģ��
public class ICModel {
	int total;  //��ɢ�����е�����
    Vector<Node> nodeVector = new Vector<>();  //������н����Ϣ
    PickNode picks = new PickNode(nodeVector,10);  //ѡ��10����
    
    public ICModel(int total, int picknum){
    	this.total = total;
    	picks.setNum(picknum);
    }
    
    public void loadNodes(String path){
    	ReadFile readfiles = new ReadFile(total);
    	readfiles.loadLinks(path, this.nodeVector);  //���ļ��е������е���Ϣ
    }
    
    //�������㼯��Ӱ��������
    public int ODInfluences(){
    	int cnt = 0;
    	int nextnum;
    	double nextv;
    	Queue<Integer> q = new ArrayDeque<>();  //�ö��д洢������㼯
    	boolean[] activated = new boolean[total];  //����Ƿ񱻼���
    	double[] pvalue = new double[total];  //��������
    	
    	//�����ѡ��Ϊ����̬��ѹ�������
    	for(Node tnode: picks.ChooseMaxODNodes){
    		activated[tnode.getNum()] = true;
    		pvalue[tnode.getNum()] = 1;
    		q.offer(tnode.getNum());
    	}
    	
    	//ģ����ɢ
    	while(!q.isEmpty()){
    		Node pNode = nodeVector.get(q.poll());
    		//�����õ��ڽӵ㣬���Լ���
    		for(NextNode next:pNode.next){
    			nextnum = next.getNodenum();
    			nextv = next.getV();
    			//����ģ��
    			if(!activated[nextnum] && Math.abs(nextv)>= Math.random()){
    				activated[next.getNodenum()] = true;
    				pvalue[nextnum] = pvalue[pNode.getNum()] * nextv > 0 ? 1 : -1 ;  //��������ֵ	
    				q.offer(nextnum);  //�������ѹ�������
    			}
    		}
    	}
    	//���㼤���������ΪӰ����
    	for(int i = 0;i < total;i++){
    		if(activated[i] && pvalue[i] == 1){
    			cnt++;
    		}
    	}
    	return cnt;
    }
    
    public int ODIC(){
    	int calnum = 20000; //��ɢģ�����
    	int inf = 0;
    	picks.pickMaxOD(this.nodeVector);
    	for(int i = 1;i <= calnum;i++){
    		inf += ODInfluences();
    	}
    	inf /= calnum;
    	return inf;
    	
    }
    
    //���������㼯��Ӱ��������
    public int PODInfluences(){	
    	int cnt = 0;
    	int nextnum;
    	double nextv;
    	Queue<Integer> q = new ArrayDeque<>();  //�ö��д洢������㼯
    	boolean[] activated = new boolean[total];  //����Ƿ񱻼���
    	double[] pvalue = new double[total];  //��������
    	
    	//�����ѡ��Ϊ����̬��ѹ�������
    	for(Node tnode: picks.ChooseMaxPODNodes){
    		activated[tnode.getNum()] = true;
    		pvalue[tnode.getNum()] = 1;
    		q.offer(tnode.getNum());
    	}
    	
    	//ģ����ɢ
    	while(!q.isEmpty()){
    		Node pNode = nodeVector.get(q.poll());
    		//�����õ��ڽӵ㣬���Լ���
    		for(NextNode next:pNode.next){
    			nextnum = next.getNodenum();
    			nextv = next.getV();
    			//����ģ��
    			if(!activated[nextnum] && Math.abs(nextv)>= Math.random()){
    				activated[next.getNodenum()] = true;
    				pvalue[nextnum] = pvalue[pNode.getNum()] * nextv > 0 ? 1 : -1 ;   //��������ֵ			
    				q.offer(nextnum);  //�������ѹ�������
    			}
    		}
    	}
    	//���㼤���������ΪӰ����
    	for(int i = 0;i < total;i++){
    		if(activated[i] && pvalue[i] == 1){
    			cnt++;
    		}
    	}
    	return cnt;
    }
    
    public int PODIC(){
    	int calnum = 20000; //��ɢģ�����
    	int inf = 0;
    	picks.PickMaxPOD(this.nodeVector);
    	for(int i = 1;i <= calnum;i++){
    		inf += PODInfluences();
    	}
    	inf /= calnum;
    	return inf;
    }
}
