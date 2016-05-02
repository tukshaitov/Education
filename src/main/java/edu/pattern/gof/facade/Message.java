package edu.pattern.gof.facade;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eldar on 11/9/2015.
 */
public class Message {
    private MessageHeader messageHeader;
    private MessageBody messageBody;
    private List<Attachment> attachmentList = new ArrayList<>();

    public Message(MessageHeader messageHeader, MessageBody messageBody) {
        this.messageHeader = messageHeader;
        this.messageBody = messageBody;
    }

    public MessageHeader getMessageHeader() {
        return messageHeader;
    }

    public void setMessageHeader(MessageHeader messageHeader) {
        this.messageHeader = messageHeader;
    }

    public MessageBody getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(MessageBody messageBody) {
        this.messageBody = messageBody;
    }

    public void addAttachment(Attachment attachment){
        attachmentList.add(attachment);
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageHeader=" + messageHeader +
                ", messageBody=" + messageBody +
                '}';
    }
}
