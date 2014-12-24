package util;

import java.io.IOException;
import java.text.Normalizer;
import java.util.regex.Pattern;

import model.Ve;

import org.smslib.GatewayException;
import org.smslib.Message.MessageEncodings;
import org.smslib.OutboundMessage;
import org.smslib.SMSLibException;
import org.smslib.Service;
import org.smslib.TimeoutException;
import org.smslib.modem.SerialModemGateway;

public class SendMessageUtil {
	private static SendMessageUtil instance;

	private SendMessageUtil() {

	}

	public static void init(String com, String smsNumber) {
		try {
			SerialModemGateway gateway = new SerialModemGateway("modem.com1",
					com, 115200, "Huawei", "");
			gateway.setInbound(true);
			gateway.setOutbound(true);
			gateway.setSimPin("0000");
			gateway.setSmscNumber(smsNumber);
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

	public void forgetPassword(String phoneNumber, String password) {
		OutboundMessage msg = new OutboundMessage(phoneNumber,
				"Mat khau moi cua quy khach la: " + password);
		Service.getInstance().queueMessage(msg);
	}

	public void sendTicket(String phoneNumber, Ve ve) {
		if(instance == null) return;
		String mes = "Thong tin ve cua quy khach vua dat la:\n-Ma Ve : "
				+ ve.getMaVe() + "\n-Tuyen : " + ve.getTuyenXe()
				+ "\n-Gio khoi hanh : " + ve.getNgayKhoiHanh()
				+ "\n-Danh sach ghe : " + ve.getTenGhe()
				+ "\n-Thoi han thanh toan : " + ve.getThoiHanThanhToan() + "\nXin vui long thanh toan truoc thoi han neu khong ve se tu dong huy! Xin cam on! vexeonline.com";
		OutboundMessage msg = new OutboundMessage(phoneNumber, unAccent(mes));
		Service.getInstance().queueMessage(msg);
	}

	private String unAccent(String s) {
		String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D").replace("đ", "");
	}
}
