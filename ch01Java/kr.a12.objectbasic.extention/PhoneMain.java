package kr.a12.objectbasic.extention;

public class PhoneMain {
	public static void main(String[] args) {
		FeaturePhone fp = 
				new FeaturePhone("010-1234",
						         "KN-123",
						         "black",800);
		SmartPhone sp = 
				new SmartPhone("010-5678",
						        "IN-567",
						        "white",
						        "안드로이드");
		
		System.out.println("-".repeat(30));
		System.out.println("번호\t\t모델\t색상\t특징");
		System.out.println("-".repeat(30));
		System.out.print(fp.getNumber()+"\t");
		System.out.print(fp.getModel()+"\t");
		System.out.print(fp.getColor()+"\t");
		System.out.println(fp.getPixel());
		
		System.out.print(sp.getNumber()+"\t");
		System.out.print(sp.getModel()+"\t");
		System.out.print(sp.getColor()+"\t");
		System.out.println(sp.getOs());
		
	}
}





