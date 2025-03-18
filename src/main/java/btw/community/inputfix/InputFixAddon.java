package btw.community.inputfix;

import btw.AddonHandler;
import btw.BTWAddon;
import net.minecraft.src.EntityPlayerMP;
import net.minecraft.src.NetServerHandler;

import java.awt.Color;
import java.util.Map;

public class InputFixAddon extends BTWAddon {

    public InputFixAddon() {
        super();
    }

    @Override
    public void preInitialize() {

    }

    @Override
    public void initialize() {
        AddonHandler.logMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
    }
}