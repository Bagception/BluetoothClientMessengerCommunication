package de.uniulm.bagception.bluetoothservermessengercommunication.broadcastmessenger;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import de.philipphock.android.lib.services.observation.ObservableService;
import de.uniulm.bagception.bluetoothservermessengercommunication.broadcastmessenger.actorreactor.BundleMessageActor;
import de.uniulm.bagception.bluetoothservermessengercommunication.broadcastmessenger.actorreactor.BundleMessageReactor;
import de.uniulm.bagception.broadcastconstants.BagceptionBroadcastContants;

public abstract class BundleBroadcastService extends ObservableService implements BundleMessengerInterface, BundleMessageReactor{

	private BundleMessageActor bmActor;
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		return super.onStartCommand(intent, flags, startId);
	}	
	@Override
	protected void onFirstInit() {
		bmActor = new BundleMessageActor(this);
		bmActor.register(this);
	}

	@Override
	public void onDestroy() {
		
		super.onDestroy();
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	// \\BundleMessengerInterface//
	
	@Override
	public void sendMessageBundle(Bundle b) {
		sendBundleBroadcast(BagceptionBroadcastContants.BROADCAST_BUNDLEMESSAGE_MESSAGE_INTENT, b);
	}

	@Override
	public void sendStatusBundle(Bundle b) {
		sendBundleBroadcast(BagceptionBroadcastContants.BROADCAST_BUNDLEMESSAGE_STATUS_INTENT, b);
	}

	@Override
	public void sendResponseBundle(Bundle b) {
		sendBundleBroadcast(BagceptionBroadcastContants.BROADCAST_BUNDLEMESSAGE_RESPONSE_INTENT, b);		
	}

	@Override
	public void sendCommandBundle(Bundle b) {
		sendBundleBroadcast(BagceptionBroadcastContants.BROADCAST_BUNDLEMESSAGE_COMMAND_INTENT, b);
		
	}
	// //BundleMessengerInterface\\

	
	private void sendBundleBroadcast(String action,Bundle b){
		Intent toSend = new Intent(action);
		toSend.putExtras(b);
		sendBroadcast(toSend);
	
	}
	
	
	
	
	
	
}
