package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;

public class Sphere extends Circle {
    float rz;

    List<Integer> index = new ArrayList<>();
    int ibo;

    public Sphere(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, float centerpointX, float centerpointY, float rx, float ry, float rz) {
        super(shaderModuleDataList, vertices, color, centerpointX, centerpointY, rx, ry);
        this.rz = rz;
//        createSphere();
//        createCircle();
//        createBox();
        createSphere1();
//        createHalfSphere();
        setupVAOVBO();
    }

//    public Sphere(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, float centerpointX, float centerpointY, float rx, float ry, float rz, int i) {
//        super(shaderModuleDataList, vertices, color, centerpointX, centerpointY, rx, ry);
//        this.rz = rz;
//        createBoxx();
//        setupVAOVBO();
//    }

    public void createSphere1() {
        ArrayList<Vector3f> temp = new ArrayList<>();
        for (double v = 0; v <= Math.PI; v += Math.PI / 500) {
            for (double u = 0; u < 2 * Math.PI; u += Math.PI / 500) {
                float x = (float) (rx * Math.sin(v) * Math.cos(u));
                float y = (float) (ry * Math.sin(v) * Math.sin(u));
                float z = (float) (rz * Math.cos(v));
                temp.add(new Vector3f(x, y, z));
            }
        }
        vertices = temp;
        setupVAOVBO();
    }


    public void createHalfSphere() {
        ArrayList<Vector3f> temp = new ArrayList<>();
        for (double v = 0; v <= Math.PI/2; v += Math.PI / 500) {
            for (double u = 0; u < 2 * Math.PI; u += Math.PI / 500) {
                float x = (float) (rx * Math.sin(v) * Math.cos(u));
                float y = (float) (ry * Math.sin(v) * Math.sin(u));
                float z = (float) (rz * Math.cos(v));
                temp.add(new Vector3f(x, y, z));
            }
        }
        vertices = temp;
        setupVAOVBO();
    }
    public void body(){
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();

        //TITIK 1
        temp.x = centerPoint.get(0) - rx / 2.0f;
        temp.y = centerPoint.get(1) + ry / 2.0f;
        temp.z = centerPoint.get(2) - rz / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 2
        temp.x = centerPoint.get(0) + rx / 2.0f;
        temp.y = centerPoint.get(1) + ry / 2.0f;
        temp.z = centerPoint.get(2) - rz / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 3
        temp.x = centerPoint.get(0) + rx / 2.0f;
        temp.y = centerPoint.get(1) - ry / 2.0f;
        temp.z = centerPoint.get(2) - rz / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 4
        temp.x = centerPoint.get(0) / rx;
        temp.y = centerPoint.get(1) - ry / 2.0f;
        temp.z = centerPoint.get(2) - rz / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 5
        temp.x = centerPoint.get(0) - rx / 2.0f;
        temp.y = centerPoint.get(1) + ry / 2.0f;
        temp.z = centerPoint.get(2) + rz / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 6
        temp.x = centerPoint.get(0) +rx / 2.0f;
        temp.y = centerPoint.get(1) + ry / 2.0f;
        temp.z = centerPoint.get(2) + rz / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 7
        temp.x = centerPoint.get(0) + rx / 2.0f;
        temp.y = centerPoint.get(1) - ry / 2.0f;
        temp.z = centerPoint.get(2) + rz / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 8
        temp.x = centerPoint.get(0) - rx  / 2.0f;
        temp.y = centerPoint.get(1) - ry / 2.0f;
        temp.z = centerPoint.get(2) + rz / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 9
        temp.x = centerPoint.get(0) / rx ;
        temp.y = centerPoint.get(1) + ry / 2.0f;
        temp.z = centerPoint.get(2) +rz/ 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 10
        temp.x = tempVertices.get(7).get(0) /2.0f;
        temp.y = centerPoint.get(1) - ry / 2.0f;
        temp.z = tempVertices.get(7).get(2)/2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        System.out.println(tempVertices.get(7).get(0)+","+tempVertices.get(7).get(1)+","+tempVertices.get(7).get(2));
        System.out.println(tempVertices.get(3).get(0)+","+tempVertices.get(3).get(1)+","+tempVertices.get(3).get(2));

        vertices.clear();
        float firstX = tempVertices.get(8).get(0);
        float firstY = tempVertices.get(8).get(1);
        float firstZ = tempVertices.get(8).get(2);
        float secondX = tempVertices.get(8).get(0) + tempVertices.get(7).get(0);
        float secondY = 0;
        float secondZ = tempVertices.get(7).get(2);
        float thirdX = tempVertices.get(7).get(0);
        float thirdY = tempVertices.get(7).get(1);
        float thirdZ = tempVertices.get(7).get(2);

        double newX, newY, newZ;
        for(double i = 0; i <=1; i+= 0.01)
        {
            newX = (Math.pow((1-i), 2) * firstX) + (2 * (1-i) * i * secondX) + (Math.pow(i, 2) * thirdX);
            newY = (Math.pow((1-i), 2) * firstY) + (2 * (1-i) * i * secondY) + (Math.pow(i, 2) * thirdY);
            newZ = (Math.pow((1-i), 2) * firstZ) + (2 * (1-i) * i * secondZ) + (Math.pow(i, 2) * thirdZ);
            vertices.add(new Vector3f((float)newX, (float)newY, (float)newZ));
        }
        firstX = tempVertices.get(6).get(0);
        firstY = tempVertices.get(6).get(1);
        secondX = tempVertices.get(6).get(0) - tempVertices.get(8).get(0);
        secondY = 0;
        thirdX = tempVertices.get(8).get(0);
        thirdY = tempVertices.get(8).get(1);
        for(double i = 0; i <=1; i+= 0.01)
        {
            newX = (Math.pow((1-i), 2) * firstX) + (2 * (1-i) * i * secondX) + (Math.pow(i, 2) * thirdX);
            newY = (Math.pow((1-i), 2) * firstY) + (2 * (1-i) * i * secondY) + (Math.pow(i, 2) * thirdY);
            newZ = (Math.pow((1-i), 2) * firstZ) + (2 * (1-i) * i * secondZ) + (Math.pow(i, 2) * thirdZ);
            vertices.add(new Vector3f((float)newX, (float)newY, tempVertices.get(6).get(2)));
        }

        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(3));
    }


    public void createBoxx() {
        ArrayList<Vector3f> temp = new ArrayList<>();
        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 60) {
            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 60) {
                float x = rx * (float) (Math.cos(v) * Math.cos(u));
                float y = ry * (float) (Math.cos(v) * Math.sin(u));
                float z = rz * (float) (Math.sin(v));
                temp.add(new Vector3f(x, y, z));
            }
        }


