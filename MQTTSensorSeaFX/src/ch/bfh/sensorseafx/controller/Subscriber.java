package ch.bfh.sensorseafx.controller;

import java.io.StreamCorruptedException;
import java.util.Date;

import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import ch.bfh.sensorseafx.helpers.Serialiser;
import ch.bfh.sensorseafx.model.Datastore;
import ch.bfh.sensorseafx.model.SubscriberList;
import ch.bfh.sensorseafx.sensors.Sensor;

public class Subscriber extends ScheduledService<Void>{
	
	private Datastore datastore;

	private SubscriberList topics = new SubscriberList();
	private String id = Double.toString(new Date().getTime());
	private Broker broker = new Broker("sub" + id);
	private Serialiser ser = new Serialiser();
	private boolean debug = false;
	private String status = "";
	
	public Subscriber(){}
	
	@Override
	protected Task<Void> createTask() {
		return new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				System.out.println("subscriberservice running...");
				if (broker.isConnected()) {
					System.out.println("connected - waiting for messages...");
					broker.getClient().setCallback(new MqttCallback() {
						@Override
						public void connectionLost(Throwable throwable) {
							System.out.println("Connection Lost");
						}

						@Override
						public void messageArrived(String string, MqttMessage message) throws Exception, StreamCorruptedException {
							//if (Sensor.class.isAssignableFrom(ser.deserialize(message.getPayload()).getClass())){
								Sensor s = (Sensor) ser.deserialize(message.getPayload());
								if (debug) {
									System.out.println("From " + string + ": " + s);
								}
								datastore.add(s);
//							} else {
//								if (debug) {
//									System.out.println("From " + string + ": " + message);
//								}
//							}
						}

						@Override
						public void deliveryComplete(IMqttDeliveryToken imdt) {

						}

					});
				}
				return null;
			}
		};
	}
	
	public void subscribe(String topic){
		if (broker.isConnected()){
			if (topics.getTopics().contains(topic)){
				if (debug){System.out.println("Already subscribed to the topic " + topic + ".");}else{};
				status = "Already subscribed to the topic " + topic + ".";
			}
			else{
				topics.add(topic);
				
				try {
					broker.getClient().subscribe(topic);
				} catch (MqttException e) {
					e.printStackTrace();
				}
				
				if (debug){System.out.println("Subscribed to the topic " + topic + ".");}else{};
				status = "Subscribed to the topic " + topic + ".";
				
			}
	    	
		}
	}
	
	public void unsubscribe(String topic){
		if (topics.getTopics().contains(topic)){
			topics.remove(topic);
			
			try {
				broker.getClient().unsubscribe(topic);
			} catch (MqttException e) {
				e.printStackTrace();
			}
			
			if (debug){System.out.println("Unsubscribed from topic " + topic + ".");}else{};
			status = "Unsubscribed from topic " + topic + ".";
			
		}
		else{
			if (debug){System.out.println("No such topic to unsubscribe.");}else{};
			status = "No topic selected to unsubscribe.";
		}
    	
	}
	
	public void unsubscribeAll(){
		for (String topic : topics.getTopics()){
			unsubscribe(topic);
		}
		topics.removeAll();
	}
	
	public void setBroker(Broker broker){
		this.broker = broker;
	}
	
	public Broker getBroker() {
		return broker;
	}
	
	public void setDatastore(Datastore datastore){
		this.datastore = datastore;
	}
	
	public void setDebug(boolean debug){
		this.debug = debug;
	}
	
	public SubscriberList getSubscriberList(){
		return topics;
	}
	
	public String getStatus(){
		return status;
	}
	
}