package com.leff.midi.examples;

import com.leff.midi.*;
import com.leff.midi.event.*;
import java.io.*;
import java.util.*;
import com.leff.midi.util.*;
import com.leff.midi.event.meta.*;

public class MidiManipulation
{
	private static List<MidiEvent>[] channels;
    public static List[] main(String args)
    {
        // 1. Open up a MIDI file/storage/sdcard0/zMidi/80sEPBallad.T160.prs
        MidiFile mf = null;
		channels = new List[16];
        File input = new File(args);
		//File out = new File(input + ".txt");
        try
        {
            mf = new MidiFile(input);
        }
        catch (IOException e)
        {
            try
			{
				throw e;
			}
			catch (IOException eu)
			{}
            return null;
        }
        List<MidiTrack> T = mf.getTracks();
		//PrintWriter p=new PrintWriter(out);
		for (MidiTrack mt :T)
		{
			Iterator<MidiEvent> it = mt.getEvents().iterator();
			while (it.hasNext())
			{
				MidiEvent E = it.next();
				if (E instanceof NoteOn)
				{
					NoteOn on = (NoteOn) E;
					int ch =on.getChannel();
					init(ch);
					channels[ch].add(E);
				}
				else if (E instanceof NoteOff)
				{
					NoteOff off = (NoteOff) E;
					int ch =off.getChannel();
					init(ch);
					channels[ch].add(E);
				}
			}
			//ChannelNotes.printChanel(chNotes);
			//mf.writeToFile(new File(input+"ben"));
		}
        //p.close();
		return channels;
    }

	private static void init(int channel)
	{
				if (channels[channel] == null)
			channels[channel] = new ArrayList();
	}
}
