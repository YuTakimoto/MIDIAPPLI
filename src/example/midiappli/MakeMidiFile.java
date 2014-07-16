package example.midiappli;
import java.io.FileInputStream;

import example.midiappli.R;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MakeMidiFile extends Activity
     implements OnClickListener {
 private MediaPlayer mediaPlayer = null;
 private EditText temppo_text;
 private Button button_Play;
 private Button button_Stop;
 @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temppo_text = (EditText)findViewById(R.id.EditText01);
        temppo_text.setText("120");
     button_Play = (Button) findViewById(R.id.Button01);
     button_Play.setOnClickListener(this);
     button_Stop = (Button) findViewById(R.id.Button02);
     button_Stop.setOnClickListener(this);

 }
    private void createMidiFile()
    {
        MidiFileWriter midFile = new MidiFileWriter(getBaseContext());
        try {
         // MIDIファイル作成
         midFile.CreateMidiFile("temp", 4, 480);
         // トラックデータ作成
   // テンポ設定
   int tempo = Integer.valueOf(temppo_text.getText().toString());
   midFile.setTempo(tempo);
   // 音色設定:ピアノ
   //midFile.setProgramChange((byte)0x00, (byte)0x00);
   //midFile.closeTrackData();

 //音色設定:ピアノ
   midFile.setProgramChange((byte)0x00, (byte)0x48);//(チャンネル設定,音色設定)
   midFile.setProgramChange((byte)0x01, (byte)0x34);//(チャンネル設定,音色設定)
   midFile.setProgramChange((byte)0x02, (byte)0x07);//(チャンネル設定,音色設定)
   //midFile.setProgramChange((byte)0x03, (byte)0x05);//(チャンネル設定,音色設定)
//   midFile.setProgramChange((byte)0x04, (byte)0x27);//(チャンネル設定,音色設定)
//   midFile.setProgramChange((byte)0x05, (byte)0x27);//(チャンネル設定,音色設定)
//   midFile.setProgramChange((byte)0x06, (byte)0x27);//(チャンネル設定,音色設定)
//   midFile.setProgramChange((byte)0x07, (byte)0x27);//(チャンネル設定,音色設定)
   midFile.closeTrackData();
   // トラックデータ作成
   // GotandaRPGメインテーマ
   midFile.addNoteOn((byte)0, 0, (byte)MidiFileWriter.NoteNo.E6, (byte)0x7F);
   midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_020), (byte)MidiFileWriter.NoteNo.E6, (byte)0x00);
   midFile.addNoteOn((byte)0, 0, (byte)MidiFileWriter.NoteNo.D6, (byte)0x7F);
   midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.D6, (byte)0x00);
   midFile.addNoteOn((byte)0, 0, (byte)MidiFileWriter.NoteNo.E6, (byte)0x7F);
   midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.E6, (byte)0x00);
   midFile.addNoteOn((byte)0, 0, (byte)MidiFileWriter.NoteNo.G6, (byte)0x7F);
   midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_010), (byte)MidiFileWriter.NoteNo.G6, (byte)0x00);
   midFile.addNoteOn((byte)0, 0, (byte)MidiFileWriter.NoteNo.A6, (byte)0x7F);
   midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.A6, (byte)0x00);
   midFile.addNoteOn((byte)0, 0, (byte)MidiFileWriter.NoteNo.E6, (byte)0x7F);
   midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.E6, (byte)0x00);
   midFile.addNoteOn((byte)0, 0, (byte)MidiFileWriter.NoteNo.D6, (byte)0x7F);
   midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.D6, (byte)0x00);
   midFile.addNoteOn((byte)0, 0, (byte)MidiFileWriter.NoteNo.E6, (byte)0x7F);
   //midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.E6, (byte)0x00);
   //midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.E6, (byte)0x00);
	   //midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_010), (byte)MidiFileWriter.NoteNo.E6, (byte)0x00);
   midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(5.5), (byte)MidiFileWriter.NoteNo.E6, (byte)0x00);



   midFile.addNoteOn((byte)0, 0, (byte)MidiFileWriter.NoteNo.F6, (byte)0x7F);
   midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_030), (byte)MidiFileWriter.NoteNo.F6, (byte)0x00);
   midFile.addNoteOn((byte)0, 0, (byte)MidiFileWriter.NoteNo.E6, (byte)0x7F);
   midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.E6, (byte)0x00);
   midFile.addNoteOn((byte)0, 0, (byte)MidiFileWriter.NoteNo.F6, (byte)0x7F);
   midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.F6, (byte)0x00);
   midFile.addNoteOn((byte)0, 0, (byte)MidiFileWriter.NoteNo.E6, (byte)0x7F);
   midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.E6, (byte)0x00);
   midFile.addNoteOn((byte)0, 0, (byte)MidiFileWriter.NoteNo.F6, (byte)0x7F);
   midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.F6, (byte)0x00);
   midFile.addNoteOn((byte)0, 0, (byte)MidiFileWriter.NoteNo.A6, (byte)0x7F);
   midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.A6, (byte)0x00);
   midFile.addNoteOn((byte)0, 0, (byte)MidiFileWriter.NoteNo.F6, (byte)0x7F);
   midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.F6, (byte)0x00);
   midFile.addNoteOn((byte)0, 0, (byte)MidiFileWriter.NoteNo.E6, (byte)0x7F);
   midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.E6, (byte)0x00);
   midFile.addNoteOn((byte)0, 0, (byte)MidiFileWriter.NoteNo.E6, (byte)0x7F);
   midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.E6, (byte)0x00);
   																		//休符
   midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.E6, (byte)0x00);
   midFile.addNoteOn((byte)0, 0, (byte)MidiFileWriter.NoteNo.D6, (byte)0x7F);
   //midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.D6, (byte)0x00);
   //midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.D6, (byte)0x00);
   midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(6.0), (byte)MidiFileWriter.NoteNo.D6, (byte)0x00);
   midFile.closeTrackData();


   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.C2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.C2, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.C2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.C2, (byte)0x00);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.C2, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.C2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.C2, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.C2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.C2, (byte)0x00);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.C2, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.G1, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.G1, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.E2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.E2, (byte)0x00);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.E2, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.G1, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.G1, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.C2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.C2, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.C2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.C2, (byte)0x00);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.C2, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.C2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.C2, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.C2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.C2, (byte)0x00);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.C2, (byte)0x00);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_035), (byte)MidiFileWriter.NoteNo.C2, (byte)0x00);


   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.A1, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.A1, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.A1, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.A1, (byte)0x00);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.A1, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.A1, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.A1, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.A1, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.A1, (byte)0x00);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.A1, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.E1, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.E1, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.C2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.C2, (byte)0x00);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.C2, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.E1, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.E1, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.A1, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.A1, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.A1, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.A1, (byte)0x00);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.A1, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.A1, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.A1, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.A1, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.A1, (byte)0x00);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.A1, (byte)0x00);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_035), (byte)MidiFileWriter.NoteNo.A1, (byte)0x00);

   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.F2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.F2, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.F2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.F2, (byte)0x00);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.F2, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.F2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.F2, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.F2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.F2, (byte)0x00);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.F2, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.F2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.F2, (byte)0x00);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.F2, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.C2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.C2, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.F2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.F2, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.F2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.F2, (byte)0x00);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.F2, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.F2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.F2, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.F2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.F2, (byte)0x00);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.F2, (byte)0x00);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_035), (byte)MidiFileWriter.NoteNo.F2, (byte)0x00);

   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.D2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.D2, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.D2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.D2, (byte)0x00);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.D2, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.D2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.D2, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.D2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.D2, (byte)0x00);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.D2, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.B1, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.B1, (byte)0x00);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.B1, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.G1, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.G1, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.D2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.D2, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.D2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.D2, (byte)0x00);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.D2, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.D2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.D2, (byte)0x00);
   midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.D2, (byte)0x7F);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.D2, (byte)0x00);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.D2, (byte)0x00);
   midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_035), (byte)MidiFileWriter.NoteNo.D2, (byte)0x00);
   midFile.closeTrackData();

