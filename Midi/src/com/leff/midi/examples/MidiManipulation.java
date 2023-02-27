package com.leff.midi.examples;

import com.leff.midi.*;
import com.leff.midi.event.*;
import java.io.*;
import java.util.*;
import com.leff.midi.util.*;
import com.leff.midi.event.meta.*;

public class MidiManipulation {
	static int a[]=new int[20];
    public static void main(String[] args) throws IOException {

        MidiFile mf = null;
        File input = new File(
			"/storage/emulated/0/Midi/mahal premam_2.mid"
		);
		mf = new MidiFile(input);
		System.out.println("started");
        List<MidiTrack> T = mf.getTracks();
		PrintWriter p=new PrintWriter(input + ".csv");
		p.println("Res "+ mf.getResolution()+" length "+mf.getLengthInTicks());
		p.println("Tick,Delta,Type,Value1,Value2,channel");
		for (MidiTrack mt :T) {
			Iterator<MidiEvent> it = mt.getEvents().iterator();
			while (it.hasNext()) {
				MidiEvent E = it.next();
				p.println(E.toString());
			}
		}
        p.close();
		System.out.println("Done");
    }
}
