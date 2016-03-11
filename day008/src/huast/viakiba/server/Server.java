package huast.viakiba.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws Exception{
		ServerSocket server=new ServerSocket(8888);
		System.out.println("服务器已经启动。。。。。");
		Socket socket=server.accept();
		FileInputStream in=new FileInputStream(new File("e:/test.html"));
		OutputStream out=socket.getOutputStream();
		
		byte[] buf=new byte[1024];
		int len=0;
		while((len=in.read(buf))!=-1){
			out.write(buf);
		}
		out.close();
		in.close();
	}
}