//   //CM7
   midFile.addNoteOn((byte)2, 0, (byte)MidiFileWriter.NoteNo.E3, (byte)0x7F);
   midFile.addNoteOn((byte)2, 10, (byte)MidiFileWriter.NoteNo.C4, (byte)0x7F);
   midFile.addNoteOn((byte)2, 20, (byte)MidiFileWriter.NoteNo.E4, (byte)0x7F);
   midFile.addNoteOn((byte)2, 30, (byte)MidiFileWriter.NoteNo.G4, (byte)0x7F);
   midFile.addNoteOn((byte)2, 40, (byte)MidiFileWriter.NoteNo.B4, (byte)0x7F);
   midFile.addNoteOn((byte)2, 50, (byte)MidiFileWriter.NoteNo.E5, (byte)0x7F);
   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_035), (byte)MidiFileWriter.NoteNo.E3, (byte)0x00);
   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(1.24), (byte)MidiFileWriter.NoteNo.C4, (byte)0x00);
   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(1.24), (byte)MidiFileWriter.NoteNo.E4, (byte)0x00);
   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(1.24), (byte)MidiFileWriter.NoteNo.G4, (byte)0x00);
   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(1.24), (byte)MidiFileWriter.NoteNo.B4, (byte)0x00);
   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(1.24), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);

   //midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
   //midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_010), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
   //midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_030), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
   //midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);

