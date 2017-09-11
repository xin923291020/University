package test1;

public class MainClass
{
	public static void main(String[] args)
	{
		MoneyRequest MR = new MoneyRequest("ycx",5000);
		Director D = new Director("D");
		DepartmentManager DM = new DepartmentManager("DM");
		DeputyGeneralManager DGM = new DeputyGeneralManager("DGM");
		GeneralManager GM = new GeneralManager("GM");
		WorkersAssembly WA = new WorkersAssembly("职工大会");
		D.SetLeader(DM);
		DM.SetLeader(DGM);
		DGM.SetLeader(GM);
		GM.SetLeader(WA);
		
		D.HandleRequest(MR);
		System.out.println("");
		
		System.out.println("ycx的请求金额变为15000");
		MR.SetMoney(15000);
		D.HandleRequest(MR);
		System.out.println("");
		
		System.out.println("ycx的请求金额变为55000");
		MR.SetMoney(55000);
		D.HandleRequest(MR);
		System.out.println("");
		
		System.out.println("ycx的请求金额变为105000");
		MR.SetMoney(105000);
		D.HandleRequest(MR);
		System.out.println("");
		
		System.out.println("ycx的请求金额变为205000");
		MR.SetMoney(205000);
		D.HandleRequest(MR);
		System.out.println("");
	}
}