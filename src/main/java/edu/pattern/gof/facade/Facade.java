package edu.pattern.gof.facade;

import org.w3c.dom.Element;

/**
 * Created by Eldar on 11/9/2015.
 */
public class Facade {
    private MessageSender messageSender;

    public Facade(String smppIp, String login, String password){
        messageSender = new MessageSender(smppIp,login,password);
    }

    public void sendMessage(String from, String to, String subject, String header, String text, String filePath) {
        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setFrom(from);
        messageHeader.setTo(to);
        messageHeader.setSubject(subject);

        Attachment attachment = new Attachment(filePath).load();
        MessageBody messageBody = new MessageBody();
        Element body = messageBody.addElement("body", null);
        messageBody.addElement(body, "hr", header);
        if(attachment != null) {
            Element image = messageBody.addElement(body, "image", "::attachment[" + 0 + "]");
        }
        messageBody.addElement(body, "div", text, new AttributeValue("style", "font-style: 'italic';"));
        Message message = new Message(messageHeader, messageBody);
        message.addAttachment(attachment);
        messageSender.send(message);
    }
}
