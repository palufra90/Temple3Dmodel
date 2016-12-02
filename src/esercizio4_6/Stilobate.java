/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio4_6;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Primitive;
import javax.media.j3d.Appearance;
import javax.media.j3d.Group;
import javax.media.j3d.Material;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;

/**
 *
 * @author francesca
 */
class Stilobate extends Group{
    protected Transform3D grad1 = new Transform3D();
    protected TransformGroup g1 = new TransformGroup(grad1);
    protected Transform3D grad2 = new Transform3D();
    protected TransformGroup g2 = new TransformGroup(grad2);
    protected Transform3D grad3 = new Transform3D();
    protected TransformGroup g3 = new TransformGroup(grad3);
    protected Stilobate(Appearance app) {
        
        Box gradino1 = new Box(11.0f, 0.3f, 25.5f,Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS,app);
        Box gradino2 = new Box(11.5f, 0.3f, 26.0f,Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS,app);
        Box gradino3 = new Box(12.0f, 0.3f, 26.5f,Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS,app);
        grad1.setTranslation(new Vector3d(0.0,0.0,-20.0));
        g1.setTransform(grad1);
        g1.addChild(gradino1);
        addChild(g1);
        
        grad2.setTranslation(new Vector3d(0.0,-0.6,-20.0));
        g2.setTransform(grad2);
        g2.addChild(gradino2);
        addChild(g2);
        
        grad3.setTranslation(new Vector3d(0.0,-1.2,-20.0));
        g3.setTransform(grad3);
        g3.addChild(gradino3);
        addChild(g3);
    }
}