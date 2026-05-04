package net.minecraft.client.gui;

import net.lax1dude.eaglercraft.v1_8.Mouse;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;

/**+
 * TruePvP Settings Screen
 */
public class GuiScreenTruePvPSettings extends GuiScreen {
	private final GuiScreen parentScreen;
	private final GameSettings gameSettings;

	public GuiScreenTruePvPSettings(GuiScreen parent, GameSettings settings) {
		this.parentScreen = parent;
		this.gameSettings = settings;
	}

	@Override
	public void initGui() {
		this.buttonList.clear();
		this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 6 + 168, I18n.format("gui.done")));
		this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 6 + 120, 200, 20,
				"CPS Counter: " + (gameSettings.cpsCounterEnabled ? "ON" : "OFF")));
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		if (button.id == 0) {
			this.mc.displayGuiScreen(parentScreen);
		} else if (button.id == 1) {
			gameSettings.cpsCounterEnabled = !gameSettings.cpsCounterEnabled;
			button.displayString = "CPS Counter: " + (gameSettings.cpsCounterEnabled ? "ON" : "OFF");
		}
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		this.drawCenteredString(this.fontRendererObj, "TruePvP Settings", this.width / 2, 15, 16777215);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
}