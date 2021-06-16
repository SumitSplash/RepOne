package com.splashlearn.app.util;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

import com.splashlearn.app.library.AppiumLibrary;

import io.appium.java_client.android.AndroidDriver;

public class MailReader extends AppiumLibrary {

	public MailReader(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static int GmailMailReader(String mailFolderName, String emailSubjectContent, int lengthOfOTP) {

		// mailFolderName(Eg- "INBOX"), emailSubjectContent(Eg- Mail for
		// OTP),emailContent(Eg- OTP is 111111), OTP length(Eg- 6)
		String hostName = "smtp.gmail.com";// change it according to your mail

		String username = "sumit.bansal@splashlearn.com";

		String password = "Trigger.16@";

		int messageCount;

		int unreadMsgCount;

		String emailSubject;

		Message emailMessage;

		String searchText = null;

		int OTP = 0;

		Properties sysProps = System.getProperties();

		sysProps.setProperty("mail.store.protocol", "imaps");

		try {

			Session session = Session.getInstance(sysProps, null);

			Store store = session.getStore();

			store.connect(hostName, username, password);

			Folder emailBox = store.getFolder(mailFolderName);

			emailBox.open(Folder.READ_WRITE);

			messageCount = emailBox.getMessageCount();

			// System.out.println("Total Message Count: " + messageCount);

			unreadMsgCount = emailBox.getUnreadMessageCount();

			// System.out.println("Unread Emails count:" + unreadMsgCount);

			for (int i = messageCount; i > (messageCount - unreadMsgCount); i--)

			{

				emailMessage = emailBox.getMessage(i);

				emailSubject = emailMessage.getSubject();

				if (emailSubject.startsWith(emailSubjectContent))

				{
					// System.out.println(emailSubject);

					// System.out.println("OTP mail found");

					// String line;

					String line2 = emailSubject.substring(9, 13);

					OTP = Integer.parseInt(line2);

					// System.out.println(line2);

					// StringBuffer buffer = new StringBuffer();

					// BufferedReader reader = new BufferedReader(new
					// InputStreamReader(emailMessage.getInputStream()));

					// while ((line = reader.readLine()) != null) {

					// buffer.append(line);

					// }

					// String messageContent = emailContent;

					// String result =
					// buffer.toString().substring(buffer.toString().indexOf(messageContent));

					// searchText = result.substring(messageContent.length(),
					// messageContent.length() + lengthOfOTP);

					// System.out.println("Text found : " + searchText);

//					emailMessage.setFlag(Flags.Flag.SEEN, true);

					break;

				}

				// emailMessage.setFlag(Flags.Flag.SEEN, true);

			}

			emailBox.close(true);

			store.close();

		} catch (Exception mex) {
			mex.printStackTrace();

			System.out.println("OTP Not found ");

		}

		return OTP;

	}

}
