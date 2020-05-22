package edu.umb.cs.cs681.hw07;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class File {

	private boolean changed = false;
	private ReentrantLock lock = new ReentrantLock();
	
	public void change() {
		lock.lock();
		try {
			System.out.println("Changing file contents...");
			changed = true;
		}finally {
			lock.unlock();
			System.out.println("File changed");
		}
	}
	
	public void save() {
		lock.lock();
		try {
			if(changed == false) {
				return;
			} else {
				String currentTimeStamp = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss").format(new Date());
				System.out.println("File saved at " + currentTimeStamp);
				changed = false;
			}
		}finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		File file = new File();
		Editor editor = new Editor(file);
		AutoSaver autoSaver = new AutoSaver(file);
		
		Thread t1_Editor = new Thread(editor);
		Thread t2_AutoSaver = new Thread(autoSaver);
		
		t1_Editor.start();
		t2_AutoSaver.start();
		try {
			Thread.sleep(3000);
			System.out.println("Thread set to sleep in 3 seconds");
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		editor.setDone();
		autoSaver.setDone();
		
		try {
			t1_Editor.join();
			t2_AutoSaver.join();
		} catch (InterruptedException e1) {}
		
		System.out.println("Finished running.");
	}
}
