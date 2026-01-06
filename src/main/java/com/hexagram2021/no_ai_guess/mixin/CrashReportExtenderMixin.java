package com.hexagram2021.no_ai_guess.mixin;

import com.hexagram2021.no_ai_guess.NoAiGuess;
import net.minecraft.CrashReport;
import net.neoforged.neoforge.logging.CrashReportExtender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings({"java:S100", "java:S1118", "java:S1181"})
@Mixin(value = CrashReportExtender.class, remap = false)
public class CrashReportExtenderMixin {
	@Inject(method = "addCrashReportHeader", at = @At("HEAD"), remap = false)
	private static void no_ai_guess$injectTaintHeaderV1(StringBuilder builder, CrashReport crashReport, CallbackInfo ci) {
		try {
			for (String line : NoAiGuess.GUIDANCE_LINES) {
				builder.append("// ").append(line);
			}
			builder.append("// -------\n");
		} catch(Throwable ignored) {
			// fail-safe, we absolutely do not want to crash during crash report generation
		}
	}
}
