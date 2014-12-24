package util;

import java.io.IOException;
import java.text.Normalizer;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import model.Ve;

import org.smslib.AGateway;
import org.smslib.GatewayException;
import org.smslib.IInboundMessageNotification;
import org.smslib.InboundMessage;
import org.smslib.InboundMessage.MessageClasses;
import org.smslib.Message.MessageTypes;
import org.smslib.OutboundMessage;
import org.smslib.SMSLibException;
import org.smslib.Service;
import org.smslib.TimeoutException;
import org.smslib.modem.SerialModemGateway;

import factory.dao.FactoryDAOImp;
import factory.dao.FactoryDao;
import DAO.VeDAO;

public class SendMessageUtil {
	private static SendMessageUtil instance = new SendMessageUtil();
	private VeDAO veDAO;

	private SendMessageUtil() {

	}

	public void init(String com, String smsNumber) {
		try {
			InboundNotification inboundNotification = new InboundNotification();
			;
			SerialModemGateway gateway = new SerialModemGateway("modem.com1",
					com, 115200, "Huawei", "");
			gateway.setInbound(true);
			gateway.setOutbound(true);
			gateway.setSimPin("0000");
			gateway.setSmscNumber(smsNumber);
			Service.getInstance().setInboundMessageNotification(
					inboundNotification);
			Service.getInstance().addGateway(gateway);
			Service.getInstance().startService();
			instance = new SendMessageUtil();
		} catch (GatewayException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (SMSLibException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void detroy() {
		try {
			Service.getInstance().stopService();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GatewayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SMSLibException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static SendMessageUtil getInstance() {
		return instance;
	}

	public void sendMess(String phoneNumber, String message) {
		OutboundMessage msg = new OutboundMessage(phoneNumber,
				unAccent(message));
		Service.getInstance().queueMessage(msg);
	}

	public void forgetPassword(String phoneNumber, String password) {
		OutboundMessage msg = new OutboundMessage(phoneNumber,
				"Mat khau moi cua quy khach la: " + password);
		Service.getInstance().queueMessage(msg);
	}

	public void sendTicket(String phoneNumber, Ve ve) {
		if (instance == null)
			return;
		String mes = "Thong tin ve cua quy khach vua dat la:\n-Ma Ve : "
				+ ve.getMaVe()
				+ "\n-Tuyen : "
				+ ve.getTuyenXe()
				+ "\n-Gio khoi hanh : "
				+ ve.getNgayKhoiHanh()
				+ "\n-Danh sach ghe : "
				+ ve.getTenGhe()
				+ "\n-Thoi han thanh toan : "
				+ ve.getThoiHanThanhToan()
				+ "\nXin vui long thanh toan truoc thoi han neu khong ve se tu dong huy! Xin cam on! vexeonline.com";
		OutboundMessage msg = new OutboundMessage(phoneNumber, unAccent(mes));
		Service.getInstance().queueMessage(msg);
	}

	private String unAccent(String s) {
		String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D")
				.replace("đ", "");
	}

	class InboundNotification implements IInboundMessageNotification {
		public void process(AGateway gateway, MessageTypes msgType,
				InboundMessage msg) {
			InboundMessage[] arr;
			StringTokenizer stk;
			System.out.println(msg.getOriginator() + " : " + msg.getText());
			try {
				arr = Service.getInstance().readMessages(MessageClasses.ALL);
				Service.getInstance().deleteMessage(msg);
				for (int i = 0; i < arr.length; i++) {
					stk = new StringTokenizer(arr[i].getText());
					if (stk.countTokens() != 2) {
						sendMess(arr[i].getOriginator(), "Tin nhan sai cu phap");
					} else {
						if ("ve".equalsIgnoreCase(stk.nextToken())) {
							System.out.println(msg.getOriginator() + " : " + msg.getText());
							String mes = veDAO.giaHan(stk.nextToken());
							System.out.println(mes);
							if(mes == null)
								sendMess("+" +arr[i].getOriginator(), "Gia hạn vé thanh công");
							else{
								sendMess("+" +arr[i].getOriginator(), mes);
							}
						}
					}
				}
			} catch (TimeoutException | GatewayException | IOException
					| InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public VeDAO getVeDAO() {
		veDAO = (VeDAO) (veDAO == null ? new FactoryDAOImp()
				.createDAO(FactoryDao.VE_DAO) : veDAO);
		return veDAO;
	}

}
