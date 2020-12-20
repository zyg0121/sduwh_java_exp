
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Vector;

public class ReadFile {

    int num;  //需要读取的节点的个数
    public ReadFile(int num) {
        this.num=num;
    }
    /*
    * 函数功能：用来从文件中读取并存储到Node中
    * path 用来获取文件名称
    */
    public void loadLinks(String path, Vector<Node> nodeVector) {

        for (int i = 0; i < this.num; i++) {
            nodeVector.add(new Node(i)); //创建num个Node节点，每个节点的编号为0-20000(符合文件内的数据)
        }
    	
        //与文件读入有关的变量
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
                * 分别获取每行的四个数据
                * num1为有向网的出发点（弧尾），num2为到达点（弧头）
                * double1为正负影响，double2为影响的概率*/

                int num1 = Integer.parseInt(pairs[0]);
                int num2 = Integer.parseInt(pairs[1]);
                double double1 = Double.parseDouble(pairs[2]);
                double double2 = Double.parseDouble(pairs[3]);                
                //将以num1为弧尾的有向边信息存入对应动态数组中
                nodeVector.get(num1).addNextNode(num2,double1 * double2);
            }

        }
        
        //异常处理
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

