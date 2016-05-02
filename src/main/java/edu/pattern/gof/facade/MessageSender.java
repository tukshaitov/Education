package edu.pattern.gof.facade;

/**
 * Created by Eldar on 11/9/2015.
 */
public class MessageSender {
    private String smppIp;
    private String login;
    private String password;

    public MessageSender(String smppIp, String login, String password) {
        this.smppIp = smppIp;
        this.login = login;
        this.password = password;
    }

    public void send(Message message){
        System.out.println(message + " is sent.");
    }
}
