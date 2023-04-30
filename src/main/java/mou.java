//import Engine.*;
//import Engine.Object;
//import org.joml.Vector2f;
//import org.joml.Vector3f;
//import org.joml.Vector4f;
//import org.lwjgl.opengl.GL;
//
//import java.lang.Math;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//import static org.lwjgl.glfw.GLFW.*;
//import static org.lwjgl.opengl.GL11.glClearColor;
//import static org.lwjgl.opengl.GL30.*;
//
//public class mou {
//    Camera camera = new Camera();
//    private Window window = new Window(800, 800, "Hello World");
//    Projection projection = new Projection(window.getWidth(), window.getHeight());
//    private ArrayList<Object> objects = new ArrayList<>();
//    private ArrayList<Object> objectsRectangle = new ArrayList<>();
//    private ArrayList<Object> objectPointControl = new ArrayList<>();
//    private ArrayList<Object> objectPointCurve = new ArrayList<>();
//    private boolean dragDrop = false;
//    private float posX = 0.0f;
//    private float posY = 0.0f;
//    private float posZ = 2.0f;
//
//    private Object lowerBody;
//    private Object upperBody;
//    private Object head;
//    private Object jointHead;
//    private Object eyeRight; //from char perspective
//    private Object eyeLeft;
//    private Object jointArmLeft;
//    private Object jointArmRight;
//    private Object jointHandLeft;
//    private Object jointHandRight;
//    private Object jointLegLeft;
//    private Object jointLegRight;
//    private Object jointFootLeft;
//    private Object jointFootRight;
//
//    private ArrayList<Double> valueArray = new ArrayList<>();
//    private ArrayList<Boolean> stateArray = new ArrayList<>();
//
//
//    public static void main(String[] args) {
//        new main().run();
//    }
//
//    public void init() {
//        window.init();
//        GL.createCapabilities();
//
//        camera.setPosition(posX, posY, posZ);
//        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(0.0f));
//
//        //lower body
//        objects.add(new Sphere3(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.13f, 0.13f, 0.07f, 0
//        ));
//        lowerBody = objects.get(0);
//        int intlowerBody = 0;
//
//
//        //upper body
//        lowerBody.getChildObject().add(new Sphere3(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.13f, 0.13f, 0.158f, 0
//        ));
//        upperBody = lowerBody.getChildObject().get(intlowerBody);
//        int intupperBody = 0;
//        intlowerBody++;
//
//        upperBody.rotateObject((float) Math.toRadians(180f), 0.0f, 0.0f, 1.0f);
//        upperBody.translateObject(0f, 0.565f, 0.0f);
//
//        //joint Head
//        upperBody.getChildObject().add(new Sphere3(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0f, 1f, 1f, 0f), 0.0f, 0.0f, 0.2f, 0.2f, 0.15f
//        ));
//
//        jointHead = upperBody.getChildObject().get(intupperBody);
//        int intjointHead = 0;
//        intupperBody++;
//
//        jointHead.scaleObject(0.1f, 0.1f, 0.1f);
//        Vector3f tempCenterPoint = upperBody.updateCenterPointObject();
//        jointHead.translateObject(0f, tempCenterPoint.y - 0.13f, 0.0f);
//
//        //head
//        jointHead.getChildObject().add(new Sphere3(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.2f, 0.2f, 0.15f
//        ));
//        head = jointHead.getChildObject().get(intjointHead);
//        int inthead = 0;
//        intjointHead++;
//
//        tempCenterPoint = jointHead.updateCenterPointObject();
//        head.scaleObject(0.5f, 0.5f, 0.5f);
//        head.translateObject(0f, tempCenterPoint.y + 0.27f, 0.0f);
//
//
//        //eye right
//        head.getChildObject().add(new Circle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.09f, 0.58f, 0.81f, 0f), 0.0f, 0.0f, 0.03f
//        ));
//        eyeRight = head.getChildObject().get(inthead);
//        inthead++;
//
//
//        eyeRight.rotateObject((float) Math.toRadians(-24f), 0f, 1f, 0f);
//        tempCenterPoint = head.updateCenterPointObject();
//        eyeRight.translateObject(tempCenterPoint.x - 0.1f, tempCenterPoint.y, tempCenterPoint.z + 0.229f);
//
//
//        //eye left
//        head.getChildObject().add(new Circle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.09f, 0.58f, 0.81f, 0f), 0.0f, 0.0f, 0.03f
//        ));
//        eyeLeft = head.getChildObject().get(inthead);
//        inthead++;
//
//        eyeLeft.rotateObject((float) Math.toRadians(24f), 0f, 1f, 0f);
//        tempCenterPoint = head.updateCenterPointObject();
//        eyeLeft.translateObject(tempCenterPoint.x + 0.1f, tempCenterPoint.y, tempCenterPoint.z + 0.229f);
//
//        //head(2)
//        eyeRightDecor();
//        inthead++;
//        //head(3)
//        eyeLeftDecor();
//        inthead++;
//
//        //nose
//        head.getChildObject().add(new Sphere3(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0f, 0f, 0f, 0f), 0.0f, 0.0f, 0.02f, 0.01f, 0.01f, 1
//        ));
//        Object nose = head.getChildObject().get(inthead);
//        inthead++;
//
//        nose.rotateObject((float) Math.toRadians(15f), 0.0f, 0.0f, 1.f);
//        nose.translateObject(tempCenterPoint.x + 0.005f, tempCenterPoint.y - 0.05f, tempCenterPoint.z + 0.24f);
//
//        head.getChildObject().add(new Sphere3(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0f, 0f, 0f, 0f), 0.0f, 0.0f, 0.02f, 0.01f, 0.01f, 1
//        ));
//
//        head.getChildObject().get(inthead).rotateObject((float) Math.toRadians(-15f), 0.0f, 0.0f, 1.f);
//        head.getChildObject().get(inthead).translateObject(tempCenterPoint.x - 0.005f, tempCenterPoint.y - 0.05f, tempCenterPoint.z + 0.24f);
//        inthead++;
//
//        //earRight
//        head.getChildObject().add(new Sphere3(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.015f, 0.004f, 0.04f, 2
//        ));
//        Object earRight = head.getChildObject().get(inthead);
//        inthead++;
//
//        tempCenterPoint = head.updateCenterPointObject();
//        earRight.rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
//        earRight.rotateObject((float) Math.toRadians(30f), 0f, 0f, 1f);
//        earRight.translateObject(tempCenterPoint.x - 0.24f, tempCenterPoint.y + 0.37f, tempCenterPoint.z + 0.07f);
//
//
//        //earRight addon
//        earRight.getChildObject().add(new Sphere3(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.93333334f, 0.77254903f, 0.81960785f, 0f), 0.0f, 0.0f, 0.015f / 1.5f, 0.004f / 1.5f, 0.04f / 1.5f, 2
//        ));
//
//        tempCenterPoint = earRight.updateCenterPointObject();
//        earRight.getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
//        earRight.getChildObject().get(0).rotateObject((float) Math.toRadians(30f), 0f, 0f, 1f);
//        earRight.getChildObject().get(0).translateObject(tempCenterPoint.x + 0.024f, tempCenterPoint.y - 0.05f, tempCenterPoint.z + 0.01f);
//
//
//        //earLeft
//        head.getChildObject().add(new Sphere3(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.015f, 0.004f, 0.04f, 2
//        ));
//        Object earLeft = head.getChildObject().get(inthead);
//        inthead++;
//
//        tempCenterPoint = head.updateCenterPointObject();
//        earLeft.rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
//        earLeft.rotateObject((float) Math.toRadians(-30f), 0f, 0f, 1f);
//        earLeft.translateObject(tempCenterPoint.x + 0.24f, tempCenterPoint.y + 0.37f, tempCenterPoint.z + 0.07f);
//
//
//        //earLeft addon
//        earLeft.getChildObject().add(new Sphere3(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.93333334f, 0.77254903f, 0.81960785f, 0f), 0.0f, 0.0f, 0.015f / 1.5f, 0.004f / 1.5f, 0.04f / 1.5f, 2
//        ));
//
//        tempCenterPoint = earLeft.updateCenterPointObject();
//        earLeft.getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
//        earLeft.getChildObject().get(0).rotateObject((float) Math.toRadians(-30f), 0f, 0f, 1f);
//        earLeft.getChildObject().get(0).translateObject(tempCenterPoint.x - 0.024f, tempCenterPoint.y - 0.05f, tempCenterPoint.z + 0.01f);
//
//
//        //mouth right
//        objectPointControl.clear();
//        objectPointControl.add(new Object(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f)
//        ));
//
//        head.getChildObject().add(new Curve2(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), 3
//        ));
//        Object mouthLeft = head.getChildObject().get(inthead);
//        inthead++;
//
//        tempCenterPoint = head.updateCenterPointObject();
//        float move1 = 0.02f;
//        float move2 = 0.1f;
//        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.02f - move1, tempCenterPoint.y + 0.015f - move2, tempCenterPoint.z + 0.232f));
//        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.014f - move1, tempCenterPoint.y - 0.0001f - move2, tempCenterPoint.z + 0.228f));
//        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.007f - move1, tempCenterPoint.y - 0.0001f - move2, tempCenterPoint.z + 0.232f));
//        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.02f - move1, tempCenterPoint.y + 0.015f - move2, tempCenterPoint.z + 0.235f));
//
//        objectPointControl.get(0).bezierCurve(mouthLeft);
//
//
//        //mouth left
//        objectPointControl.clear();
//        objectPointControl.add(new Object(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f)
//        ));
//
//        head.getChildObject().add(new Curve2(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), 3
//        ));
//        Object mouthRight = head.getChildObject().get(inthead);
//        inthead++;
//
//        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.02f + move1, tempCenterPoint.y + 0.015f - move2, tempCenterPoint.z + 0.235f));
//        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.007f + move1, tempCenterPoint.y - 0.0001f - move2, tempCenterPoint.z + 0.232f));
//        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.014f + move1, tempCenterPoint.y - 0.0001f - move2, tempCenterPoint.z + 0.228f));
//        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.02f + move1, tempCenterPoint.y + 0.015f - move2, tempCenterPoint.z + 0.232f));
//
//        objectPointControl.get(0).bezierCurve(mouthRight);
//
//
//        //whisker left up
//        objectPointControl.clear();
//        objectPointControl.add(new Object(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f)
//        ));
//
//        head.getChildObject().add(new Curve2(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), 1
//        ));
//        Object whiskerLeftUp = head.getChildObject().get(inthead);
//        inthead++;
//
//        move1 = 0.3f;
//        move2 = 0.1f;
//        float move3 = 0.2f;
//        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.08f - move1, tempCenterPoint.y - 0.005f - move2, tempCenterPoint.z + move3));
//        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.053f - move1, tempCenterPoint.y + 0.011f - move2, tempCenterPoint.z + move3));
//        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.05f - move1, tempCenterPoint.y + 0.011f - move2, tempCenterPoint.z + move3));
//        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.08f - move1, tempCenterPoint.y - 0.005f - move2, tempCenterPoint.z + move3));
//
//        objectPointControl.get(0).bezierCurve(whiskerLeftUp);
//        tempCenterPoint = whiskerLeftUp.updateCenterPointObject();
//        whiskerLeftUp.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
//        whiskerLeftUp.rotateObject((float) Math.toRadians(-10f), 0f, 0f, 1f);
//        whiskerLeftUp.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
//
//
//        //whisker right up
//        objectPointControl.clear();
//        objectPointControl.add(new Object(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f)
//        ));
//
//        head.getChildObject().add(new Curve2(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), 1
//        ));
//        Object whiskerRightUp = head.getChildObject().get(inthead);
//        inthead++;
//
//        move1 = -move1;
//
//        tempCenterPoint = head.updateCenterPointObject();
//        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.08f - move1, tempCenterPoint.y - 0.005f - move2, tempCenterPoint.z + move3));
//        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.05f - move1, tempCenterPoint.y + 0.011f - move2, tempCenterPoint.z + move3));
//        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.053f - move1, tempCenterPoint.y + 0.011f - move2, tempCenterPoint.z + move3));
//        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.08f - move1, tempCenterPoint.y - 0.005f - move2, tempCenterPoint.z + move3));
//
//        objectPointControl.get(0).bezierCurve(whiskerRightUp);
//        tempCenterPoint = whiskerRightUp.updateCenterPointObject();
//        whiskerRightUp.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
//        whiskerRightUp.rotateObject((float) Math.toRadians(10f), 0f, 0f, 1f);
//        whiskerRightUp.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
//
//
//        //whisker left down
//        objectPointControl.clear();
//        objectPointControl.add(new Object(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f)
//        ));
//
//        head.getChildObject().add(new Curve2(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), 1
//        ));
//        Object whiskerLeftDown = head.getChildObject().get(inthead);
//        inthead++;
//
//        move1 = -move1 - 0.15f;
//        move2 += -0.023f;
//        move3 += -0.01f;
//
//        tempCenterPoint = head.updateCenterPointObject();
//        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.08f - move1, tempCenterPoint.y - 0.005f - move2, tempCenterPoint.z + move3));
//        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.05f - move1, tempCenterPoint.y + 0.011f - move2, tempCenterPoint.z + move3));
//        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.053f - move1, tempCenterPoint.y + 0.011f - move2, tempCenterPoint.z + move3));
//        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.08f - move1, tempCenterPoint.y - 0.005f - move2, tempCenterPoint.z + move3));
//
//        objectPointControl.get(0).bezierCurve(whiskerLeftDown);
//        tempCenterPoint = whiskerLeftDown.updateCenterPointObject();
//        whiskerLeftDown.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
//        whiskerLeftDown.rotateObject((float) Math.toRadians(3f), 0f, 0f, 1f);
//        whiskerLeftDown.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
//
//
//        //whisker right down
//        objectPointControl.clear();
//        objectPointControl.add(new Object(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f)
//        ));
//
//        head.getChildObject().add(new Curve2(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), 1
//        ));
//        Object whiskerRightDown = head.getChildObject().get(inthead);
//        inthead++;
//
//        move1 = -move1;
//
//        tempCenterPoint = head.updateCenterPointObject();
//        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.08f - move1, tempCenterPoint.y - 0.005f - move2, tempCenterPoint.z + move3));
//        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.05f - move1, tempCenterPoint.y + 0.011f - move2, tempCenterPoint.z + move3));
//        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.053f - move1, tempCenterPoint.y + 0.011f - move2, tempCenterPoint.z + move3));
//        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.08f - move1, tempCenterPoint.y - 0.005f - move2, tempCenterPoint.z + move3));
//
//        objectPointControl.get(0).bezierCurve(whiskerRightDown);
//
//        tempCenterPoint = whiskerRightDown.updateCenterPointObject();
//        whiskerRightDown.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
//        whiskerRightDown.rotateObject((float) Math.toRadians(-3f), 0f, 0f, 1f);
//        whiskerRightDown.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
//
//        //joint upper body arm
//        upperBody.getChildObject().add(new Sphere3(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.02f, 0.02f, 0.05f
//        ));
//
//        jointArmLeft = upperBody.getChildObject().get(1);
//
//        jointArmLeft.scaleObject(0.06f, 0.06f, 0.06f);
//        tempCenterPoint = upperBody.updateCenterPointObject();
//        jointArmLeft.translateObject(tempCenterPoint.x + 0.1f, tempCenterPoint.y - 0.11f, tempCenterPoint.z);
//
//        upperBody.getChildObject().add(new Sphere3(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.02f, 0.02f, 0.05f
//        ));
//
//        jointArmRight = upperBody.getChildObject().get(2);
//
//        jointArmRight.scaleObject(0.06f, 0.06f, 0.06f);
//        tempCenterPoint = upperBody.updateCenterPointObject();
//        jointArmRight.translateObject(tempCenterPoint.x - 0.1f, tempCenterPoint.y - 0.11f, tempCenterPoint.z);
//
//
//        //arm right
//        jointArmRight.getChildObject().add(new Tube(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.03f, 0.2f
//        ));
//        Object armRight = jointArmRight.getChildObject().get(0);
//
//        tempCenterPoint = jointArmRight.updateCenterPointObject();
//        armRight.rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        armRight.translateObject(tempCenterPoint.x - 0.1f, tempCenterPoint.y, tempCenterPoint.z);
//
//
//        //joint arm right hand
//        armRight.getChildObject().add(new Sphere3(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.02f, 0.02f, 0.05f
//        ));
//        jointHandRight = armRight.getChildObject().get(0);
//
//        jointHandRight.scaleObject(0.06f, 0.06f, 0.06f);
//
//        tempCenterPoint = armRight.updateCenterPointObject();
//        jointHandRight.translateObject(tempCenterPoint.x - 0.094f, tempCenterPoint.y, tempCenterPoint.z);
//
//        handRight();
//
//        //arm left
//        jointArmLeft.getChildObject().add(new Tube(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.03f, 0.2f
//        ));
//        Object armLeft = jointArmLeft.getChildObject().get(0);
//
//        armLeft.rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        tempCenterPoint = jointArmLeft.updateCenterPointObject();
//        armLeft.translateObject(tempCenterPoint.x + 0.1f, tempCenterPoint.y, tempCenterPoint.z);
//
//
//        //joint arm left hand
//        armLeft.getChildObject().add(new Sphere3(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.788f, 0.815f, 0.305f, 0f), 0.0f, 0.0f, 0.02f, 0.02f, 0.05f
//        ));
//        jointHandLeft = armLeft.getChildObject().get(0);
//
//        jointHandLeft.scaleObject(0.04f, 0.04f, 0.04f);
//
//        tempCenterPoint = armLeft.updateCenterPointObject();
//        jointHandLeft.translateObject(tempCenterPoint.x + 0.094f, tempCenterPoint.y, tempCenterPoint.z);
//
//        handLeft();
//
//
//        //joint leg right
//        lowerBody.getChildObject().add(new Sphere3(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1, 1, 1, 1f), 0.0f, 0.0f, 0.02f, 0.02f, 0.05f
//        ));jointLegRight = lowerBody.getChildObject().get(intlowerBody);
//        intlowerBody++;
//
//        tempCenterPoint = lowerBody.updateCenterPointObject();
//        jointLegRight.rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
//        jointLegRight.scaleObject(0.1f, 0.1f, 0.1f);
//        jointLegRight.translateObject(tempCenterPoint.x - 0.1f, tempCenterPoint.y + 0.09f, tempCenterPoint.z);
//
//
//        //legRight
//        jointLegRight.getChildObject().add(new Tube(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.05f, 0.2f
//        ));
//        Object legRight = jointLegRight.getChildObject().get(0);
//
//        tempCenterPoint = jointLegRight.updateCenterPointObject();
//        legRight.rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
//        legRight.translateObject(tempCenterPoint.x, tempCenterPoint.y - 0.09f, tempCenterPoint.z);
//
//
//        //joint foot right
//        legRight.getChildObject().add(new Sphere3(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1, 1, 1, 1f), 0.0f, 0.0f, 0.02f, 0.02f, 0.05f
//        ));jointFootRight = legRight.getChildObject().get(0);
//
//        tempCenterPoint = legRight.updateCenterPointObject();
//
//        jointFootRight.scaleObject(0.1f, 0.1f, 0.1f);
//        jointFootRight.translateObject(tempCenterPoint.x, tempCenterPoint.y - 0.1f, tempCenterPoint.z);
//
//
//        //foot right
//        jointFootRight.getChildObject().add(new Tube(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.09f, 0.04f
//        ));
//
//
//        tempCenterPoint = jointFootRight.updateCenterPointObject();
//        jointFootRight.getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
//        jointFootRight.getChildObject().get(0).translateObject(tempCenterPoint.x, tempCenterPoint.y -0.03f, tempCenterPoint.z + 0.033f);
//
//
//        //joint leg left
//        lowerBody.getChildObject().add(new Sphere3(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1, 1, 1, 1f), 0.0f, 0.0f, 0.02f, 0.02f, 0.05f
//        ));jointLegLeft = lowerBody.getChildObject().get(intlowerBody);
//        intlowerBody++;
//
//        tempCenterPoint = lowerBody.updateCenterPointObject();
//        jointLegLeft.rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
//        jointLegLeft.scaleObject(0.1f, 0.1f, 0.1f);
//        jointLegLeft.translateObject(tempCenterPoint.x + 0.1f, tempCenterPoint.y + 0.09f, tempCenterPoint.z);
//
//
//        //legLeft
//        jointLegLeft.getChildObject().add(new Tube(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.05f, 0.2f
//        ));
//        Object legLeft = jointLegLeft.getChildObject().get(0);
//
//
//        tempCenterPoint = jointLegLeft.updateCenterPointObject();
//        legLeft.rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
//        legLeft.translateObject(tempCenterPoint.x, tempCenterPoint.y - 0.09f, tempCenterPoint.z);
//
//
//        //joint foot left
//        legLeft.getChildObject().add(new Sphere3(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1, 1, 1, 1f), 0.0f, 0.0f, 0.02f, 0.02f, 0.05f
//        ));jointFootLeft = legLeft.getChildObject().get(0);
//
//        tempCenterPoint = legLeft.updateCenterPointObject();
//
//        jointFootLeft.scaleObject(0.1f, 0.1f, 0.1f);
//        jointFootLeft.translateObject(tempCenterPoint.x, tempCenterPoint.y - 0.1f, tempCenterPoint.z);
//
//
//        //foot left
//        jointFootLeft.getChildObject().add(new Tube(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.09f, 0.04f
//        ));
//
//
//        tempCenterPoint = jointFootLeft.updateCenterPointObject();
//        jointFootLeft.getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
//        jointFootLeft.getChildObject().get(0).translateObject(tempCenterPoint.x, tempCenterPoint.y -0.03f, tempCenterPoint.z + 0.033f);
//
//
//
//
//
//        tempCenterPoint = jointArmRight.updateCenterPointObject();
//        jointArmRight.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
//        jointArmRight.rotateObject((float) Math.toRadians(55f), 0f, 0f, 1f);
//        jointArmRight.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
//
//        tempCenterPoint = jointArmLeft.updateCenterPointObject();
//        jointArmLeft.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
//        jointArmLeft.rotateObject((float) Math.toRadians(-55f), 0f, 0f, 1f);
//        jointArmLeft.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
//
//        lowerBody.translateObject(0f, -0.2f, 0f);
//
//
//        for (int i = 0; i < 3; i++) {
//            valueArray.add(0.0);
//        }
//
//        for (int i = 0; i < 6; i++) {
//            stateArray.add(true);
//        }
//
//        objectPointControl.clear();
//
//
//    }
//
//    public void input() {
//        class Rotate {
//            private void x (Object object, float rotate) {
//                Vector3f tempCenterPoint = object.updateCenterPointObject();
//                object.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
//                object.rotateObjectAnimate((float) Math.toRadians(rotate), 1f, 0f, 0f, camera, projection);
//                object.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
//            }
//
//            private void y (Object object, float rotate) {
//                Vector3f tempCenterPoint = object.updateCenterPointObject();
//                object.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
//                object.rotateObjectAnimate((float) Math.toRadians(rotate), 0f, 1f, 0f, camera, projection);
//                object.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
//            }
//
//            private void z (Object object, float rotate) {
//                Vector3f tempCenterPoint = object.updateCenterPointObject();
//                object.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
//                object.rotateObjectAnimate((float) Math.toRadians(rotate), 0f, 0f, 1f, camera, projection);
//                object.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
//            }
//        }
//        Rotate rotate1 = new Rotate();
//
//        // value 0 state 0 1 head right left
//        if (window.isKeyPressed(GLFW_KEY_P)) {
//            if (stateArray.get(1)) {
//                if (valueArray.get(0) < 30 && stateArray.get(0)) {
//                    rotate1.z(jointHead, 0.2f);
//                    valueArray.set(0, valueArray.get(0) + 1);
//
//                } else {
//                    stateArray.set(0, false);
//                    rotate1.z(jointHead, -0.2f);
//                    valueArray.set(0, valueArray.get(0) - 1);
//                }
//
//                if (valueArray.get(0) == 0) {
//                    stateArray.set(0, true);
//                    stateArray.set(1, false);
//                }
//            } else {
//                if (valueArray.get(0) > -30 && stateArray.get(0)) {
//                    rotate1.z(jointHead, -0.2f);
//                    valueArray.set(0, valueArray.get(0) - 1);
//                } else {
//                    stateArray.set(0, false);
//                    new Rotate().z(jointHead, 0.2f);
//                    valueArray.set(0, valueArray.get(0) + 1);
//                }
//
//                if (valueArray.get(0) == 0) {
//                    stateArray.set(0, true);
//                    stateArray.set(1, true);
//                }
//            }
//        }
//
//
//        // value 1 state 2 3 walk
//        if (window.isKeyPressed(GLFW_KEY_Q)) {
//            float move = 1;
//            float move1 = move/2;
//            if (stateArray.get(3)) {
//                if (valueArray.get(1) < 30 && stateArray.get(2)) {
//                    rotate1.x(jointArmRight, -move);
//                    rotate1.x(jointHandRight, -move1);
//                    rotate1.x(jointArmLeft, move);
//
//                    rotate1.x(jointLegRight, move);
//                    rotate1.x(jointFootRight, -move);
//                    rotate1.x(jointLegLeft, -move);
//                    rotate1.x(jointFootLeft, move);
//                    valueArray.set(1, valueArray.get(1) + move);
//
//                } else {
//                    stateArray.set(2, false);
//                    rotate1.x(jointArmRight, move);
//                    rotate1.x(jointHandRight, move1);
//                    rotate1.x(jointArmLeft, -move);
//
//                    rotate1.x(jointLegRight, -move);
//                    rotate1.x(jointFootRight, move);
//                    rotate1.x(jointLegLeft, move);
//                    rotate1.x(jointFootLeft, -move);
//                    valueArray.set(1, valueArray.get(1) - move);
//                }
//
//                if (valueArray.get(1) == 0) {
//                    stateArray.set(2, true);
//                    stateArray.set(3, false);
//                }
//            } else {
//                if (valueArray.get(1) > -30 && stateArray.get(2)) {
//                    rotate1.x(jointArmRight, move);
//                    rotate1.x(jointArmLeft, -move);
//                    rotate1.x(jointHandLeft, -move1);
//
//                    rotate1.x(jointLegRight, -move);
//                    rotate1.x(jointFootRight, move);
//                    rotate1.x(jointLegLeft, move);
//                    rotate1.x(jointFootLeft, -move);
//                    valueArray.set(1, valueArray.get(1) - move);
//                } else {
//                    stateArray.set(2, false);
//                    rotate1.x(jointArmRight, -move);
//                    rotate1.x(jointArmLeft, move);
//                    rotate1.x(jointHandLeft, move1);
//
//                    rotate1.x(jointLegRight, move);
//                    rotate1.x(jointFootRight, -move);
//                    rotate1.x(jointLegLeft, -move);
//                    rotate1.x(jointFootLeft, move);
//                    valueArray.set(1, valueArray.get(1) + move);
//                }
//
//                if (valueArray.get(1) == 0) {
//                    stateArray.set(2, true);
//                    stateArray.set(3, true);
//                }
//            }
//        }
//
//
//        if (window.isKeyPressed(GLFW_KEY_R)) {
//            lowerBody.resetPosChildren();
//            valueArray.replaceAll(Integer -> 0.0);
//            stateArray.replaceAll(Boolean -> true);
//        }
//
//        float rotate = 0.6f;
//        if (window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
//            rotate = 1;
//        }
//
//        if (window.isKeyPressed(GLFW_KEY_W)) {
//            rotate1.x(lowerBody, -rotate);
//        }
//
//        if (window.isKeyPressed(GLFW_KEY_A)) {
//            rotate1.y(lowerBody, -rotate);
//        }
//
//        if (window.isKeyPressed(GLFW_KEY_S)) {
//            rotate1.x(lowerBody, rotate);
//        }
//
//        if (window.isKeyPressed(GLFW_KEY_D)) {
//            rotate1.y(lowerBody, rotate);
//        }
//
//        if (window.isKeyPressed(GLFW_KEY_UP)) {
//            posZ -= 0.1f;
//        }
//
//        if (window.isKeyPressed(GLFW_KEY_DOWN)) {
//            posZ += 0.1f;
//        }
//
//        camera.setPosition(0f, 0f, posZ);
//        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(0.0f));
//    }
//
//    public void eyeRightDecor() {
//        Vector3f tempCenterPoint;
//        //eye right black retina
//        eyeRight.getChildObject().add(new Circle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0f, 0f, 0f, 0f), 0.0f, 0.0f, 0.02f
//        ));
//
//        eyeRight.getChildObject().get(0).rotateObject((float) Math.toRadians(-24f), 0f, 1f, 0f);
//        tempCenterPoint = eyeRight.updateCenterPointObject();
//        eyeRight.getChildObject().get(0).translateObject(tempCenterPoint.x, tempCenterPoint.y, tempCenterPoint.z + 0.0003f);
//
//        //eye right white up
//        eyeRight.getChildObject().add(new Circle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.02f
//        ));
//
//        eyeRight.getChildObject().get(1).scaleObject(1f, 0.5f, 0.01f);
//        eyeRight.getChildObject().get(1).rotateObject((float) Math.toRadians(40f), 0f, 0f, 1f);
//        eyeRight.getChildObject().get(1).rotateObject((float) Math.toRadians(-24f), 0f, 1f, 0f);
//        eyeRight.getChildObject().get(1).translateObject(tempCenterPoint.x - 0.01f, tempCenterPoint.y + 0.015f, tempCenterPoint.z - 0.0041f);
//
//        //eye right white down
//        eyeRight.getChildObject().add(new Circle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.004f
//        ));
//
//        eyeRight.getChildObject().get(2).rotateObject((float) Math.toRadians(-24f), 0f, 1f, 0f);
//        eyeRight.getChildObject().get(2).translateObject(tempCenterPoint.x + 0.01f, tempCenterPoint.y - 0.02f, tempCenterPoint.z + 0.005f);
//
//        //eye right black circle
//        head.getChildObject().add(new Circle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0f, 0f, 0f, 0f), 0.0f, 0.0f, 0.045f
//        ));
//
//
//        head.getChildObject().get(2).rotateObject((float) Math.toRadians(-25f), 0f, 1f, 0f);
//        head.getChildObject().get(2).rotateObject((float) Math.toRadians(1f), 1f, 0f, 0f);
//        head.getChildObject().get(2).translateObject(tempCenterPoint.x - 0.003f, tempCenterPoint.y - 0.005f, tempCenterPoint.z - 0.0045f);
//    }
//
//    public void eyeLeftDecor() {
//        Vector3f tempCenterPoint;
//        //eye left black
//        eyeLeft.getChildObject().add(new Circle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0f, 0f, 0f, 0f), 0.0f, 0.0f, 0.02f
//        ));
//
//        eyeLeft.getChildObject().get(0).rotateObject((float) Math.toRadians(24f), 0f, 1f, 0f);
//        tempCenterPoint = eyeLeft.updateCenterPointObject();
//        eyeLeft.getChildObject().get(0).translateObject(tempCenterPoint.x, tempCenterPoint.y, tempCenterPoint.z + 0.0003f);
//
//        //eye left white up
//        eyeLeft.getChildObject().add(new Circle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.02f
//        ));
//
//        eyeLeft.getChildObject().get(1).scaleObject(1f, 0.5f, 0.01f);
//        eyeLeft.getChildObject().get(1).rotateObject((float) Math.toRadians(40f), 0f, 0f, 1f);
//        eyeLeft.getChildObject().get(1).rotateObject((float) Math.toRadians(24f), 0f, 1f, 0f);
//        eyeLeft.getChildObject().get(1).translateObject(tempCenterPoint.x - 0.01f, tempCenterPoint.y + 0.015f, tempCenterPoint.z + 0.0048f);
//
//        //eye left white down
//        eyeLeft.getChildObject().add(new Circle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.004f
//        ));
//
//        eyeLeft.getChildObject().get(2).rotateObject((float) Math.toRadians(24f), 0f, 1f, 0f);
//        eyeLeft.getChildObject().get(2).translateObject(tempCenterPoint.x + 0.01f, tempCenterPoint.y - 0.02f, tempCenterPoint.z + 0.00002f);
//
//        //eye left black circle
//        head.getChildObject().add(new Circle(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0f, 0f, 0f, 0f), 0.0f, 0.0f, 0.045f
//        ));
//
//        head.getChildObject().get(3).rotateObject((float) Math.toRadians(23f), 0f, 1f, 0f);
//        head.getChildObject().get(3).rotateObject((float) Math.toRadians(1f), 1f, 0f, 0f);
//        head.getChildObject().get(3).translateObject(tempCenterPoint.x - 0.003f, tempCenterPoint.y - 0.006f, tempCenterPoint.z - 0.002f);
//    }
//
//    public void handRight() {
//        Vector3f tempCenterPoint;
//        //hand tebel
//        jointHandRight.getChildObject().add(new Tube(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.788f - 0.05f, 0.815f - 0.05f, 0.305f - 0.05f, 0f), 0.0f, 0.0f, 0.04f, 0.07f
//        ));
//        Object handTebel = jointHandRight.getChildObject().get(0);
//
//        tempCenterPoint = jointHandRight.updateCenterPointObject();
//        handTebel.rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        handTebel.translateObject(tempCenterPoint.x - 0.035f, tempCenterPoint.y, tempCenterPoint.z);
//
//
//        tempCenterPoint = handTebel.updateCenterPointObject();
//
//
//        handTebel.getChildObject().add(new Object(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.788f, 0.815f, 0.305f, 0f)
//        ));
//        Object hand = handTebel.getChildObject().get(0);
//
//        objectPointControl.clear();
//        objectPointControl.add(new Curve2(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f), 1
//        ));
//
//
//        float move1 = -0.01f;
//        tempCenterPoint.x += move1;
//        for (double v = -20f; v <= 200; v += 1f) {
//
//            float z = tempCenterPoint.z + 0.027f * (float) (Math.cos(Math.toRadians(v)));
//            float y = tempCenterPoint.y + 0.027f * (float) (Math.sin(Math.toRadians(v)));
//
//            float zextend = tempCenterPoint.z + 0.04f * (float) (Math.cos(Math.toRadians(v)));
//            float yextend = tempCenterPoint.y + 0.04f * (float) (Math.sin(Math.toRadians(v)));
//
//            float zextend2 = tempCenterPoint.z + 0.05f * (float) (Math.cos(Math.toRadians(v)));
//            float yextend2 = tempCenterPoint.y + 0.05f * (float) (Math.sin(Math.toRadians(v)));
//
//
//            objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x, y, z));
//            objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.05f, yextend, zextend));
//            objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.08f, yextend2, zextend2));
//            objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.12f, y, z));
//
//            objectPointControl.get(0).bezierCurve(hand);
//            objectPointControl.get(0).clearVertices();
//        }
//
//
//        for (double v = 201; v <= 215; v += 2f) {
//            float y = tempCenterPoint.y + 0.027f * (float) (Math.sin(Math.toRadians(v)));
//            float z = tempCenterPoint.z + 0.027f * (float) (Math.cos(Math.toRadians(v)));
//
//
//            hand.addVertices(new Vector3f(tempCenterPoint.x, y, z));
//            hand.addVertices(new Vector3f(tempCenterPoint.x - 0.12f, y, z));
//        }
//
//
//        float y = tempCenterPoint.y + 0.029f * (float) (Math.sin(Math.toRadians(201)));
//
//        for (double v = 215; v <= 360; v += 5f) {
//
//            float z = tempCenterPoint.z + 0.027f * (float) (Math.cos(Math.toRadians(v)));
//
//
//            hand.addVertices(new Vector3f(tempCenterPoint.x, y, z));
//            hand.addVertices(new Vector3f(tempCenterPoint.x - 0.12f, y, z));
//        }
//
//        for (double v = -89f; v <= -36; v += 5f) {
//
//            float z = tempCenterPoint.z + 0.027f * (float) (Math.cos(Math.toRadians(v)));
//
//            hand.addVertices(new Vector3f(tempCenterPoint.x, y, z));
//            hand.addVertices(new Vector3f(tempCenterPoint.x - 0.12f, y, z));
//
//        }
//
//        for (double v = -21; v >= -35; v -= 2f) {
//            y = tempCenterPoint.y + 0.027f * (float) (Math.sin(Math.toRadians(v)));
//            float z = tempCenterPoint.z + 0.027f * (float) (Math.cos(Math.toRadians(v)));
//
//
//            hand.addVertices(new Vector3f(tempCenterPoint.x, y, z));
//            hand.addVertices(new Vector3f(tempCenterPoint.x - 0.12f, y, z));
//        }
//
//        hand.translateObject(0f, -0.01f, 0f);
//
//        //jari 1 belakang
//        hand.getChildObject().add(new Sphere3(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.352f, 0.352f, 0.352f, 0f), 0.0f, 0.0f, 0.01f, 0.01f, 0.02f, 0
//        ));
//        Object jari1 = hand.getChildObject().get(0);
//
//        tempCenterPoint = handTebel.updateCenterPointObject();
//
//        jari1.rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
//        jari1.rotateObject((float) Math.toRadians(80f), 0f, 1f, 0f);
//        jari1.translateObject(tempCenterPoint.x - 0.18f, tempCenterPoint.y, tempCenterPoint.z - 0.038f);
//
//
//        //jari 2 tengah
//        hand.getChildObject().add(new Sphere3(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.352f, 0.352f, 0.352f, 0f), 0.0f, 0.0f, 0.01f, 0.01f, 0.02f, 0
//        ));
//        Object jari2 = hand.getChildObject().get(1);
//
//        jari2.rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
//        jari2.rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        jari2.translateObject(tempCenterPoint.x - 0.18f, tempCenterPoint.y, tempCenterPoint.z);
//
//
//        //jari 3 depan
//        hand.getChildObject().add(new Sphere3(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.352f, 0.352f, 0.352f, 0f), 0.0f, 0.0f, 0.01f, 0.01f, 0.02f, 0
//        ));
//        Object jari3 = hand.getChildObject().get(2);
//
//        jari3.rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
//        jari3.rotateObject((float) Math.toRadians(100f), 0f, 1f, 0f);
//        jari3.translateObject(tempCenterPoint.x - 0.18f, tempCenterPoint.y, tempCenterPoint.z + 0.038f);
//
//
//        //jari1 tube
//        jari1.getChildObject().add(new Tube(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.788f, 0.815f, 0.305f, 0f), 0.0f, 0.0f, 0.015f, 0.03f
//        ));
//
//        jari1.getChildObject().get(0).rotateObject((float) Math.toRadians(100f), 0f, 1f, 0f);
//        tempCenterPoint = jari1.updateCenterPointObject();
//        jari1.getChildObject().get(0).translateObject(tempCenterPoint.x + 0.06f, tempCenterPoint.y, tempCenterPoint.z + 0.064f);
//
//
//        //jari2 tube
//        jari2.getChildObject().add(new Tube(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.788f, 0.815f, 0.305f, 0f), 0.0f, 0.0f, 0.015f, 0.03f
//        ));
//
//        jari2.getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        tempCenterPoint = jari2.updateCenterPointObject();
//        jari2.getChildObject().get(0).translateObject(tempCenterPoint.x + 0.06f, tempCenterPoint.y, tempCenterPoint.z);
//
//
//        //jari3 tube
//        jari3.getChildObject().add(new Tube(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.788f, 0.815f, 0.305f, 0f), 0.0f, 0.0f, 0.015f, 0.03f
//        ));
//
//        jari3.getChildObject().get(0).rotateObject((float) Math.toRadians(80f), 0f, 1f, 0f);
//        tempCenterPoint = jari3.updateCenterPointObject();
//        jari3.getChildObject().get(0).translateObject(tempCenterPoint.x + 0.06f, tempCenterPoint.y, tempCenterPoint.z - 0.064f);
//
//    }
//
//    public void handLeft() {
//        Vector3f tempCenterPoint;
//        //hand tebel
//        jointHandLeft.getChildObject().add(new Tube(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.788f - 0.05f, 0.815f - 0.05f, 0.305f - 0.05f, 0f), 0.0f, 0.0f, 0.04f, 0.07f
//        ));
//        Object handTebel = jointHandLeft.getChildObject().get(0);
//
//        tempCenterPoint = jointHandLeft.updateCenterPointObject();
//        handTebel.rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        handTebel.translateObject(tempCenterPoint.x + 0.035f, tempCenterPoint.y, tempCenterPoint.z);
//
//
//        tempCenterPoint = handTebel.updateCenterPointObject();
//
//        handTebel.getChildObject().add(new Object(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.788f, 0.815f, 0.305f, 0f)
//        ));
//        Object hand = handTebel.getChildObject().get(0);
//
//
//        objectPointControl.add(new Curve2(
//                Arrays.asList(
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f), 1
//        ));
//
//
//        float move1 = 0.01f;
//        tempCenterPoint.x += move1;
//        for (double v = -20f; v <= 200; v += 1f) {
//
//            float z = tempCenterPoint.z + 0.027f * (float) (Math.cos(Math.toRadians(v)));
//            float y = tempCenterPoint.y + 0.027f * (float) (Math.sin(Math.toRadians(v)));
//
//            float zextend = tempCenterPoint.z + 0.04f * (float) (Math.cos(Math.toRadians(v)));
//            float yextend = tempCenterPoint.y + 0.04f * (float) (Math.sin(Math.toRadians(v)));
//
//            float zextend2 = tempCenterPoint.z + 0.05f * (float) (Math.cos(Math.toRadians(v)));
//            float yextend2 = tempCenterPoint.y + 0.05f * (float) (Math.sin(Math.toRadians(v)));
//
//
//            objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x, y, z));
//            objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.05f, yextend, zextend));
//            objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.08f, yextend2, zextend2));
//            objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.12f, y, z));
//
//            objectPointControl.get(0).bezierCurve(hand);
//            objectPointControl.get(0).clearVertices();
//        }
//
//
//        for (double v = 201; v <= 215; v += 2f) {
//            float y = tempCenterPoint.y + 0.027f * (float) (Math.sin(Math.toRadians(v)));
//            float z = tempCenterPoint.z + 0.027f * (float) (Math.cos(Math.toRadians(v)));
//
//
//            hand.addVertices(new Vector3f(tempCenterPoint.x, y, z));
//            hand.addVertices(new Vector3f(tempCenterPoint.x + 0.12f, y, z));
//        }
//
//
//        float y = tempCenterPoint.y + 0.029f * (float) (Math.sin(Math.toRadians(201)));
//
//        for (double v = 215; v <= 360; v += 5f) {
//
//            float z = tempCenterPoint.z + 0.027f * (float) (Math.cos(Math.toRadians(v)));
//
//
//            hand.addVertices(new Vector3f(tempCenterPoint.x, y, z));
//            hand.addVertices(new Vector3f(tempCenterPoint.x + 0.12f, y, z));
//        }
//
//        for (double v = -89f; v <= -36; v += 5f) {
//
//            float z = tempCenterPoint.z + 0.027f * (float) (Math.cos(Math.toRadians(v)));
//
//            hand.addVertices(new Vector3f(tempCenterPoint.x, y, z));
//            hand.addVertices(new Vector3f(tempCenterPoint.x + 0.12f, y, z));
//
//        }
//
//        for (double v = -21; v >= -35; v -= 2f) {
//            y = tempCenterPoint.y + 0.027f * (float) (Math.sin(Math.toRadians(v)));
//            float z = tempCenterPoint.z + 0.027f * (float) (Math.cos(Math.toRadians(v)));
//
//
//            hand.addVertices(new Vector3f(tempCenterPoint.x, y, z));
//            hand.addVertices(new Vector3f(tempCenterPoint.x + 0.12f, y, z));
//        }
//        hand.translateObject(0f, -0.01f, 0f);
//
//        //jari 1 belakang
//        hand.getChildObject().add(new Sphere3(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.352f, 0.352f, 0.352f, 0f), 0.0f, 0.0f, 0.01f, 0.01f, 0.02f, 0
//        ));
//        Object jari1 = hand.getChildObject().get(0);
//
//        tempCenterPoint = handTebel.updateCenterPointObject();
//
//        jari1.rotateObject((float) Math.toRadians(-90f), 1f, 0f, 0f);
//        jari1.rotateObject((float) Math.toRadians(100f), 0f, 1f, 0f);
//        jari1.translateObject(tempCenterPoint.x + 0.18f, tempCenterPoint.y, tempCenterPoint.z - 0.038f);
//
//
//        //jari 2 tengah
//        hand.getChildObject().add(new Sphere3(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.352f, 0.352f, 0.352f, 0f), 0.0f, 0.0f, 0.01f, 0.01f, 0.02f, 0
//        ));
//        Object jari2 = hand.getChildObject().get(1);
//
//        jari2.rotateObject((float) Math.toRadians(-90f), 1f, 0f, 0f);
//        jari2.rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
//        jari2.translateObject(tempCenterPoint.x + 0.18f, tempCenterPoint.y, tempCenterPoint.z);
//
//
//        //jari 3 depan
//        hand.getChildObject().add(new Sphere3(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.352f, 0.352f, 0.352f, 0f), 0.0f, 0.0f, 0.01f, 0.01f, 0.02f, 0
//        ));
//        Object jari3 = hand.getChildObject().get(2);
//
//        jari3.rotateObject((float) Math.toRadians(-90f), 1f, 0f, 0f);
//        jari3.rotateObject((float) Math.toRadians(80f), 0f, 1f, 0f);
//        jari3.translateObject(tempCenterPoint.x + 0.18f, tempCenterPoint.y, tempCenterPoint.z + 0.038f);
//
//
//        //jari1 tube
//        jari1.getChildObject().add(new Tube(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.788f, 0.815f, 0.305f, 0f), 0.0f, 0.0f, 0.015f, 0.03f
//        ));
//
//        jari1.getChildObject().get(0).rotateObject((float) Math.toRadians(-100f), 0f, 1f, 0f);
//        tempCenterPoint = jari1.updateCenterPointObject();
//        jari1.getChildObject().get(0).translateObject(tempCenterPoint.x - 0.06f, tempCenterPoint.y, tempCenterPoint.z + 0.064f);
//
//
//        //jari2 tube
//        jari2.getChildObject().add(new Tube(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.788f, 0.815f, 0.305f, 0f), 0.0f, 0.0f, 0.015f, 0.03f
//        ));
//
//        jari2.getChildObject().get(0).rotateObject((float) Math.toRadians(-90f), 0f, 1f, 0f);
//        tempCenterPoint = jari2.updateCenterPointObject();
//        jari2.getChildObject().get(0).translateObject(tempCenterPoint.x - 0.06f, tempCenterPoint.y, tempCenterPoint.z);
//
//
//        //jari3 tube
//        jari3.getChildObject().add(new Tube(
//                Arrays.asList(
//                        //shaderFile lokasi menyesuaikan objectnya
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.vert"
//                                        , GL_VERTEX_SHADER),
//                        new ShaderProgram.ShaderModuleData
//                                ("resources/shaders/scene.frag"
//                                        , GL_FRAGMENT_SHADER)
//                ),
//                new ArrayList<>(),
//                new Vector4f(0.788f, 0.815f, 0.305f, 0f), 0.0f, 0.0f, 0.015f, 0.03f
//        ));
//
//        jari3.getChildObject().get(0).rotateObject((float) Math.toRadians(-80f), 0f, 1f, 0f);
//        tempCenterPoint = jari3.updateCenterPointObject();
//        jari3.getChildObject().get(0).translateObject(tempCenterPoint.x - 0.06f, tempCenterPoint.y, tempCenterPoint.z - 0.064f);
//
//    }
//
//
//    public void loop() {
//        while (window.isOpen()) {
//            window.update();
//            glClearColor(0f, 0f, 0.0f, 0.0f);
//            GL.createCapabilities();
//            glEnable(GL_DEPTH_TEST);
//
//            glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
//            glDepthMask(true);
//            glDepthFunc(GL_LEQUAL);
//            glDepthRange(0.0f, 1.0f);
//            glDisableVertexAttribArray(0);
//            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
//
//
//            for (Object object : objects) {
//                object.draw(camera, projection);
//            }
//
////            for (Object object : objectsRectangle) {
////                object.draw(camera, projection);
////            }
//
////            for (Object object : objectPointControl) {
////                object.drawLine(camera, projection);
////            }
////
////            for (Object object : objectPointCurve) {
////                object.drawLine();
////            }
//
//            input();
//
//
//            // Restore state
//            glDisableVertexAttribArray(0);
//
//            // Poll for window events.
//            // The key callback above will only be
//            // invoked during this call.
//            glfwPollEvents();
//        }
//    }
//
//    public void run() {
//        init();
//        loop();
//
//        glfwTerminate();
//        glfwSetErrorCallback(null).free();
//    }
//}
