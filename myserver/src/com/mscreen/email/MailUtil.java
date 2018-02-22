package com.mscreen.email;



import org.apache.commons.mail.EmailException;  
import org.apache.commons.mail.HtmlEmail;  
import org.apache.log4j.Logger;  
  

  
/**  
 * �ʼ����͹���ʵ����  
 *   
 * @author shadow  
 * @create 2013/07/12  
 */  
public class MailUtil {  
  
    protected final Logger logger = Logger.getLogger(getClass());  
  
    public boolean send(Mail mail) {  
        // ����email  
        HtmlEmail email = new HtmlEmail();  
        try {  
            // ������SMTP���ͷ����������֣�163�����£�"smtp.163.com"  
            email.setHostName(mail.getHost());  
            // �ַ����뼯������  
            email.setCharset(Mail.ENCODEING);  
            // �ռ��˵�����  
            email.addTo(mail.getReceiver());  
            // �����˵�����  
            email.setFrom(mail.getSender(), mail.getName());  
            // �����Ҫ��֤��Ϣ�Ļ���������֤���û���-���롣�ֱ�Ϊ���������ʼ��������ϵ�ע�����ƺ�����  
            email.setAuthentication(mail.getUsername(), mail.getPassword());  
            // Ҫ���͵��ʼ�����  
            email.setSubject(mail.getSubject());  
            // Ҫ���͵���Ϣ������ʹ����HtmlEmail���������ʼ�������ʹ��HTML��ǩ  
            email.setMsg(mail.getMessage());  
            // ����  
            email.send();  
            if (logger.isDebugEnabled()) {  
                logger.debug(mail.getSender() + " �����ʼ��� " + mail.getReceiver());  
            }  
            return true;  
        } catch (EmailException e) {  
            e.printStackTrace();  
            logger.info(mail.getSender() + " �����ʼ��� " + mail.getReceiver()  
                    + " ʧ��");  
            return false;  
        }  
    }  
  
}  