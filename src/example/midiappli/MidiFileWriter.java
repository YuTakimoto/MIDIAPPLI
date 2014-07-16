package example.midiappli;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import android.content.Context;


public class MidiFileWriter {
 private String FILE_ID = ".mid";
 //          M    T    h    d
 private byte[] HEADER_TAG = {0x4d,0x54,0x68,0x64};
 private byte[] HEADER_DATA_LEN = {0x00,0x00,0x00,0x06};
 private byte[] MIDI_FORMAT = {0x00,0x01};
 //         M    T    r    k
 private byte[] TRACK_TAG = {0x4d,0x54,0x72,0x6b};
 private byte[] TRACK_END = {0x00,(byte)0xff,0x2f,0x00};


 private FileOutputStream fos = null;
 private Context context = null;
 private ArrayList<TrackData> TrackDataList = new ArrayList<TrackData>();
 private int quarterNoteDeltaTime;

 //*************************************************************************
 // �R���X�g���N�^
 //*************************************************************************
 public MidiFileWriter(Context contxt)
 {
  context = contxt;
 }

 //*************************************************************************
 // MIDI�t�@�C���쐬
 //*************************************************************************
 public boolean CreateMidiFile(String fileName ,int trackNo ,int deltaTime) throws IOException
 {
  if (fos != null)
  {
   return false;
  }
  String flname = fileName+FILE_ID;
  quarterNoteDeltaTime = deltaTime;

  try {
   // �t�@�C���쐬
   fos = context.openFileOutput(flname, Context.MODE_WORLD_WRITEABLE);
   // �w�b�_
   fos.write(HEADER_TAG);
   // �f�[�^�T�C�Y
   fos.write(HEADER_DATA_LEN);
   // �f�[�^�t�H�[�}�b�g
   fos.write(MIDI_FORMAT);

   // �g���b�N��
   byte work = (byte)((trackNo & 0x0000ff00) >> 8);
   fos.write(work);
   work = (byte)(trackNo & 0x000000ff);
   fos.write(work);

   // �f���^�^�C��
   work = (byte)((deltaTime & 0x0000ff00) >> 8);
   fos.write(work);
   work = (byte)(deltaTime & 0x000000ff);
   fos.write(work);

  } catch (FileNotFoundException e) {
   // TODO �����������ꂽ catch �u���b�N
   e.printStackTrace();

   // �㏈��
   Release();
   return false;
  }

  return true;
 }
 //*************************************************************************
 // �e���|��ݒ�
 //*************************************************************************
 public void setTempo(int tempo)
 {
  int tempoTime = 60000000 / tempo;
  TrackData trackData = new TrackData();
  trackData.length = 7;
  trackData.data = new byte[7];
  trackData.data[0] = (byte)0x00;
  trackData.data[1] = (byte)0xff;
  trackData.data[2] = (byte)0x51;
  trackData.data[3] = (byte)0x03;

  byte work = (byte)((tempoTime & 0x00ff0000) >> 16);
  trackData.data[4] = work;
  work = (byte)((tempoTime & 0x0000ff00) >> 8);
  trackData.data[5] = work;
  work = (byte)(tempoTime & 0x000000ff);
  trackData.data[6] = work;

  TrackDataList.add(trackData);
 }

 //*************************************************************************
 // �v���O�����`�F���W
 //*************************************************************************
 public void setProgramChange(byte ch, byte no)
 {
  TrackData trackData = new TrackData();
  trackData.length = 3;
  trackData.data = new byte[4];
  trackData.data[0] = (byte)0x00;
  trackData.data[1] = (byte)(0xc0 | ch);
  trackData.data[2] = (byte)no;

  TrackDataList.add(trackData);
 }

 //*************************************************************************
 // Track�f�[�^�ǉ�
 //*************************************************************************
 public void addTrackData(byte[] data, int length)
 {
  if (length <= 0)
  {
   return;
  }

  TrackData trackData = new TrackData();
  trackData.length = length;
  trackData.data = new byte[length];

  for(int i = 0; i < length; i++)
  {
   trackData.data[i] = data[i];
  }
  TrackDataList.add(trackData);
 }

