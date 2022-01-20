package com.thunderware.ui.ClickGUI.dropDown.impl.set;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

import java.awt.*;
import java.util.List;

import com.thunderware.font.CFontRenderer;
import com.thunderware.settings.settings.ModeSetting;
import com.thunderware.ui.ClickGUI.dropDown.ClickGui;

public class Mode extends SetComp {

	private boolean dragging = false;
	private double x;
	private double y;
	private static int height = 18;;
	private boolean hovered;
	private ModeSetting set;
	private boolean isOpened = false;

	public Mode(ModeSetting s, com.thunderware.ui.ClickGUI.dropDown.impl.Button b) {
		super(s, b, height);
		this.set = s;
	}

	@Override
	public int drawScreen(int mouseX, int mouseY, double x, double y) {
		this.hovered = this.isHovered(mouseX, mouseY);
		this.x = x;
		this.y = y;
		CFontRenderer font = Minecraft.getMinecraft().customFont;
		String name = this.set.getName() + "";

		Gui.drawRect(x + 1, y, x + this.parent.getWidth() - 1, y + height + 1, ClickGui.getSecondaryColor().getRGB());
		Gui.drawRect(this.x, this.y, this.x + this.parent.getWidth(), this.y + this.height, ClickGui.getSecondaryColor().brighter().getRGB());

		font.drawString(name, (this.x + 3), (y + (font.getHeight() / 2) + 0.0F), new Color(255,255,255).darker().getRGB());
		font.drawString(this.set.getCurrentValue(), (this.x + 100) - font.getStringWidth(this.set.getCurrentValue()) - 3, (y + (font.getHeight() / 2) + 0.0F), -1);
		
		return this.height;
	}

	@Override
	public void mouseClicked(int x, int y, int button) {
		if ((button == 0 || button == 1) && this.hovered) {
				List<String> options = this.set.getValue();
				int index = options.indexOf(this.set.getCurrentValue());
				if (button == 0) {
					index++;
				} else if (button == 1) {
					index--;
				}
				if (index >= options.size()) {
					index = 0;
				} else if (index < 0) {
					index = options.size() - 1;
				}
				this.set.setCurrentValue(this.set.getValue().get(index));
			}

	}

	private boolean isHovered(int mouseX, int mouseY) {
		return mouseX >= x && mouseX <= x + this.parent.getWidth() && mouseY >= y && mouseY <= y + height;
	}
}
