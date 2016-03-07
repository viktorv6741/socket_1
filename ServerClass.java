package socket_1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerClass {

    public static void main(String... args) throws IOException, ClassNotFoundException {

        ServerSocket serverSocket = new ServerSocket(8080);
        Socket accept = serverSocket.accept();

//////////////////////////////////////////////////////////////////////////

        ObjectInputStream objectInputStream = new ObjectInputStream(accept.getInputStream());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(accept.getOutputStream());

//////////////////////////////////////////////////////////////////////////

        UserClass changedByServer = (UserClass) objectInputStream.readObject();

        changedByServer.setName("Changed_Name");
        //changedByServer.setSurName("Changed_SurName");
        //changedByServer.setAge(23);

        objectOutputStream.writeObject(changedByServer);
        objectOutputStream.flush();
    }
}