 //*************************************************************************
 // �m�[�g�I��
 //*************************************************************************
 public void addNoteOn(byte chNo, int deltaTime, byte noteNo, byte velocity)
 {
  byte[] dltime = deltaTime(deltaTime);
  int dataLen = dltime.length + 3;
  byte data[] = new byte[dataLen];

  for(int i = 0; i < dltime.length; i++)
  {
   data[i] = dltime[i];
  }

  data[dltime.length + 0] = (byte)(0x90 | chNo);
  data[dltime.length + 1] = (byte)noteNo;
  data[dltime.length + 2] = (byte)velocity;

  addTrackData(data, dataLen);
 }

 //*************************************************************************
 // Track�f�[�^�N���[�Y
 //*************************************************************************
 public void closeTrackData()
 {
  int dataLen = 4;    // �f�[�^���@�f�[�^�I�[�f�[�^�T�C�Y�������l�Ƃ���
  for(int i=0; i < TrackDataList.size(); i++)
  {
   dataLen += TrackDataList.get(i).length;
  }
  try {
   // Track�w�b�_
   fos.write(TRACK_TAG);
   // �f�[�^�T�C�Y
   byte work = (byte)((dataLen & 0xff000000) >> 24);
   fos.write(work);
   work = (byte)((dataLen & 0x00ff0000) >> 16);
   fos.write(work);
   work = (byte)((dataLen & 0x0000ff00) >> 8);
   fos.write(work);
   work = (byte)(dataLen & 0x000000ff);
   fos.write(work);
   // Track�f�[�^�W�J
   for(int i=0; i < TrackDataList.size(); i++)
   {
    for(int c=0; c < TrackDataList.get(i).length; c++)
    {
     fos.write(TrackDataList.get(i).data[c]);
    }
   }

   // Track�I�[
   fos.write(TRACK_END);
  } catch (IOException e) {
   // TODO �����������ꂽ catch �u���b�N
   e.printStackTrace();
  }
  clearTrackData();
 }

 //*************************************************************************
 // MIDI�t�@�C���쐬����
 //*************************************************************************
 public void Release()
 {
  if (fos != null)
  {
   return;
  }
  try {
   fos.close();
  } catch (IOException e) {
   // TODO �����������ꂽ catch �u���b�N
   e.printStackTrace();
  }
  fos = null;
 }

 //*************************************************************************
 // �����̃f���^�^�C�����v�Z
 //*************************************************************************
 public int getNoteDeltaTime(double noteTime)
 {
  return (int)(quarterNoteDeltaTime * noteTime);
 }

 //*************************************************************************
 // Track�f�[�^�N���A
 //*************************************************************************
 private void clearTrackData()
 {
  TrackDataList.clear();
 }
 //*************************************************************************
 // �f���^�^�C���̌v�Z
 //*************************************************************************
 private byte[] deltaTime(int deltaTime)
 {
  int size = 1;
  if (deltaTime >= 0x00200000)
  {
   size = 4;
  }
  else if (deltaTime >= 0x00004000)
  {
   size = 3;
  }
  else if (deltaTime >= 0x00000080)
  {
   size = 2;
  };
  byte[] dltTime = new byte[size];
  if (dltTime == null)
  {
   return null;
  }

  int workDeltaTime = deltaTime;
  for(int i=(size-1); i >= 0; i--)
  {
   byte work = (byte)(workDeltaTime & 0x0000007f);
   dltTime[i] = (byte)(work | 0x80);
   workDeltaTime -= work;
   workDeltaTime >>= 7;
  }

  dltTime[(size-1)] = (byte)(dltTime[(size-1)] & 0x7f);
  return dltTime;
 }
 //*************************************************************************
 // Track�f�[�^
 //*************************************************************************
 protected class TrackData
 {
  protected int length = 0;
  protected byte[] data;
 }
 //*************************************************************************
 // ����
 //*************************************************************************
 public class NoteTime {
  public final static double Note_010 = 4; // �S����
  public final static double Note_020 = 3; //�@�t�_2������
  public final static double Note_030 = 2; //�@2������
  public final static double Note_035 = 1.5; //�@�t�_4������
  public final static double Note_040 = 1; //�@4������
  public final static double Note_060 = 0.75; // �t�_8������
  public final static double Note_080 = 0.5; // 8������
  public final static double Note_120 = 0.375; // �t�_16������
  public final static double Note_160 = 0.25; // 16������
  public final static double Note_320 = 0.125;//32������
 }

