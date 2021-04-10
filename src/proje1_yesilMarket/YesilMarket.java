package proje1_yesilMarket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class YesilMarket {
	
	public static List<String> ürünler = new ArrayList<>();
	public static List<Double> fiyatlar = new ArrayList<>();
	
	public static List<String> sepetÜrünler = new ArrayList<>();
	public static List<Double> sepetKg = new ArrayList<>();
	public static List<Double> sepetFiyatlar = new ArrayList<>();
	
	public static void main(String[] args) {
		
		/* Yeþil Market alýþ-veriþ programý.
         * 
         * 1. Adým: Ürünler ve fiyatlarý içeren listeleri oluþturunuz.
         *          No      Ürün         Fiyat
                  ====  =======        =========
                    00   Domates         2.10 TL 
                    01   Patates         3.20 TL
                    02   Biber            1.50 TL
                    03   Soðan            2.30 TL
                    04   Havuç            3.10 TL
                    05   Elma             1.20 TL
                    06   Muz              1.90 TL
                    07   Çilek             6.10 TL
                    08   Kavun            4.30 TL
                    09   Üzüm               2.70 TL
                    10   Limon             0.50 TL
                    
         * 2. Adým: Kullanýcýnýn ürün nosuna göre listeden ürün seçmesini isteyiniz.
         * 3. Adým: Kaç kg satýn almak istediðini sorunuz.
         * 4. Adým: Alýnacak bu ürünü sepete ekleyiniz ve Sepeti yazdýrýnýz.
         * 5. Baþka bir ürün alýp almak istemediðini sorunuz.
         * 6. Eðer devam etmek istiyorsa yeniden ürün seçme kýsmýna yönlendiriniz.
         * 7. Eðer bitirmek istiyorsa ödeme kýsmýna geçiniz ve ödem sonrasýnda programý bitirinzi.
         */
		
		Scanner scan =new Scanner(System.in);
		
		ürünler.addAll(Arrays.asList("Domates","Patates","Biber","Soðan","Havuç", "Elma", "Muz", "Cilek", "Kavun", "Uzum", "Limon"));
		
		fiyatlar.addAll(Arrays.asList(2.10,3.20,1.50,2.30,3.10,1.20,1.90,6.10,4.30,2.70,0.50));
		
		String devam;
		double toplamFiyat=0.0;
		do {
		ürünListele();	
		System.out.println("ürününüzü numaraya göre seçiniz :");
		
		int ürünNo=scan.nextInt();
		System.out.println("kaç kg istiyorsunuz giriniz :");
		double kg=scan.nextDouble();	
		//sepeteekle kýsmý lazým orda urunun adý kg si ve urunun toplma fiyatý, methodda parametre olarak olmalý
		
		sepeteEkle(ürünNo, kg );
		
		toplamFiyat = Math.round(sepeteYazdýr());
		System.out.println("Alýþveriþe devam etmek ister misiniz");
		devam = scan.next();
		}while(devam.equalsIgnoreCase("e"));
		
		ödeme(toplamFiyat);	
		
		System.out.println("güzel proje oldu SATIR 70");
		System.out.println("güzel olmakla beraber baþkalarýna aracý olacak");
		
	}
	public static void ürünListele() {//ürünleri gösterecek bir method yazmalýyýz
		
		System.out.println("No\t Ürünler \tFiyatlar");
		System.out.println("===\t ======== \t========");
		
		for (int i = 0; i < ürünler.size(); i++) {
			
			System.out.println(" "+ i + "\t" + ürünler.get(i) + "\t \t" + fiyatlar.get(i));
		}
	
	}	
	public static void sepeteEkle(int ürünNo, double kg) {

		sepetÜrünler.add(ürünler.get(ürünNo));
		sepetKg.add(kg);
		sepetFiyatlar.add(fiyatlar.get(ürünNo) * kg);
		
		
	}
	
	public static double sepeteYazdýr() {
		double fiyatToplamý=0.0;
		double kgToplamý=0.0;
		System.out.println("ürün adý \tKG \tFiyatý");//sürekli yazdýrmasýn diye buraya koyduk for dýþýnda
		System.out.println("============================================================");
		
		for (int i = 0; i <sepetÜrünler.size(); i++) {//list te size diyorduk
			System.out.println(sepetÜrünler.get(i) + "\t \t" + sepetKg.get(i) + "\t" + sepetFiyatlar.get(i));
			
			fiyatToplamý+=sepetFiyatlar.get(i);
			kgToplamý+=sepetKg.get(i);
			
			
		}
		
		System.out.println("============================================================");
		System.out.println("\t TOPLAM" + kgToplamý + "\t" + fiyatToplamý);
		
		return fiyatToplamý;
	}
	
	
	public static void ödeme(double toplamFiyat){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("**************************");
		System.out.println("**********ÖDEME***********");
		System.out.println("Ödenecek Toplam Fiyat :" + toplamFiyat);
		
		double nakit=0.0;//local olduðu için do dýþýnda tanýmlamak gerekiyor
		
		do {
		System.out.print("Lütfen nakit giriniz :");
		nakit+=scan.nextDouble();
		if(nakit<toplamFiyat) {
			System.out.println("girilen rakam yetersiz :");
			System.out.println((toplamFiyat-nakit) + "TL  daha yatýrmanýz gerekmektedir :");
		
		}
		
		}while(nakit<toplamFiyat);
	
		double paraÜstü=nakit-toplamFiyat;
		
		if(paraÜstü>0) {
			
			System.out.println("paraüstü ="+paraÜstü);
		}//burda else de koyardýk ama her durumda yine bekleriz durumunda görülsün
		
		System.out.println("yine bekleriz");
	}
}
