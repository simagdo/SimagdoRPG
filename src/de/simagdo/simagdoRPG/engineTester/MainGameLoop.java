package de.simagdo.simagdoRPG.engineTester;

import de.simagdo.simagdoRPG.entities.Camera;
import de.simagdo.simagdoRPG.entities.Entity;
import de.simagdo.simagdoRPG.entities.Light;
import de.simagdo.simagdoRPG.entities.Player;
import de.simagdo.simagdoRPG.guis.GUIRenderer;
import de.simagdo.simagdoRPG.guis.GUITexture;
import de.simagdo.simagdoRPG.models.RawModel;
import de.simagdo.simagdoRPG.models.TextureModel;
import de.simagdo.simagdoRPG.objConverter.ModelData;
import de.simagdo.simagdoRPG.objConverter.OBJFileLoader;
import de.simagdo.simagdoRPG.renderEngine.DisplayManager;
import de.simagdo.simagdoRPG.renderEngine.Loader;
import de.simagdo.simagdoRPG.renderEngine.MasterRenderer;
import de.simagdo.simagdoRPG.renderEngine.OBJLoader;
import de.simagdo.simagdoRPG.terrain.Terrain;
import de.simagdo.simagdoRPG.textures.ModelTexture;
import de.simagdo.simagdoRPG.textures.TerrainTexture;
import de.simagdo.simagdoRPG.textures.TerrainTexturePack;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;
import org.lwjgl.util.vector.Vector3f;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainGameLoop {

    public static void main(String[] args) {

        DisplayManager.createDisplay();
        Loader loader = new Loader();

        ModelData data = OBJFileLoader.loadOBJ("tree");

        RawModel model = loader.loadToVAO(data.getVertices(), data.getTextureCoords(), data.getNormals(), data.getIndices());

        TextureModel staticModel = new TextureModel(model, new ModelTexture(loader.loadTexture("tree")));

        //Terrain Texture Pack
        TerrainTexture backgroundTexture = new TerrainTexture(loader.loadTexture("grass"));
        TerrainTexture rTexture = new TerrainTexture(loader.loadTexture("mud"));
        TerrainTexture gTexture = new TerrainTexture(loader.loadTexture("pinkFlowers"));
        TerrainTexture bTexture = new TerrainTexture(loader.loadTexture("path"));

        TerrainTexturePack texturePack = new TerrainTexturePack(backgroundTexture, rTexture, gTexture, bTexture);
        TerrainTexture blendMap = new TerrainTexture(loader.loadTexture("blendMap"));

        List<Entity> entities = new ArrayList<>();
        Random random = new Random();

        TextureModel lamp = new TextureModel(OBJLoader.loadObjModel("lamp", loader), new ModelTexture(loader.loadTexture("lamp")));

        List<Light> lights = new ArrayList<>();
        lights.add(new Light(new Vector3f(0, 1000, -7000), new Vector3f(0.4f, 0.4f, 0.4f)));
        lights.add(new Light(new Vector3f(185, 10, -293), new Vector3f(2, 0, 0), new Vector3f(1, 0.01f, 0.002f)));
        lights.add(new Light(new Vector3f(293, 7, -305), new Vector3f(2, 2, 0), new Vector3f(1, 0.01f, 0.002f)));
        lights.add(new Light(new Vector3f(370, 7, -300), new Vector3f(0, 2, 2), new Vector3f(1, 0.01f, 0.002f)));

        entities.add(new Entity(lamp, new Vector3f(185, -4.7f, -293), 0, 0, 0, 1));
        entities.add(new Entity(lamp, new Vector3f(293, -6.8f, -305), 0, 0, 0, 1));
        entities.add(new Entity(lamp, new Vector3f(370, 4.2f, -300), 0, 0, 0, 1));

        Terrain terrain = new Terrain(0, -1, loader, texturePack, blendMap, "heightmap");
        TextureModel fern = new TextureModel(OBJLoader.loadObjModel("fern", loader), new ModelTexture(loader.loadTexture("fern")));
        fern.getTexture().setHasTransparency(true);
        fern.getTexture().setUseFakeLightning(true);

        ModelTexture fernTextureAtlas = new ModelTexture(loader.loadTexture("fernatlas"));
        fernTextureAtlas.setNumberOfRows(2);
        TextureModel fernAtlas = new TextureModel(OBJLoader.loadObjModel("fern", loader), fernTextureAtlas);

        List<GUITexture> guiTextures = new ArrayList<>();
        GUITexture texture = new GUITexture(loader.loadTexture("socuwan"), new Vector2f(0.5f, 0.5f), new Vector2f(0.25f, 0.25f));
        guiTextures.add(texture);

        GUIRenderer guiRenderer = new GUIRenderer(loader);

        for (int i = 0; i < 500; i++) {
            if (i % 20 == 0) {
                float x = random.nextFloat() * 800 - 400;
                float z = random.nextFloat() * -600;
                float y = terrain.getHeightOfTerrain(x, z);
                entities.add(new Entity(fernAtlas, random.nextInt(4), new Vector3f(x, y, z), 0, random.nextFloat() * 360, 0, 0.9f));
            }
            if (i % 5 == 0) {
                float x = random.nextFloat() * 800 - 400;
                float z = random.nextFloat() * -600;
                float y = terrain.getHeightOfTerrain(x, z);
                entities.add(new Entity(staticModel, new Vector3f(x, y, z), 0, random.nextFloat() * 360, 0, random.nextFloat() * 1 + 4));
            }
        }

        MasterRenderer renderer = new MasterRenderer(loader);

        RawModel bunnyModel = OBJLoader.loadObjModel("person", loader);
        TextureModel standfordBunny = new TextureModel(bunnyModel, new ModelTexture(loader.loadTexture("playerTexture")));

        Player player = new Player(standfordBunny, new Vector3f(153, 5, -274), 0, 100, 0, 0.6f);
        Camera camera = new Camera(player);

        while (!Display.isCloseRequested()) {
            player.move(terrain);
            camera.move();
            renderer.processEntity(player);
            renderer.processTerrain(terrain);
            for (Entity entity : entities) {
                renderer.processEntity(entity);
            }
            renderer.render(lights, camera);
            guiRenderer.render(guiTextures);
            DisplayManager.updateDisplay();
        }

        guiRenderer.clear();
        renderer.clear();
        loader.clear();
        DisplayManager.closeDisplay();

    }

}
