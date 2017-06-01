package de.simagdo.simagdoRPG.models;

public class RawModel {

    private int vaoID;
    private int vertexCount;

    public RawModel(int vaoID, int vertexCount) {
        this.vaoID = vaoID;
        this.vertexCount = vertexCount;
    }

    public void setVaoID(int vaoID) {
        this.vaoID = vaoID;
    }

    public int getVaoID() {
        return vaoID;
    }

    public void setVertexCount(int vertexCount) {
        this.vertexCount = vertexCount;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public String toString() {
        return "VaiID: " + vaoID + ", VertexCount: " + vertexCount;
    }

}
