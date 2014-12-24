package util;

import java.io.IOException;

import javax.servlet.ServletContext;

import model.Ve;

import org.smslib.GatewayException;
import org.smslib.OutboundMessage;
import org.smslib.SMSLibException;
import org.smslib.Service;
import org.smslib.TimeoutException;
import org.smslib.modem.SerialModemGateway;

public class SendMessageUtil {
	private static SendMessageUtil instance ;

	private SendMessageUtil() {
		
	}
	public static void init(String com, String smsNumber){
		try {
			SerialModemGateway gateway = new SerialModemGateway("modem.com1", com, 115200, "Huawei", "");
			gateway.setInbound(true);
			gateway.setOutbound(true);
			gateway.setSimPin("0000");
			gateway.setSmscNumber(smsNumber);
			Service.getInstance().addGateway(gateway);
			Service.getInstance().startService();
			System.in.read();
			Service.getInstance().stopService();
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
	public static SendMessageUtil getInstance(){
		return instance;
	}
	public void forgetPassword(String phoneNumber, String password){
		OutboundMessage msg = new OutboundMessage(phoneNumber, "Mat khau moi cua quy khach la: " + password);
		Service.getInstance().queueMessage(msg);
	}
	public void sendTicket(String phoneNumber, Ve ve){
		String mes = "Thong tin ve cua quy khach vua dat la:\nMa Ve : " + ve.getMaVe() + "\nTuyen : " + ve.getTuyenXe() + "\nGio khoi hanh : " + ve.getNgayKhoiHanh() + "\nDanh sach ghe : " + ve.getTenGhe();
		OutboundMessage msg = new OutboundMessage(phoneNumber, mes);
		Service.getInstance().queueMessage(msg);
	}
}