//   midFile.addNoteOn((byte)2, 0, (byte)MidiFileWriter.NoteNo.E3, (byte)0x7F);
//   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.E3, (byte)0x00);
//   midFile.addNoteOn((byte)2, 0, (byte)MidiFileWriter.NoteNo.C4, (byte)0x7F);
//   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.C4, (byte)0x00);
//   midFile.addNoteOn((byte)2, 0, (byte)MidiFileWriter.NoteNo.E4, (byte)0x7F);
//   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.E4, (byte)0x00);
//   midFile.addNoteOn((byte)2, 0, (byte)MidiFileWriter.NoteNo.G4, (byte)0x7F);
//   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.G4, (byte)0x00);
//   midFile.addNoteOn((byte)2, 0, (byte)MidiFileWriter.NoteNo.B4, (byte)0x7F);
//   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.B4, (byte)0x00);
//   midFile.addNoteOn((byte)2, 0, (byte)MidiFileWriter.NoteNo.E5, (byte)0x7F);
//   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
//   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_010), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
//   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_030), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
//   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);


   //Am7
   midFile.addNoteOn((byte)2, 0, (byte)MidiFileWriter.NoteNo.A3, (byte)0x7F);
   midFile.addNoteOn((byte)2, 10, (byte)MidiFileWriter.NoteNo.E4, (byte)0x7F);
   midFile.addNoteOn((byte)2, 20, (byte)MidiFileWriter.NoteNo.G4, (byte)0x7F);
   midFile.addNoteOn((byte)2, 30, (byte)MidiFileWriter.NoteNo.C5, (byte)0x7F);
   midFile.addNoteOn((byte)2, 40, (byte)MidiFileWriter.NoteNo.E5, (byte)0x7F);
   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(1.532), (byte)MidiFileWriter.NoteNo.A3, (byte)0x00);
   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(1.532), (byte)MidiFileWriter.NoteNo.E4, (byte)0x00);
   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(1.532), (byte)MidiFileWriter.NoteNo.G4, (byte)0x00);
   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(1.532), (byte)MidiFileWriter.NoteNo.C5, (byte)0x00);
   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(1.532), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
   //midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_030), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
   //midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_010), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
   //midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_060), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
