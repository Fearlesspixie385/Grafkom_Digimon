import Engine.*;
import Engine.Object;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class mou {
    Camera camera = new Camera();
    private Window window = new Window(800, 800, "Hello World");
    Projection projection = new Projection(window.getWidth(), window.getHeight());
    private ArrayList<Object> objects = new ArrayList<>();
    private ArrayList<Object> objectsRectangle = new ArrayList<>();
    private ArrayList<Object> objectPointControl = new ArrayList<>();
    private ArrayList<Object> objectPointCurve = new ArrayList<>();
    private boolean dragDrop = false;
    private int var = -1;
    private float posX = 0.0f;
    private float posY = 0.0f;
    private float posZ = 2.0f;

    private Object lowerBody;
    private Object upperBody;
    private Object head;
    private Object eyeRight; //from char perspective
    private Object eyeLeft;
    private Object armLeft;
    private Object armRight;
    private Object handLeft;
    private Object handRight;
    private Object mouth;
    private Object nose;
    private Object legRight;
    private Object legLeft;
    private Object earRight;
    private Object earLeft;
    private float value = 0;
    private boolean state = true;
    private boolean state2 = true;
    private float limitXKiri = 1;
    private float limitXKanan = 1;
    private float limitYBawah = 1;
    private float limitYAtas = 1;
    float total = 0;


    public static void main(String[] args) {

        new main().run();

    }

    public Vector2f convertRange(Vector2f pos, float height, float width) {
        float OldMax = 255, OldMin = 0, NewMax = 1, NewMin = 0, OldValue = 208, NewRange, NewValue, OldRange;
        OldRange = (OldMax - OldMin);
        NewRange = (NewMax - NewMin);
        NewValue = (((OldValue - OldMin) * NewRange) / OldRange) + NewMin;
        System.out.println(NewValue);
        return new Vector2f((((pos.x - 0) * (1 - (-1))) / (width - 0) + (-1)), (((pos.y - 0) * (1 - (-1))) / (height - 0) + (-1)) * -1);
    }


    public void init() {
        window.init();
        GL.createCapabilities();

        camera.setPosition(posX, posY, posZ);
        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(0.0f));

        //lower body
        objects.add(new Sphere3(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.13f, 0.13f, 0.07f, 0
        ));
        lowerBody = objects.get(0);


        //upper body
        objects.get(0).getChildObject().add(new Sphere3(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.13f, 0.13f, 0.158f, 0
        ));
        upperBody = objects.get(0).getChildObject().get(0);

        upperBody.rotateObject((float) Math.toRadians(180f), 0.0f, 0.0f, 1.0f);
        upperBody.translateObject(0f, 0.565f, 0.0f);


        //head
        upperBody.getChildObject().add(new Sphere3(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.2f, 0.2f, 0.15f
        ));
        head = upperBody.getChildObject().get(0);

        head.scaleObject(0.5f, 0.5f, 0.5f);
        head.translateObject(0f, 0.7f, 0.0f);


        //eye right
        head.getChildObject().add(new Circle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.09f, 0.58f, 0.81f, 0f), 0.0f, 0.0f, 0.03f
        ));
        eyeRight = head.getChildObject().get(0);


        eyeRight.rotateObject((float) Math.toRadians(-24f), 0f, 1f, 0f);
        Vector3f tempCenterPoint = upperBody.updateCenterPointObject();
        tempCenterPoint = head.updateCenterPointObject();
        eyeRight.translateObject(tempCenterPoint.x - 0.1f, tempCenterPoint.y, tempCenterPoint.z + 0.229f);


        //eye left
        head.getChildObject().add(new Circle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.09f, 0.58f, 0.81f, 0f), 0.0f, 0.0f, 0.03f
        ));
        eyeLeft = head.getChildObject().get(1);

        eyeLeft.rotateObject((float) Math.toRadians(24f), 0f, 1f, 0f);
        tempCenterPoint = head.updateCenterPointObject();
        eyeLeft.translateObject(tempCenterPoint.x + 0.1f, tempCenterPoint.y, tempCenterPoint.z + 0.229f);

        //head(2)
        eyeRightDecor();
        //head(3)
        eyeLeftDecor();

        //nose
        head.getChildObject().add(new Sphere3(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0f), 0.0f, 0.0f, 0.02f, 0.01f, 0.01f, 1
        ));
        nose = head.getChildObject().get(4);
        nose.rotateObject((float) Math.toRadians(15f), 0.0f, 0.0f, 1.f);
        nose.translateObject(tempCenterPoint.x + 0.005f, tempCenterPoint.y - 0.05f, tempCenterPoint.z + 0.24f);

        head.getChildObject().add(new Sphere3(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0f), 0.0f, 0.0f, 0.02f, 0.01f, 0.01f, 1
        ));
        head.getChildObject().get(5).rotateObject((float) Math.toRadians(-15f), 0.0f, 0.0f, 1.f);
        head.getChildObject().get(5).translateObject(tempCenterPoint.x - 0.005f, tempCenterPoint.y - 0.05f, tempCenterPoint.z + 0.24f);


        //joint upper body arm
        upperBody.getChildObject().add(new Sphere3(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.02f, 0.02f, 0.05f
        ));

        Object jointArmLeft = upperBody.getChildObject().get(1);

        jointArmLeft.scaleObject(0.06f, 0.06f, 0.06f);
        tempCenterPoint = upperBody.updateCenterPointObject();
        jointArmLeft.translateObject(tempCenterPoint.x + 0.1f, tempCenterPoint.y - 0.11f, tempCenterPoint.z);

        upperBody.getChildObject().add(new Sphere3(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.02f, 0.02f, 0.05f
        ));

        Object jointArmRight = upperBody.getChildObject().get(2);

        jointArmRight.scaleObject(0.06f, 0.06f, 0.06f);
        tempCenterPoint = upperBody.updateCenterPointObject();
        jointArmRight.translateObject(tempCenterPoint.x - 0.1f, tempCenterPoint.y - 0.11f, tempCenterPoint.z);


        //arm right
        jointArmRight.getChildObject().add(new Tube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.03f, 0.2f
        ));
        armRight = jointArmRight.getChildObject().get(0);

        tempCenterPoint = jointArmRight.updateCenterPointObject();
        armRight.rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        armRight.translateObject(tempCenterPoint.x - 0.1f, tempCenterPoint.y, tempCenterPoint.z);


        //joint arm right hand
        armRight.getChildObject().add(new Sphere3(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.02f, 0.02f, 0.05f
        ));
        Object jointHandRight = armRight.getChildObject().get(0);

        jointHandRight.scaleObject(0.06f, 0.06f, 0.06f);

        tempCenterPoint = armRight.updateCenterPointObject();
        jointHandRight.translateObject(tempCenterPoint.x - 0.094f, tempCenterPoint.y, tempCenterPoint.z);

        handRight(jointHandRight);


        //arm left
        jointArmLeft.getChildObject().add(new Tube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.03f, 0.2f
        ));
        armLeft = jointArmLeft.getChildObject().get(0);

        armLeft.rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        tempCenterPoint = jointArmLeft.updateCenterPointObject();
        armLeft.translateObject(tempCenterPoint.x + 0.1f, tempCenterPoint.y, tempCenterPoint.z);


        //joint arm left hand
        armLeft.getChildObject().add(new Sphere3(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.02f, 0.02f, 0.05f
        ));
        Object jointHandLeft = armLeft.getChildObject().get(0);

        jointHandLeft.scaleObject(0.06f, 0.06f, 0.06f);

        tempCenterPoint = armLeft.updateCenterPointObject();
        jointHandLeft.translateObject(tempCenterPoint.x + 0.094f, tempCenterPoint.y, tempCenterPoint.z);

        handLeft(jointHandLeft);


        //legRight
        lowerBody.getChildObject().add(new Tube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.05f, 0.2f
        ));
        legRight = lowerBody.getChildObject().get(1);

        tempCenterPoint = lowerBody.updateCenterPointObject();
        legRight.rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        legRight.translateObject(tempCenterPoint.x - 0.07f, tempCenterPoint.y, tempCenterPoint.z);


        //foot right
        legRight.getChildObject().add(new Tube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.09f, 0.03f
        ));

        tempCenterPoint = legRight.updateCenterPointObject();
        legRight.getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        legRight.getChildObject().get(0).translateObject(tempCenterPoint.x, tempCenterPoint.y - 0.1f, tempCenterPoint.z + 0.033f);


        //legLeft
        lowerBody.getChildObject().add(new Tube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.05f, 0.2f
        ));
        legLeft = lowerBody.getChildObject().get(2);

        tempCenterPoint = lowerBody.updateCenterPointObject();
        legLeft.rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        legLeft.translateObject(tempCenterPoint.x + 0.07f, tempCenterPoint.y, tempCenterPoint.z);


        //foot right
        legLeft.getChildObject().add(new Tube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.09f, 0.03f
        ));

        tempCenterPoint = legLeft.updateCenterPointObject();
        legLeft.getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        legLeft.getChildObject().get(0).translateObject(tempCenterPoint.x, tempCenterPoint.y - 0.1f, tempCenterPoint.z + 0.033f);


        //earRight
        head.getChildObject().add(new Sphere3(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.015f, 0.004f, 0.04f, 2
        ));
        earRight = head.getChildObject().get(6);

        tempCenterPoint = head.updateCenterPointObject();
        earRight.rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        earRight.rotateObject((float) Math.toRadians(30f), 0f, 0f, 1f);
        earRight.translateObject(tempCenterPoint.x - 0.24f, tempCenterPoint.y + 0.37f, tempCenterPoint.z + 0.07f);


        //earRight addon
        earRight.getChildObject().add(new Sphere3(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.93333334f, 0.77254903f, 0.81960785f, 0f), 0.0f, 0.0f, 0.015f / 1.5f, 0.004f / 1.5f, 0.04f / 1.5f, 2
        ));

        tempCenterPoint = earRight.updateCenterPointObject();
        earRight.getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        earRight.getChildObject().get(0).rotateObject((float) Math.toRadians(30f), 0f, 0f, 1f);
        earRight.getChildObject().get(0).translateObject(tempCenterPoint.x + 0.024f, tempCenterPoint.y - 0.05f, tempCenterPoint.z + 0.01f);


        //earLeft
        head.getChildObject().add(new Sphere3(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.015f, 0.004f, 0.04f, 2
        ));
        earLeft = head.getChildObject().get(7);

        tempCenterPoint = head.updateCenterPointObject();
        earLeft.rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        earLeft.rotateObject((float) Math.toRadians(-30f), 0f, 0f, 1f);
        earLeft.translateObject(tempCenterPoint.x + 0.24f, tempCenterPoint.y + 0.37f, tempCenterPoint.z + 0.07f);


        //earLeft addon
        earLeft.getChildObject().add(new Sphere3(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.93333334f, 0.77254903f, 0.81960785f, 0f), 0.0f, 0.0f, 0.015f / 1.5f, 0.004f / 1.5f, 0.04f / 1.5f, 2
        ));


        //mouth
        head.getChildObject().add(new Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 1.0f, 1.0f, 1.0f)
        ));

        objectPointCurve.add(new Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f)
        ));
        mouth = head.getChildObject().get(8);
        tempCenterPoint = head.updateCenterPointObject();
        mouth.addVertices(new Vector3f(tempCenterPoint.x - 1, tempCenterPoint.y + 1, tempCenterPoint.z + 1f));
        mouth.addVertices(new Vector3f(tempCenterPoint.x - 0.5f, tempCenterPoint.y - 1, tempCenterPoint.z + 1f));
        mouth.addVertices(new Vector3f(tempCenterPoint.x - 0.5f, tempCenterPoint.y - 1, tempCenterPoint.z + 1f));
        mouth.addVertices(new Vector3f(tempCenterPoint.x, tempCenterPoint.y, tempCenterPoint.z + 1f));
        mouth.bezierCurve(objectPointCurve.get(0));




        tempCenterPoint = earLeft.updateCenterPointObject();
        earLeft.getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        earLeft.getChildObject().get(0).rotateObject((float) Math.toRadians(-30f), 0f, 0f, 1f);
        earLeft.getChildObject().get(0).translateObject(tempCenterPoint.x - 0.024f, tempCenterPoint.y - 0.05f, tempCenterPoint.z + 0.01f);


        tempCenterPoint = jointArmRight.updateCenterPointObject();
        jointArmRight.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
        jointArmRight.rotateObject((float) Math.toRadians(55f), 0f, 0f, 1f);
        jointArmRight.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);

        tempCenterPoint = jointArmLeft.updateCenterPointObject();
        jointArmLeft.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
        jointArmLeft.rotateObject((float) Math.toRadians(-55f), 0f, 0f, 1f);
        jointArmLeft.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
        lowerBody.translateObject(0f, -0.2f, 0f);
    }

    public void input() {


//        if (window.isKeyPressed(GLFW_KEY_W)) {
//            System.out.println("W");
//        }


//        if (window.getMousInput().isLeftButtonPressed()) {
//            Vector2f pos = window.getMousInput().getCurrentPos();
//
//            pos.x = (pos.x - (window.getWidth()) / 2.0f) / (window.getWidth() / 2.0f);
//
//            pos.y = (pos.y - (window.getWidth()) / 2.0f) / (-window.getHeight() / 2.0f);
//
//            if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))) {
//                System.out.println("x : " + pos.x + " y : " + pos.y);
//                objectPointControl.get(0).addVertices(new Vector3f(pos.x, pos.y, 0));
//            }
//        }

        float x = 0.0005f;
        float y = 0.0003f;
        if (window.isKeyPressed(GLFW_KEY_P)) {
            if (state2) {
                if (value < 45 && state) {
                    Vector3f tempCenterPoint = head.updateCenterPointObject();
                    head.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                    head.rotateObject((float) Math.toRadians(0.5f), 0f, 0f, 1f);
                    head.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                    value++;
                    head.translateObject(-x, -y, 0f);
                    System.out.println(value);
                } else {
                    state = false;
                    Vector3f tempCenterPoint = head.updateCenterPointObject();
                    head.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                    head.rotateObject((float) Math.toRadians(-0.5f), 0f, 0f, 1f);
                    head.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                    head.translateObject(x, y, 0f);
                    value--;
                }

                if (value == 0) {
                    state = true;
                    state2 = false;
                }
            } else {
                if (value > -45 && state) {
                    Vector3f tempCenterPoint = head.updateCenterPointObject();
                    head.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                    head.rotateObject((float) Math.toRadians(-0.5f), 0f, 0f, 1f);
                    head.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                    head.translateObject(x, -y, 0f);
                    value--;

                    System.out.println(value);
                } else {
                    state = false;
                    Vector3f tempCenterPoint = head.updateCenterPointObject();
                    head.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                    head.rotateObject((float) Math.toRadians(0.5f), 0f, 0f, 1f);
                    head.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
                    value++;
                    head.translateObject(-x, y, 0f);
                }

                if (value == 0) {
                    state = true;
                    state2 = true;
                }
            }
        }
        if (window.isKeyPressed(GLFW_KEY_O)) {

        }

        if (window.isKeyPressed(GLFW_KEY_Q)) {
            for (int i = 0; i <= 90; i++) {
                lowerBody.translateObject(0f, -0.1f, -0.1f);


                Vector3f tempCenterPoint = legLeft.updateCenterPointObject();
                legLeft.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                legLeft.rotateObject((float) Math.toRadians(0.5f), 1f, 0f, 0f);
                legLeft.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);

                legLeft.translateObject(0f, 0.1f, 0.1f);

            }

        }
        float rotate = 0.01f;
        if (window.isKeyPressed(GLFW_KEY_LEFT_CONTROL)) {
            rotate = 0.1f;
        }

        if (window.isKeyPressed(GLFW_KEY_T)) {
            objects.get(0).rotateObject(-rotate, 1f, 0f, 0f);

        }

        if (window.isKeyPressed(GLFW_KEY_F)) {
            objects.get(0).rotateObject(-rotate, 0f, 1f, 0f);
        }

        if (window.isKeyPressed(GLFW_KEY_G)) {
            objects.get(0).rotateObject(rotate, 1f, 0f, 0f);
        }

        if (window.isKeyPressed(GLFW_KEY_H)) {
            objects.get(0).rotateObject(rotate, 0f, 1f, 0f);
        }

        if (window.isKeyPressed(GLFW_KEY_UP)) {
            posZ -= 0.1f;
        }

        if (window.isKeyPressed(GLFW_KEY_DOWN)) {
            posZ += 0.1f;
        }

        camera.setPosition(0f, 0f, posZ);
        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(0.0f));
    }

    public void eyeRightDecor() {
        Vector3f tempCenterPoint;
        //eye right black retina
        eyeRight.getChildObject().add(new Circle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0f), 0.0f, 0.0f, 0.02f
        ));

        eyeRight.getChildObject().get(0).rotateObject((float) Math.toRadians(-24f), 0f, 1f, 0f);
        tempCenterPoint = eyeRight.updateCenterPointObject();
        eyeRight.getChildObject().get(0).translateObject(tempCenterPoint.x, tempCenterPoint.y, tempCenterPoint.z + 0.0003f);

        //eye right white up
        eyeRight.getChildObject().add(new Circle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.02f
        ));

        eyeRight.getChildObject().get(1).scaleObject(1f, 0.5f, 0.01f);
        eyeRight.getChildObject().get(1).rotateObject((float) Math.toRadians(40f), 0f, 0f, 1f);
        eyeRight.getChildObject().get(1).rotateObject((float) Math.toRadians(-24f), 0f, 1f, 0f);
        eyeRight.getChildObject().get(1).translateObject(tempCenterPoint.x - 0.01f, tempCenterPoint.y + 0.015f, tempCenterPoint.z - 0.0041f);

        //eye right white down
        eyeRight.getChildObject().add(new Circle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.004f
        ));

        eyeRight.getChildObject().get(2).rotateObject((float) Math.toRadians(-24f), 0f, 1f, 0f);
        eyeRight.getChildObject().get(2).translateObject(tempCenterPoint.x + 0.01f, tempCenterPoint.y - 0.02f, tempCenterPoint.z + 0.005f);

        //eye right black circle
        head.getChildObject().add(new Circle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0f), 0.0f, 0.0f, 0.045f
        ));

        head.getChildObject().get(2).rotateObject((float) Math.toRadians(-25f), 0f, 1f, 0f);
        head.getChildObject().get(2).rotateObject((float) Math.toRadians(1f), 1f, 0f, 0f);
        head.getChildObject().get(2).translateObject(tempCenterPoint.x - 0.003f, tempCenterPoint.y - 0.005f, tempCenterPoint.z - 0.0045f);
    }

    public void eyeLeftDecor() {
        Vector3f tempCenterPoint;
        //eye left black
        eyeLeft.getChildObject().add(new Circle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0f), 0.0f, 0.0f, 0.02f
        ));

        eyeLeft.getChildObject().get(0).rotateObject((float) Math.toRadians(24f), 0f, 1f, 0f);
        tempCenterPoint = eyeLeft.updateCenterPointObject();
        eyeLeft.getChildObject().get(0).translateObject(tempCenterPoint.x, tempCenterPoint.y, tempCenterPoint.z + 0.0003f);

        //eye left white up
        eyeLeft.getChildObject().add(new Circle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.02f
        ));

        eyeLeft.getChildObject().get(1).scaleObject(1f, 0.5f, 0.01f);
        eyeLeft.getChildObject().get(1).rotateObject((float) Math.toRadians(40f), 0f, 0f, 1f);
        eyeLeft.getChildObject().get(1).rotateObject((float) Math.toRadians(24f), 0f, 1f, 0f);
        eyeLeft.getChildObject().get(1).translateObject(tempCenterPoint.x - 0.01f, tempCenterPoint.y + 0.015f, tempCenterPoint.z + +0.0048f);

        //eye left white down
        eyeLeft.getChildObject().add(new Circle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.004f
        ));

        eyeLeft.getChildObject().get(2).rotateObject((float) Math.toRadians(24f), 0f, 1f, 0f);
        eyeLeft.getChildObject().get(2).translateObject(tempCenterPoint.x + 0.01f, tempCenterPoint.y - 0.02f, tempCenterPoint.z + 0.00002f);

        //eye left black circle
        head.getChildObject().add(new Circle(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0f, 0f, 0f, 0f), 0.0f, 0.0f, 0.045f
        ));

        head.getChildObject().get(3).rotateObject((float) Math.toRadians(23f), 0f, 1f, 0f);
        head.getChildObject().get(3).rotateObject((float) Math.toRadians(1f), 1f, 0f, 0f);
        head.getChildObject().get(3).translateObject(tempCenterPoint.x - 0.003f, tempCenterPoint.y - 0.006f, tempCenterPoint.z - 0.002f);
    }

    public void handRight(Object jointHandRight) {
        Vector3f tempCenterPoint;
        //hand right
        jointHandRight.getChildObject().add(new Tube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.05f, 0.05f
        ));
        handRight = jointHandRight.getChildObject().get(0);

        tempCenterPoint = jointHandRight.updateCenterPointObject();
        handRight.rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        handRight.translateObject(tempCenterPoint.x - 0.05f, tempCenterPoint.y, tempCenterPoint.z);


        //hand tebel
        jointHandRight.getChildObject().add(new Tube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.035f, 0.03f
        ));

        tempCenterPoint = jointHandRight.updateCenterPointObject();
        jointHandRight.getChildObject().get(1).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        jointHandRight.getChildObject().get(1).translateObject(tempCenterPoint.x - 0.02f, tempCenterPoint.y, tempCenterPoint.z);


        //jari 1 belakang
        handRight.getChildObject().add(new Sphere3(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.352f, 0.352f, 0.352f, 0f), 0.0f, 0.0f, 0.01f, 0.01f, 0.02f, 0
        ));
        Object jari1 = handRight.getChildObject().get(0);

        tempCenterPoint = handRight.updateCenterPointObject();

        jari1.rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        jari1.rotateObject((float) Math.toRadians(70f), 0f, 1f, 0f);
        jari1.translateObject(tempCenterPoint.x - 0.09f, tempCenterPoint.y, tempCenterPoint.z - 0.05f);


        //jari 2 tengah
        handRight.getChildObject().add(new Sphere3(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.352f, 0.352f, 0.352f, 0f), 0.0f, 0.0f, 0.01f, 0.01f, 0.02f, 0
        ));
        Object jari2 = handRight.getChildObject().get(1);

        tempCenterPoint = handRight.updateCenterPointObject();

        jari2.rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        jari2.rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        jari2.translateObject(tempCenterPoint.x - 0.09f, tempCenterPoint.y, tempCenterPoint.z);


        //jari 3 depan
        handRight.getChildObject().add(new Sphere3(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.352f, 0.352f, 0.352f, 0f), 0.0f, 0.0f, 0.01f, 0.01f, 0.02f, 0
        ));
        Object jari3 = handRight.getChildObject().get(2);

        tempCenterPoint = handRight.updateCenterPointObject();

        jari3.rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        jari3.rotateObject((float) Math.toRadians(110f), 0f, 1f, 0f);
        jari3.translateObject(tempCenterPoint.x - 0.09f, tempCenterPoint.y, tempCenterPoint.z + 0.05f);


        //jari1 tube
        jari1.getChildObject().add(new Tube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.015f, 0.03f
        ));

        jari1.getChildObject().get(0).rotateObject((float) Math.toRadians(70f), 0f, 1f, 0f);
        tempCenterPoint = jari1.updateCenterPointObject();
        jari1.getChildObject().get(0).translateObject(tempCenterPoint.x + 0.06f, tempCenterPoint.y, tempCenterPoint.z + 0.022f);


        //jari3 tube
        jari3.getChildObject().add(new Tube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.015f, 0.03f
        ));

        jari3.getChildObject().get(0).rotateObject((float) Math.toRadians(110f), 0f, 1f, 0f);
        tempCenterPoint = jari3.updateCenterPointObject();
        jari3.getChildObject().get(0).translateObject(tempCenterPoint.x + 0.06f, tempCenterPoint.y, tempCenterPoint.z - 0.022f);

    }

    public void handLeft(Object jointHandLeft) {
        Vector3f tempCenterPoint;
        //hand Left
        jointHandLeft.getChildObject().add(new Tube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.05f, 0.05f
        ));
        handLeft = jointHandLeft.getChildObject().get(0);

        tempCenterPoint = jointHandLeft.updateCenterPointObject();
        handLeft.rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        handLeft.translateObject(tempCenterPoint.x + 0.05f, tempCenterPoint.y, tempCenterPoint.z);


        //hand tebel
        jointHandLeft.getChildObject().add(new Tube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.035f, 0.03f
        ));

        tempCenterPoint = jointHandLeft.updateCenterPointObject();
        jointHandLeft.getChildObject().get(1).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        jointHandLeft.getChildObject().get(1).translateObject(tempCenterPoint.x + 0.02f, tempCenterPoint.y, tempCenterPoint.z);


        //jari 1 belakang
        handLeft.getChildObject().add(new Sphere3(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.352f, 0.352f, 0.352f, 0f), 0.0f, 0.0f, 0.01f, 0.01f, 0.02f, 0
        ));
        Object jari1 = handLeft.getChildObject().get(0);

        tempCenterPoint = handLeft.updateCenterPointObject();

        jari1.rotateObject((float) Math.toRadians(-90f), 1f, 0f, 0f);
        jari1.rotateObject((float) Math.toRadians(110f), 0f, 1f, 0f);
        jari1.translateObject(tempCenterPoint.x + 0.09f, tempCenterPoint.y, tempCenterPoint.z - 0.05f);


        //jari 2 tengah
        handLeft.getChildObject().add(new Sphere3(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.352f, 0.352f, 0.352f, 0f), 0.0f, 0.0f, 0.01f, 0.01f, 0.02f, 0
        ));
        Object jari2 = handLeft.getChildObject().get(1);

        tempCenterPoint = handLeft.updateCenterPointObject();

        jari2.rotateObject((float) Math.toRadians(-90f), 1f, 0f, 0f);
        jari2.rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        jari2.translateObject(tempCenterPoint.x + 0.09f, tempCenterPoint.y, tempCenterPoint.z);


        //jari 3 depan
        handLeft.getChildObject().add(new Sphere3(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.352f, 0.352f, 0.352f, 0f), 0.0f, 0.0f, 0.01f, 0.01f, 0.02f, 0
        ));
        Object jari3 = handLeft.getChildObject().get(2);

        tempCenterPoint = handLeft.updateCenterPointObject();

        jari3.rotateObject((float) Math.toRadians(-90f), 1f, 0f, 0f);
        jari3.rotateObject((float) Math.toRadians(70f), 0f, 1f, 0f);
        jari3.translateObject(tempCenterPoint.x + 0.09f, tempCenterPoint.y, tempCenterPoint.z + 0.05f);


        //jari1 tube
        jari1.getChildObject().add(new Tube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.015f, 0.03f
        ));

        jari1.getChildObject().get(0).rotateObject((float) Math.toRadians(-70f), 0f, 1f, 0f);
        tempCenterPoint = jari1.updateCenterPointObject();
        jari1.getChildObject().get(0).translateObject(tempCenterPoint.x - 0.06f, tempCenterPoint.y, tempCenterPoint.z + 0.022f);


        //jari3 tube
        jari3.getChildObject().add(new Tube(
                Arrays.asList(
                        //shaderFile lokasi menyesuaikan objectnya
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.015f, 0.03f
        ));

        jari3.getChildObject().get(0).rotateObject((float) Math.toRadians(-110f), 0f, 1f, 0f);
        tempCenterPoint = jari3.updateCenterPointObject();
        jari3.getChildObject().get(0).translateObject(tempCenterPoint.x - 0.06f, tempCenterPoint.y, tempCenterPoint.z - 0.022f);

    }


    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0f, 0f, 0.0f, 0.0f);
            GL.createCapabilities();
            glEnable(GL_DEPTH_TEST);

            glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);
            glDepthMask(true);
            glDepthFunc(GL_LEQUAL);
            glDepthRange(0.0f, 1.0f);
            glDisableVertexAttribArray(0);
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);


            for (Object object : objects) {
                object.draw(camera, projection);
            }

//            for (Object object : objectsRectangle) {
//                object.draw(camera, projection);
//            }

            for (Object object : objectPointControl) {
                object.drawLine(camera, projection);
            }
//
//            for (Object object : objectPointCurve) {
//                object.drawLine();
//            }

            input();


            // Restore state
            glDisableVertexAttribArray(0);

            // Poll for window events.
            // The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }
    }

    public void run() {
        init();
        loop();

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
}
