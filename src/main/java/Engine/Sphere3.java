package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;

public class Sphere3 extends Circle {
    float rz, centerpointY;

    List<Integer> index = new ArrayList<>();
    int ibo;

    public Sphere3(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, float centerpointX, float centerpointY, float rx, float ry, float rz) {
        super(shaderModuleDataList, vertices, color, centerpointX, centerpointY, rx, ry);
        this.rz = rz;
        this.centerpointY = centerpointY;
        createSphere();
//        createBox();
        setupVAOVBO();
    }

    public Sphere3(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, float centerpointX, float centerpointY, float rx, float ry, float rz, int i) {
        super(shaderModuleDataList, vertices, color, centerpointX, centerpointY, rx, ry);
        this.rz = rz;
        this.centerpointY = centerpointY;
        int cases = i;
        createQuadratic(cases);
        setupVAOVBO();
    }

    public Sphere3(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, float centerpointX, float centerpointY, float rx, float ry, float rz, boolean b) {
        super(shaderModuleDataList, vertices, color, centerpointX, centerpointY, rx, ry);
        this.rz = rz;
//        createSphere();
        createBox();
        setupVAOVBO();
    }


    public void createQuadratic(int cases) {
        ArrayList<Vector3f> temp = new ArrayList<>();
        switch (cases) {
            //lowerbody upperbody Elliptic Paraboloid
            case 0:
                for (double v = Math.PI / 2 + centerpointY; v >= 0 + centerpointY; v -= Math.PI / 350) {
                    for (double u = -Math.PI + centerpointY; u <= Math.PI + centerpointY; u += Math.PI / 350) {
                        float x = rx * (float) (v * Math.cos(u));
                        float y = ry * (float) (v * Math.sin(u));
                        float z = rz * (float) (Math.pow(v, 2));
                        temp.add(new Vector3f(x, z, y));
                    }
                }

                break;

            //foot finger eye glare Ellipsoid
            case 1:
                for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 200) {
                    for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 200) {
                        float x = rx * (float) (Math.cos(v) * Math.cos(u));
                        float y = ry * (float) (Math.cos(v) * Math.sin(u));
                        float z = rz * (float) (Math.sin(v));
                        temp.add(new Vector3f(x, y, z));
                    }
                }
                break;

