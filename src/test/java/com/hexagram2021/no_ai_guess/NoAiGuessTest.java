package com.hexagram2021.no_ai_guess;

import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

@SuppressWarnings("java:S2187")
public class NoAiGuessTest implements DedicatedServerModInitializer {
	private int ticks = 0;

	@Override
	public void onInitializeServer() {
		ServerTickEvents.END_SERVER_TICK.register(server -> {
			this.ticks += 1;
			if(this.ticks >= 100 && server.isRunning()) {
				NoAiGuess.LOGGER.info("Smoke Test Passed! Server has been running for 100 ticks.");
				server.halt(false);
			}
		});
	}
}
