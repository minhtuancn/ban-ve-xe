import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/checkGhe")
public class ServerCheckGhe {
	static Set<Session> room = Collections
			.synchronizedSet(new HashSet<Session>());
	static boolean[] ghe = new boolean[45];

	@OnOpen
	public void open(Session session) {
		System.out.println("connecting...");
		room.add(session);
	}

	@OnClose
	public void close(Session session) {
		System.out.println("disConnecting...");
		room.remove(session);
	}

	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		int ighe = Integer.parseInt(message);
		if (ghe[ighe]) {
			session.getBasicRemote().sendText(
					buildJsonData("check", "false", "ghe", message));
		} else {
			session.getBasicRemote().sendText(
					buildJsonData("check", "true", "ghe", message));
			ghe[ighe] = true;
			Iterator<Session> i = room.iterator();
			while (i.hasNext()) {
				Session session2 = i.next();
				if (session2.equals(session))
					continue;
				session2.getBasicRemote()
						.sendText(buildJsonData("set", message));
			}
		}
	}

	private String buildJsonData(String user, String message) {
		JsonObject jsonObj = Json.createObjectBuilder().add(user, message)
				.build();
		StringWriter stringWriter = new StringWriter();
		JsonWriter jsonWriter = Json.createWriter(stringWriter);
		jsonWriter.writeObject(jsonObj);
		System.out.println(stringWriter.toString());
		return stringWriter.toString();
	}

	private String buildJsonData(String check, String ok, String ghe,
			String soGhe) {
		JsonObject jsonObj = Json.createObjectBuilder().add(check, ok)
				.add(ghe, soGhe).build();
		StringWriter stringWriter = new StringWriter();
		JsonWriter jsonWriter = Json.createWriter(stringWriter);
		jsonWriter.writeObject(jsonObj);
		System.out.println(stringWriter.toString());
		return stringWriter.toString();
	}
}
