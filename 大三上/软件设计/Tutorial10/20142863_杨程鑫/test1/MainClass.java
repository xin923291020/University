package test1;

public class MainClass
{
	public static void main(String[] args)
	{
		Folder C1 = new Folder();
		C1.setName("һ���ļ���");
		
		Folder C2 = new Folder();
		C2.setName("�����ļ���");
		TextFile Text = new TextFile();
		Text.setName("TXT�ĵ�");
		C1.add(C2);
		C1.add(Text);
		
		Folder C3 = new Folder();
		C3.setName("�����ļ���");
		ImageFile Image = new ImageFile();
		Image.setName("ImageͼƬ");
		C2.add(C3);
		C2.add(Image);
		
		Folder C4 = new Folder();
		C4.setName("�Ĳ��ļ���");
		VideoFile Video = new VideoFile();
		Video.setName("Video��Ƶ");
		C3.add(C4);
		C3.add(Video);
		
		while(C1 != null)
		{
			C1 = (Folder) C1.operation();
		}
	}
}