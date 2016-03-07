package socket_1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Logger;

public class ClientClass {

    public static void main(String... args) throws IOException, ClassNotFoundException, InterruptedException {

        Logger logger = Logger.getLogger(ClientClass.class.getName());

///////////////////////////////////////////////////////////////////////////////////////////

        InetAddress clientIP = InetAddress.getByName("127.0.0.1");
        Socket client = new Socket(clientIP, 8080);

        UserClass userClass = new UserClass("Test_User", "Test_User", 29);

///////////////////////////////////////////////////////////////////////////////////////////

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());
        ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());

///////////////////////////////////////////////////////////////////////////////////////////

        //System.out.println(userClass.toString());

        objectOutputStream.writeObject(userClass);
        objectOutputStream.flush();
        logger.info("Client sent the userClass-object to Server" + "\n");

///////////////////////////////////////////////////////////////////////////////////////////

        UserClass changedByServerFromClientSide = (UserClass) objectInputStream.readObject();
        logger.info("Client's got object from Server" + "\n");
        if (!(changedByServerFromClientSide.getName().equals(userClass.getName()))) {
            logger.info("Server changed name from "
                    + userClass.getName()
                    + " to " + changedByServerFromClientSide.getName() + "\n");
        }
        if (!(changedByServerFromClientSide.getSurName().equals(userClass.getSurName()))) {
            logger.info("Server changed surname from "
                    + userClass.getSurName()
                    + " to " + changedByServerFromClientSide.getSurName() + "\n");
        }
        if (changedByServerFromClientSide.getAge() != userClass.getAge()) {
            logger.info("Server changed age from "
                    + userClass.getSurName()
                    + " to " + changedByServerFromClientSide.getSurName() + "\n");
        }
        //System.out.println(changedByServerFromClientSide.toString());


        objectOutputStream.close();
        objectInputStream.close();
    }
}
