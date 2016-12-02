/*
 * Costruire l'intero tempio navigabile.
 * Se il tempio sparisce dalla visuale, tenere premuta o la freccia a destra 
 * o quella a sinistra, finche' non ricompare.
 */
package esercizio4_6;

import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.behaviors.keyboard.KeyNavigatorBehavior;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.View;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import javax.vecmath.Vector3f;

/**
 *
 * @author francesca
 */
public class Esercizio4_6 extends Applet{
    public Esercizio4_6(){
        setLayout(new BorderLayout());
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        Canvas3D canvas3D = new Canvas3D(config);
        add("Center",canvas3D);
        SimpleUniverse simpleU = new SimpleUniverse(canvas3D);
        BranchGroup scene = createSceneGraph();
        simpleU.getViewingPlatform().setNominalViewingTransform();
        // accedo all'oggetto view del SimpleUniverse
        View myView = simpleU.getViewer().getView();
        //Impostazione della distanza dal piano sullo sfondo
        myView.setBackClipDistance (100.0);
        //Impostazione del clip dal piano frontale
        myView.setFrontClipDistance (0.1);
        //cambio il punto di vista dell'osservatore
        Transform3D t3 = new Transform3D();
        t3.setTranslation(new Vector3d(0,2,50));
        TransformGroup vtg = simpleU.getViewingPlatform().getViewPlatformTransform();
        vtg.setTransform(t3);        
        //creo behavior per navigazione da tastiera
        KeyNavigatorBehavior keyNavBeh = new KeyNavigatorBehavior(vtg);
        keyNavBeh.setSchedulingBounds(new BoundingSphere(new Point3d(), 1000.0));
        scene.addChild(keyNavBeh);
        scene.compile();
        simpleU.addBranchGraph(scene);    
    }

    private BranchGroup createSceneGraph(){ 
        BranchGroup objRoot = new BranchGroup();
        Tempio tempio = new Tempio();
        directionLight(objRoot);
        //scalo oggetto
        Transform3D scale = new Transform3D(); // creo oggetto per la trasf.
	scale.setScale(new Vector3d(0.4,0.4,0.4));
        TransformGroup scaleTG = new TransformGroup(scale);
	scaleTG.addChild(tempio);
        objRoot.addChild(scaleTG);
        return objRoot; 
    }
      
     private void directionLight(BranchGroup node){
        BoundingSphere bounds = new BoundingSphere( 
                    new Point3d(0.d,0.d,0.d),100.d);
        Color3f white = new Color3f(1.0f, 1.0f, 1.0f);
        Vector3f direction = new Vector3f(-5.0f,15.0f,-10.0f);
        DirectionalLight lightD1 = new DirectionalLight();
        lightD1.setColor(white);
        lightD1.setDirection(direction);
        lightD1.setInfluencingBounds(bounds);  
        node.addChild(lightD1);
    }

    public static void main(String[] args){
            new MainFrame(new Esercizio4_6(), 1024, 768);
    }
}
