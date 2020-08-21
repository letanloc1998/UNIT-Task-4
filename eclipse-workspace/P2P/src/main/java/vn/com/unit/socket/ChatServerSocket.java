package vn.com.unit.socket;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketConfig;
import com.corundumstudio.socketio.SocketIOServer;

public class ChatServerSocket {

	private SocketIOServer server;

	public ChatServerSocket() {

		Configuration config = new Configuration();

		/*
		 * setHostname If not set then bind address will be 0.0.0.0 or ::0
		 */
//		config.setHostname("localhost");

		/*
		 * setPort The port the socket.io server will listen to
		 */
		config.setPort(8888);

		/*
		 * setJsonTypeFieldName defaults to "@class"
		 */

		/*
		 * setJsonSupport Allows to setup custom implementation of JSON
		 * serialization/deserialization.See JsonSupport
		 */

		/*
		 * setAuthorizationListener Authorization listener invoked on every handshake.
		 * Accepts all clients by default.
		 */

		/*
		 * setStoreFactory Client store and pubsub factory, used to store session data
		 * and implements distributed pubsub. Defaults to MemoryStoreFactory, but
		 * RedisStoreFactory and HazelcastStoreFactory also implemented.
		 */

		/*
		 * setPreferDirectBuffer (added in 1.5 version) Buffer allocation method used
		 * during packet encoding. Defaults to true.
		 */

		/*
		 * setBossThreads (added in 1.5 version) boss-threads amount for netty
		 */

		/*
		 * setWorkerThreads (added in 1.5 version) worker-threads amount for netty
		 */

		/*
		 * setHeartbeatInterval Heartbeat interval (in seconds), defaults to 25
		 */

		/*
		 * setHeartbeatTimeout Heartbeat timeout (in seconds), defaults to 60. Use 0 to
		 * disable it
		 */
//		config.setCloseTimeout(30);

		/*
		 * setCloseTimeout Channel close timeout (in seconds) due to inactivity,
		 * defaults to 60
		 */

		/*
		 * setContext Namespace, defaults to "/socket.io"
		 */

		/*
		 * setAllowCustomRequests Allow to service custom requests that differ from
		 * socket.io protocol, defaults to false.
		 */

		/*
		 * If true, add own handler which handle custom requests in order to avoid hang
		 * connections. setPollingDuration Polling interval for XHR transport (in
		 * seconds), defaults to 20
		 */

		/*
		 * setKeyStorePassword SSL key store password (for secure connections)
		 */

		/*
		 * setKeyStore SSL key store stream, maybe appointed to any source
		 */

		/*
		 * setMaxHttpContentLength Set maximum HTTP content length limit, defaults to
		 * 64KB.
		 */

		/*
		 * If the length of the aggregated content exceeds this value, a
		 * TooLongFrameException will be raised. setTransports Transports supported by
		 * server, defaults to [Transport.WEBSOCKET, Transport.FLASHSOCKET,
		 * Transport.XHRPOLLING]. Cannot be empty list
		 */

		/*
		 * SocketConfig setReuseAddress
		 */
//		java.net.BindException: Address already in use
		SocketConfig socketConfig = new SocketConfig();
		socketConfig.setReuseAddress(true);

		config.setSocketConfig(socketConfig);

		server = new SocketIOServer(config);

	}
	
	public void start() {
		server.start();
	}
	
	public void stop() {
		server.stop();
	}

}
