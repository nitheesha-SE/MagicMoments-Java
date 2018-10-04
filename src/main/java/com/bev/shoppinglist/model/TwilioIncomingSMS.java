package com.bev.shoppinglist.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TwilioIncomingSMS {
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}


/*
ToCountry=US&ToState=IL&SmsMessageSid=SMa0dc3f4ea8109eec8537490fc3df22de&NumMedia=0&ToCity=&FromZip=60714&SmsSid=
        SMa0dc3f4ea8109eec8537490fc3df22de&FromState=IL&SmsStatus=received&FromCity=NORTHBROOK&Body=Tea&FromCountry=US&To=%2B12243103355&ToZip=&NumSegments=1&MessageSid=SMa0dc3f4ea8109eec8537490fc3df22de&AccountSid=ACd6489b7fcf8f81ad194583ad2d22215a&From=%2B18479625894&ApiVersion=2010-04-01
 */
