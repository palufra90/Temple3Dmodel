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
import javax.media.j3d.TextureAttributes;
import javax.media.j3d.TriangleStripArray;
import javax.vecmath.Point3d;
import javax.vecmath.TexCoord2f;

/**
 *
 * @author francesca
 */
public class PianoFrontale extends Shape3D{ 
   protected Point3d v[] = null;
    protected TexCoord2f t[] = null;
    protected TriangleStripArray triangleStrips = null;
    
    public PianoFrontale(Appearance ap){
        //creo la geometry
        v = new Point3d[5];
        v[0] = new Point3d(12.0,0.0,1.4);
        v[1] = new Point3d(0.0,3.0,1.4);
        v[2] = new Point3d(-12.0,0.0,1.4);
        v[3] = new Point3d(0.0,3.0,-1.4);
        v[4] = new Point3d(-12.0,0.0,-1.4);
                
        t = new TexCoord2f[4];
        t[0] = new TexCoord2f(0,0);
        t[1] = new TexCoord2f(1,1);
        t[2] = new TexCoord2f(2f,0);
        t[3] = new TexCoord2f(2f,1f);
        //t[4] = new TexCoord2f(2.5f,0f);*/
        int[] stripCounts = {5};
        triangleStrips = new TriangleStripArray(5, GeometryArray.COORDINATES|GeometryArray.TEXTURE_COORDINATE_2, stripCounts);
        triangleStrips.setCoordinates(0,v);
        triangleStrips.setTextureCoordinates(0,0,t);
        
        GeometryInfo geometryInfo = new GeometryInfo(triangleStrips);
        //genero le normali
        NormalGenerator ng = new NormalGenerator();
	ng.generateNormals(geometryInfo);
         //definisco gli attributi della texture
        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.MODULATE);
        
        ap.setTextureAttributes(texAttr);
	GeometryArray result = geometryInfo.getGeometryArray();
        //restituisco geometria con normali e appearance
        setGeometry(result) ; 
        setAppearance(ap);
    }  
} 