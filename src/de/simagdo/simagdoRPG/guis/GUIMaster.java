package de.simagdo.simagdoRPG.guis;

import de.simagdo.simagdoRPG.utils.FileUtils;
import de.simagdo.simagdoRPG.utils.MyFile;

public class GUIMaster {

    public static final MyFile GUIS_LOCATION = new MyFile(FileUtils.RES_FOLDER, "guis");
    public static final GUIScreenContainer CONTAINER = new GUIScreenContainer();

    public static void addComponent(GUIComponent component, float relativeX, float relativeY, float relativeScaleX, float relativeScaleY) {
        CONTAINER.addComponent(component, relativeX, relativeY, relativeScaleX, relativeScaleY);
    }

}
