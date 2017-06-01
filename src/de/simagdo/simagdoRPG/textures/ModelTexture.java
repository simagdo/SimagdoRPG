package de.simagdo.simagdoRPG.textures;

public class ModelTexture {

    private int textureID;
    private float shineDamper = 1;
    private float reflectivity = 0;

    private int numberOfRows = 1;

    private boolean hasTransparency = false;
    private boolean useFakeLightning = false;

    public ModelTexture(int textureID) {
        this.textureID = textureID;
    }

    public void setID(int textureID) {
        this.textureID = textureID;
    }

    public int getID() {
        return this.textureID;
    }

    public void setShineDamper(float shineDamper) {
        this.shineDamper = shineDamper;
    }

    public float getShineDamper() {
        return shineDamper;
    }

    public void setReflectivity(float reflectivity) {
        this.reflectivity = reflectivity;
    }

    public float getReflectivity() {
        return reflectivity;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public void setHasTransparency(boolean hasTransparency) {
        this.hasTransparency = hasTransparency;
    }

    public boolean isHasTransparency() {
        return hasTransparency;
    }

    public void setUseFakeLightning(boolean useFakeLightning) {
        this.useFakeLightning = useFakeLightning;
    }

    public boolean isUseFakeLightning() {
        return useFakeLightning;
    }

    @Override
    public String toString() {
        return "TextureID: " + textureID + ", ShineDamper: " + shineDamper + ", Reflectivity: " + reflectivity + ", NumberOfRows: " + numberOfRows + ", Transparency: " + hasTransparency + ", FakeLightning: " + useFakeLightning;
    }
}
