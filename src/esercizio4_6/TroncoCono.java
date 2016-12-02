/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio4_6;

import com.sun.j3d.utils.geometry.GeometryInfo;
import com.sun.j3d.utils.geometry.NormalGenerator;
import javax.media.j3d.Appearance;
import javax.media.j3d.GeometryArray;
import javax.media.j3d.Shape3D;
import javax.media.j3d.TriangleStripArray;
import javax.vecmath.Point3f;
import javax.vecmath.TexCoord2f;

/**
 *
 * @author francesca
 */
public class TroncoCono extends Shape3D{

    public static final float TOP = 0.5f;
    public static final float BOTTOM = -0.5f;
    
    protected Point3f v[] = null;
    protected TexCoord2f t[] = null;
    protected TriangleStripArray triangleStrips = null;
       
    public TroncoCono(Appearance ap){
        //creo la geometry
        v = new Point3f[(20+1)*2];
        t = new TexCoord2f[(20+1)*2];
        for (int i=0; i<20; i++){
            double angle = 2.0*Math.PI*(double)i/(double)20;
            float x = (float)Math.sin(angle);
            float z = (float)Math.cos(angle);
            v[i*2+1] = new Point3f(x,BOTTOM,z);
            v[i*2] = new Point3f(x*0.6f,TOP,z*0.6f);
            // calcolo delle coordinate di texture
            t[i*2+1] = new TexCoord2f((float)(i/(float)20),0.0f);
            t[i*2] = new TexCoord2f((float)(i/(float)20),1.0f);
        }
        v[20*2+1] = new Point3f(0.0f,BOTTOM,1.0f);
        v[20*2] = new Point3f(0.0f,TOP,0.6f);
        t[20*2+1] = new TexCoord2f((float)1,0.0f);
        t[20*2] = new TexCoord2f((float)1,1.0f);
        int[] stripCounts = {(20+1)*2};
        triangleStrips = new TriangleStripArray((20+1)*2, GeometryArray.COORDINATES|GeometryArray.TEXTURE_COORDINATE_2, stripCounts);
        triangleStrips.setCoordinates(0,v);
        triangleStrips.setTextureCoordinates(0,0,t);
                
        GeometryInfo geometryInfo = new GeometryInfo(triangleStrips);
        //genero le normali
        NormalGenerator ng = new NormalGenerator();
	ng.generateNormals(geometryInfo);
       
	GeometryArray result = geometryInfo.getGeometryArray();
        //restituisco geometria con normali e appearance
        setGeometry(result) ; 
        setAppearance(ap);
    }  
}
