import Engine.*;
import Engine.Object;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class main {
    Camera camera = new Camera();

    private Window window = new Window(800, 800, "Hello World");
    Projection projection = new Projection(window.getWidth(), window.getHeight());

    private ArrayList<Object> environment = new ArrayList<>();

    private ArrayList<Object> objects = new ArrayList<>();
    private ArrayList<Object> objectPointControl = new ArrayList<>();

    private Object lowerBody;
    private Object upperBody;
    private Object head;
    private Object jointHead;
    private Object eyeRight; //from char perspective
    private Object eyeLeft;
    private Object jointArmLeft;
    private Object jointArmRight;
    private Object jointHandLeft;
    private Object jointHandRight;
    private Object jointLegLeft;
    private Object jointLegRight;
    private Object jointFootLeft;
    private Object jointFootRight;

    private ArrayList<Double> valueArray = new ArrayList<>();
    private ArrayList<Boolean> stateArray = new ArrayList<>();

    public static void main(String[] args) {

        new main().run();
    }

    float kaki=0;
    float tangan=0;
    float temp=0;
    float tempo=0;

    float jalan=0;


    public void init() {
        window.init();
        GL.createCapabilities();

        camera.setPosition(0f, 0f, 3f);
//        camera.setRotation((float) Math.toRadians(0.0f), (float) Math.toRadians(30.0f));

        objects.add(new Sphere2(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.85f,0.97f,0.46f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.15f,
                        0.1f,
                        0.15f,
                        0
                )
        );
        objects.get(0).translateObject(0.0f,-0.08f,0.025f);
        objects.get(0).rotateObject((float)Math.toRadians(0.1), -90.0f, 0f, 0f);


        objects.get(0).getChildObject().add(new Sphere2(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.85f,0.97f,0.46f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.15f,
                        0.1f,
                        0.15f,
                        0
                )
        );
        objects.get(0).getChildObject().get(0).translateObject(0.0f,-0.08f,-0.025f);
        objects.get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(0.1), 0.0f, 0f, 0f);

        objects.get(0).getChildObject().add(new Sphere2(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.85f,0.97f,0.46f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.15f,
                        0.12f,
                        0.15f,
                        0
                )
        );
        objects.get(0).getChildObject().get(1).translateObject(0.0f,-0.09f,0f);
        objects.get(0).getChildObject().get(1).rotateObject((float)Math.toRadians(0.1), -45f, 0f, 0f);

        //Kepala
        objects.get(0).getChildObject().add(new Sphere2(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.85f,0.97f,0.46f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.25f,
                        0.22f,
                        0.18f,
                        0
                )
        );
        //objects.get(0).scaleObject(0.6f,0.1f,0.1f);
        objects.get(0).getChildObject().get(2).translateObject(0.0f,0.2f,0.0f);

        //Mata
        objects.get(0).getChildObject().get(2).getChildObject().add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.03f,0.27f,0.11f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.06f,
                0.02f,
                0.05f,
                0
        ));
        //objects.get(0).getChildObject().get(0).translateObject(-0.1f,0.20f,-0.2f);
        objects.get(0).getChildObject().get(2).getChildObject().get(0).translateObject(0f,0.20f,-0.215f);
        objects.get(0).getChildObject().get(2).getChildObject().get(0).rotateObject((float)Math.toRadians(35), 0f, 1f, 0f);

        objects.get(0).getChildObject().get(2).getChildObject().get(0).getChildObject().add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.02f,
                0.02f,
                0.02f,
                0
        ));
        //objects.get(0).getChildObject().get(0).translateObject(-0.1f,0.20f,-0.2f);
        objects.get(0).getChildObject().get(2).getChildObject().get(0).getChildObject().get(0).translateObject(0f,0.21f,-0.225f);
        objects.get(0).getChildObject().get(2).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(35), 0f, 1f, 0f);

        objects.get(0).getChildObject().get(2).getChildObject().add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.03f,0.27f,0.11f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.06f,
                0.02f,
                0.05f,
                0
        ));
        objects.get(0).getChildObject().get(2).getChildObject().get(1).translateObject(0f,0.20f,-0.215f);
        objects.get(0).getChildObject().get(2).getChildObject().get(1).rotateObject((float)Math.toRadians(35), 0f, -1f, 0f);


        objects.get(0).getChildObject().get(2).getChildObject().get(0).getChildObject().add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1f,1f,1f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.02f,
                0.02f,
                0.02f,
                0
        ));
        //objects.get(0).getChildObject().get(0).translateObject(-0.1f,0.20f,-0.2f);
        objects.get(0).getChildObject().get(2).getChildObject().get(0).getChildObject().get(1).translateObject(-0.02f,0.21f,-0.225f);
        objects.get(0).getChildObject().get(2).getChildObject().get(0).getChildObject().get(1).rotateObject((float)Math.toRadians(35), 0f, -1f, 0f);


        //Hair
        objects.get(0).getChildObject().get(2).getChildObject().add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.42f,0.09f,0.32f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.019f,
                0.019f,
                -0.02f,
                0,
                -7,
                0
        ));
        objects.get(0).getChildObject().get(2).getChildObject().get(2).scaleObject(1.0f,1.0f,1.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(2).translateObject(0.0f,0.27f,0.0f);

        objects.get(0).getChildObject().get(2).getChildObject().get(2).getChildObject().add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.42f,0.09f,0.32f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.015f,
                0.0025f,
                -0.03f,
                0,
                -7,
                0
        ));
        objects.get(0).getChildObject().get(2).getChildObject().get(2).getChildObject().get(0).scaleObject(1.0f,1.0f,1.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(2).getChildObject().get(0).translateObject(0.0f,0.0f,-0.36f);
        objects.get(0).getChildObject().get(2).getChildObject().get(2).getChildObject().get(0).rotateObject((float)Math.toRadians(45), 1f, 0f, 0f);

        objects.get(0).getChildObject().get(2).getChildObject().get(2).getChildObject().add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.42f,0.09f,0.32f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.015f,
                0.0025f,
                -0.03f,
                0,
                -7,
                0
        ));
        objects.get(0).getChildObject().get(2).getChildObject().get(2).getChildObject().get(1).scaleObject(1.0f,1.0f,1.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(2).getChildObject().get(1).translateObject(0.0f,0.0f,-0.36f);
        objects.get(0).getChildObject().get(2).getChildObject().get(2).getChildObject().get(1).rotateObject((float)Math.toRadians(45), 1f, 0f, 0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(2).getChildObject().get(1).rotateObject((float)Math.toRadians(72), 0f, 1f, 0f);

        objects.get(0).getChildObject().get(2).getChildObject().get(2).getChildObject().add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.42f,0.09f,0.32f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.015f,
                0.0025f,
                -0.03f,
                0,
                -7,
                0
        ));
        objects.get(0).getChildObject().get(2).getChildObject().get(2).getChildObject().get(2).scaleObject(1.0f,1.0f,1.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(2).getChildObject().get(2).translateObject(0.0f,0.0f,-0.36f);
        objects.get(0).getChildObject().get(2).getChildObject().get(2).getChildObject().get(2).rotateObject((float)Math.toRadians(45), 1f, 0f, 0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(2).getChildObject().get(2).rotateObject((float)Math.toRadians(144), 0f, 1f, 0f);

        objects.get(0).getChildObject().get(2).getChildObject().get(2).getChildObject().add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.42f,0.09f,0.32f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.015f,
                0.0025f,
                -0.03f,
                0,
                -7,
                0
        ));
        objects.get(0).getChildObject().get(2).getChildObject().get(2).getChildObject().get(3).scaleObject(1.0f,1.0f,1.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(2).getChildObject().get(3).translateObject(0.0f,0.0f,-0.36f);
        objects.get(0).getChildObject().get(2).getChildObject().get(2).getChildObject().get(3).rotateObject((float)Math.toRadians(45), 1f, 0f, 0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(2).getChildObject().get(3).rotateObject((float)Math.toRadians(216), 0f, 1f, 0f);

        objects.get(0).getChildObject().get(2).getChildObject().get(2).getChildObject().add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.42f,0.09f,0.32f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.015f,
                0.0025f,
                -0.03f,
                0,
                -7,
                0
        ));
        objects.get(0).getChildObject().get(2).getChildObject().get(2).getChildObject().get(4).scaleObject(1.0f,1.0f,1.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(2).getChildObject().get(4).translateObject(0.0f,0.0f,-0.36f);
        objects.get(0).getChildObject().get(2).getChildObject().get(2).getChildObject().get(4).rotateObject((float)Math.toRadians(45), 1f, 0f, 0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(2).getChildObject().get(4).rotateObject((float)Math.toRadians(288), 0f, 1f, 0f);


        objects.get(0).getChildObject().get(2).getChildObject().add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.84f,0.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.01f,
                0.01f,
                0.2f,
                4
        ));
        objects.get(0).getChildObject().get(2).getChildObject().get(3).scaleObject(1.0f,1.0f,1.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(3).translateObject(0.0f,0.27f,0.0f);

        objects.get(0).getChildObject().get(2).getChildObject().add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.84f,0.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.01f,
                0.01f,
                0.04f,
                4
        ));
        objects.get(0).getChildObject().get(2).getChildObject().get(4).scaleObject(1.0f,1.0f,1.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(4).translateObject(-0.15f,0.44f,0.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(4).rotateObject((float)Math.toRadians(20), 0.0f, 0f, -1f);
        objects.get(0).getChildObject().get(2).getChildObject().add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData(
                                "resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f,0.0f,0.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.03f,
                0.01f,
                0.03f,
                0
        ));
        objects.get(0).getChildObject().get(2).getChildObject().get(5).scaleObject(1.0f,1f,1.0f);
        objects.get(0).getChildObject().get(2).getChildObject().get(5).translateObject(0.0f,0.5f,0.0f);

        //Mulut
//        objects.get(0).getChildObject().get(2).getChildObject().add(new kerucut(
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
//                new Vector4f(0.960f, 0.528f, 0.535f, 1f), 0.0f, 0.0f, 0.025f, 0.005f, 0.01f
//        ));
//        objects.get(0).getChildObject().get(2).getChildObject().get(6).rotateObject((float)Math.toRadians(-180),0f,0f,1f);
//        objects.get(0).getChildObject().get(2).getChildObject().get(6).translateObject(0.0f,0.06f,-0.185f);
        objects.get(0).getChildObject().get(2).getChildObject().add(new Curve(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0f,0.0f,0.0f,1.0f), true
                )
        );
        objects.get(0).getChildObject().get(2).getChildObject().get(6).addVertices(new Vector3f(-0.125f, 0.1f, 0.03f));
        objects.get(0).getChildObject().get(2).getChildObject().get(6).addVertices(new Vector3f(-0.08f, 0.05f, 0.0f));
        objects.get(0).getChildObject().get(2).getChildObject().get(6).addVertices(new Vector3f(-0.04f, 0.075f, 0.0f));
        objects.get(0).getChildObject().get(2).getChildObject().get(6).addVertices(new Vector3f(0.0f, 0.12f, 0.0f));
        objects.get(0).getChildObject().get(2).getChildObject().get(6).addVertices(new Vector3f(0.04f, 0.075f, 0.0f));
        objects.get(0).getChildObject().get(2).getChildObject().get(6).addVertices(new Vector3f(0.08f, 0.05f, 0.0f));
        objects.get(0).getChildObject().get(2).getChildObject().get(6).addVertices(new Vector3f(0.125f, 0.1f, 0.03f));
        objects.get(0).getChildObject().get(2).getChildObject().get(6).translateObject(0f,-0f,-0.17f);

        //Kaki
        objects.get(0).getChildObject().add(new Sphere2(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.85f,0.97f,0.46f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        -0.025f,
                        -0.025f,
                        0.07f,
                        1
                )
        );
        objects.get(0).getChildObject().get(3).translateObject(-0.075f,-0.25f,0.0f);


        objects.get(0).getChildObject().add(new Sphere2(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.85f,0.97f,0.46f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.025f,
                        0.025f,
                        0.07f,
                        1
                )
        );
        objects.get(0).getChildObject().get(4).translateObject(0.075f,-0.25f,0.0f);



        // Right hand
        objects.get(0).getChildObject().add(new Sphere2(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.85f,0.97f,0.46f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.03f,
                        0.04f,
                        0.1f,
                        0
                )
        );
        objects.get(0).getChildObject().get(5).translateObject(-0.11f,-0.11f,0.0f);
        objects.get(0).getChildObject().get(5).rotateObject((float)Math.toRadians(0.2), 0.0f, 0f, -90f);

        objects.get(0).getChildObject().get(5).getChildObject().add(new Sphere2(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.85f,0.97f,0.46f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.04f,
                        0.09f,
                        0.18f,
                        0
                )
        );
        objects.get(0).getChildObject().get(5).getChildObject().get(0).translateObject(-0.13f,-0.23f,0.0f);
        objects.get(0).getChildObject().get(5).getChildObject().get(0).rotateObject((float)Math.toRadians(0.2), 0.0f, 0f, -40f);

        objects.get(0).getChildObject().get(5).getChildObject().get(0).getChildObject().add(new Sphere2(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.42f,0.09f,0.32f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.005f,
                        0.005f,
                        0.02f,
                        0,-5,0
                )
        );
        objects.get(0).getChildObject().get(5).getChildObject().get(0).getChildObject().get(0).translateObject(0.15f,0.45f,-0.045f);
        objects.get(0).getChildObject().get(5).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(-185), 0.0f, 0f, 1f);

        objects.get(0).getChildObject().get(5).getChildObject().get(0).getChildObject().add(new Sphere2(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.42f,0.09f,0.32f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.005f,
                        0.005f,
                        0.02f,
                        0,-5,0
                )
        );
        objects.get(0).getChildObject().get(5).getChildObject().get(0).getChildObject().get(1).translateObject(0.165f,0.45f,0.0f);
        objects.get(0).getChildObject().get(5).getChildObject().get(0).getChildObject().get(1).rotateObject((float)Math.toRadians(-185), 0.0f, 0f, 1f);

        objects.get(0).getChildObject().get(5).getChildObject().get(0).getChildObject().add(new Sphere2(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.42f,0.09f,0.32f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.005f,
                        0.005f,
                        0.02f,
                        0,-5,0
                )
        );
        objects.get(0).getChildObject().get(5).getChildObject().get(0).getChildObject().get(2).translateObject(0.15f,0.45f,0.045f);
        objects.get(0).getChildObject().get(5).getChildObject().get(0).getChildObject().get(2).rotateObject((float)Math.toRadians(-185), 0.0f, 0f, 1f);

        //Left hand
        objects.get(0).getChildObject().add(new Sphere2(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.85f,0.97f,0.46f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.03f,
                        0.04f,
                        0.1f,
                        0
                )
        );
        objects.get(0).getChildObject().get(6).translateObject(0.11f,-0.11f,0.0f);
        objects.get(0).getChildObject().get(6).rotateObject((float)Math.toRadians(0.2), 0.0f, 0f, 90f);

        objects.get(0).getChildObject().get(6).getChildObject().add(new Sphere2(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.85f,0.97f,0.46f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.04f,
                        0.09f,
                        0.18f,
                        0
                )
        );
        objects.get(0).getChildObject().get(6).getChildObject().get(0).translateObject(0.13f,-0.23f,0.0f);
        objects.get(0).getChildObject().get(6).getChildObject().get(0).rotateObject((float)Math.toRadians(0.2), 0.0f, 0f, 40f);

        objects.get(0).getChildObject().get(6).getChildObject().get(0).getChildObject().add(new Sphere2(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.42f,0.09f,0.32f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.005f,
                        0.005f,
                        0.02f,
                        0,-5,0
                )
        );
        objects.get(0).getChildObject().get(6).getChildObject().get(0).getChildObject().get(0).translateObject(-0.15f,0.45f,-0.045f);
        objects.get(0).getChildObject().get(6).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(185), 0.0f, 0f, 1f);

        objects.get(0).getChildObject().get(6).getChildObject().get(0).getChildObject().add(new Sphere2(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.42f,0.09f,0.32f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.005f,
                        0.005f,
                        0.02f,
                        0,-5,0
                )
        );
        objects.get(0).getChildObject().get(6).getChildObject().get(0).getChildObject().get(1).translateObject(-0.165f,0.45f,0.0f);
        objects.get(0).getChildObject().get(6).getChildObject().get(0).getChildObject().get(1).rotateObject((float)Math.toRadians(185), 0.0f, 0f, 1f);

        objects.get(0).getChildObject().get(6).getChildObject().get(0).getChildObject().add(new Sphere2(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.42f,0.09f,0.32f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.005f,
                        0.005f,
                        0.02f,
                        0,-5,0
                )
        );
        objects.get(0).getChildObject().get(6).getChildObject().get(0).getChildObject().get(2).translateObject(-0.15f,0.45f,0.045f);
        objects.get(0).getChildObject().get(6).getChildObject().get(0).getChildObject().get(2).rotateObject((float)Math.toRadians(185), 0.0f, 0f, 1f);

        //Ekor
        objects.get(0).getChildObject().add(new Sphere2(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.85f,0.97f,0.46f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.005f,
                        0.006f,
                        0.002f,
                        1,-7,0
                )
        );
        objects.get(0).getChildObject().get(7).translateObject(0f,-0.267f,-0.10f);
        objects.get(0).getChildObject().get(7).rotateObject((float)Math.toRadians(-70), 1.0f, 0f, 0f);

        objects.get(0).getChildObject().get(7).getChildObject().add(new Sphere2(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.85f,0.97f,0.46f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.004f,
                        0.005f,
                        0.003f,
                        1,-7,0
                )
        );
        objects.get(0).getChildObject().get(7).getChildObject().get(0).translateObject(0f,-0.215f,-0.25f);
        objects.get(0).getChildObject().get(7).getChildObject().get(0).rotateObject((float)Math.toRadians(-125), 1.0f, 0f, 0f);

        objects.get(0).getChildObject().get(7).getChildObject().get(0).getChildObject().add(new Sphere2(
                        Arrays.asList(
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                                new ShaderProgram.ShaderModuleData(
                                        "resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                        ),
                        new ArrayList<>(),
                        new Vector4f(0.85f,0.97f,0.46f,1.0f),
                        Arrays.asList(0.0f,0.0f,0.0f),
                        0.003f,
                        0.004f,
                        0.002f,
                        1,-7,0
                )
        );
        objects.get(0).getChildObject().get(7).getChildObject().get(0).getChildObject().get(0).translateObject(0f,-0.31f,-0.22f);
        objects.get(0).getChildObject().get(7).getChildObject().get(0).getChildObject().get(0).rotateObject((float)Math.toRadians(-115), 1.0f, 0f, 0f);
        objects.get(0).scaleObject(0.55f,0.55f,0.55f);
        objects.get(0).rotateObject((float)Math.toRadians(-180), 0.0f, 1f, 0f);

        objects.add(new Sphere(
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
                new Vector4f(0.0177f, 0.590f, 0.275f, 1f), 0.0f, 0.0f, 0.5f, 0.7f, 0.5f
        ));

        objects.get(1).scaleObject(2f, 2f, 2f);

//        sendi
        objects.get(1).getChildObject().add(new Sphere(
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
                new Vector4f(0,0,0, 1f), 0.0f, 0.0f, 0.1f, 0.1f, 0.1f
        ));
        objects.get(1).getChildObject().add(new Sphere(
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
                new Vector4f(0,0,0, 1f), 0.0f, 0.0f, 0.1f, 0.1f, 0.1f
        ));
        //tangan
        objects.get(1).getChildObject().get(0).getChildObject().add(new Tabung(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(),
                new Vector4f(0.0177f, 0.590f, 0.275f, 1f), Arrays.asList(0.0f, 0.0f, 0.0f), 0.1f, 0.1f, 0.4f, 40, 80
        ));
        objects.get(1).getChildObject().get(1).getChildObject().add(new Tabung(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(),
                new Vector4f(0.0177f, 0.590f, 0.275f, 1f), Arrays.asList(0.0f, 0.0f, 0.0f), 0.1f, 0.1f, 0.4f, 40, 80
        ));


//    mata
        objects.get(1).getChildObject().add(new Sphere(
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
                new Vector4f(0f, 0f, 0f, 1f), 0.0f, 0.0f, 0.2f, 0.2f, 0.2f
        ));
        objects.get(1).getChildObject().add(new Sphere(
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
                new Vector4f(0f, 0f, 0f, 1f), 0.0f, 0.0f, 0.2f, 0.2f, 0.2f
        ));
//        mulut
        objects.get(1).getChildObject().add(new Sphere(
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
                new Vector4f(0f, 0f, 0f, 1f), 0.0f, 0.0f, 0.3f, 0.44f, 0.25f
        ));
//        poros paha kaki
        objects.get(1).getChildObject().add(new Sphere(
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
                new Vector4f(0f, 0f, 0f, 1f), 0.0f, 0.0f, 0.2f, 0.2f, 0.2f
        ));
        objects.get(1).getChildObject().add(new Sphere(
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
                new Vector4f(0f, 0f, 0f, 1f), 0.0f, 0.0f, 0.2f, 0.2f, 0.2f
        ));

        //kaki child
        objects.get(1).getChildObject().get(5).getChildObject().add(new TabungBerdiri(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(),
                new Vector4f(0.0177f, 0.590f, 0.275f, 1f), Arrays.asList(0.0f, 0.0f, 0.0f), 0.3f, 0.2f, 0.2f, 40, 80
        ));
        objects.get(1).getChildObject().get(6).getChildObject().add(new TabungBerdiri(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(),
                new Vector4f(0.0177f, 0.590f, 0.275f, 1f), Arrays.asList(0.0f, 0.0f, 0.0f), 0.3f, 0.2f, 0.2f, 40, 80
        ));
//        sarung tinju kanan
        objects.get(1).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new Tabung(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(),
                new Vector4f(0.760f, 0.0228f, 0.0965f, 1f), Arrays.asList(0.0f, 0.0f, 0.0f), 0.16f, 0.15f, 0.05f, 40, 80
        ));
        objects.get(1).getChildObject().get(0).getChildObject().add(new Sphere(
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
                new Vector4f(0.760f, 0.0228f, 0.0965f, 1f), 0.0f, 0.0f, 0.19f, 0.17f, 0.25f
        ));
        objects.get(1).getChildObject().get(0).getChildObject().add(new Sphere(
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
                new Vector4f(0.610f, 0.0183f, 0.0183f, 1f), 0.0f, 0.0f, 0.1f, 0.05f, 0.05f
        ));
//        sarung tinju kiri
        objects.get(1).getChildObject().get(1).getChildObject().get(0).getChildObject().add(new Tabung(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(),
                new Vector4f(0.760f, 0.0228f, 0.0965f, 1f), Arrays.asList(0.0f, 0.0f, 0.0f), 0.16f, 0.15f, 0.05f, 40, 80
        ));
        objects.get(1).getChildObject().get(1).getChildObject().add(new Sphere(
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
                new Vector4f(0.760f, 0.0228f, 0.0965f, 1f), 0.0f, 0.0f, 0.19f, 0.17f, 0.25f
        ));
        objects.get(1).getChildObject().get(1).getChildObject().add(new Sphere(
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
                new Vector4f(0.610f, 0.0183f, 0.0183f, 1f), 0.0f, 0.0f, 0.1f, 0.05f, 0.05f
        ));
//      sendi betis kaki kanan
        objects.get(1).getChildObject().get(5).getChildObject().get(0).getChildObject().add(new Sphere(
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
                new Vector4f(0,0,0, 1f), 0.0f, 0.0f, 0.1f, 0.1f, 0.1f
        ));
//      sendi betis kaki kiri
        objects.get(1).getChildObject().get(6).getChildObject().get(0).getChildObject().add(new Sphere(
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
                new Vector4f(0,0,0, 1f), 0.0f, 0.0f, 0.1f, 0.1f, 0.1f
        ));
//    betis kanan

        objects.get(1).getChildObject().get(5).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new TabungBerdiri(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(),
                new Vector4f(0.0177f, 0.590f, 0.275f, 1f), Arrays.asList(0.0f, 0.0f, 0.0f), 0.2f, 0.2f, 0.2f, 40, 80
        ));
