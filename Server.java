import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Server {

  ServerSocket server;
  Socket socket;

  BufferedReader br;
  PrintWriter out;

  public Server() 
  {
      try {
          server = new ServerSocket(7777);
          System.out.println("server is ready to accept connection");
          System.out.println("waiting...");
          socket = server.accept();
          br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          out = new PrintWriter(socket.getOutputStream());

          startReading();
          startWriting();

      } catch (Exception e) {
        e.printStackTrace();
      }
  }

  /**
   * 
   */
  public void startWriting()
  {
   Runnable r2 = () ->{

    System.out.println("Writer Started");

    try{
      while(true && !socket.isClosed())
      {
        
           BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
           String content = br1.readLine();
           if(content.equals("exit"))
           {
            socket.close();
            break;
           }
           out.println(content);
           out.flush();
            
       
      }
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
   
   };
   new Thread(r2).start();

  }
  public void startReading()
  {
    Runnable r1 =() ->{
      System.out.println("Reader started..");

      try
      {
        while (true) { 
          
      
          String msg = br.readLine();
          if(msg.equals("exit"))
          {
            System.out.println("clinet terminated the chat");
            socket.close();
            break;
          }
          System.out.println("client :" + msg);
        
        }
      }
      catch(Exception e){
      e.printStackTrace();
      }
 

     };
     new Thread(r1).start();
  }

  public static void main(String[] args) {
    
    System.out.println("this is server...going to start server");
    new Server();

    
  }
}