//   //FM7
   midFile.addNoteOn((byte)2, 0, (byte)MidiFileWriter.NoteNo.A3, (byte)0x7F);
   midFile.addNoteOn((byte)2, 10, (byte)MidiFileWriter.NoteNo.F4, (byte)0x7F);
   midFile.addNoteOn((byte)2, 20, (byte)MidiFileWriter.NoteNo.A4, (byte)0x7F);
   midFile.addNoteOn((byte)2, 30, (byte)MidiFileWriter.NoteNo.C5, (byte)0x7F);
   midFile.addNoteOn((byte)2, 40, (byte)MidiFileWriter.NoteNo.E5, (byte)0x7F);
   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(1.55), (byte)MidiFileWriter.NoteNo.A3, (byte)0x00);
   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(1.55), (byte)MidiFileWriter.NoteNo.F4, (byte)0x00);
   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(1.55), (byte)MidiFileWriter.NoteNo.A4, (byte)0x00);
   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(1.55), (byte)MidiFileWriter.NoteNo.C5, (byte)0x00);
   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(1.55), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
 //midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_030), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
 //midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_010), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
 //midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_060), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
   //D7
   midFile.addNoteOn((byte)2, 0, (byte)MidiFileWriter.NoteNo.D4, (byte)0x7F);
   midFile.addNoteOn((byte)2, 10, (byte)MidiFileWriter.NoteNo.A4, (byte)0x7F);
   midFile.addNoteOn((byte)2, 20, (byte)MidiFileWriter.NoteNo.C5, (byte)0x7F);
   midFile.addNoteOn((byte)2, 30, (byte)MidiFileWriter.NoteNo.FF5, (byte)0x7F);
   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_035), (byte)MidiFileWriter.NoteNo.D4, (byte)0x00);
   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_035), (byte)MidiFileWriter.NoteNo.A4, (byte)0x00);
   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_035), (byte)MidiFileWriter.NoteNo.C5, (byte)0x00);
   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_035), (byte)MidiFileWriter.NoteNo.FF5, (byte)0x00);
 //midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_030), (byte)MidiFileWriter.NoteNo.FF5, (byte)0x00);
 //midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_010), (byte)MidiFileWriter.NoteNo.FF5, (byte)0x00);
 //midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_060), (byte)MidiFileWriter.NoteNo.FF5, (byte)0x00);
   midFile.closeTrackData();


   midFile.addNoteOn((byte)3, 0, (byte)MidiFileWriter.NoteNo.E5, (byte)0x7F);
   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_020), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
   midFile.addNoteOn((byte)3, 0, (byte)MidiFileWriter.NoteNo.D5, (byte)0x7F);
   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.D5, (byte)0x00);
   midFile.addNoteOn((byte)3, 0, (byte)MidiFileWriter.NoteNo.E5, (byte)0x7F);
   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
   midFile.addNoteOn((byte)3, 0, (byte)MidiFileWriter.NoteNo.G5, (byte)0x7F);
   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_010), (byte)MidiFileWriter.NoteNo.G5, (byte)0x00);
   midFile.addNoteOn((byte)3, 0, (byte)MidiFileWriter.NoteNo.A5, (byte)0x7F);
   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.A5, (byte)0x00);
   midFile.addNoteOn((byte)3, 0, (byte)MidiFileWriter.NoteNo.E5, (byte)0x7F);
   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
   midFile.addNoteOn((byte)3, 0, (byte)MidiFileWriter.NoteNo.D5, (byte)0x7F);
   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.D5, (byte)0x00);
   midFile.addNoteOn((byte)3, 0, (byte)MidiFileWriter.NoteNo.E5, (byte)0x7F);
   //midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.E6, (byte)0x00);
   //midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.E6, (byte)0x00);
	   //midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_010), (byte)MidiFileWriter.NoteNo.E6, (byte)0x00);
   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(5.5), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);



   midFile.addNoteOn((byte)3, 0, (byte)MidiFileWriter.NoteNo.F5, (byte)0x7F);
   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_030), (byte)MidiFileWriter.NoteNo.F5, (byte)0x00);
   midFile.addNoteOn((byte)3, 0, (byte)MidiFileWriter.NoteNo.E5, (byte)0x7F);
   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
   midFile.addNoteOn((byte)3, 0, (byte)MidiFileWriter.NoteNo.F5, (byte)0x7F);
   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.F5, (byte)0x00);
   midFile.addNoteOn((byte)3, 0, (byte)MidiFileWriter.NoteNo.E5, (byte)0x7F);
   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
   midFile.addNoteOn((byte)3, 0, (byte)MidiFileWriter.NoteNo.F5, (byte)0x7F);
   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.F5, (byte)0x00);
   midFile.addNoteOn((byte)3, 0, (byte)MidiFileWriter.NoteNo.A5, (byte)0x7F);
   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.A5, (byte)0x00);
   midFile.addNoteOn((byte)3, 0, (byte)MidiFileWriter.NoteNo.F5, (byte)0x7F);
   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.F5, (byte)0x00);
   midFile.addNoteOn((byte)3, 0, (byte)MidiFileWriter.NoteNo.E5, (byte)0x7F);
   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
   midFile.addNoteOn((byte)3, 0, (byte)MidiFileWriter.NoteNo.E5, (byte)0x7F);
   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
   																		//休符
   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
   midFile.addNoteOn((byte)3, 0, (byte)MidiFileWriter.NoteNo.D5, (byte)0x7F);
   //midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.D6, (byte)0x00);
   //midFile.addNoteOn((byte)0, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.D6, (byte)0x00);
   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(6.0), (byte)MidiFileWriter.NoteNo.D5, (byte)0x00);
   midFile.closeTrackData();

