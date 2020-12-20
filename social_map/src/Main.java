
public class Main {
	public static void main(String[] args){
		int ODIF, PODIF;  //分别存储出度法和正出度法计算影响力结果
		ICModel IC = new ICModel(20000,10);
        String path = "links.txt"; // 输入文件路径
        IC.loadNodes(path);
        
        System.out.println("正在计算出度最大的10个点的影响力");
        ODIF = IC.ODIC();
		System.out.println("影响力均值为："+ ODIF);
//        System.out.println((endTime1 - startTime1) / 1000 + "seconds"); // 输出运行时间(以秒为单位)
        
        System.out.println("==================================");

        System.out.println("正在计算正出度最大的10个点的影响力");
        PODIF = IC.PODIC();
		System.out.println("影响力均值为："+ PODIF);
	}
}
