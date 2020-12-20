

import java.util.Vector;

public class PickNode {
	int picknum;  //Ҫѡȡ�ĵ�ĸ���
	Vector<Node> nodeVector = new Vector<>();  //������н����Ϣ
	Vector<Node> ChooseMaxODNodes = new Vector<>();  //�����ѡ��ĳ�������
	Vector<Node> ChooseMaxPODNodes = new Vector<>();  //�����ѡ�������������

	public PickNode(Vector<Node> nodes, int num){
		this.nodeVector = nodes;
		this.picknum = num;
	}
	
	//����Ҫѡ��ĵ����
	public void setNum(int num){
		this.picknum = num;
	}
	
	//ѡȡ��������picknum����
	public void pickMaxOD(Vector<Node> nodes){
		int i, maxOD, maxIdx;  //maxOD���������ֵ��maxIdx��ų�������ı��
		Node maxnode;  //��������
		this.nodeVector = nodes;
		boolean[] picked = new boolean[nodeVector.size()];  //��ǵ��Ƿ�ѡ��
		
		System.out.println("����ѡ���������ʮ����");
		for(i = 1;i <= picknum;i++){
			maxOD = maxIdx = -1;  //���0��ʼ���
			//�����㼯�ϣ�����δѡ��ĵ��г������ĵ�
			for(Node tn:nodeVector){  
				if(picked[tn.num]) continue;
				if(tn.getOutDegree(nodeVector, tn.num) > maxOD){
					maxOD = tn.getOutDegree(nodeVector, tn.num);
					maxIdx = tn.getNum();
				}
			}
			picked[maxIdx] = true;  //���Ϊ��ѡ��
			maxnode = nodeVector.get(maxIdx);
			ChooseMaxODNodes.add(maxnode);  //������ѡ�㼯����
			System.out.print("��" + i +"���㣺"+maxIdx);
			System.out.println("�����ĳ���Ϊ"+maxOD);

		}
	}
	
	//ѡȡ����������picknum����
	public void PickMaxPOD(Vector<Node> nodes){
		int i, maxPOD, maxIdx;  ////maxPOD������������ֵ��maxIdx��ų�������ı��
		Node maxnode;  //����������
		this.nodeVector = nodes;
		boolean[] picked = new boolean[nodeVector.size()];  //��ǵ��Ƿ�ѡ��
		
		System.out.println("����ѡ������������ʮ����");
		for(i = 1;i <= picknum;i++){
			maxPOD = maxIdx = -1;
			//�����㼯�ϣ�����δѡ��ĵ������������ĵ�
			for(Node tn:nodeVector){
				if(picked[tn.num]) continue;
				if(tn.getPostiveOD(nodeVector, tn.num) > maxPOD){
					maxPOD = tn.getPostiveOD(nodeVector, tn.num);
					maxIdx = tn.getNum();
				}
			}
			picked[maxIdx] = true;  //���Ϊ��ѡ��
			maxnode = nodeVector.get(maxIdx);
			ChooseMaxPODNodes.add(maxnode);  //������ѡ�㼯����
			System.out.print("��" + i +"���㣺"+maxIdx);
			System.out.println("������������Ϊ"+maxPOD);

		}
	}
	
}