////ギター
//   midFile.addNoteOn((byte)2, 0, (byte)MidiFileWriter.NoteNo.E3, (byte)0x7F);
//   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_010), (byte)MidiFileWriter.NoteNo.E3, (byte)0x00);
//   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_010), (byte)MidiFileWriter.NoteNo.E3, (byte)0x00);
//
//   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.C4, (byte)0x00);
//   midFile.addNoteOn((byte)3, 0, (byte)MidiFileWriter.NoteNo.C4, (byte)0x7F);
//   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_010), (byte)MidiFileWriter.NoteNo.C4, (byte)0x00);
//   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_020), (byte)MidiFileWriter.NoteNo.C4, (byte)0x00);
//   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_060), (byte)MidiFileWriter.NoteNo.C4, (byte)0x00);
//   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.C4, (byte)0x00);
//
//
//   midFile.addNoteOn((byte)4, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.E4, (byte)0x00);
//   midFile.addNoteOn((byte)4, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.E4, (byte)0x00);
//   midFile.addNoteOn((byte)4, 0, (byte)MidiFileWriter.NoteNo.E4, (byte)0x7F);
//   midFile.addNoteOn((byte)4, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_010), (byte)MidiFileWriter.NoteNo.E4, (byte)0x00);
//   midFile.addNoteOn((byte)4, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_020), (byte)MidiFileWriter.NoteNo.E4, (byte)0x00);
//   midFile.addNoteOn((byte)4, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_060), (byte)MidiFileWriter.NoteNo.E4, (byte)0x00);
//
//   midFile.addNoteOn((byte)5, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.G4, (byte)0x00);
//   midFile.addNoteOn((byte)5, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.G4, (byte)0x00);
//   midFile.addNoteOn((byte)5, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.G4, (byte)0x00);
//   midFile.addNoteOn((byte)5, 0, (byte)MidiFileWriter.NoteNo.G4, (byte)0x7F);
//   midFile.addNoteOn((byte)5, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_010), (byte)MidiFileWriter.NoteNo.G4, (byte)0x00);
//   midFile.addNoteOn((byte)5, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_020), (byte)MidiFileWriter.NoteNo.G4, (byte)0x00);
//   midFile.addNoteOn((byte)5, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.G4, (byte)0x00);
//   midFile.addNoteOn((byte)5, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.G4, (byte)0x00);
//
//
//   midFile.addNoteOn((byte)6, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.B4, (byte)0x00);
//   midFile.addNoteOn((byte)6, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.B4, (byte)0x00);
//   midFile.addNoteOn((byte)6, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.B4, (byte)0x00);
//   midFile.addNoteOn((byte)6, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.B4, (byte)0x00);
//   midFile.addNoteOn((byte)6, 0, (byte)MidiFileWriter.NoteNo.B4, (byte)0x7F);
//   midFile.addNoteOn((byte)6, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_010), (byte)MidiFileWriter.NoteNo.B4, (byte)0x00);
//   midFile.addNoteOn((byte)6, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_020), (byte)MidiFileWriter.NoteNo.B4, (byte)0x00);
//   midFile.addNoteOn((byte)6, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.B4, (byte)0x00);
//
//
//   midFile.addNoteOn((byte)7, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
//   midFile.addNoteOn((byte)7, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
//   midFile.addNoteOn((byte)7, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
//   midFile.addNoteOn((byte)7, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
//   midFile.addNoteOn((byte)7, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
//   midFile.addNoteOn((byte)7, 0, (byte)MidiFileWriter.NoteNo.E5, (byte)0x7F);
//   midFile.addNoteOn((byte)7, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_010), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
//   midFile.addNoteOn((byte)7, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_020), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
//   midFile.addNoteOn((byte)7, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
//
//   midFile.closeTrackData();
////////
////
////
//   midFile.addNoteOn((byte)2, 0, (byte)MidiFileWriter.NoteNo.A3, (byte)0x7F);
//   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_010), (byte)MidiFileWriter.NoteNo.A3, (byte)0x00);
//   midFile.addNoteOn((byte)2, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_010), (byte)MidiFileWriter.NoteNo.A3, (byte)0x00);
//   midFile.closeTrackData();
//
//
//   midFile.addNoteOn((byte)3, 0, (byte)MidiFileWriter.NoteNo.E4, (byte)0x7F);
//   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_010), (byte)MidiFileWriter.NoteNo.E4, (byte)0x00);
//   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_020), (byte)MidiFileWriter.NoteNo.E4, (byte)0x00);
//   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_060), (byte)MidiFileWriter.NoteNo.E4, (byte)0x00);
//   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.E4, (byte)0x00);
//   midFile.addNoteOn((byte)3, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.E4, (byte)0x00);
//   midFile.closeTrackData();
//
//
//   midFile.addNoteOn((byte)4, 0, (byte)MidiFileWriter.NoteNo.G4, (byte)0x7F);
//   midFile.addNoteOn((byte)4, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_010), (byte)MidiFileWriter.NoteNo.G4, (byte)0x00);
//   midFile.addNoteOn((byte)4, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_020), (byte)MidiFileWriter.NoteNo.G4, (byte)0x00);
//   midFile.addNoteOn((byte)4, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_060), (byte)MidiFileWriter.NoteNo.G4, (byte)0x00);
//   midFile.addNoteOn((byte)4, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.G4, (byte)0x00);
//   midFile.addNoteOn((byte)4, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.G4, (byte)0x00);
//   midFile.closeTrackData();
//
//
//   midFile.addNoteOn((byte)5, 0, (byte)MidiFileWriter.NoteNo.C5, (byte)0x7F);
//   midFile.addNoteOn((byte)5, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_010), (byte)MidiFileWriter.NoteNo.C5, (byte)0x00);
//   midFile.addNoteOn((byte)5, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_020), (byte)MidiFileWriter.NoteNo.C5, (byte)0x00);
//   midFile.addNoteOn((byte)5, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.C5, (byte)0x00);
//   midFile.addNoteOn((byte)5, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.C5, (byte)0x00);
//   midFile.addNoteOn((byte)5, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.C5, (byte)0x00);
//   midFile.addNoteOn((byte)5, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.C5, (byte)0x00);
//   midFile.addNoteOn((byte)5, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.C5, (byte)0x00);
//   midFile.closeTrackData();
//
//
//   midFile.addNoteOn((byte)6, 0, (byte)MidiFileWriter.NoteNo.E5, (byte)0x7F);
//   midFile.addNoteOn((byte)6, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_010), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
//   midFile.addNoteOn((byte)6, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_020), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
//   midFile.addNoteOn((byte)6, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
//   midFile.addNoteOn((byte)6, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
//   midFile.addNoteOn((byte)6, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
//   midFile.addNoteOn((byte)6, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
//   midFile.addNoteOn((byte)6, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_320), (byte)MidiFileWriter.NoteNo.E5, (byte)0x00);
//   midFile.closeTrackData();


  } catch (Exception e) {
   // TODO 自動生成された catch ブロック
   e.printStackTrace();
  }

