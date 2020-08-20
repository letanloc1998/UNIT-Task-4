package vn.com.unit.service;

import java.io.IOException;
import java.net.InetSocketAddress;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.java_websocket.server.WebSocketServer;
import org.springframework.stereotype.Service;

import vn.com.unit.socket.ChatServerSocket;

@Service
public class ChatServerService {

	WebSocketServer server;

	@PostConstruct
	public void initChatServerSocket() {
//		String host = "localhost";
//		int port = 8081;
//
//		server = new ChatServerSocket(new InetSocketAddress(host, port));
//		server.run();
	}

	@PreDestroy
	public void stopChatServerSocket() throws IOException, InterruptedException {
		server.stop();
	}

}
