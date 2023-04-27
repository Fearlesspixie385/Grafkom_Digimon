package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

public class Curve extends Object {

    List<Vector3f> points = new ArrayList<>();
    List<Integer>numbers;
    List<Vector3f> curve;
    boolean isLine;

    public Curve(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, boolean line) {
        super(shaderModuleDataList, vertices, color);
        this.isLine = line;
        //BezierPoint();
    }
    public Curve(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList, vertices, color);
        //BezierPoint();
    }

    public void BezierPoint() {
        curve=new ArrayList<>();
        int n = points.size() - 1;
        if (points.size() < 2){
            System.out.println("Hi");
            return;
        }

        //Point.vertices.clear();

        for(float t = 0; t <= 1; t += 0.01f) {
            double x = 0, y = 0, z=0;
            for (int i = 0; i <= n; i++) {
                double blend = calculateBezierBlend(t, n, i);
                x += points.get(i).x * blend;
                y += points.get(i).y * blend;
                z += points.get(i).z * blend;

            }
            curve.add(new Vector3f((float)x, (float)y, (float)z));
            //System.out.println("X: "+x +" Y: "+ y);
        }
    }

    public void addVertices(Vector3f newVector) {
        points.add(newVector);
        BezierPoint();
        vertices = curve;
        setupVAOVBO();
    }

    public double calculateBezierBlend(float t, int n, int i) {
        return binomialCoefficient(n, i) * Math.pow(t, i) *  Math.pow(1 - t, n - i);
    }

    public int binomialCoefficient(int n, int k) {
        int coefficient = 1;
        for (int i = 1; i <= k; i++) {
            coefficient *= n - i + 1;
            coefficient /= i;
        }
        return coefficient;
    }
    public void changeVerticesPos(Vector3f newVertices){
        vertices.add(newVertices);
        setupVAOVBO();
    }

    public void draw(Camera camera, Projection projection){
        drawSetup(camera,projection);
        // Draw the vertices
        if(isLine){
            glLineWidth(5);
            glPointSize(5);
            //GL_TRIANGLES
            //GL_LINE_LOOP
            //GL_LINE_STRIP
            //GL_LINES
            //GL_POINTS
            //GL_TRIANGLE_FAN
            glDrawArrays(GL_LINE_STRIP, 0,
                    vertices.size());
            for(Object child:childObject){
                child.draw(camera,projection);
            }
        }
        else {
            glLineWidth(10);
            glPointSize(10);
            //GL_TRIANGLES
            //GL_LINE_LOOP
            //GL_LINE_STRIP
            //GL_LINES
            //GL_POINTS
            //GL_TRIANGLE_FAN
            glDrawArrays(GL_POLYGON, 0,
                    vertices.size());
            for (Object child : childObject) {
                child.draw(camera, projection);
            }
        }
    }
}