//        try {
//            // MIDIファイル作成
//            midFile.CreateMidiFile("temp", 2, 480);
//            // トラックデータ作成
//      // テンポ設定
//      int tempo = Integer.valueOf(temppo_text.getText().toString());
//      midFile.setTempo(tempo);
//      midFile.setProgramChange((byte)0x01, (byte)0x39);//(チャンネル設定,音色設定)
//      midFile.closeTrackData();

//      midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.C2, (byte)0x7F);
//      midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.C2, (byte)0x00);
//      midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.C2, (byte)0x7F);
//      midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.C2, (byte)0x00);
//      midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_040), (byte)MidiFileWriter.NoteNo.C2, (byte)0x00);
//      midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.C2, (byte)0x7F);
//      midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.C2, (byte)0x00);
//      midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.C2, (byte)0x7F);
//      midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.C2, (byte)0x00);
//      midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_030), (byte)MidiFileWriter.NoteNo.C2, (byte)0x00);
//      midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.G1, (byte)0x7F);
//      midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.G1, (byte)0x00);
//      midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.E2, (byte)0x7F);
//      midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.E2, (byte)0x00);
//      midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_160), (byte)MidiFileWriter.NoteNo.C2, (byte)0x00);
//      midFile.addNoteOn((byte)1, 0, (byte)MidiFileWriter.NoteNo.G1, (byte)0x7F);
//      midFile.addNoteOn((byte)1, midFile.getNoteDeltaTime(MidiFileWriter.NoteTime.Note_080), (byte)MidiFileWriter.NoteNo.G1, (byte)0x00);
//      midFile.closeTrackData();

