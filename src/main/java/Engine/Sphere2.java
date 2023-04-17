package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_POLYGON;

public class Sphere2 extends Circle2{
    float radiusZ;
    int stackCount;
    int sectorCount;
    public Sphere2(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ,
                  int sectorCount,int stackCount) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        this.stackCount = stackCount;
        this.sectorCount = sectorCount;
        createBox();
//        createSphere();
        setupVAOVBO();
    }


    public Sphere2(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        createSphere();
        setupVAOVBO();
    }

    //No range
    public Sphere2(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ, int type
    ) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        if (type < 3) createSphere(type);
        else{
            switch (type) {
                case 3 -> createBox();
                case 4 -> createCylinder();
            }
        }
        setupVAOVBO();
    }

    //With range
    public Sphere2(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ, int type
            ,int vstart, int vend) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        createSphereWithRange(type, vstart,vend);
        setupVAOVBO();
    }

    public void createCylinder(){
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();

        for (double i = 0;i<360;i+=0.1){

            Float x = (float) (centerPoint.get(0)+Math.cos(i * Math.PI / (float) 180)*radiusX);
            Float y = (float) (centerPoint.get(1)+Math.sin(i * Math.PI / (float) 180)*radiusY);
            Float z = 0f;
            temp.add(new Vector3f(x,z,y));
            temp.add(new Vector3f(x,radiusZ,y));
        }
        vertices = temp;
    }



    public void createBox(){
        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
        //TITIK 1
        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 2
        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 3
        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 4
        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) - radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 5
        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 6
        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) + radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 7
        temp.x = centerPoint.get(0) + radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();
        //TITIK 8
        temp.x = centerPoint.get(0) - radiusX / 2.0f;
        temp.y = centerPoint.get(1) - radiusY / 2.0f;
        temp.z = centerPoint.get(2) + radiusZ / 2.0f;
        tempVertices.add(temp);
        temp = new Vector3f();

        vertices.clear();
        //kotak yg sisi belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        //kotak yg sisi depan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        //kotak yg sisi kiri
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));
        //kotak yg sisi kanan
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(2));
        //kotak yg sisi atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));
        //kotak yg sisi bawah
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(6));
    }
    //    public void draw(){
//        drawSetup();
//        glLineWidth(2); //ketebalan garis
//        glPointSize(2); //besar kecil vertex
//        glDrawArrays(GL_LINE_STRIP,
//                0,
//                vertices.size());
//    }
    public void createSphere(){
        float pi = (float)Math.PI;

        float sectorStep = 2 * (float)Math.PI / sectorCount;
        float stackStep = (float)Math.PI / stackCount;
        float sectorAngle, StackAngle, x, y, z;

        for (int i = 0; i <= stackCount; ++i)
        {
            StackAngle = pi / 2 - i * stackStep;
            x = radiusX * (float)Math.cos(StackAngle);
            y = radiusY * (float)Math.cos(StackAngle);
            z = radiusZ * (float)Math.sin(StackAngle);

            for (int j = 0; j <= sectorCount; ++j)
            {
                sectorAngle = j * sectorStep;
                Vector3f temp_vector = new Vector3f();
                temp_vector.x = centerPoint.get(0) + x * (float)Math.cos(sectorAngle);
                temp_vector.y = centerPoint.get(1) + y * (float)Math.sin(sectorAngle);
                temp_vector.z = centerPoint.get(2) + z;
                vertices.add(temp_vector);
            }
        }
    }

    public void createSphere(int quadratic){
        ArrayList<Vector3f> temp = new ArrayList<>();
        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60) {
            switch (quadratic) {
                case 0: //Elipsoid
                    for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                        float x = this.radiusX * (float)(Math.cos(v) * Math.cos(u));
                        float y = this.radiusY * (float)(Math.cos(v) * Math.sin(u));
                        float z = this.radiusZ * (float)(Math.sin(v));
                        temp.add(new Vector3f(x,z,y));
                    }
                    break;
                case 1: //Hyperboloid 1 side
                    for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                        float x = this.radiusX * (float)((Math.cosh(v)) * Math.cos(u));
                        float y = this.radiusY * (float)((Math.cosh(v)) * Math.sin(u));
                        float z = this.radiusZ * (float)(Math.sinh(v));
                        temp.add(new Vector3f(x,z,y));
                    }
                    break;
                case 2://Hyperboloid 2 side
                    //sheet 1
                    for(double u = -Math.PI/2; u<= Math.PI/2; u+=Math.PI/60){
                        float x = this.radiusX * (float)(Math.sinh(v) * Math.cos(u));
                        float y = this.radiusY * (float)(Math.sinh(v) * Math.sin(u));
                        float z = this.radiusZ * (float)(Math.cosh(v));
                        temp.add(new Vector3f(x,z,y));
                    }
                    //sheet 2
                    for(double u = Math.PI/2; u<= 3*Math.PI/2; u+=Math.PI/60){
                        float x = this.radiusX * (float)(Math.sinh(v) * Math.cos(u));
                        float y = this.radiusY * (float)(Math.sinh(v) * Math.sin(u));
                        float z = this.radiusZ * (float)(Math.cosh(v));
                        temp.add(new Vector3f(x,z,y));
                    }
                    break;
            }
        }
        vertices = temp;

    }

    public void createSphereWithRange(int quadratic, int vstart, int vend){
        ArrayList<Vector3f> temp = new ArrayList<>();
        for(double v = vstart ; v<= vend; v+=Math.PI/60) {
            if (quadratic > 0 && v > 0) break;
            switch (quadratic) {
                case 0: //Elliptic cone
                    for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                        float x = this.radiusX * (float)((v) * Math.cos(u));
                        float y = this.radiusY * (float)((v) * Math.sin(u));
                        float z = this.radiusZ * (float)((v));
                        temp.add(new Vector3f(x,z,y));
                    }
                    break;
                case 1: //Eliptic paraboloid
                    for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                        float x = this.radiusX * (float)((v) * Math.cos(u));
                        float y = this.radiusY * (float)((v) * Math.sin(u));
                        float z = this.radiusZ * (float)(Math.pow(v,2));
                        temp.add(new Vector3f(x,z,y));
                    }
                    break;
                case 2: //Hyperbolic paraboloid
                    for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
//                        float x = this.radiusX * (float)((v) * Math.tan(u));
//                        float y = this.radiusY * (float)((v) * 1/Math.cos(u));
//                        float z = this.radiusZ * (float)(Math.pow(v,2));
                        float x = this.radiusX * (float)v;
                        float y = this.radiusY * (float)u;
                        float z = this.radiusZ * ((float)(Math.pow(v,2)) - (float)(Math.pow(u,2)));
                        temp.add(new Vector3f(x,z,y));
                    }
                    break;
            }
        }
        vertices = temp;
    }
    public void createEllipticCylinder (float r1, float r2, float h, int segment){
        ArrayList<Vector3f> temp = new ArrayList<>();

        vertices = temp;
    }
}