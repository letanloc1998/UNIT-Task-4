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

	@PostConstruct
	public void initChatServerSocket() {
		ChatServerSocket.start();
	}

	@PreDestroy
	public void stopChatServerSocket() {
		ChatServerSocket.stop();
	}

}
