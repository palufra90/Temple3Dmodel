/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio4_6;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Primitive;
import javax.media.j3d.Appearance;
import javax.media.j3d.Group;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3d;

/**
 *
 * @author francesca
 */
public class Colonna extends Group{
    protected Transform3D tEchino = new Transform3D();
    protected Transform3D rEchino = new Transform3D();
    Vector3d vEchino = new Vector3d(0.0,3.0,0.0);
    TransformGroup tgEchino = new TransformGroup();
    
    protected Transform3D tFusto = new Transform3D();
    Vector3d vFusto = new Vector3d(0.0,-2.0,0.0);
    TransformGroup tgFusto = new TransformGroup();
        
    Vector3d vAbaco = new Vector3d(0.0,3.7,0.0);
    protected Transform3D tAbaco = new Transform3D();
    TransformGroup tgAbaco = new TransformGroup();
    
    
    public Colonna(Appearance app){
        //creo l'echino       
        TroncoCono echino = new TroncoCono(app);  
        tEchino.setTranslation(vEchino);
        rEchino.rotX(Math.PI);
        tEchino.mul(rEchino);
        tgEchino.setTransform(tEchino);
        tgEchino.addChild(echino);
        addChild(tgEchino);
        //creo l'abaco
        Box abaco = new Box(1.2f, 0.3f, 1.2f,Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS, app);
        tAbaco.setTranslation(vAbaco);
        tgAbaco.setTransform(tAbaco);
        tgAbaco.addChild(abaco);
        addChild(tgAbaco);
        
        //creo il fusto con texture
        Cylinder fusto = new Cylinder(0.8f,10.0f,Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS,app);
        tFusto.setTranslation(vFusto);
        tgFusto.setTransform(tFusto);
        tgFusto.addChild(fusto);
        addChild(tgFusto);
    } 
}
