package vn.com.unit.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;

import vn.com.unit.socket.ChatServerSocket;

@Service
public class ChatServerService {

//	private ChatServerSocket server = new ChatServerSocket();

	@PostConstruct
	public void initChatServerSocket() {

//		server = new ChatServerSocket();
//		server.start();
		
		Configuration config = new Configuration();
		config.setHostname("localhost");
		config.setPort(8088);
		SocketConfig socketConfig = new SocketConfig();
		socketConfig.setReuseAddress(true);

		config.setSocketConfig(socketConfig);

		SocketIOServer server = new SocketIOServer(config);
		server.start();
	}

	@PreDestroy
	public void stopChatServerSocket() {
//		server.stop();
	}

}
