package test1;

public class MainClass
{
	public static void main(String a[])
	{
		UserInfoDTO Info = new UserInfoDTO();
		Caretaker Caretaker = new Caretaker();
		
		Info.SetAccount("ycx");
		Info.SetPassword("1995");
		Info.SetTelNo("11111111111");
		Info.show();
		Caretaker.SetMemento(Info.saveMemento());
		System.out.println();
	
		Info.SetPassword("1122");
		Info.SetTelNo("22222222222");
		Info.show();
		Caretaker.SetMemento(Info.saveMemento());
		System.out.println();
			
		Info.SetPassword("1201");
		Info.SetTelNo("33333333333");
		Info.show();
		Caretaker.SetMemento(Info.saveMemento());
		System.out.println();
		
		Info.restoreMemento(Caretaker.GetMemento());
		Info.show();
	    System.out.println();
	    
	    Info.SetPassword("0101");
		Info.SetTelNo("44444444444");
		Info.show();
		Caretaker.SetMemento(Info.saveMemento());
		System.out.println();
	    
	    Info.restoreMemento(Caretaker.GetMemento());
		Info.show();
	    System.out.println();
	}
}