//        ArrayList<Vector3f> temp = new ArrayList<>();
//        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 60) {
//            for (double u = -Math.PI; u <= Math.PI; u += Math.PI / 60) {
//                float x = rx * (float) (1/Math.cos(v) * Math.cos(u));
//                float y = ry * (float) (1/Math.cos(v) * Math.sin(u));
//                float z = rz * (float) (Math.tan(v));
//                temp.add(new Vector3f(x, y, z));
//            }
//        }

//        ArrayList<Vector3f> temp = new ArrayList<>();
//        for (double v = -Math.PI / 2; v <= Math.PI / 2; v += Math.PI / 60) {
//            for (double u = -Math.PI / 2; u <= Math.PI / 2; u += Math.PI / 60) {
//                float x = 0.7f * (float) (Math.tan(v) * Math.cos(u));
//                float y = 0.7f * (float) (Math.tan(v) * Math.sin(u));
//                float z = 0.7f * (float) (1 / Math.cos(v));
//                temp.add(new Vector3f(x, z, y));
//            }
//
//            for (double u = Math.PI/2; u <= 3 * Math.PI / 2; u += Math.PI / 60) {
//                float x = 0.7f * (float) (Math.tan(v) * Math.cos(u));
//                float y = 0.7f * (float) (Math.tan(v) * Math.sin(u));
//                float z = 0.7f * (float) (1 / Math.cos(v));
//                temp.add(new Vector3f(x, z, y));
//            }
//        }
        vertices = temp;
//        draw();

    }
//    public void createCircle() {
//        vertices.clear();
//        for (int i = 0; i < 360; i++) {
//            float x = centerPoint.get(0) + rx * (float)Math.cos(Math.toRadians(i));
//            float y = centerPoint.get(1) + ry * (float)Math.sin(Math.toRadians(i));
//            float z = centerPoint.get(2);
//            vertices.add(new Vector3f(x, y, z));
//        }
//        setupVAOVBO();
//    }
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
        int stackCount = 500, sectorCount = 36;
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
