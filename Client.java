
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

  Socket socket;

   BufferedReader br;
  PrintWriter out;
 
  public Client(){
      try {
        System.out.println("sending request to server");
          socket = new Socket("127.0.0.1",7777);
          System.out.println("conection done");

           br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          out = new PrintWriter(socket.getOutputStream());

          startReading();
          startWriting();

      } catch (IOException ex) {
        ex.printStackTrace();
      }

  }
  
  public void startWriting()
  {
   Runnable r2 = () ->{

    System.out.println("Writer Started");
    try {
      while(true && !socket.isClosed())
      {
        
           BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
  
           String content = br1.readLine();
           if(content.equals("exit"))
           {
             System.out.println("server terminated the chat");
             socket.close();
             break;
           }
           out.println(content);
           out.flush();
            
        
      }
        
    } catch (Exception e) {
      e.printStackTrace();
    }
   
   };
   new Thread(r2).start();

  }
  public void startReading()
  {
    Runnable r1 =() ->{
      System.out.println("Reader started..");
      try {
        while (true) { 
          
      
          String msg = br.readLine();
          if(msg.equals("exit"))
          {
            System.out.println("server terminated the chat");
            socket.close();
            break;
          }
          System.out.println("server :" + msg);
       
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
 
    
     };
     new Thread(r1).start();
  }

  public static void main(String[] args) {
    
    System.out.println("this is Client...going to start server");
     new Client();  
  }
}
