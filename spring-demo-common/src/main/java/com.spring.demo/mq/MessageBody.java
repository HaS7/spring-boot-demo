package com.spring.demo.mq;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageBody {
    private long messageId;
    private String messageReceiver;
    private String messageSender;
    private String messageContent;
    public MessageBody(long messageId,String messageReceiver,String messageSender,String messageContent){
        this.messageId = messageId;
        this.messageReceiver = messageReceiver;
        this.messageSender = messageSender;
        this.messageContent = messageContent;
    }
    //这个无参数构造器必须要有
    public MessageBody(){
    }
}
