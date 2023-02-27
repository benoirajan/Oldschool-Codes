//////////////////////////////////////////////////////////////////////////////
//	Copyright 2011 Alex Leffelman
//	
//	Licensed under the Apache License, Version 2.0 (the "License");
//	you may not use this file except in compliance with the License.
//	You may obtain a copy of the License at
//	
//	http://www.apache.org/licenses/LICENSE-2.0
//	
//	Unless required by applicable law or agreed to in writing, software
//	distributed under the License is distributed on an "AS IS" BASIS,
//	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//	See the License for the specific language governing permissions and
//	limitations under the License.
//////////////////////////////////////////////////////////////////////////////

package com.leff.midi.event;

public class Controller extends ChannelEvent {
    public Controller(long tick, int channel, int controllerType, int value) {
        super(tick, ChannelEvent.CONTROLLER, channel, controllerType, value);
    }

    public Controller(long tick, long delta, int channel, int controllerType, int value) {
        super(tick, delta, ChannelEvent.CONTROLLER, channel, controllerType, value);
    }

    public int getControllerType() {
        return mValue1;
    }

    public int getValue() {
        return mValue2;
    }

    public void setControllerType(int t) {
        mValue1 = t;
    }

    public void setValue(int v) {
        mValue2 = v;
    }

	public enum Type{
		Bank_Select_MSB_GS,
		Modulation_Wheel,
		Breath,
		_4,
		Foot,
		Portamento_Time,
		Data_Entry_MSB,
		Volume,
		Balance,
		_10,
		Pan,
		Expression,
		Effect_control1,
		Effect_control2,
		_15,
		_16,
		General_Purpose1,
		General_Purpose2,
		General_Purpose3,
		General_Purpose4,
		_21,
		_22,
		_23,
		_24,
		_25,
		_26,
		_27,
		_28,
		_29,
		_30,
		_31,
		_32,
		Bank_Select_LSB_GS,
		Modulation_Wheel_LSB,
		Breath_LSB,
		_36,
		Foot_LSB,
		Portamento_Time_LSB,
		Data_Entry_LSB,
		Volume_LSB,
		Balance_LSB,
		_42,
		Pan_LSB,
		Expression_LSB,
		Effect_control1_LSB,
		Effect_control2_LSB,
		_47,
		_48,
		General_Purpose1_LSB,
		General_Purpose2_LSB,
		General_Purpose3_LSB,
		General_Purpose4_LSB,
		_53,
		_54,
		_55,
		_56,
		_57,
		_58,
		_59,
		_60,
		_61,
		_62,
		_63,
		_64,
		Hold_Pedal1,
		Portamento_GS,
		Sostenuto_GS,
		Soft_Pedal_GS,
		Legato_Pedal,
		Hold_Pedal2,
		Sound_Variation,
		Sound_Timbre,
		Sound_Release_Time,
		Sound_Attack_Time,
		Sound_Brightness,
		Sound_Control6,
		Sound_Control7,
		Sound_Control8,
		Sound_Control9,
		Sound_Control10,
		GP_Control5,
		GP_Control6,
		GP_Control7,
		GP_Control8,
		Portamento_Control_GS,
		_86,
		_87,
		_88,
		_89,
		_90,
		_91,
		Reverb_Level_GS,
		Tremolo_Depth,
		Chorus_Level_GS,
		Celeste_Depth,
		Phaser_Depth,
		Data_Increment,
		Data_Decrement,
		NRPN_Parameter_LSB_GS,
		NRPN_Parameter_MSB_GS,
		RPN_Parameter_LSB,
		RPN_Parameter_MSB,
		_103,
		_104,
		_105,
		_106,
		_107,
		_108,
		_109,
		_110,
		_111,
		_112,
		_113,
		_114,
		_115,
		_116,
		_117,
		_118,
		_119,
		_120,
		All_Sound_Off_GS,
		Reset_All_Controllers,
		Local_On_Off,
		All_Notes_Off,
		Omni_Mode_Off,
		Omni_Mode_On,
		Mono_Mode_On,
		Poly_Mode_ON;
		
		public int value(){
			return this.ordinal();
		}
	}
}
