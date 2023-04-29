package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

public class kerucut extends Circle{
    float rz;

    List<Integer> index = new ArrayList<>();
    int ibo;

    public kerucut(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, float centerpointX, float centerpointY, float rx, float ry, float rz) {
        super(shaderModuleDataList, vertices, color, centerpointX, centerpointY, rx, ry);
        this.rz = rz;
        kerucut();
        setupVAOVBO();
    }
    public void kerucut() {
        ArrayList<Vector3f> temp = new ArrayList<>();
        for(double v = -7 ; v<= 0; v+=Math.PI/60) {
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float x = this.rx * (float)((v) * Math.cos(u));
                float y = this.ry * (float)((v) * Math.sin(u));
                float z = this.rz * (float)((v));
                temp.add(new Vector3f(x,z,y));
            }
        }
        vertices = temp;
        setupVAOVBO();
    }
}
