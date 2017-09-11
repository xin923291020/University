package test1;

public class MainClass
{
	public static void main(String[] args)
	{
		Folder C1 = new Folder();
		C1.setName("一层文件夹");
		
		Folder C2 = new Folder();
		C2.setName("二层文件夹");
		TextFile Text = new TextFile();
		Text.setName("TXT文档");
		C1.add(C2);
		C1.add(Text);
		
		Folder C3 = new Folder();
		C3.setName("三层文件夹");
		ImageFile Image = new ImageFile();
		Image.setName("Image图片");
		C2.add(C3);
		C2.add(Image);
		
		Folder C4 = new Folder();
		C4.setName("四层文件夹");
		VideoFile Video = new VideoFile();
		Video.setName("Video视频");
		C3.add(C4);
		C3.add(Video);
		
		while(C1 != null)
		{
			C1 = (Folder) C1.operation();
		}
	}
}