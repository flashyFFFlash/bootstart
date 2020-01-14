package com.example.demo.setup;

import org.springframework.context.SmartLifecycle;

public abstract class Initializer implements SmartLifecycle {

	boolean running = false;

	public abstract void initialize();

	@Override
	public void start() {
		this.running = true;
		initialize();
	}

	@Override
	public void stop() {
		this.running = false;
	}

	@Override
	public boolean isRunning() {
		return this.running;
	}
}