//        } catch (Exception e) {
//        	   // TODO 自動生成された catch ブロック
//        	   e.printStackTrace();
//        	  }


  if (midFile != null)
  {
   // MIDIファイル作成完了
   midFile.Release();
  }
    }
 @Override
 public void onClick(View v) {
  if (v == button_Play) {
   // 再生してなかったら
    if (mediaPlayer == null) {
     // midファイルの作成
     createMidiFile();
     // メディアプレイヤーの作成
     FileInputStream fis = null;
     mediaPlayer = new MediaPlayer();
     try {
      fis = new FileInputStream("/data/data/example.midiappli/files/temp.mid");
      if (fis != null){
       mediaPlayer.setDataSource(fis.getFD());
      }
      mediaPlayer.prepare();
     } catch (Exception e) {
      // TODO 自動生成された catch ブロック
      e.printStackTrace();
     }
     // ループ再生の設定
     mediaPlayer.setLooping(true);
    }

    if (!mediaPlayer.isPlaying())
    {
     // MediaPlayerの再生
     mediaPlayer.start();
    }
   }
   else if (v == button_Stop) {
    // 再生してたら
    if (mediaPlayer != null) {
     // MediaPlayerの停止
     mediaPlayer.stop();
     try {
      mediaPlayer.release();
      mediaPlayer = null;
     } catch (Exception e) {
     }
    }
   }
 }
}
