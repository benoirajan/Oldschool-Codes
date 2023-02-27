package com.leff.midi.examples;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.leff.midi.MidiFile;
import com.leff.midi.MidiTrack;
import com.leff.midi.event.NoteOff;
import com.leff.midi.event.NoteOn;
import com.leff.midi.event.meta.Tempo;
import com.leff.midi.event.meta.TimeSignature;

public class MidiFileFromScratch
{
	static int[] key = {2,2,1,2,2,2,1};
    public static void main(String[] args)
    {
        // 1. Create some MidiTracks
        MidiTrack tempoTrack = new MidiTrack();
        MidiTrack noteTrack = new MidiTrack();

        // 2. Add events to the tracks
        // 2a. Track 0 is typically the tempo map
        TimeSignature ts = new TimeSignature();
        ts.setTimeSignature(4, 4, 12, 8);

        Tempo t = new Tempo();
        t.setBpm(100);

        tempoTrack.insertEvent(ts);
        tempoTrack.insertEvent(t);

		int j=0;
        // 2b. Track 1 will have some notes in it
        for (int i = 0; j < 84;j++)
        {
            int channel = 0, pitch = i+12, velocity = 100;
            NoteOn on = new NoteOn(j * 240, channel, pitch, velocity);
            NoteOn off = new NoteOn(on.getTick()+100, channel, pitch, 0);
            //on.setNoteValue(i + 12);
			//off.setNoteValue(i + 12);
            noteTrack.insertEvent(on);
		    noteTrack.insertEvent(off);
			i+=key[j%7];
            // There is also a utility function for notes that you should use
            // instead of the above.
			// noteTrack.insertNote(channel, pitch+2 , velocity, j * 480, 120);
        }

        // It's best not to manually insert EndOfTrack events; MidiTrack will
        // call closeTrack() on itself before writing itself to a file

        // 3. Create a MidiFile with the tracks we created
        ArrayList<MidiTrack> tracks = new ArrayList<MidiTrack>();
        tracks.add(tempoTrack);
        tracks.add(noteTrack);

        MidiFile midi = new MidiFile(MidiFile.DEFAULT_RESOLUTION, tracks);
        // 4. Write the MIDI data to a file
        
        try
        {
            midi.writeToFile(new File("/sdcard/exampleout.mid"));
        }
        catch (IOException e)
        {
            System.err.println(e);
        }
    }
}
