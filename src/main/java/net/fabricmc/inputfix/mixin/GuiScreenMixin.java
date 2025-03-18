package net.fabricmc.inputfix.mixin;

import emi.shims.java.com.unascribed.retroemi.RetroEMI;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.Minecraft;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(GuiScreen.class)
public abstract class GuiScreenMixin {
    @Shadow protected abstract void keyTyped(char par1, int par2);
    @Shadow protected Minecraft mc;

    @Shadow public boolean allowUserInput;

    /**
     * @author limingzxc
     * @reason fcl fix
     */
    @Overwrite
    public void handleKeyboardInput() {
        int var1 = Keyboard.getEventKey();
        char var2 = Keyboard.getEventCharacter();
        if (Keyboard.getEventKeyState()) {
            if (var1 == 87) {
                this.mc.toggleFullscreen();
                return;
            }

            if (allowUserInput && var1 == 28 && var2 == 0) {
                var1 = 29;
            }

            RetroEMI.handleKeyboardInput();
            this.keyTyped(var2, var1);
        }
    }
}