//        betis kiri
        objects.get(1).getChildObject().get(6).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new TabungBerdiri(Arrays.asList(
                //shaderFile lokasi menyesuaikan objectnya
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.vert"
                                , GL_VERTEX_SHADER),
                new ShaderProgram.ShaderModuleData
                        ("resources/shaders/scene.frag"
                                , GL_FRAGMENT_SHADER)
        ),
                new ArrayList<>(),
                new Vector4f(0.0177f, 0.590f, 0.275f, 1f), Arrays.asList(0.0f, 0.0f, 0.0f), 0.2f, 0.2f, 0.2f, 40, 80
        ));
        //   telapak betis kanan

        objects.get(1).getChildObject().get(5).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new Sphere(
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
                new Vector4f(0.00930f, 0.930f, 0.193f, 1f), 0.0f, 0.0f, 0.3f, 0.1f, 0.45f
        ));
//     telapak betis kiri
        objects.get(1).getChildObject().get(6).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().add(new Sphere(
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
                new Vector4f(0.00930f, 0.930f, 0.193f, 1f), 0.0f, 0.0f, 0.3f, 0.1f, 0.45f
        ));
//        rambut
        objects.get(1).getChildObject().add(new kerucut(
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
                new Vector4f(0.910f, 0.706f, 0.0364f, 1f), 0.0f, 0.0f, 0.03f, 0.03f, 0.05f
        ));
        objects.get(1).getChildObject().get(7).getChildObject().add(new kerucut(
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
                new Vector4f(0.910f, 0.706f, 0.0364f, 1f), 0.0f, 0.0f, 0.03f, 0.03f, 0.05f
        ));
        objects.get(1).getChildObject().get(7).getChildObject().add(new kerucut(
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
                new Vector4f(0.910f, 0.706f, 0.0364f, 1f), 0.0f, 0.0f, 0.03f, 0.03f, 0.05f
        ));
        objects.get(1).getChildObject().get(7).getChildObject().add(new kerucut(
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
                new Vector4f(0.910f, 0.706f, 0.0364f, 1f), 0.0f, 0.0f, 0.03f, 0.03f, 0.05f
        ));
        objects.get(1).getChildObject().get(7).getChildObject().add(new kerucut(
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
                new Vector4f(0.910f, 0.706f, 0.0364f, 1f), 0.0f, 0.0f, 0.03f, 0.03f, 0.05f
        ));
        objects.get(1).getChildObject().get(7).getChildObject().add(new kerucut(
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
                new Vector4f(0.910f, 0.706f, 0.0364f, 1f), 0.0f, 0.0f, 0.03f, 0.03f, 0.05f
        ));

        objects.get(1).getChildObject().get(7).getChildObject().add(new kerucut(
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
                new Vector4f(0.910f, 0.706f, 0.0364f, 1f), 0.0f, 0.0f, 0.03f, 0.03f, 0.05f
        ));

        objects.get(1).getChildObject().get(7).getChildObject().add(new kerucut(
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
                new Vector4f(0.910f, 0.706f, 0.0364f, 1f), 0.0f, 0.0f, 0.03f, 0.03f, 0.05f
        ));

        objects.get(1).getChildObject().get(7).getChildObject().add(new kerucut(
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
                new Vector4f(0.910f, 0.706f, 0.0364f, 1f), 0.0f, 0.0f, 0.03f, 0.03f, 0.05f
        ));
