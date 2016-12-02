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
class Architrave  extends Group{
    
    protected Architrave(Appearance app) {
        
        Box stilobate = new Box(11.0f, 1.0f, 1.2f,Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS,app);
        addChild(stilobate);
    }
}