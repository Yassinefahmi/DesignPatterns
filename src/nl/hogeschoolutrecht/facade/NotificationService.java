package nl.hogeschoolutrecht.facade;

public class NotificationService
{
    public void send(String message, String target)
    {
        NotificationServer notificationServer = new NotificationServer();

        Connection connection = notificationServer.connect("127.0.0.1");
        AuthToken authToken = notificationServer.authenticate("appId", "key");

        notificationServer.send(authToken, new Message(message), target);

        connection.disconnect();
    }
}
