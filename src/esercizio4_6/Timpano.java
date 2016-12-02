/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio4_6;

import javax.media.j3d.Appearance;
import javax.media.j3d.Group;
import javax.media.j3d.TransformGroup;

/**
 *
 * @author francesca
 */
class Timpano extends Group{
    public Timpano(Appearance ap){
        TransformGroup timpano = new TransformGroup();     
        PianoFrontale fronte = new PianoFrontale(ap);
        PianoRetro retro = new PianoRetro(ap);
        PianoSotto ps = new PianoSotto(ap);
        timpano.addChild(fronte);
        timpano.addChild(retro);
        timpano.addChild(ps);
        addChild(timpano);
    }
}