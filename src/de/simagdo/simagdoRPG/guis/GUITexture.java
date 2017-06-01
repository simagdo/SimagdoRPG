package de.simagdo.simagdoRPG.guis;

import org.lwjgl.util.vector.Vector2f;

/**
 * Created by Simon on 30.05.2017.
 */
public class GUITexture {

    private int texture;
    private Vector2f position;
    private Vector2f scale;

    public GUITexture(int texture, Vector2f position, Vector2f scale) {
        this.texture = texture;
        this.position = position;
        this.scale = scale;
    }

    public int getTexture() {
        return texture;
    }

    public void setTexture(int texture) {
        this.texture = texture;
    }

    public Vector2f getPosition() {
        return position;
    }

    public void setPosition(Vector2f position) {
        this.position = position;
    }

    public Vector2f getScale() {
        return scale;
    }

    public void setScale(Vector2f scale) {
        this.scale = scale;
    }
}
