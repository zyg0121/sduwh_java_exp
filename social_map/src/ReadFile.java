
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Vector;

public class ReadFile {

    int num;  //��Ҫ��ȡ�Ľڵ�ĸ���
    public ReadFile(int num) {
        this.num=num;
    }
    /*
    * �������ܣ��������ļ��ж�ȡ���洢��Node��
    * path ������ȡ�ļ�����
    */
    public void loadLinks(String path, Vector<Node> nodeVector) {

        for (int i = 0; i < this.num; i++) {
            nodeVector.add(new Node(i)); //����num��Node�ڵ㣬ÿ���ڵ�ı��Ϊ0-20000(�����ļ��ڵ�����)
        }
    	
        //���ļ������йصı���
        LineNumberReader reader = null;
        FileReader in = null;
        String[] pairs;

        try {
            in = new FileReader(path);
            reader = new LineNumberReader(in);

            while (true) {
                String str = reader.readLine();
                if (str == null) {
                    break;
                }
                pairs = str.split(" ");
                /*
                * �ֱ��ȡÿ�е��ĸ�����
                * num1Ϊ�������ĳ����㣨��β����num2Ϊ����㣨��ͷ��
                * double1Ϊ����Ӱ�죬double2ΪӰ��ĸ���*/

                int num1 = Integer.parseInt(pairs[0]);
                int num2 = Integer.parseInt(pairs[1]);
                double double1 = Double.parseDouble(pairs[2]);
                double double2 = Double.parseDouble(pairs[3]);                
                //����num1Ϊ��β���������Ϣ�����Ӧ��̬������
                nodeVector.get(num1).addNextNode(num2,double1 * double2);
            }

        }
        
        //�쳣����
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

