package de.simagdo.simagdoRPG.guis;

public class GUIScreenContainer  extends GUIComponent{

    private boolean mouseInGUI = false;

    protected GUIScreenContainer() {
        super.forceInitalization(0,0,1,1);
    }

    private boolean isMouseInGUI() {
        return mouseInGUI;
    }

    @Override
    protected void updateSelf() {

    }

    protected void checkMouseOver() {
        for(GUIComponent component : super.getComponents()) {
            //if(component.isShown() && component.ism)
        }
    }

}