 //*************************************************************************
 // �m�[�g�i���o�[
 //*************************************************************************
 public class NoteNo {
  public final static int C0 = 12;
  public final static int CC0 = 13;
  public final static int D0 = 14;
  public final static int DD0 = 15;
  public final static int E0 = 16;
  public final static int F0 = 17;
  public final static int FF0 = 18;
  public final static int G0 = 19;
  public final static int GG0 = 20;
  public final static int A0 = 21;
  public final static int AA0 = 22;
  public final static int B0 = 23;

  public final static int C1 = 24;
  public final static int CC1 = 25;
  public final static int D1 = 26;
  public final static int DD1 = 27;
  public final static int E1 = 28;
  public final static int F1 = 29;
  public final static int FF1 = 30;
  public final static int G1 = 31;
  public final static int GG1 = 32;
  public final static int A1 = 33;
  public final static int AA1 = 34;
  public final static int B1 = 35;
  public final static int C2 = 36;
  public final static int CC2 = 37;
  public final static int D2 = 38;
  public final static int DD2 = 39;
  public final static int E2 = 40;
  public final static int F2 = 41;
  public final static int FF2 = 42;
  public final static int G2 = 43;
  public final static int GG2 = 44;
  public final static int A2 = 45;
  public final static int AA2 = 46;
  public final static int B2 = 47;
  public final static int C3 = 48;
  public final static int CC3 = 49;
  public final static int D3 = 50;
  public final static int DD3 = 51;
  public final static int E3 = 52;
  public final static int F3 = 53;
  public final static int FF3 = 54;
  public final static int G3 = 55;
  public final static int GG3 = 56;
  public final static int A3 = 57;
  public final static int AA3 = 58;
  public final static int B3 = 59;
  public final static int C4 = 60;
  public final static int CC4 = 61;
  public final static int D4 = 62;
  public final static int DD4 = 63;
  public final static int E4 = 64;
  public final static int F4 = 65;
  public final static int FF4 = 66;
  public final static int G4 = 67;
  public final static int GG4 = 68;
  public final static int A4 = 69;
  public final static int AA4 = 70;
  public final static int B4 = 71;

  public final static int C5 = 72;
  public final static int CC5 = 73;
  public final static int D5 = 74;
  public final static int DD5 = 75;
  public final static int E5 = 76;
  public final static int F5 = 77;
  public final static int FF5 = 78;
  public final static int G5 = 79;
  public final static int GG5 = 80;
  public final static int A5 = 81;
  public final static int AA5 = 82;
  public final static int B5 = 83;
  public final static int C6 = 84;
  public final static int CC6 = 85;
  public final static int D6 = 86;
  public final static int DD6 = 87;
  public final static int E6 = 88;
  public final static int F6 = 89;
  public final static int FF6 = 90;
  public final static int G6 = 91;
  public final static int GG6 = 92;
  public final static int A6 = 93;
  public final static int AA6 = 94;
  public final static int B6 = 95;
  public final static int C7 = 96;
  public final static int CC7 = 97;
  public final static int D7 = 98;
  public final static int DD7 = 99;
  public final static int E7 = 100;
  public final static int F7 = 101;
  public final static int FF7 = 102;
  public final static int G7 = 103;
  public final static int GG7 = 104;
  public final static int A7 = 105;
  public final static int AA7 = 106;
  public final static int B7 = 107;
  public final static int C8 = 108;
  public final static int CC8 = 109;
  public final static int D8 = 110;
  public final static int DD8 = 111;
  public final static int E8 = 112;
  public final static int F8 = 113;
  public final static int FF8 = 114;
  public final static int G8 = 115;
  public final static int GG8 = 116;
  public final static int A8 = 117;
  public final static int AA8 = 118;
  public final static int B8 = 119;
  public final static int C9 = 120;
  public final static int CC9 = 121;
  public final static int D9 = 122;
  public final static int DD9 = 123;
  public final static int E9 = 124;
  public final static int F9 = 125;
  public final static int FF9 = 126;
  public final static int G9 = 127;
 }

}