                //segitiga but 3d
            case 2:
                for (double v = 0; v <= 2 * Math.PI; v += Math.PI / 200) {
                    for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 200) {
                        float x = (float) (rx * v * Math.cos(u));
                        float y = (float) (ry * v * Math.sin(u));
                        float z = (float) (rz * v);
                        temp.add(new Vector3f(x, y, z));
                    }
                }
                break;

                //hiperboloid 1 sisi
            case 3:
                for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60) {
                    for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 60) {
                        float x = this.rx * (float) ((Math.cosh(v)) * Math.cos(u));
                        float y = this.ry * (float) ((Math.cosh(v)) * Math.sin(u));
                        float z = this.rz * (float) (Math.sinh(v));
                        temp.add(new Vector3f(x, z, y));
                    }
                }
                break;
            case 4:
                createBox();
        }
        vertices = temp;
    }

    public void createBox() {
        vertices.clear();
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        //TITIK 1 kiri atas belakang
        temp.x = centerPoint.get(0) - rx / 2.0f;
        temp.y = centerPoint.get(1) + ry / 2.0f;
        temp.z = centerPoint.get(2) - rz / 2.0f;
        tempVertices.add(temp);

        temp = new Vector3f();
        //TITIK 2 kiri bawah belakang
        temp.x = centerPoint.get(0) + rx / 2.0f;
        temp.y = centerPoint.get(1) + ry / 2.0f;
        temp.z = centerPoint.get(2) - rz / 2.0f;
        tempVertices.add(temp);

        temp = new Vector3f();
        //TITIK 3 kanan bawah belakang
        temp.x = centerPoint.get(0) + rx / 2.0f;
        temp.y = centerPoint.get(1) - ry / 2.0f;
        temp.z = centerPoint.get(2) - rz / 2.0f;
        tempVertices.add(temp);

        temp = new Vector3f();
        //TITIK 4 kanan atas belakang
        temp.x = centerPoint.get(0) - rx / 2.0f;
        temp.y = centerPoint.get(1) - ry / 2.0f;
        temp.z = centerPoint.get(2) - rz / 2.0f;
        tempVertices.add(temp);

        temp = new Vector3f();
        //TITIK 5 kiri atas depan
        temp.x = centerPoint.get(0) - rx / 2.0f;
        temp.y = centerPoint.get(1) + ry / 2.0f;
        temp.z = centerPoint.get(2) + rz / 2.0f;
        tempVertices.add(temp);

        temp = new Vector3f();
        //TITIK 6 kiri bawah depan
        temp.x = centerPoint.get(0) + rx / 2.0f;
        temp.y = centerPoint.get(1) + ry / 2.0f;
        temp.z = centerPoint.get(2) + rz / 2.0f;
        tempVertices.add(temp);

        temp = new Vector3f();
        //TITIK 7 kanan bawah depan
        temp.x = centerPoint.get(0) + rx / 2.0f;
        temp.y = centerPoint.get(1) - ry / 2.0f;
        temp.z = centerPoint.get(2) + rz / 2.0f;
        tempVertices.add(temp);

        temp = new Vector3f();
        //TITIK 8 kanan atas depan
        temp.x = centerPoint.get(0) - rx / 2.0f;
        temp.y = centerPoint.get(1) - ry / 2.0f;
        temp.z = centerPoint.get(2) + rz / 2.0f;
        tempVertices.add(temp);

        //kotak belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(0));
        //kotak depan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(4));
        //kotak samping kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(4));

        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));
        //kotak samping kanan
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(7));
        //kotak atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));

        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));
        //kotak bawah
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));
    }

    public void createSphere() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        int stackCount = 270, sectorCount = 540;
        float x, y, z, xy, nx, ny, nz;
        float sectorStep = (float) (2 * Math.PI) / sectorCount; //sector count
        float stackStep = (float) Math.PI / stackCount; // stack count
        float sectorAngle, stackAngle;

        //titik persegi
        for (int i = 0; i <= stackCount; i++) {
            stackAngle = (float) Math.PI / 2 - i * stackStep;
            xy = (float) (0.5f * Math.cos(stackAngle));
            z = (float) (0.5f * Math.sin(stackAngle));
            for (int j = 0; j < sectorCount; j++) {
                sectorAngle = j * sectorStep;
                x = (float) (xy * Math.cos(sectorAngle));
                y = (float) (xy * Math.sin(sectorAngle));
                temp.add(new Vector3f(x, y, z));
            }
        }
        vertices = temp;

        int k1, k2;
        ArrayList<Integer> temp_indices = new ArrayList<>();
        for (int i = 0; i < stackCount; i++) {
            k1 = i * (sectorCount + 1);
            k2 = k1 + sectorCount + 1;
            k2 = k1 + sectorCount + 1;

            for (int j = 0; j < sectorCount; ++j, ++k1, ++k2) {
                if (i != 0) {
                    temp_indices.add(k1);
                    temp_indices.add(k2);
                    temp_indices.add(k1 + 1);
                }
                if (i != (18 - 1)) {
                    temp_indices.add(k1 + 1);
                    temp_indices.add(k2);
                    temp_indices.add(k2 + 1);
                }
            }
        }

        this.index = temp_indices;
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,
                ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,
                Utils.listoInt(index), GL_STATIC_DRAW);

    }

//    public void draw() {
//        drawSetup();
//        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ibo);
//        glDrawElements(GL_LINE_STRIP,
//                index.size(),
//                GL_UNSIGNED_INT, 0);
//    }

//    public void draw() {
//        drawSetup();
//        glLineWidth(1);
//        glPointSize(0);
//        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
//    }
}
