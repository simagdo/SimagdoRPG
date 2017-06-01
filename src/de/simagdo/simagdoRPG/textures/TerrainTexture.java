package de.simagdo.simagdoRPG.textures;

public class TerrainTexture {

    private int textureID;

    public TerrainTexture(int textureID) {
        this.textureID = textureID;
    }

    public void setTextureID(int textureID) {
        this.textureID = textureID;
    }

    public int getTextureID() {
        return textureID;
    }

    @Override
    public String toString() {
        return "TextureID: " + textureID;
    }
}
