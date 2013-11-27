package de.uniulm.bagception.bluetoothservermessengercommunication.broadcastmessenger;

import android.os.Bundle;

public interface BundleMessengerInterface {
	public void sendMessageBundle(Bundle b);

	public void sendStatusBundle(Bundle b);

	public void sendResponseBundle(Bundle b);

	public void sendCommandBundle(Bundle b);
	
	
}
