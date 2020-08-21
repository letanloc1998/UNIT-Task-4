package vn.com.unit.socket;

import java.net.InetSocketAddress;
//import java.nio.ByteBuffer;

//import org.java_websocket.WebSocket;
//import org.java_websocket.handshake.ClientHandshake;
//import org.java_websocket.server.WebSocketServer;
//
//public class ChatServerSocket extends WebSocketServer {

public class ChatServerSocket {

	public ChatServerSocket(InetSocketAddress address) {
//		super(address);
	}

	/*
	 * @Override public void onOpen(WebSocket conn, ClientHandshake handshake) { //
	 * TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public void onClose(WebSocket conn, int code, String reason,
	 * boolean remote) { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public void onMessage(WebSocket conn, String message) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public void onError(WebSocket conn, Exception ex) { // TODO
	 * Auto-generated method stub
	 * 
	 * }
	 * 
	 * @Override public void onStart() { // TODO Auto-generated method stub
	 * 
	 * }
	 */
	/*
	 * @Override public void onOpen(WebSocket conn, ClientHandshake handshake) {
	 * conn.send("Welcome to the server!"); //This method sends a message to the new
	 * client broadcast( "new connection: " + handshake.getResourceDescriptor() );
	 * //This method sends a message to all clients connected
	 * System.out.println("new connection to " + conn.getRemoteSocketAddress()); }
	 * 
	 * @Override public void onClose(WebSocket conn, int code, String reason,
	 * boolean remote) { System.out.println("closed " +
	 * conn.getRemoteSocketAddress() + " with exit code " + code +
	 * " additional info: " + reason); }
	 * 
	 * @Override public void onMessage(WebSocket conn, String message) {
	 * System.out.println("received message from " + conn.getRemoteSocketAddress() +
	 * ": " + message); }
	 * 
	 * @Override public void onMessage( WebSocket conn, ByteBuffer message ) {
	 * System.out.println("received ByteBuffer from " +
	 * conn.getRemoteSocketAddress()); }
	 * 
	 * @Override public void onError(WebSocket conn, Exception ex) {
	 * System.err.println("an error occurred on connection " +
	 * conn.getRemoteSocketAddress() + ":" + ex); }
	 * 
	 * @Override public void onStart() {
	 * System.out.println("server started successfully"); }
	 */
}
