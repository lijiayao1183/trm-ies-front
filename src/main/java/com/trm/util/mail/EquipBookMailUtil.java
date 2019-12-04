package com.trm.util.mail;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @describe 设备预约邮件发送
 * @author zhaosimiao 
 * @date 2017-9-30 10:00:36
 */
@Component("equipBookMailUtil")
public class EquipBookMailUtil {

	/**
	 * SMTP服务器
	 */
	@Value("#{mail.host}")
	private String host;
	
	/**
	 * 登录SMTP服务器的用户名
	 */
	@Value("#{mail.user}")
	private String user;
	
	/**
	 * 登录SMTP服务器的授权码（第三方登录需授权码）
	 */
	@Value("#{mail.pwd}")
	private String pwd; // 密码
	
	/**
	 * 发件人地址
	 */
	@Value("#{mail.from}")
	private String from;
	
	/**
	 * 收件人地址
	 */
	private String to;
	
	/**
	 * 邮件主题
	 */
	private static final String subject = "设备预约提醒-陕西军民融合科技创新资源开放共享管理服务平台";
	
	/**
	 * 邮件内容
	 */
	private String content = "<p>亲爱的{用户名}：</p>"
						+ "<p style='text-align: justify; text-indent: 2em;'>您发布的  {设备设施名称}  被  {预约用户名}  预约，联系方式为  {预约用户注册手机号码}，请您知悉并关注。</p>"
						+ "<p style='text-align: justify; text-indent: 2em;'>如需访问平台，请点击链接</p>"
						+ "<p style='text-align: justify; text-indent: 2em;'>"
						+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style='color: rgb(192, 0, 0); font-size: 20px;'>http://113.201.62.250:18080</span>"
						+ "</p>"
						+ "<p style='text-align: justify; text-indent: 2em;'>感谢您使用陕西军民融合科技创新资源开放共享管理服务平台！</p>"
						+ "<p style='text-align: right;'>开发团队集体</p>";
	
	/**
	 * 附件地址
	 */
	private String affix;
	
	/**
	 * 附件名称
	 */
	private String affixName;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getAffix() {
		return affix;
	}

	public void setAffix(String affix) {
		this.affix = affix;
	}

	public String getAffixName() {
		return affixName;
	}

	public void setAffixName(String affixName) {
		this.affixName = affixName;
	}

	public void send(String username, String equipName, String orderUser, String orderMobile, String to) {
		Properties props = new Properties();
		// 设置发送邮件的邮件服务器的属性（使用网易的smtp服务器）
		props.put("mail.smtp.host", host);
		// 需要经过授权，也就是有户名和密码的校验，这样才能通过验证
		props.put("mail.smtp.auth", "true");
		// 用设置好的props对象构建一个session
		Session session = Session.getDefaultInstance(props);
		// 设置发送邮件的过程中在console处显示过程信息，供调试使，在console上看到发送邮件的过程
		session.setDebug(true);
		// 用session为参数定义消息对象
		MimeMessage message = new MimeMessage(session);
		try {
			// 加载发件人地址
			//message.setFrom(new InternetAddress(from));
			message.setFrom(new InternetAddress(from, MimeUtility.encodeText("陕西军民融合科技创新资源开放共享管理服务平台").toString()));
			// 加载收件人地址
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// 加载邮件主题
			message.setSubject(subject);

			// 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
			Multipart multipart = new MimeMultipart();
			// 设置邮件的文本内容
			BodyPart contentPart = new MimeBodyPart();
			// 内容为HTML
			String userContent = content.replaceAll("\\{用户名\\}", username)
					.replaceAll("\\{设备设施名称\\}", equipName)
					.replaceAll("\\{预约用户名\\}", orderUser)
					.replaceAll("\\{预约用户注册手机号码\\}", orderMobile).replaceAll("\"", "\'");
			
			contentPart.setContent(userContent,"text/html; charset=utf-8");
			multipart.addBodyPart(contentPart);
			
			/*
			// 添加附件
			BodyPart messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(affix);
			// 添加附件的内容
			messageBodyPart.setDataHandler(new DataHandler(source));
			// 添加附件的标题
			// 非常重要，通过下面的Base64编码的转换可以保证你的中文附件标题名在发送时不会变成乱码
			sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
			messageBodyPart.setFileName("=?GBK?B?" + enc.encode(affixName.getBytes()) + "?=");
			multipart.addBodyPart(messageBodyPart);
			*/

			// 将multipart对象放到message中
			message.setContent(multipart);
			// 保存邮件
			message.saveChanges();
			// 发送邮件
			Transport transport = session.getTransport("smtp");
			// 连接服务器的邮箱
			transport.connect(host, user, pwd);
			// 把邮件发送出去
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设置smtp服务器以及邮箱的帐号和密码 用QQ 邮箱作为发生者不好使 （原因不明） 163 邮箱可以，但是必须开启 POP3/SMTP服务
	 * 和 IMAP/SMTP服务 因为程序属于第三方登录，所以登录密码必须使用163的授权码
	 */
	public static void main(String[] args) {
		new MailUtil().send("threewater603", "zhaosimiao@trm-cloud.com", "R1");
	}
}