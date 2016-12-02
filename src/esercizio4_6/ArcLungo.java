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

/**
 *
 * @author francesca
 */
public class ArcLungo extends Group{
    
    protected ArcLungo(Appearance app) {
        Box architrave = new Box(1.0f, 1.2f, 24.0f,Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS,app);
        addChild(architrave);
    }
}