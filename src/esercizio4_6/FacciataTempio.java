/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio4_6;

import javax.media.j3d.Appearance;
import javax.media.j3d.Group;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3d;

/**
 *
 * @author francesca
 */
class FacciataTempio  extends Group{
    
    protected Transform3D trans = new Transform3D();
    protected Transform3D scale = new Transform3D();
    protected Transform3D translationArc = new Transform3D();
    protected Transform3D translationCol = new Transform3D();
    protected Transform3D translationTimp = new Transform3D();
        
    public FacciataTempio(Appearance app){
        //aggiungo colonne
        double step = 4;
        double curPos = -10.0;
        for(int i = 1; i<7; i++){
           
            Vector3d t = new Vector3d(curPos,0.0,0.0);
            curPos = curPos + step;
            
            translationCol.setTranslation(t);
           
            TransformGroup tgCol = new TransformGroup();
            tgCol.setTransform(translationCol);
            tgCol.addChild(new Colonna(app));
            addChild(tgCol);//aggiunge l'oggetto TG come figlio del BranchGroup
        } 
        //aggiungo architrave
        Vector3d a = new Vector3d(0.0,5.0,0.0);
        translationArc.setTranslation(a);
           
        TransformGroup tgArc = new TransformGroup();
        tgArc.setTransform(translationArc);
        tgArc.addChild(new Architrave(app));
        addChild(tgArc);
        
        //aggiungo timpano
        Vector3d t = new Vector3d(0.0,6.0,0.0);
        translationTimp.setTranslation(t);
           
        TransformGroup tgTimp = new TransformGroup();
        tgTimp.setTransform(translationTimp);
        tgTimp.addChild(new Timpano(app));
        addChild(tgTimp);
    } 
}