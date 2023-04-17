import Engine.*;
import Engine.Object;
import org.joml.Vector2f;
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
    private ArrayList<Object> objects = new ArrayList<>();
    private ArrayList<Object> objectsRectangle = new ArrayList<>();
    private ArrayList<Object> objectPointControl = new ArrayList<>();
    private ArrayList<Object> objectPointCurve = new ArrayList<>();
    private boolean dragDrop = false;
    private int var = -1;

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
    private float value2 = 0;
    private boolean state = true;
    private boolean state2 = true;
    private boolean state3 = true;
    private boolean state4 = true;

    public static void main(String[] args) {

        new main().run();
    }

    public Vector2f convertRange(Vector2f pos, float height, float width) {
        return new Vector2f((((pos.x - 0) * (1 - (-1))) / (width - 0) + (-1)), (((pos.y - 0) * (1 - (-1))) / (height - 0) + (-1)) * -1);
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
        objects.get(0).getChildObject().get(2).getChildObject().add(new kerucut(
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
                new Vector4f(0.960f, 0.528f, 0.535f, 1f), 0.0f, 0.0f, 0.025f, 0.005f, 0.01f
        ));
        objects.get(0).getChildObject().get(2).getChildObject().get(6).rotateObject((float)Math.toRadians(-180),0f,0f,1f);
        objects.get(0).getChildObject().get(2).getChildObject().get(6).translateObject(0.0f,0.06f,-0.185f);

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
        upperBody = lowerBody.getChildObject().get(0);

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
        lowerBody.translateObject(0f, -0.2f, 3f);

        //environment
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
                new Vector4f(0, 1, 0.1f, 0f), 0.0f, 0.0f, 1000, 1000, 1000, 1
        ));
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
                new Vector4f(0.510f, 0.500f, 0.500f, 0f), 0.0f, 0.0f, 100, 100, 90, 4
        ));

        tempCenterPoint = lowerBody.updateCenterPointObject();
        objects.get(3).translateObject(tempCenterPoint.x, tempCenterPoint.y - 1000f, tempCenterPoint.z);
//        objects.get(0).translateObject(tempCenterPoint.x - 1f, tempCenterPoint.y , tempCenterPoint.z);
//        objects.get(1).translateObject(tempCenterPoint.x + 3f, tempCenterPoint.y + 1f, tempCenterPoint.z + 1f);
        objects.get(0).translateObject(0f,-1f,0f);
        objects.get(1).translateObject(0f,-1f,0f);
        objects.get(4).translateObject(tempCenterPoint.x, tempCenterPoint.y + 10f, tempCenterPoint.z);



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
            objects.get(0).getChildObject().get(3).translateObject(temp.get(0)*-1,temp.get(1)*-1,temp.get(2)*-1);
            objects.get(0).getChildObject().get(3).rotateObject(1.5f, 1f, 0f, 0f,15f);
            objects.get(0).getChildObject().get(3).translateObject(temp.get(0)*1,temp.get(1)*1,temp.get(2)*1);

            objects.get(0).getChildObject().get(4).translateObject(temp2.get(0)*-1,temp2.get(1)*-1,temp2.get(2)*-1);
            objects.get(0).getChildObject().get(4).rotateObject(1.5f, -1f, 0f, 0f,15f);
            objects.get(0).getChildObject().get(4).translateObject(temp2.get(0)*1,temp2.get(1)*1,temp2.get(2)*1);



            }
        float x = 0.0005f;
        float y = 0.0003f;
        if (window.isKeyPressed(GLFW_KEY_Y)) {
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




//            for (Object child : objects.get(0).getChildObject()) {
//                Vector3f tempCenterPoint = child.updateCenterPointObject();
//                child.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
//                child.rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
//                child.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
//
//            }

//            for (Object child : objects.get(0).getChildObject().get(1).getChildObject()) {
//                Vector3f tempCenterPoint = objects.get(0).getChildObject().get(1).updateCenterPointObject();
//                child.translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
//                child.rotateObject((float) Math.toRadians(0.5f), 0.0f, 1.0f, 0.0f);
//                child.translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
//
//            }
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
            glClearColor(0,0.5f,1, 0.0f);
            GL.createCapabilities();

            glDisableVertexAttribArray(0);

            for (Object object : objects) {
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
