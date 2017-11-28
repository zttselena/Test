package com.frame.mall.core.mail;

/**
 * Created by wangyanlong on 2017/4/6.
 */

import java.text.*;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * 有一封邮件就需要建立一个ReciveMail对象
 */
public class ReciveMail {
    private MimeMessage mimeMessage = null;
    private final String dateformat = "yy-MM-dd HH:mm"; //默认的日前显示格式

    private String saveAttachPath; //附件下载后的存放目录
    private String host;   //smtp.126.com  的host
    private int port;      //收件服务器  端口
    private String file;
    private String username;   //邮箱账户
    private String password;   //授权的密码
    private String popHost;   //pop3的host pop.126.com

    private StringBuffer bodytext = new StringBuffer();//存放邮件内容

    public ReciveMail() {
    }

    public ReciveMail(MimeMessage mimeMessage) {
        this.mimeMessage = mimeMessage;
    }

    /**
     * 获得发件人的地址和姓名
     */
    public String getFrom() throws Exception {
        InternetAddress address[] = (InternetAddress[]) mimeMessage.getFrom();
        String from = address[0].getAddress();
        if (from == null)
            from = "";
        String personal = address[0].getPersonal();
        if (personal == null)
            personal = "";
        String fromaddr = personal + "<" + from + ">";
        return fromaddr;
    }

    /**
     * 获得邮件的收件人，抄送，和密送的地址和姓名，根据所传递的参数的不同 "to"----收件人 "cc"---抄送人地址 "bcc"---密送人地址
     */
    public String getMailAddress(String type) throws Exception {
        String mailaddr = "";
        String addtype = type.toUpperCase();
        InternetAddress[] address = null;
        if (addtype.equals("TO") || addtype.equals("CC") || addtype.equals("BCC")) {
            if (addtype.equals("TO")) {
                address = (InternetAddress[]) mimeMessage.getRecipients(Message.RecipientType.TO);
            } else if (addtype.equals("CC")) {
                address = (InternetAddress[]) mimeMessage.getRecipients(Message.RecipientType.CC);
            } else {
                address = (InternetAddress[]) mimeMessage.getRecipients(Message.RecipientType.BCC);
            }
            if (address != null) {
                for (int i = 0; i < address.length; i++) {
                    String email = address[i].getAddress();
                    if (email == null)
                        email = "";
                    else {
                        email = MimeUtility.decodeText(email);
                    }
                    String personal = address[i].getPersonal();
                    if (personal == null)
                        personal = "";
                    else {
                        personal = MimeUtility.decodeText(personal);
                    }
                    String compositeto = personal + "<" + email + ">";
                    mailaddr += "," + compositeto;
                }
                mailaddr = mailaddr.substring(1);
            }
        } else {
            throw new Exception("Error emailaddr type!");
        }
        return mailaddr;
    }

    /**
     * 获得邮件主题
     */
    public String getSubject() throws MessagingException {
        String subject = "";
        try {
            subject = MimeUtility.decodeText(mimeMessage.getSubject());
            if (subject == null)
                subject = "";
        } catch (Exception exce) {
        }
        return subject;
    }

    /**
     * 判断此邮件是否需要回执，如果需要回执返回"true",否则返回"false"
     */
    public boolean getReplySign() throws MessagingException {
        boolean replysign = false;
        String needreply[] = mimeMessage
                .getHeader("Disposition-Notification-To");
        if (needreply != null) {
            replysign = true;
        }
        return replysign;
    }

    /**
     * 获得此邮件的Message-ID
     */
    public String getMessageId() throws MessagingException {
        return mimeMessage.getMessageID();
    }

    /**
     * 【判断此邮件是否已读，如果未读返回返回false,反之返回true】
     */
    public boolean isNew() throws MessagingException {
        boolean isnew = false;
        Flags flags = ((Message) mimeMessage).getFlags();
        Flags.Flag[] flag = flags.getSystemFlags();
        System.out.println("flags's length: " + flag.length);
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] == Flags.Flag.SEEN) {
                isnew = true;
                System.out.println("seen Message.......");
                break;
            }
        }
        return isnew;
    }


    /**
     * 获得邮件发送日期
     */
    public String getSentDate() throws Exception {
        Date sentdate = mimeMessage.getSentDate();
        SimpleDateFormat format = new SimpleDateFormat(dateformat);
        return format.format(sentdate);
    }

    public MimeMessage getMimeMessage() {
        return mimeMessage;
    }

    public void setMimeMessage(MimeMessage mimeMessage) {
        this.mimeMessage = mimeMessage;
    }

    public StringBuffer getBodytext() {
        return bodytext;
    }

    public void setBodytext(StringBuffer bodytext) {
        this.bodytext = bodytext;
    }

    public String getPopHost() {
        return popHost;
    }

    public void setPopHost(String popHost) {
        this.popHost = popHost;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * 【设置附件存放路径】
     */

    public void setAttachPath(String attachpath) {
        this.saveAttachPath = attachpath;
    }


    /**
     * 获得邮件正文内容
     */
    public String getBodyText() {
        return bodytext.toString();
    }

    /**
     * 【获得附件存放路径】
     */
    public String getAttachPath() {
        return saveAttachPath;
    }

}
