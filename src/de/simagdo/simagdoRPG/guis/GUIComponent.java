package de.simagdo.simagdoRPG.guis;

import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;
import java.util.List;

public abstract class GUIComponent {

    private Vector2f position = new Vector2f();
    private Vector2f scale = new Vector2f();

    private Vector2f relativePosition = new Vector2f();
    private Vector2f relativeScale = new Vector2f();
    private GUIComponent parent;

    private List<GUIComponent> components = new ArrayList<>();
    private List<GUIComponent> childComponents = new ArrayList<>();

    private boolean visible = true;
    private boolean initalizied = false;

    public void show(boolean visible) {
        this.visible = visible;
    }

    public void addComponent(GUIComponent component, float relativeX, float relativeY, float relativeScaleX, float relativeScaleY) {
        component.relativePosition.set(relativeX, relativeY);
        component.relativeScale.set(relativeScaleX, relativeScaleY);
        component.parent = this;
        components.add(component);
    }

    protected void forceInitalization(float absX, float absY, float absScaleX, float absScaleY) {
        position.x = absX;
        position.y = absY;
        scale.x = absScaleX;
        scale.y = absScaleY;
        this.initalizied = true;
    }

    protected List<GUIComponent> getComponents() {
        return childComponents;
    }

    public boolean isShown() {
        return visible;
    }

    protected abstract void updateSelf();

}
