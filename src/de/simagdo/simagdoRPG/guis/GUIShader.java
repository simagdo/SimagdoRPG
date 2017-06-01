package de.simagdo.simagdoRPG.guis;

import de.simagdo.simagdoRPG.shaders.ShaderProgram;
import org.lwjgl.util.vector.Matrix4f;

public class GUIShader extends ShaderProgram {

    private static final String VERTEX_FILE = "src\\de\\simagdo\\simagdoRPG\\guis\\guiVertexShader.txt";
    private static final String FRAGMENT_FILE = "src\\de\\simagdo\\simagdoRPG\\guis\\guiFragmentShader.txt";

    private int location_transformationMatrix;

    public GUIShader() {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }

    public void loadTransformation(Matrix4f matrix) {
        super.loadMatrix(location_transformationMatrix, matrix);
    }

    @Override
    protected void getAllUniformLocations() {
        location_transformationMatrix = super.getUniformLocation("transformationMatrix");
    }

    @Override
    protected void bindAttributes() {
        super.bindAttribute(0, "position");
    }


}
