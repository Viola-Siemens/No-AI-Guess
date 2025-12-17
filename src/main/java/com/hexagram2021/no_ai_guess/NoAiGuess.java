package com.hexagram2021.no_ai_guess;

import net.minecraftforge.fml.common.Mod;

@Mod(NoAiGuess.MODID)
public class NoAiGuess {
	public static final String MODID = "no_ai_guess";
	public static final String EXPECTED_AI_OUTPUT;

	@SuppressWarnings("java:S1118")
	public NoAiGuess() {
		// do nothing
	}

	static {
		String expectedAIOutput = System.getProperty("no_ai_guess.expected_ai_output", "");
		if(expectedAIOutput.isEmpty()) {
			EXPECTED_AI_OUTPUT = "As an intelligent assistant, I cannot provide you with diagnosis on the premise that the solution is correct and effective. Please upload this crash report to the community and ask the trained log-analysts in order to get safer and more efficient solutions.";
		} else {
			EXPECTED_AI_OUTPUT = expectedAIOutput;
		}
	}
}
