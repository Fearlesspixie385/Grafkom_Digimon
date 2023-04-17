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

    boolean hold = false;
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
                        new Vector4f(1f,0.0f,0.0f,1.0f)
                )
        );
        objects.get(0).getChildObject().get(2).getChildObject().get(6).addVertices(new Vector3f(0.0f, 0.5f, 0.0f));
        objects.get(0).getChildObject().get(2).getChildObject().get(6).addVertices(new Vector3f(0.125f, 0.15f, 0.0f));
        objects.get(0).getChildObject().get(2).getChildObject().get(6).addVertices(new Vector3f(0.25f, 0.5f, 0.0f));
        objects.get(0).getChildObject().get(2).getChildObject().get(6).translateObject(0.0f,0.0f,-0.2f);

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
    }
    public void input(){
//        Walk
        if (window.isKeyPressed(GLFW_KEY_Z)) {
            List<Float> temp = new ArrayList<>(objects.get(0).getChildObject().get(3).getCenterPoint());
            List<Float> temp2 = new ArrayList<>(objects.get(0).getChildObject().get(4).getCenterPoint());
            objects.get(0).getChildObject().get(3).translateObject(temp.get(0)*-1,temp.get(1)*-1,temp.get(2)*-1);
            objects.get(0).getChildObject().get(3).rotateObject(1.5f, 1f, 0f, 0f,15f);
            objects.get(0).getChildObject().get(3).translateObject(temp.get(0)*1,temp.get(1)*1,temp.get(2)*1);

            objects.get(0).getChildObject().get(4).translateObject(temp2.get(0)*-1,temp2.get(1)*-1,temp2.get(2)*-1);
            objects.get(0).getChildObject().get(4).rotateObject(1.5f, -1f, 0f, 0f,15f);
            objects.get(0).getChildObject().get(4).translateObject(temp2.get(0)*1,temp2.get(1)*1,temp2.get(2)*1);
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

        if (window.isKeyPressed(GLFW_KEY_Q)) {
            objects.get(0).rotateObject((float)Math.toRadians(0.1), 0.0f, 7f, 0.0f);
        }

        if (window.isKeyPressed(GLFW_KEY_W)) {
            objects.get(0).rotateObject((float)Math.toRadians(0.1), 0.0f, -7f, 0.0f);
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
    public void loop(){
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f,
                    0.0f, 0.0f,
                    0.0f);
            glEnable(GL_DEPTH_TEST);
            GL.createCapabilities();

            input();
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
