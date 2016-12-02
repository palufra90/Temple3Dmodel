/*
 * classe Tempio, che definisce la appearance e la texture 
 * da applicare a tutti gli elementi, e li assembla tra loro
 */
package esercizio4_6;

import com.sun.j3d.utils.image.TextureLoader;
import javax.media.j3d.Appearance;
import javax.media.j3d.Group;
import javax.media.j3d.Material;
import javax.media.j3d.Texture;
import javax.media.j3d.TextureAttributes;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;

/**
 *
 * @author francesca
 */
public class Tempio extends Group{
    Appearance app = new Appearance();
    Material mat = new Material();
    protected Stilobate stilobate = new Stilobate(app);
    protected FacciataTempio facciata = new FacciataTempio(app);
    protected Transform3D translationStil = new Transform3D();
    protected Transform3D translationRetro = new Transform3D();
    protected Transform3D translationCol = new Transform3D();
    protected Transform3D translationArc1 = new Transform3D();
    protected Transform3D translationArc2 = new Transform3D();
    public Tempio(){
        //definisco l'appearance per tutti gli oggetti
        mat.setEmissiveColor(new Color3f(0.3f,0.3f,0.3f));
        app.setMaterial(mat);
        //carico la texture
        TextureLoader loader = new TextureLoader("Pietra.jpg",null);
        Texture texture = loader.getTexture();
        //definisco gli attributi della texture
        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.MODULATE);
        app.setTexture(texture);
        app.setTextureAttributes(texAttr);
        //aggiungo stilobate
        Vector3d s = new Vector3d(0.0,-7.3,-4.0);
        translationStil.setTranslation(s);   
        TransformGroup tgStil = new TransformGroup();
        tgStil.setTransform(translationStil);
        tgStil.addChild(stilobate);
        addChild(tgStil);
        //aggiungo facciata
        FacciataTempio facTempio = new FacciataTempio(app);
        TransformGroup tgFac = new TransformGroup();
        tgFac.addChild(facTempio);
        addChild(tgFac);
        //aggiungo retro
        Vector3d r = new Vector3d(0.0,0.0,-48.0);
        translationRetro.setTranslation(r); 
        FacciataTempio retro = new FacciataTempio(app);
        TransformGroup tgRet = new TransformGroup();
        tgRet.setTransform(translationRetro);
        tgRet.addChild(retro);
        addChild(tgRet);
        //aggiungo colonne
        double step = 4;
        double curPos = 0.0;
        for(int i = 1; i<12; i++){ 
            curPos = curPos + step;
            Vector3d t = new Vector3d(-10.0,0.0,-curPos);
            translationCol.setTranslation(t);
            TransformGroup tgCol = new TransformGroup();
            tgCol.setTransform(translationCol);
            tgCol.addChild(new Colonna(app));
            addChild(tgCol);
        } 
        //aggiungo colonne
        double curPos1 = 0.0;
        for(int i = 1; i<12; i++){ 
            curPos1 = curPos1 + step;
            Vector3d t = new Vector3d(10.0,0.0,-curPos1);
            translationCol.setTranslation(t);
            TransformGroup tgCol = new TransformGroup();
            tgCol.setTransform(translationCol);
            tgCol.addChild(new Colonna(app));
            addChild(tgCol);
        }
        //aggiungo architravi
        //aggiungo architrave sinistro
        Vector3d a = new Vector3d(-10.0,5.0,-24.0);
        translationArc1.setTranslation(a);  
        TransformGroup tgArc1 = new TransformGroup();
        tgArc1.setTransform(translationArc1);
        tgArc1.addChild(new ArcLungo(app));
        addChild(tgArc1);
        //aggiungo architrave destro
        Vector3d b = new Vector3d(10.0,5.0,-24.0);
        translationArc2.setTranslation(b);  
        TransformGroup tgArc2 = new TransformGroup();
        tgArc2.setTransform(translationArc2);
        tgArc2.addChild(new ArcLungo(app));
        addChild(tgArc2);
    }
}
