import Engine.*;
import Engine.Object;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;
public class Palmon {
    private Window window =
            new Window(600,600,
                    "Hello World");
    ArrayList<Object> objects
            = new ArrayList<>();
    ArrayList<Object> objectsLines
            = new ArrayList<>();

    ArrayList<Object> objectsPointsControl = new ArrayList<>();
    Camera camera = new Camera();
    Projection projection = new Projection(window.getWidth(),window.getHeight());

    boolean hold = true;
    boolean startEvolve = false;
    int action = -1;
    float timer = 0;
    boolean evolveFinish = false;

    public void init(){
        window.init();
        GL.createCapabilities();
        //glEnable(GL_DEPTH_TEST);
        //code
        camera.setPosition(0f,0.0f,1f);
//        camera.setRotation((float)Math.toRadians(0.0f),(float)Math.toRadians(0.0f),(float)Math.toRadians(0.0f));


        //Badan
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
                        new Vector4f(1f,0.0f,0.0f,1.0f), true
                )
        );
//        objects.get(0).getChildObject().get(2).getChildObject().get(6).addVertices(new Vector3f(-0.125f, 0.1f, 0.0f));
//        objects.get(0).getChildObject().get(2).getChildObject().get(6).addVertices(new Vector3f(0.0f, 0.0f, 0.0f));
//        objects.get(0).getChildObject().get(2).getChildObject().get(6).addVertices(new Vector3f(0.125f, 0.1f, 0.0f));
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

        objects.get(0).scaleObject(0.75f,0.75f,0.75f);
        objects.get(0).rotateObject((float)Math.toRadians(-180), 0.0f, 1f, 0f);


    }
    public void input(){
//        Walk
        if (window.isKeyPressed(GLFW_KEY_Z)) {
//            List<Float> temp = new ArrayList<>(objects.get(0).getChildObject().get(3).getCenterPoint());
//            List<Float> temp2 = new ArrayList<>(objects.get(0).getChildObject().get(4).getCenterPoint());
//            objects.get(0).getChildObject().get(3).translateObject(temp.get(0)*-1,temp.get(1)*-1,temp.get(2)*-1);
//            objects.get(0).getChildObject().get(3).rotateObject(1.5f, 1f, 0f, 0f,15f);
//            objects.get(0).getChildObject().get(3).translateObject(temp.get(0)*1,temp.get(1)*1,temp.get(2)*1);
//
//            objects.get(0).getChildObject().get(4).translateObject(temp2.get(0)*-1,temp2.get(1)*-1,temp2.get(2)*-1);
//            objects.get(0).getChildObject().get(4).rotateObject(1.5f, -1f, 0f, 0f,15f);
//            objects.get(0).getChildObject().get(4).translateObject(temp2.get(0)*1,temp2.get(1)*1,temp2.get(2)*1);
        }
//        Run
        if (window.isKeyPressed(GLFW_KEY_X)) {
//            List<Float> temp = new ArrayList<>(objects.get(0).getCenterPoint());
//            objects.get(0).getChildObject().get(2).rotateObject(0.1f, 1f, 0f, 0.0f, 1f);
//
//            objects.get(0).getChildObject().get(3).translateObject(0f,0f,0f);
//            objects.get(0).getChildObject().get(3).rotateObject(2f, 1f, 0f, 0f,20f);
//            objects.get(0).getChildObject().get(3).translateObject(0f,0f,0f);
//
//            objects.get(0).getChildObject().get(4).translateObject(0f,0f,0f);
//            objects.get(0).getChildObject().get(4).rotateObject(2f, -1f, 0f, 0f,20f);
//            objects.get(0).getChildObject().get(4).translateObject(0f,0f,0f);
//
//            objects.get(0).getChildObject().get(5).translateObject(0f,0f,0f);
//            //objects.get(0).getChildObject().get(5).rotateObject(2f, -1f, 0f, 0f,20f);
//            objects.get(0).getChildObject().get(5).rotateObject((float)Math.toRadians(3.5), -1f, 0f, 0f);
//            objects.get(0).getChildObject().get(5).rotateObject((float)Math.toRadians(0.17), 0f, 6f, 0f);
//            objects.get(0).getChildObject().get(5).translateObject(0f,0f,0f);
//
//            objects.get(0).getChildObject().get(6).translateObject(0f,0f,0f);
//            //objects.get(0).getChildObject().get(5).rotateObject(2f, -1f, 0f, 0f,20f);
//            objects.get(0).getChildObject().get(6).rotateObject((float)Math.toRadians(4), 1f, 0f, 0f);
//            objects.get(0).getChildObject().get(6).rotateObject((float)Math.toRadians(0.2), 0f, 6f, 0f);
//            objects.get(0).getChildObject().get(6).translateObject(0f,0f,0f);
        }

        if (window.isKeyPressed(GLFW_KEY_C)){
            List<Float> temp1 = new ArrayList<>(objects.get(0).getChildObject().get(5).getCenterPoint());
            objects.get(0).getChildObject().get(5).translateObject(-temp1.get(0), -temp1.get(1), -temp1.get(2));
            objects.get(0).getChildObject().get(5).rotateObject((float)Math.toRadians(-30), 0f, 1f, 0f);
            objects.get(0).getChildObject().get(5).translateObject(temp1.get(0), temp1.get(1), temp1.get(2));
        }
        //Evolve
        if (window.isKeyPressed(GLFW_KEY_E)) {
            action = 0;
            startEvolve = true;
            hold = false;
        }
        if (window.isKeyPressed(GLFW_KEY_Q)) {
            objects.get(0).rotateObject((float)Math.toRadians(0.1), 0.0f, 7f, 0.0f);
//            List<Float> temp = new ArrayList<>(objects.get(0).getCenterPoint());
//            objects.get(0).translateObject(-temp.get(0), -temp.get(1), -temp.get(2));
//            objects.get(0).rotateObjectAnimate((float) Math.toRadians(1), 0f, 1f, 0f);
//            objects.get(0).translateObject(temp.get(0), temp.get(1), temp.get(2));

        }

        if (window.isKeyPressed(GLFW_KEY_W)) {
            objects.get(0).rotateObject((float)Math.toRadians(0.1), 0.0f, -7f, 0.0f);
//            Vector3f tempCenterPoint = objects.get(0).updateCenterPointObject();
//            objects.get(0).translateObject(tempCenterPoint.x * -1, tempCenterPoint.y * -1, tempCenterPoint.z * -1);
//            objects.get(0).rotateObjectAnimate((float) Math.toRadians(0.1), 0f, -1f, 0f);
//            objects.get(0).translateObject(tempCenterPoint.x * 1, tempCenterPoint.y * 1, tempCenterPoint.z * 1);
        }

        if (window.isKeyPressed(GLFW_KEY_LEFT)) {
            objects.get(0).translateObject(-0.01f,0f,0f);
        }
        if (window.isKeyPressed(GLFW_KEY_RIGHT)) {
            objects.get(0).translateObject(0.01f,0f,0f);
        }
        if (window.isKeyPressed(GLFW_KEY_UP)) {
            objects.get(0).translateObject(0f,0.01f,0f);
        }
        if (window.isKeyPressed(GLFW_KEY_DOWN)) {
            objects.get(0).translateObject(0f,-0.01f,0f);
        }
        if(window.isKeyPressed(GLFW_KEY_LEFT_SHIFT))
        {
            camera.moveForward(0.02f);
        }

        if(window.isKeyPressed(GLFW_KEY_LEFT_CONTROL))
        {
            camera.moveBackwards(0.02f);
        }

        if(window.getMousInput().isLeftButtonPressed()){
            Vector2f pos = window.getMousInput().getCurrentPos();
            //System.out.println("x : "+pos.x+" y : "+pos.y);
            pos.x = (pos.x - (window.getWidth())/2.0f) / (window.getWidth()/2.0f);
            pos.y = (pos.y - (window.getHeight())/2.0f) / (-window.getHeight()/2.0f);
            //System.out.println("x : "+pos.x+" y : "+pos.y);
            if((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))){
                System.out.println("x : "+pos.x+" y : "+pos.y);
                //objectsPointsControl.get(0).addVertices(new Vector3f(pos.x,pos.y,0));
            }

        }

    }
    public void Evolve(){
        double inc, limit;
        // Spin
        if(action == 0){
            //System.out.println(timer);
            inc = 5;
            objects.get(0).rotateObject((float)Math.toRadians(inc), 0f, 1f, 0f);

//            for(Object child:objects.get(0).getChildObject()) {
//                List<Float> temp1 = new ArrayList<>(child.getCenterPoint());
//                objects.get(0).getChildObject().get(5).translateObject(temp1.get(0) * -1, temp1.get(1) * -1, temp1.get(2) * -1);
//                child.rotateObject((float)Math.toRadians(inc), 0f, -1f, 0f);
//                objects.get(0).getChildObject().get(5).translateObject(temp1.get(0), temp1.get(1), temp1.get(2));
//
//                objects.get(0).getChildObject().get(5).translateObject(temp1.get(0) * -1, temp1.get(1) * -1, temp1.get(2) * -1);
//                objects.get(0).getChildObject().get(5).rotateObject((float) Math.toRadians(5), 0f, 0f, 1f);
//                objects.get(0).getChildObject().get(5).translateObject(temp1.get(0), temp1.get(1), temp1.get(2));
//            }
            timer += inc;
            if(timer > 715) {
                //startEvolve = false;
                action = 1;
                //hold = true;
                timer = 0;

            }
        }
        // Jump
        if (action == 1){
            objects.get(0).translateObject(0f, 0.01f, 0f);
            objects.get(0).getChildObject().get(5).translateObject(0f, 0.0022f, 0f);
            objects.get(0).getChildObject().get(6).translateObject(0f, 0.0022f, 0f);
            System.out.println(objects.get(0).getCenterPoint().get(1));

            List<Float> temp1 = new ArrayList<>(objects.get(0).getChildObject().get(5).getCenterPoint());
            objects.get(0).getChildObject().get(5).translateObject(-temp1.get(0), -temp1.get(1), -temp1.get(2));
            objects.get(0).getChildObject().get(5).rotateObject((float)Math.toRadians(4), 0f, 0f, 1f);
            objects.get(0).getChildObject().get(5).translateObject(temp1.get(0), temp1.get(1), temp1.get(2));

            List<Float> temp2 = new ArrayList<>(objects.get(0).getChildObject().get(6).getCenterPoint());
            objects.get(0).getChildObject().get(6).translateObject(-temp2.get(0), -temp2.get(1), -temp2.get(2));
            objects.get(0).getChildObject().get(6).rotateObject((float)Math.toRadians(4), 0f, 0f, -1f);
            objects.get(0).getChildObject().get(6).translateObject(temp2.get(0), temp2.get(1), temp2.get(2));

            if(objects.get(0).getCenterPoint().get(1) >= 0.2f){
                System.out.println("test");
                action = 2;
            }
        }

        // Landing
        if (action == 2){
            objects.get(0).translateObject(0f, -0.02f, 0f);

            objects.get(0).getChildObject().get(5).translateObject(0f, -0.0022f, 0f);
            objects.get(0).getChildObject().get(6).translateObject(0f, -0.0022f, 0f);

            List<Float> temp1 = new ArrayList<>(objects.get(0).getChildObject().get(5).getCenterPoint());
            objects.get(0).getChildObject().get(5).translateObject(-temp1.get(0), -temp1.get(1), -temp1.get(2));
            objects.get(0).getChildObject().get(5).rotateObject((float)Math.toRadians(4), 0f, 0f, -1f);
            objects.get(0).getChildObject().get(5).translateObject(temp1.get(0), temp1.get(1), temp1.get(2));

            List<Float> temp2 = new ArrayList<>(objects.get(0).getChildObject().get(6).getCenterPoint());
            objects.get(0).getChildObject().get(6).translateObject(-temp2.get(0), -temp2.get(1), -temp2.get(2));
            objects.get(0).getChildObject().get(6).rotateObject((float)Math.toRadians(4), 0f, 0f, 1f);
            objects.get(0).getChildObject().get(6).translateObject(temp2.get(0), temp2.get(1), temp2.get(2));

            List<Float> temp3 = new ArrayList<>(objects.get(0).getChildObject().get(3).getCenterPoint());
            objects.get(0).getChildObject().get(3).translateObject(temp3.get(0)*-1,temp3.get(1)*-1,temp3.get(2)*-1);
            objects.get(0).getChildObject().get(3).rotateObject((float)Math.toRadians(1.5), 1f, 0f, 0f);
            objects.get(0).getChildObject().get(3).translateObject(temp3.get(0)*1,temp3.get(1)*1,temp3.get(2)*1);

            List<Float> temp4 = new ArrayList<>(objects.get(0).getChildObject().get(4).getCenterPoint());
            objects.get(0).getChildObject().get(4).translateObject(temp4.get(0)*-1,temp4.get(1)*-1,temp4.get(2)*-1);
            objects.get(0).getChildObject().get(4).rotateObject((float)Math.toRadians(1.5), -1f, 0f, 0f);
            objects.get(0).getChildObject().get(4).translateObject(temp4.get(0)*1,temp4.get(1)*1,temp4.get(2)*1);

            if(objects.get(0).getCenterPoint().get(1) <= -0.05f){
                action = 3;
                timer = 1;
            }
        }
        ///Transform to togemon with effects
        if (action == 3){
            //Effect
            timer -= 0.1;
            objects.get(0).scaleObject(0.5f,0.5f,0.5f);

            if(timer < 0){
                action = 4;
                timer = 1;
            }
        }
        if (action == 4){
            if(!evolveFinish) Togemon();
            timer -= 0.1;
            objects.get(1).scaleObject(0.7f, 0.7f, 0.7f);
            if(timer < 0){
                hold = true;
                action = -1;
            }
        }
    }

    public void Togemon(){
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

        objects.get(1).translateObject(0.2f, 0.7f, 0.0f);
        evolveFinish = true;

        System.out.println("Hi");
    }

    public void loop(){
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f,
                    0.0f, 0.0f,
                    0.0f);
            glEnable(GL_DEPTH_TEST);
            GL.createCapabilities();

            if (hold) input();
            if (startEvolve) Evolve();
            //code
            //..

            for(Object object:objects){
                object.draw(camera,projection);
            }

//            for(Object2d object:objectsRectangle){
//                object.draw();
//            }
//            for(Object2d object:objectsPointsControl){
//                object.drawLine();
//            }
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

        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
    public static void main(String[] args) {
        new Palmon().run();
    }
}
