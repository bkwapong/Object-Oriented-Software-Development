package edu.umb.cs.cs681.hw14;

public class MainClient {
	
	public static void main(String[] args) {
		AdmissionControl admissionControl = new AdmissionControl();
		EntranceHandler entranceHandler = new EntranceHandler(admissionControl);
		ExitHandler exitHandler = new ExitHandler(admissionControl);
		
		Thread entranceThread = new Thread(entranceHandler);
		entranceThread.start();
		Thread exitThread = new Thread(exitHandler);
		exitThread.start();

		try{
			Thread.sleep(1000);
		} catch (Exception exception) {
			exception.printStackTrace();
		}

		entranceHandler.setDone();
		exitHandler.setDone();
		entranceThread.interrupt();
		exitThread.interrupt();
		try {
			entranceThread.join();
			exitThread.join();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