//



        objects.get(1).getChildObject().get(0).scaleObject(2f, 2f, 2f);
        objects.get(1).getChildObject().get(1).scaleObject(2f, 2f, 2f);
        objects.get(1).getChildObject().get(0).getChildObject().get(2).rotateObject(0.5f,0f,-0.5f,-1f);
//        objects.get(0).getChildObject().get(1).getChildObject().get(2).rotateObject(0.5f,0f,-0.5f,1f);
//        objects.get(0).getChildObject().get(1).rotateObject((float)Math.toRadians(-90f),0f,0f,1f);



        objects.get(1).getChildObject().get(0).translateObject(0.8f, 0.5f, 0.0f);
        objects.get(1).getChildObject().get(1).translateObject(-0.8f, 0.5f, 0.0f);
        objects.get(1).getChildObject().get(2).translateObject(0.2f, 0.6f, 0.7f);
        objects.get(1).getChildObject().get(3).translateObject(-0.2f, 0.6f, 0.7f);
        objects.get(1).getChildObject().get(4).translateObject(0f, 0.2f, 0.75f);
        objects.get(1).getChildObject().get(5).translateObject(0.3f, -1f, 0f);
        objects.get(1).getChildObject().get(6).translateObject(-0.3f, -1f, 0f);
        objects.get(1).getChildObject().get(7).translateObject(0f, 1.5f, 0.1f);

        objects.get(1).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0.8f, 0.0f, 0.0f);
        objects.get(1).getChildObject().get(0).getChildObject().get(1).translateObject(1.1f, 0.0f, 0.0f);
        objects.get(1).getChildObject().get(0).getChildObject().get(2).translateObject(1f, -0.08f, 0.4f);
        objects.get(1).getChildObject().get(1).getChildObject().get(0).getChildObject().get(0).translateObject(-0.8f, 0.0f, 0.0f);
        objects.get(1).getChildObject().get(1).getChildObject().get(1).translateObject(-1.1f, 0.0f, 0.0f);
        objects.get(1).getChildObject().get(1).getChildObject().get(2).translateObject(-1f, -0.08f, 0.4f);
        objects.get(1).getChildObject().get(5).getChildObject().get(0).translateObject(0f, -0.4f, 0.2f);
        objects.get(1).getChildObject().get(6).getChildObject().get(0).translateObject(0f, -0.4f, 0.2f);
