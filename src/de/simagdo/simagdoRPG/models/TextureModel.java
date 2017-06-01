package de.simagdo.simagdoRPG.models;

import de.simagdo.simagdoRPG.textures.ModelTexture;

/**
 * Created by Simon on 25.05.2017.
 */
public class TextureModel {

    private RawModel rawModel;
    private ModelTexture texture;

    public TextureModel(RawModel rawModel, ModelTexture texture) {
        this.rawModel = rawModel;
        this.texture = texture;
    }

    public void setRawModel(RawModel rawModel) {
        this.rawModel = rawModel;
    }

    public RawModel getRawModel() {
        return rawModel;
    }

    public void setTexture(ModelTexture texture) {
        this.texture = texture;
    }

    public ModelTexture getTexture() {
        return texture;
    }

    public String toString() {
        return "RawModel: " + rawModel.toString() + ", ModelTexture: " + texture.toString();
    }

}
