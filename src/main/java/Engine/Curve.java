package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.List;

public class Curve extends Object {

    public Curve(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList, vertices, color);
        //BezierPoint();
    }

    public void BezierPoint(Object Point) {

        if (vertices.size() < 2){
            System.out.println("Hi");
            return;
        }

        Point.vertices.clear();
        int n = vertices.size() - 1;
        for(float t = 0; t <= 1; t += 0.01f) {
            double x = 0, y = 0;
            for (int i = 0; i <= n; i++) {
                double blend = calculateBezierBlend(t, n, i);
                x += vertices.get(i).x * blend;
                y += vertices.get(i).y * blend;

            }
            Point.addVertices(new Vector3f((float)x, (float)y, 0));
            //System.out.println("X: "+x +" Y: "+ y);
        }
    }

    public void addVertices(Vector3f newVector) {
        vertices.add(newVector);
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
}