// letak rambut
        objects.get(1).getChildObject().get(7).getChildObject().get(0).translateObject(0.1f, 0.1f, 0f);
        objects.get(1).getChildObject().get(7).getChildObject().get(1).translateObject(-0.1f, 0.05f, 0f);
        objects.get(1).getChildObject().get(7).getChildObject().get(2).translateObject(0.2f, 0.08f, 0f);
        objects.get(1).getChildObject().get(7).getChildObject().get(3).translateObject(-0.2f, 0.1f, 0f);
        objects.get(1).getChildObject().get(7).getChildObject().get(4).translateObject(0f, 0.1f, 0.1f);
        objects.get(1).getChildObject().get(7).getChildObject().get(5).translateObject(0f, 0.1f, -0.1f);
        objects.get(1).getChildObject().get(7).getChildObject().get(6).translateObject(0f, 0.1f, 0.2f);
        objects.get(1).getChildObject().get(7).getChildObject().get(7).translateObject(0f, 0.1f, -0.2f);
//        paha kaki
        objects.get(1).getChildObject().get(5).getChildObject().get(0).translateObject(0f, 0.5f, 0f);
        objects.get(1).getChildObject().get(6).getChildObject().get(0).translateObject(0f, 0.5f, 0f);
//      sendi  betis
        objects.get(1).getChildObject().get(5).getChildObject().get(0).getChildObject().get(0).translateObject(0f, -0.4f, 0f);
        objects.get(1).getChildObject().get(6).getChildObject().get(0).getChildObject().get(0).translateObject(0f, -0.4f, 0f);
//      betis kaki
        objects.get(1).getChildObject().get(5).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0f, -0.1f, 0f);
        objects.get(1).getChildObject().get(6).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0f, -0.1f, 0f);
//        telapak
        objects.get(1).getChildObject().get(5).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0f, -0.25f, 0.2f);
        objects.get(1).getChildObject().get(6).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).getChildObject().get(0).translateObject(0f, -0.25f, 0.2f);


        objects.get(1).getChildObject().get(1).rotateObject((float)Math.toRadians(40f),0f,0f,1f);
        objects.get(1).getChildObject().get(1).translateObject(0.2f, 0.7f, 0.0f);
        objects.get(1).getChildObject().get(0).rotateObject((float)Math.toRadians(40f),0f,0f,-1f);
        objects.get(1).getChildObject().get(0).translateObject(-0.2f, 0.7f, 0.0f);

        objects.get(0).translateObject(1.3f,0f,0f);
        objects.get(0).scaleObject(3f,3f,3f);


