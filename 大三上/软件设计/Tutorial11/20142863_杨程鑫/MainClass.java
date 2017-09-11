package test1;

public class MainClass
{
	public static void main(String[] args)
	{
		Phone MyFirstPhone = new SimplePhone();
		MyFirstPhone.Sound();
		
		System.out.println();
		JarPhone MyNextPhone = new JarPhone(MyFirstPhone);
		MyNextPhone.Sound();
		MyNextPhone.Vibrate();
		
		System.out.println();
		ComplexPhone MyLastPhone = new ComplexPhone(MyNextPhone);
		MyLastPhone.Sound();
		MyLastPhone.Vibrate();
		MyLastPhone.Flash();
	}
}