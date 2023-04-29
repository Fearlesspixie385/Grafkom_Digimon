package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_LINE_STRIP;

public class Tabung extends Circle1 {

    int stackCount, sectorCount;
    float radiusZ;

    public Tabung(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ, int sectorCount, int stackCount) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
        createTabung();
//        createTabungberdiri();
        setupVAOVBO();
    }

    public void createTabung() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        float sectorStep = 2 * (float) Math.PI / sectorCount;

        for (int i = 0; i <= stackCount; ++i) {
            float stackFraction = (float) i / stackCount;
            float x = stackFraction * radiusZ * 2 - radiusZ;

            for (int j = 0; j <= sectorCount; ++j) {
                float sectorAngle = j * sectorStep;

                float z = radiusX * (float) Math.cos(sectorAngle);
                float y = radiusY * (float) Math.sin(sectorAngle);

                temp.add(new Vector3f(x, y, z));
            }
        }

        vertices = temp;
    }
    public void createTabungberdiri() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        float sectorStep = 2* (float) Math.PI / sectorCount;

        for (int i = 0; i <= stackCount; ++i) {
            float stackFraction = (float) i / stackCount;
            float y= stackFraction * radiusX * 2 - radiusX;

            for (int j = 0; j <= sectorCount; ++j) {
                float sectorAngle = j * sectorStep;

                float x = radiusY * (float) Math.cos(sectorAngle);
                float z = radiusZ * (float) Math.sin(sectorAngle);

                temp.add(new Vector3f(x, y, z));
            }
        }

        vertices = temp;
    }


    public void draw() {
//        drawSetup();
        glLineWidth(10); // ketebalan garis
        glPointSize(10); // besar kecil vertex
        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
    }
}