//        code mouritus
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

        lowerBody = objects.get(2);
        int intlowerBody = 0;


        //upper body
        lowerBody.getChildObject().add(new Sphere3(
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
        upperBody = lowerBody.getChildObject().get(intlowerBody);
        int intupperBody = 0;
        intlowerBody++;

        upperBody.rotateObject((float) Math.toRadians(180f), 0.0f, 0.0f, 1.0f);
        upperBody.translateObject(0f, 0.565f, 0.0f);

        //joint Head
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
                new Vector4f(0f, 1f, 1f, 0f), 0.0f, 0.0f, 0.2f, 0.2f, 0.15f
        ));

        jointHead = upperBody.getChildObject().get(intupperBody);
        int intjointHead = 0;
        intupperBody++;

        jointHead.scaleObject(0.1f, 0.1f, 0.1f);
        Vector3f tempCenterPoint = upperBody.updateCenterPointObject();
        jointHead.translateObject(0f, tempCenterPoint.y - 0.13f, 0.0f);

        //head
        jointHead.getChildObject().add(new Sphere3(
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
        head = jointHead.getChildObject().get(intjointHead);
        int inthead = 0;
        intjointHead++;

        tempCenterPoint = jointHead.updateCenterPointObject();
        head.scaleObject(0.5f, 0.5f, 0.5f);
        head.translateObject(0f, tempCenterPoint.y + 0.27f, 0.0f);


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
        eyeRight = head.getChildObject().get(inthead);
        inthead++;


        eyeRight.rotateObject((float) Math.toRadians(-24f), 0f, 1f, 0f);
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
        eyeLeft = head.getChildObject().get(inthead);
        inthead++;

        eyeLeft.rotateObject((float) Math.toRadians(24f), 0f, 1f, 0f);
        tempCenterPoint = head.updateCenterPointObject();
        eyeLeft.translateObject(tempCenterPoint.x + 0.1f, tempCenterPoint.y, tempCenterPoint.z + 0.229f);

        //head(2)
        eyeRightDecor();
        inthead++;
        //head(3)
        eyeLeftDecor();
        inthead++;

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
        Object nose = head.getChildObject().get(inthead);
        inthead++;

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

        head.getChildObject().get(inthead).rotateObject((float) Math.toRadians(-15f), 0.0f, 0.0f, 1.f);
        head.getChildObject().get(inthead).translateObject(tempCenterPoint.x - 0.005f, tempCenterPoint.y - 0.05f, tempCenterPoint.z + 0.24f);
        inthead++;

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
        Object earRight = head.getChildObject().get(inthead);
        inthead++;

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
        Object earLeft = head.getChildObject().get(inthead);
        inthead++;

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

        tempCenterPoint = earLeft.updateCenterPointObject();
        earLeft.getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        earLeft.getChildObject().get(0).rotateObject((float) Math.toRadians(-30f), 0f, 0f, 1f);
        earLeft.getChildObject().get(0).translateObject(tempCenterPoint.x - 0.024f, tempCenterPoint.y - 0.05f, tempCenterPoint.z + 0.01f);


        //mouth right
        objectPointControl.clear();
        objectPointControl.add(new Object(
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

        head.getChildObject().add(new Curve2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), 3
        ));
        Object mouthLeft = head.getChildObject().get(inthead);
        inthead++;

        tempCenterPoint = head.updateCenterPointObject();
        float move1 = 0.02f;
        float move2 = 0.1f;
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.02f - move1, tempCenterPoint.y + 0.015f - move2, tempCenterPoint.z + 0.232f));
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.014f - move1, tempCenterPoint.y - 0.0001f - move2, tempCenterPoint.z + 0.228f));
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.007f - move1, tempCenterPoint.y - 0.0001f - move2, tempCenterPoint.z + 0.232f));
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.02f - move1, tempCenterPoint.y + 0.015f - move2, tempCenterPoint.z + 0.235f));

        objectPointControl.get(0).bezierCurve(mouthLeft);


        //mouth left
        objectPointControl.clear();
        objectPointControl.add(new Object(
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

        head.getChildObject().add(new Curve2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), 3
        ));
        Object mouthRight = head.getChildObject().get(inthead);
        inthead++;

        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.02f + move1, tempCenterPoint.y + 0.015f - move2, tempCenterPoint.z + 0.235f));
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.007f + move1, tempCenterPoint.y - 0.0001f - move2, tempCenterPoint.z + 0.232f));
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.014f + move1, tempCenterPoint.y - 0.0001f - move2, tempCenterPoint.z + 0.228f));
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.02f + move1, tempCenterPoint.y + 0.015f - move2, tempCenterPoint.z + 0.232f));

        objectPointControl.get(0).bezierCurve(mouthRight);


        //whisker left up
        objectPointControl.clear();
        objectPointControl.add(new Object(
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

        head.getChildObject().add(new Curve2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), 1
        ));
        Object whiskerLeftUp = head.getChildObject().get(inthead);
        inthead++;

        move1 = 0.3f;
        move2 = 0.1f;
        float move3 = 0.2f;
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.08f - move1, tempCenterPoint.y - 0.005f - move2, tempCenterPoint.z + move3));
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.053f - move1, tempCenterPoint.y + 0.011f - move2, tempCenterPoint.z + move3));
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.05f - move1, tempCenterPoint.y + 0.011f - move2, tempCenterPoint.z + move3));
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.08f - move1, tempCenterPoint.y - 0.005f - move2, tempCenterPoint.z + move3));

        objectPointControl.get(0).bezierCurve(whiskerLeftUp);
        tempCenterPoint = whiskerLeftUp.updateCenterPointObject();
        whiskerLeftUp.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
        whiskerLeftUp.rotateObject((float) Math.toRadians(-10f), 0f, 0f, 1f);
        whiskerLeftUp.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);


        //whisker right up
        objectPointControl.clear();
        objectPointControl.add(new Object(
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

        head.getChildObject().add(new Curve2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), 1
        ));
        Object whiskerRightUp = head.getChildObject().get(inthead);
        inthead++;

        move1 = -move1;

        tempCenterPoint = head.updateCenterPointObject();
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.08f - move1, tempCenterPoint.y - 0.005f - move2, tempCenterPoint.z + move3));
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.05f - move1, tempCenterPoint.y + 0.011f - move2, tempCenterPoint.z + move3));
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.053f - move1, tempCenterPoint.y + 0.011f - move2, tempCenterPoint.z + move3));
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.08f - move1, tempCenterPoint.y - 0.005f - move2, tempCenterPoint.z + move3));

        objectPointControl.get(0).bezierCurve(whiskerRightUp);
        tempCenterPoint = whiskerRightUp.updateCenterPointObject();
        whiskerRightUp.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
        whiskerRightUp.rotateObject((float) Math.toRadians(10f), 0f, 0f, 1f);
        whiskerRightUp.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);


        //whisker left down
        objectPointControl.clear();
        objectPointControl.add(new Object(
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

        head.getChildObject().add(new Curve2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), 1
        ));
        Object whiskerLeftDown = head.getChildObject().get(inthead);
        inthead++;

        move1 = -move1 - 0.15f;
        move2 += -0.023f;
        move3 += -0.01f;

        tempCenterPoint = head.updateCenterPointObject();
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.08f - move1, tempCenterPoint.y - 0.005f - move2, tempCenterPoint.z + move3));
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.05f - move1, tempCenterPoint.y + 0.011f - move2, tempCenterPoint.z + move3));
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.053f - move1, tempCenterPoint.y + 0.011f - move2, tempCenterPoint.z + move3));
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.08f - move1, tempCenterPoint.y - 0.005f - move2, tempCenterPoint.z + move3));

        objectPointControl.get(0).bezierCurve(whiskerLeftDown);
        tempCenterPoint = whiskerLeftDown.updateCenterPointObject();
        whiskerLeftDown.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
        whiskerLeftDown.rotateObject((float) Math.toRadians(3f), 0f, 0f, 1f);
        whiskerLeftDown.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);


        //whisker right down
        objectPointControl.clear();
        objectPointControl.add(new Object(
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

        head.getChildObject().add(new Curve2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.0f, 0.0f, 0.0f, 1.0f), 1
        ));
        Object whiskerRightDown = head.getChildObject().get(inthead);
        inthead++;

        move1 = -move1;

        tempCenterPoint = head.updateCenterPointObject();
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.08f - move1, tempCenterPoint.y - 0.005f - move2, tempCenterPoint.z + move3));
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.05f - move1, tempCenterPoint.y + 0.011f - move2, tempCenterPoint.z + move3));
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.053f - move1, tempCenterPoint.y + 0.011f - move2, tempCenterPoint.z + move3));
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.08f - move1, tempCenterPoint.y - 0.005f - move2, tempCenterPoint.z + move3));

        objectPointControl.get(0).bezierCurve(whiskerRightDown);

        tempCenterPoint = whiskerRightDown.updateCenterPointObject();
        whiskerRightDown.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
        whiskerRightDown.rotateObject((float) Math.toRadians(-3f), 0f, 0f, 1f);
        whiskerRightDown.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);

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

        jointArmLeft = upperBody.getChildObject().get(1);

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

        jointArmRight = upperBody.getChildObject().get(2);

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
        Object armRight = jointArmRight.getChildObject().get(0);

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
        jointHandRight = armRight.getChildObject().get(0);

        jointHandRight.scaleObject(0.06f, 0.06f, 0.06f);

        tempCenterPoint = armRight.updateCenterPointObject();
        jointHandRight.translateObject(tempCenterPoint.x - 0.094f, tempCenterPoint.y, tempCenterPoint.z);

        handRight();

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
        Object armLeft = jointArmLeft.getChildObject().get(0);

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
                new Vector4f(0.788f, 0.815f, 0.305f, 0f), 0.0f, 0.0f, 0.02f, 0.02f, 0.05f
        ));
        jointHandLeft = armLeft.getChildObject().get(0);

        jointHandLeft.scaleObject(0.04f, 0.04f, 0.04f);

        tempCenterPoint = armLeft.updateCenterPointObject();
        jointHandLeft.translateObject(tempCenterPoint.x + 0.094f, tempCenterPoint.y, tempCenterPoint.z);

        handLeft();


        //joint leg right
        lowerBody.getChildObject().add(new Sphere3(
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
                new Vector4f(1, 1, 1, 1f), 0.0f, 0.0f, 0.02f, 0.02f, 0.05f
        ));jointLegRight = lowerBody.getChildObject().get(intlowerBody);
        intlowerBody++;

        tempCenterPoint = lowerBody.updateCenterPointObject();
        jointLegRight.rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        jointLegRight.scaleObject(0.1f, 0.1f, 0.1f);
        jointLegRight.translateObject(tempCenterPoint.x - 0.1f, tempCenterPoint.y + 0.09f, tempCenterPoint.z);


        //legRight
        jointLegRight.getChildObject().add(new Tube(
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
        Object legRight = jointLegRight.getChildObject().get(0);

        tempCenterPoint = jointLegRight.updateCenterPointObject();
        legRight.rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        legRight.translateObject(tempCenterPoint.x, tempCenterPoint.y - 0.09f, tempCenterPoint.z);


        //joint foot right
        legRight.getChildObject().add(new Sphere3(
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
                new Vector4f(1, 1, 1, 1f), 0.0f, 0.0f, 0.02f, 0.02f, 0.05f
        ));jointFootRight = legRight.getChildObject().get(0);

        tempCenterPoint = legRight.updateCenterPointObject();

        jointFootRight.scaleObject(0.1f, 0.1f, 0.1f);
        jointFootRight.translateObject(tempCenterPoint.x, tempCenterPoint.y - 0.1f, tempCenterPoint.z);


        //foot right
        jointFootRight.getChildObject().add(new Tube(
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
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.09f, 0.04f
        ));


        tempCenterPoint = jointFootRight.updateCenterPointObject();
        jointFootRight.getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        jointFootRight.getChildObject().get(0).translateObject(tempCenterPoint.x, tempCenterPoint.y -0.03f, tempCenterPoint.z + 0.033f);


        //joint leg left
        lowerBody.getChildObject().add(new Sphere3(
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
                new Vector4f(1, 1, 1, 1f), 0.0f, 0.0f, 0.02f, 0.02f, 0.05f
        ));jointLegLeft = lowerBody.getChildObject().get(intlowerBody);
        intlowerBody++;

        tempCenterPoint = lowerBody.updateCenterPointObject();
        jointLegLeft.rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        jointLegLeft.scaleObject(0.1f, 0.1f, 0.1f);
        jointLegLeft.translateObject(tempCenterPoint.x + 0.1f, tempCenterPoint.y + 0.09f, tempCenterPoint.z);


        //legLeft
        jointLegLeft.getChildObject().add(new Tube(
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
        Object legLeft = jointLegLeft.getChildObject().get(0);


        tempCenterPoint = jointLegLeft.updateCenterPointObject();
        legLeft.rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        legLeft.translateObject(tempCenterPoint.x, tempCenterPoint.y - 0.09f, tempCenterPoint.z);


        //joint foot left
        legLeft.getChildObject().add(new Sphere3(
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
                new Vector4f(1, 1, 1, 1f), 0.0f, 0.0f, 0.02f, 0.02f, 0.05f
        ));jointFootLeft = legLeft.getChildObject().get(0);

        tempCenterPoint = legLeft.updateCenterPointObject();

        jointFootLeft.scaleObject(0.1f, 0.1f, 0.1f);
        jointFootLeft.translateObject(tempCenterPoint.x, tempCenterPoint.y - 0.1f, tempCenterPoint.z);


        //foot left
        jointFootLeft.getChildObject().add(new Tube(
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
                new Vector4f(1f, 1f, 1f, 0f), 0.0f, 0.0f, 0.09f, 0.04f
        ));


        tempCenterPoint = jointFootLeft.updateCenterPointObject();
        jointFootLeft.getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        jointFootLeft.getChildObject().get(0).translateObject(tempCenterPoint.x, tempCenterPoint.y -0.03f, tempCenterPoint.z + 0.033f);


        //tail
        objectPointControl.clear();
        objectPointControl.add(new Object(
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

        lowerBody.getChildObject().add(new Curve2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1, 1, 1, 1.0f), 9
        ));
        Object tail = lowerBody.getChildObject().get(intlowerBody);
        intlowerBody++;


        move2 = 0.1f;
        move3 = 0.14f;
        tempCenterPoint = lowerBody.updateCenterPointObject();
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x, tempCenterPoint.y + move2, tempCenterPoint.z - move3));
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.5f, tempCenterPoint.y + move2, tempCenterPoint.z - 0.6f - move3));
        objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.2f, tempCenterPoint.y + 1f + move2, tempCenterPoint.z - move3));
        objectPointControl.get(0).bezierCurve(tail);



        tempCenterPoint = jointArmRight.updateCenterPointObject();
        jointArmRight.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
        jointArmRight.rotateObject((float) Math.toRadians(55f), 0f, 0f, 1f);
        jointArmRight.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);

        tempCenterPoint = jointArmLeft.updateCenterPointObject();
        jointArmLeft.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
        jointArmLeft.rotateObject((float) Math.toRadians(-55f), 0f, 0f, 1f);
        jointArmLeft.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);

        lowerBody.translateObject(0f, -0.2f, 0f);

        for (int i = 0; i < 3; i++) {
            valueArray.add(0.0);
        }

        for (int i = 0; i < 6; i++) {
            stateArray.add(true);
        }

        tempCenterPoint = objects.get(1).updateCenterPointObject();

        lowerBody.translateObject(tempCenterPoint.x + 1f, tempCenterPoint.y, tempCenterPoint.z + 1f);


        objects.get(2).translateObject(.0f, -0.265f, 0f);


        //environment
        //        environment.add(new Sphere3(
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
//                new Vector4f(0, 1, 0.1f, 0f), 0.0f, 0.0f, 100, 1000, 100, 1
//        ));
//        environment.add(new Sphere3(
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
//                new Vector4f(0.510f, 0.500f, 0.500f, 0f), 0.0f, 0.0f, 100, 100, 90, 4
//        ));
        //Lantai
        environment.add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.7f, 0.69f, 0.62f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                10f,
                0.02f,
                2f,
                108,
                72,
                180f
        ));
        Object floor = environment.get(0);
        floor.translateObject(0f, -3f, 0f);

        //platform atas floor
        floor.getChildObject().add(new Sphere3(
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
                new Vector4f(0.996f, 0.933f, 0.015f, 0f), 0.0f, 0.0f, 0.2f, 0.2f, 0.2f, true
        ));

        tempCenterPoint = floor.updateCenterPointObject();
        floor.getChildObject().get(0).translateObject(tempCenterPoint.x, tempCenterPoint.y + 1f, tempCenterPoint.z + 1f);



        //Wall
        environment.add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.49f, 0.62f, 0.675f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                10f,
                8f,
                0.005f,
                108,
                72,
                180f
        ));
        environment.get(1).translateObject(0f, -2f, -1f);

        environment.add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.49f, 0.62f, 0.675f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                5f,
                1.5f,
                .005f,
                108,
                72,
                180f
        ));

        environment.get(2).rotateObject((float) Math.toRadians(270f), 0f, 1f, 0f);
        environment.get(2).translateObject(-2.5f, 1f, 0.0f);


        environment.add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.49f, 0.62f, 0.675f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                5f,
                1.5f,
                .005f,
                108,
                72,
                180f
        ));

        environment.get(3).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        environment.get(3).translateObject(2.5f, 1f, 0.0f);

        //Roof
        environment.add(new Sphere2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.vert", GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData("resources/shaders/scene.frag", GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.7f, 0.69f, 0.62f, 1.0f),
                Arrays.asList(0.0f, 0.0f, 0.0f),
                5f,
                0.02f,
                5f,
                108,
                72,
                180f
        ));
        environment.get(4).translateObject(0f, 3f, 0f);

        objects.get(0).translateObject(0f,-1f,0f);
        objects.get(1).translateObject(0f,-1f,0f);
        //environment.get(1).translateObject(tempCenterPoint.x, tempCenterPoint.y + 10f, tempCenterPoint.z);



    }


    public void input() {
        if (window.isKeyPressed(GLFW_KEY_W)) {
//            kaki
//            objects.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(7f), 1.0f, 0.0f, 0.0f);
            for (Object y :  objects.get(1).getChildObject().get(5).getChildObject()) {
                kaki--;
//                rotasi terhadap bumi
                List<Float> temp1 = new ArrayList<>(objects.get(1).getChildObject().get(0).getChildObject().get(0).getCenterPoint());
                y.translateObject(temp1.get(0) * -1, temp1.get(1) * -1, temp1.get(2) * -1);
                if (temp==10){
                    kaki=0;
                    temp=0;
                }
                if(kaki <= -10){
//                    jalan+=0.001;
                    {y.rotateObject((float) Math.toRadians(7f), -1.0f, 0.0f, 0.0f);}
//                    objects.get(0).translateObject(0f,0f,jalan);
                    temp++;
                }
                else
//                jalan+=0.001;
                {y.rotateObject((float) Math.toRadians(7f), 1.0f, 0.0f, 0.0f);}
                y.translateObject(temp1.get(0) * 1, temp1.get(1) * 1, temp1.get(2) * 1);
                System.out.println(kaki);
            }
            for (Object y :  objects.get(1).getChildObject().get(6).getChildObject()) {
                kaki--;
//                rotasi terhadap bumi
                List<Float> temp1 = new ArrayList<>(objects.get(1).getChildObject().get(0).getChildObject().get(0).getCenterPoint());
                y.translateObject(temp1.get(0) * -1, temp1.get(1) * -1, temp1.get(2) * -1);
                if (temp==10){
                    kaki=0;
                    temp=0;
                }
                if(kaki <= -10){
//                    jalan+=0.001;
                    {y.rotateObject((float) Math.toRadians(7f), 1.0f, 0.0f, 0.0f);}
//                    objects.get(0).translateObject(0f,0f,jalan);
                    temp++;
                }
                else
//                jalan+=0.001;
                {y.rotateObject((float) Math.toRadians(7f), -1.0f, 0.0f, 0.0f);}
                y.translateObject(temp1.get(0) * 1, temp1.get(1) * 1, temp1.get(2) * 1);
                System.out.println(kaki);
            }
//            tangan
//
            for (Object y :  objects.get(1).getChildObject().get(0).getChildObject()) {
                tangan--;
//                rotasi terhadap bumi
                List<Float> temp1 = new ArrayList<>(objects.get(1).getChildObject().get(0).getChildObject().get(0).getCenterPoint());
                y.translateObject(temp1.get(0) * -1, temp1.get(1) * -1, temp1.get(2) * -1);
                if (tempo==30){
                    tangan=0;
                    tempo=0;
                }
                if(tangan <= -30){
//                    jalan+=0.001;
                    {y.rotateObject((float) Math.toRadians(7f), 1.0f, 0.0f, 0.0f);}
//                    objects.get(0).translateObject(0f,0f,jalan);
                   tempo++;
                }
                else
//                jalan+=0.001;
                {y.rotateObject((float) Math.toRadians(7f), -1.0f, 0.0f, 0.0f);}
                y.translateObject(temp1.get(0) * 1, temp1.get(1) * 1, temp1.get(2) * 1);
                System.out.println(kaki);
            }
            for (Object y :  objects.get(1).getChildObject().get(1).getChildObject()) {
                tangan--;
//                rotasi terhadap bumi
                List<Float> temp1 = new ArrayList<>(objects.get(1).getChildObject().get(0).getChildObject().get(0).getCenterPoint());
                y.translateObject(temp1.get(0) * -1, temp1.get(1) * -1, temp1.get(2) * -1);
                if (tempo==30){
                    tangan=0;
                    tempo=0;
                }
                if(tangan <= -30){
//                    jalan+=0.001;
                    {y.rotateObject((float) Math.toRadians(7f), -1.0f, 0.0f, 0.0f);}
//                    objects.get(0).translateObject(0f,0f,jalan);
                    tempo++;
                }
                else
//                jalan+=0.001;
                {y.rotateObject((float) Math.toRadians(7f), 1.0f, 0.0f, 0.0f);}
                y.translateObject(temp1.get(0) * 1, temp1.get(1) * 1, temp1.get(2) * 1);
                System.out.println(kaki);
            }
            List<Float> temp = new ArrayList<>(objects.get(0).getChildObject().get(3).getCenterPoint());
            List<Float> temp2 = new ArrayList<>(objects.get(0).getChildObject().get(4).getCenterPoint());
//            objects.get(0).getChildObject().get(3).translateObject(temp.get(0)*-1,temp.get(1)*-1,temp.get(2)*-1);
//            objects.get(0).getChildObject().get(3).rotateObject(1.5f, 1f, 0f, 0f,15f);
//            objects.get(0).getChildObject().get(3).translateObject(temp.get(0)*1,temp.get(1)*1,temp.get(2)*1);
//
//            objects.get(0).getChildObject().get(4).translateObject(temp2.get(0)*-1,temp2.get(1)*-1,temp2.get(2)*-1);
//            objects.get(0).getChildObject().get(4).rotateObject(1.5f, -1f, 0f, 0f,15f);
//            objects.get(0).getChildObject().get(4).translateObject(temp2.get(0)*1,temp2.get(1)*1,temp2.get(2)*1);



            }

        class Rotate {
            private void x (Object object, float rotate) {
                Vector3f tempCenterPoint = object.updateCenterPointObject();
                object.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                object.rotateObjectAnimate((float) Math.toRadians(rotate), 1f, 0f, 0f, camera, projection);
                object.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
            }

            private void y (Object object, float rotate) {
                Vector3f tempCenterPoint = object.updateCenterPointObject();
                object.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                object.rotateObjectAnimate((float) Math.toRadians(rotate), 0f, 1f, 0f, camera, projection);
                object.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
            }

            private void z (Object object, float rotate) {
                Vector3f tempCenterPoint = object.updateCenterPointObject();
                object.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
                object.rotateObjectAnimate((float) Math.toRadians(rotate), 0f, 0f, 1f, camera, projection);
                object.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
            }
        }
        Rotate rotate1 = new Rotate();

        // value 0 state 0 1 head right left
        if (window.isKeyPressed(GLFW_KEY_Y)) {
            if (stateArray.get(1)) {
                if (valueArray.get(0) < 30 && stateArray.get(0)) {
                    rotate1.z(jointHead, 0.2f);
                    valueArray.set(0, valueArray.get(0) + 1);

                } else {
                    stateArray.set(0, false);
                    rotate1.z(jointHead, -0.2f);
                    valueArray.set(0, valueArray.get(0) - 1);
                }

                if (valueArray.get(0) == 0) {
                    stateArray.set(0, true);
                    stateArray.set(1, false);
                }
            } else {
                if (valueArray.get(0) > -30 && stateArray.get(0)) {
                    rotate1.z(jointHead, -0.2f);
                    valueArray.set(0, valueArray.get(0) - 1);
                } else {
                    stateArray.set(0, false);
                    rotate1.z(jointHead, 0.2f);
                    valueArray.set(0, valueArray.get(0) + 1);
                }

                if (valueArray.get(0) == 0) {
                    stateArray.set(0, true);
                    stateArray.set(1, true);
                }
            }
        }


        // value 1 state 2 3 walk
        if (window.isKeyPressed(GLFW_KEY_Q)) {
            float move = 1;
            float move1 = move/2;
            if (stateArray.get(3)) {
                if (valueArray.get(1) < 30 && stateArray.get(2)) {
                    rotate1.x(jointArmRight, -move);
                    rotate1.x(jointHandRight, -move1);
                    rotate1.x(jointArmLeft, move);

                    rotate1.x(jointLegRight, move);
                    rotate1.x(jointLegLeft, -move);

                    valueArray.set(1, valueArray.get(1) + move);

                } else {
                    stateArray.set(2, false);
                    rotate1.x(jointArmRight, move);
                    rotate1.x(jointHandRight, move1);
                    rotate1.x(jointArmLeft, -move);

                    rotate1.x(jointLegRight, -move);
                    rotate1.x(jointLegLeft, move);


                    if (valueArray.get(1) > 18) {
                        rotate1.x(jointFootLeft, move * 1.3f);

                    }
                    else {
                        rotate1.x(jointFootLeft, -move);

                    }

                    valueArray.set(1, valueArray.get(1) - move);
                }

                if (valueArray.get(1) == 0) {
                    stateArray.set(2, true);
                    stateArray.set(3, false);
                }
            } else {
                if (valueArray.get(1) > -30 && stateArray.get(2)) {
                    rotate1.x(jointArmRight, move);
                    rotate1.x(jointArmLeft, -move);
                    rotate1.x(jointHandLeft, -move1);

                    rotate1.x(jointLegRight, -move);
                    rotate1.x(jointLegLeft, move);

                    valueArray.set(1, valueArray.get(1) - move);
                } else {
                    stateArray.set(2, false);
                    rotate1.x(jointArmRight, -move);
                    rotate1.x(jointArmLeft, move);
                    rotate1.x(jointHandLeft, move1);

                    rotate1.x(jointLegRight, move);
                    rotate1.x(jointLegLeft, -move);


                    if (valueArray.get(1) < -18) {
                        rotate1.x(jointFootRight, move * 1.3f);
                    }
                    else {

                        rotate1.x(jointFootRight, -move);
                    }
                    valueArray.set(1, valueArray.get(1) + move);
                }

                if (valueArray.get(1) == 0) {
                    stateArray.set(2, true);
                    stateArray.set(3, true);
                    jointFootRight.resetPos();
                    jointFootLeft.resetPos();
                }
            }
        }


        if (window.isKeyPressed(GLFW_KEY_R)) {
            lowerBody.resetPosChildren();
            valueArray.replaceAll(Integer -> 0.0);
            stateArray.replaceAll(Boolean -> true);
        }

        if (window.isKeyPressed(GLFW_KEY_L)){
//            objects.get(0).rotateObject((float) Math.toRadians(7f), 0.0f, 1.0f, 0.0f);
            camera.addRotation((float) Math.toRadians(0f), (float) Math.toRadians(4f));


        }
        if (window.isKeyPressed(GLFW_KEY_J)){
            camera.addRotation((float) Math.toRadians(0f), (float) Math.toRadians(-4f));


        }
        if (window.isKeyPressed(GLFW_KEY_I)){
            camera.moveForward((float) Math.toRadians(4f));


    }
        if (window.isKeyPressed(GLFW_KEY_K)){
            camera.moveBackwards((float) Math.toRadians(4f));


        }
        if (window.isKeyPressed(GLFW_KEY_A)){
            objects.get(1).rotateObject((float) Math.toRadians(7f), 1.0f, 0.0f, 1.0f);

        }
        if (window.isKeyPressed(GLFW_KEY_E)){
            objects.get(1).rotateObject((float) Math.toRadians(7f), 0.0f, 0.0f, 0.0f);
        }
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
        eyeLeft.getChildObject().get(1).translateObject(tempCenterPoint.x - 0.01f, tempCenterPoint.y + 0.015f, tempCenterPoint.z + 0.0048f);

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

    public void handRight() {
        Vector3f tempCenterPoint;
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
                new Vector4f(0.788f - 0.05f, 0.815f - 0.05f, 0.305f - 0.05f, 0f), 0.0f, 0.0f, 0.04f, 0.07f
        ));
        Object handTebel = jointHandRight.getChildObject().get(0);

        tempCenterPoint = jointHandRight.updateCenterPointObject();
        handTebel.rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        handTebel.translateObject(tempCenterPoint.x - 0.035f, tempCenterPoint.y, tempCenterPoint.z);


        tempCenterPoint = handTebel.updateCenterPointObject();


        handTebel.getChildObject().add(new Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.788f, 0.815f, 0.305f, 0f)
        ));
        Object hand = handTebel.getChildObject().get(0);

        objectPointControl.clear();
        objectPointControl.add(new Curve2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f), 1
        ));


        float move1 = -0.01f;
        tempCenterPoint.x += move1;
        for (double v = -20f; v <= 200; v += 1f) {

            float z = tempCenterPoint.z + 0.027f * (float) (Math.cos(Math.toRadians(v)));
            float y = tempCenterPoint.y + 0.027f * (float) (Math.sin(Math.toRadians(v)));

            float zextend = tempCenterPoint.z + 0.04f * (float) (Math.cos(Math.toRadians(v)));
            float yextend = tempCenterPoint.y + 0.04f * (float) (Math.sin(Math.toRadians(v)));

            float zextend2 = tempCenterPoint.z + 0.05f * (float) (Math.cos(Math.toRadians(v)));
            float yextend2 = tempCenterPoint.y + 0.05f * (float) (Math.sin(Math.toRadians(v)));


            objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x, y, z));
            objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.05f, yextend, zextend));
            objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.08f, yextend2, zextend2));
            objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x - 0.12f, y, z));

            objectPointControl.get(0).bezierCurve(hand);
            objectPointControl.get(0).clearVertices();
        }


        for (double v = 201; v <= 215; v += 2f) {
            float y = tempCenterPoint.y + 0.027f * (float) (Math.sin(Math.toRadians(v)));
            float z = tempCenterPoint.z + 0.027f * (float) (Math.cos(Math.toRadians(v)));


            hand.addVertices(new Vector3f(tempCenterPoint.x, y, z));
            hand.addVertices(new Vector3f(tempCenterPoint.x - 0.12f, y, z));
        }


        float y = tempCenterPoint.y + 0.029f * (float) (Math.sin(Math.toRadians(201)));

        for (double v = 215; v <= 360; v += 5f) {

            float z = tempCenterPoint.z + 0.027f * (float) (Math.cos(Math.toRadians(v)));


            hand.addVertices(new Vector3f(tempCenterPoint.x, y, z));
            hand.addVertices(new Vector3f(tempCenterPoint.x - 0.12f, y, z));
        }

        for (double v = -89f; v <= -36; v += 5f) {

            float z = tempCenterPoint.z + 0.027f * (float) (Math.cos(Math.toRadians(v)));

            hand.addVertices(new Vector3f(tempCenterPoint.x, y, z));
            hand.addVertices(new Vector3f(tempCenterPoint.x - 0.12f, y, z));

        }

        for (double v = -21; v >= -35; v -= 2f) {
            y = tempCenterPoint.y + 0.027f * (float) (Math.sin(Math.toRadians(v)));
            float z = tempCenterPoint.z + 0.027f * (float) (Math.cos(Math.toRadians(v)));


            hand.addVertices(new Vector3f(tempCenterPoint.x, y, z));
            hand.addVertices(new Vector3f(tempCenterPoint.x - 0.12f, y, z));
        }

        hand.translateObject(0f, -0.01f, 0f);

        //jari 1 belakang
        hand.getChildObject().add(new Sphere3(
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
        Object jari1 = hand.getChildObject().get(0);

        tempCenterPoint = handTebel.updateCenterPointObject();

        jari1.rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        jari1.rotateObject((float) Math.toRadians(80f), 0f, 1f, 0f);
        jari1.translateObject(tempCenterPoint.x - 0.18f, tempCenterPoint.y, tempCenterPoint.z - 0.038f);


        //jari 2 tengah
        hand.getChildObject().add(new Sphere3(
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
        Object jari2 = hand.getChildObject().get(1);

        jari2.rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        jari2.rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        jari2.translateObject(tempCenterPoint.x - 0.18f, tempCenterPoint.y, tempCenterPoint.z);


        //jari 3 depan
        hand.getChildObject().add(new Sphere3(
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
        Object jari3 = hand.getChildObject().get(2);

        jari3.rotateObject((float) Math.toRadians(90f), 1f, 0f, 0f);
        jari3.rotateObject((float) Math.toRadians(100f), 0f, 1f, 0f);
        jari3.translateObject(tempCenterPoint.x - 0.18f, tempCenterPoint.y, tempCenterPoint.z + 0.038f);


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
                new Vector4f(0.788f, 0.815f, 0.305f, 0f), 0.0f, 0.0f, 0.015f, 0.03f
        ));

        jari1.getChildObject().get(0).rotateObject((float) Math.toRadians(100f), 0f, 1f, 0f);
        tempCenterPoint = jari1.updateCenterPointObject();
        jari1.getChildObject().get(0).translateObject(tempCenterPoint.x + 0.06f, tempCenterPoint.y, tempCenterPoint.z + 0.064f);


        //jari2 tube
        jari2.getChildObject().add(new Tube(
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
                new Vector4f(0.788f, 0.815f, 0.305f, 0f), 0.0f, 0.0f, 0.015f, 0.03f
        ));

        jari2.getChildObject().get(0).rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        tempCenterPoint = jari2.updateCenterPointObject();
        jari2.getChildObject().get(0).translateObject(tempCenterPoint.x + 0.06f, tempCenterPoint.y, tempCenterPoint.z);


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
                new Vector4f(0.788f, 0.815f, 0.305f, 0f), 0.0f, 0.0f, 0.015f, 0.03f
        ));

        jari3.getChildObject().get(0).rotateObject((float) Math.toRadians(80f), 0f, 1f, 0f);
        tempCenterPoint = jari3.updateCenterPointObject();
        jari3.getChildObject().get(0).translateObject(tempCenterPoint.x + 0.06f, tempCenterPoint.y, tempCenterPoint.z - 0.064f);

    }

    public void handLeft() {
        Vector3f tempCenterPoint;
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
                new Vector4f(0.788f - 0.05f, 0.815f - 0.05f, 0.305f - 0.05f, 0f), 0.0f, 0.0f, 0.04f, 0.07f
        ));
        Object handTebel = jointHandLeft.getChildObject().get(0);

        tempCenterPoint = jointHandLeft.updateCenterPointObject();
        handTebel.rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        handTebel.translateObject(tempCenterPoint.x + 0.035f, tempCenterPoint.y, tempCenterPoint.z);


        tempCenterPoint = handTebel.updateCenterPointObject();

        handTebel.getChildObject().add(new Object(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(0.788f, 0.815f, 0.305f, 0f)
        ));
        Object hand = handTebel.getChildObject().get(0);


        objectPointControl.add(new Curve2(
                Arrays.asList(
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.vert"
                                        , GL_VERTEX_SHADER),
                        new ShaderProgram.ShaderModuleData
                                ("resources/shaders/scene.frag"
                                        , GL_FRAGMENT_SHADER)
                ),
                new ArrayList<>(),
                new Vector4f(1.0f, 1.0f, 1.0f, 1.0f), 1
        ));


        float move1 = 0.01f;
        tempCenterPoint.x += move1;
        for (double v = -20f; v <= 200; v += 1f) {

            float z = tempCenterPoint.z + 0.027f * (float) (Math.cos(Math.toRadians(v)));
            float y = tempCenterPoint.y + 0.027f * (float) (Math.sin(Math.toRadians(v)));

            float zextend = tempCenterPoint.z + 0.04f * (float) (Math.cos(Math.toRadians(v)));
            float yextend = tempCenterPoint.y + 0.04f * (float) (Math.sin(Math.toRadians(v)));

            float zextend2 = tempCenterPoint.z + 0.05f * (float) (Math.cos(Math.toRadians(v)));
            float yextend2 = tempCenterPoint.y + 0.05f * (float) (Math.sin(Math.toRadians(v)));


            objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x, y, z));
            objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.05f, yextend, zextend));
            objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.08f, yextend2, zextend2));
            objectPointControl.get(0).addVertices(new Vector3f(tempCenterPoint.x + 0.12f, y, z));

            objectPointControl.get(0).bezierCurve(hand);
            objectPointControl.get(0).clearVertices();
        }


        for (double v = 201; v <= 215; v += 2f) {
            float y = tempCenterPoint.y + 0.027f * (float) (Math.sin(Math.toRadians(v)));
            float z = tempCenterPoint.z + 0.027f * (float) (Math.cos(Math.toRadians(v)));


            hand.addVertices(new Vector3f(tempCenterPoint.x, y, z));
            hand.addVertices(new Vector3f(tempCenterPoint.x + 0.12f, y, z));
        }


        float y = tempCenterPoint.y + 0.029f * (float) (Math.sin(Math.toRadians(201)));

        for (double v = 215; v <= 360; v += 5f) {

            float z = tempCenterPoint.z + 0.027f * (float) (Math.cos(Math.toRadians(v)));


            hand.addVertices(new Vector3f(tempCenterPoint.x, y, z));
            hand.addVertices(new Vector3f(tempCenterPoint.x + 0.12f, y, z));
        }

        for (double v = -89f; v <= -36; v += 5f) {

            float z = tempCenterPoint.z + 0.027f * (float) (Math.cos(Math.toRadians(v)));

            hand.addVertices(new Vector3f(tempCenterPoint.x, y, z));
            hand.addVertices(new Vector3f(tempCenterPoint.x + 0.12f, y, z));

        }

        for (double v = -21; v >= -35; v -= 2f) {
            y = tempCenterPoint.y + 0.027f * (float) (Math.sin(Math.toRadians(v)));
            float z = tempCenterPoint.z + 0.027f * (float) (Math.cos(Math.toRadians(v)));


            hand.addVertices(new Vector3f(tempCenterPoint.x, y, z));
            hand.addVertices(new Vector3f(tempCenterPoint.x + 0.12f, y, z));
        }
        hand.translateObject(0f, -0.01f, 0f);

        //jari 1 belakang
        hand.getChildObject().add(new Sphere3(
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
        Object jari1 = hand.getChildObject().get(0);

        tempCenterPoint = handTebel.updateCenterPointObject();

        jari1.rotateObject((float) Math.toRadians(-90f), 1f, 0f, 0f);
        jari1.rotateObject((float) Math.toRadians(100f), 0f, 1f, 0f);
        jari1.translateObject(tempCenterPoint.x + 0.18f, tempCenterPoint.y, tempCenterPoint.z - 0.038f);


        //jari 2 tengah
        hand.getChildObject().add(new Sphere3(
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
        Object jari2 = hand.getChildObject().get(1);

        jari2.rotateObject((float) Math.toRadians(-90f), 1f, 0f, 0f);
        jari2.rotateObject((float) Math.toRadians(90f), 0f, 1f, 0f);
        jari2.translateObject(tempCenterPoint.x + 0.18f, tempCenterPoint.y, tempCenterPoint.z);


        //jari 3 depan
        hand.getChildObject().add(new Sphere3(
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
        Object jari3 = hand.getChildObject().get(2);

        jari3.rotateObject((float) Math.toRadians(-90f), 1f, 0f, 0f);
        jari3.rotateObject((float) Math.toRadians(80f), 0f, 1f, 0f);
        jari3.translateObject(tempCenterPoint.x + 0.18f, tempCenterPoint.y, tempCenterPoint.z + 0.038f);


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
                new Vector4f(0.788f, 0.815f, 0.305f, 0f), 0.0f, 0.0f, 0.015f, 0.03f
        ));

        jari1.getChildObject().get(0).rotateObject((float) Math.toRadians(-100f), 0f, 1f, 0f);
        tempCenterPoint = jari1.updateCenterPointObject();
        jari1.getChildObject().get(0).translateObject(tempCenterPoint.x - 0.06f, tempCenterPoint.y, tempCenterPoint.z + 0.064f);


        //jari2 tube
        jari2.getChildObject().add(new Tube(
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
                new Vector4f(0.788f, 0.815f, 0.305f, 0f), 0.0f, 0.0f, 0.015f, 0.03f
        ));

        jari2.getChildObject().get(0).rotateObject((float) Math.toRadians(-90f), 0f, 1f, 0f);
        tempCenterPoint = jari2.updateCenterPointObject();
        jari2.getChildObject().get(0).translateObject(tempCenterPoint.x - 0.06f, tempCenterPoint.y, tempCenterPoint.z);


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
                new Vector4f(0.788f, 0.815f, 0.305f, 0f), 0.0f, 0.0f, 0.015f, 0.03f
        ));

        jari3.getChildObject().get(0).rotateObject((float) Math.toRadians(-80f), 0f, 1f, 0f);
        tempCenterPoint = jari3.updateCenterPointObject();
        jari3.getChildObject().get(0).translateObject(tempCenterPoint.x - 0.06f, tempCenterPoint.y, tempCenterPoint.z - 0.064f);

    }


    public void loop() {
        while (window.isOpen()) {
            window.update();
            glClearColor(0,0.5f,1, 0.0f);
            GL.createCapabilities();

            glDisableVertexAttribArray(0);

            for (Object object : objects) {
                object.draw(camera, projection);
            }

            for (Object object : environment) {
                object.draw(camera, projection);
            }

//            for (Object object : objectsRectangle) {
//                object.draw(camera, projection);
//            }

//            for (Object object : objectPointControl) {
//                object.drawLine();
//            }
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
