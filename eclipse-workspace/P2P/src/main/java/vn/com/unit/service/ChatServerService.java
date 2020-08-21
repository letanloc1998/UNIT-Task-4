package vn.com.unit.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

import vn.com.unit.socket.ChatServerSocket;

@Service
public class ChatServerService {

	private ChatServerSocket server;

	@PostConstruct
	public void initChatServerSocket() {

		server = new ChatServerSocket();
		server.start();
	}

	@PreDestroy
	public void stopChatServerSocket() {
		server.stop();
	}

}
