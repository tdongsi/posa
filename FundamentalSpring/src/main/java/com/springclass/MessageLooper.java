package com.springclass;


public class MessageLooper {
	private Messager messager;
	private int numTimes;

	public Messager getMessager() {
		return messager;
	}
	public void setMessager(Messager messager) {
		this.messager = messager;
	}
	public int getNumTimes() {
		return numTimes;
	}
	public void setNumTimes(int numTimes) {
		this.numTimes = numTimes;
	}
	
	public void doIt()
	{
		for (int i=0; i<numTimes; i++)
		{
		getMessager().greet();	
		}
	}

}
