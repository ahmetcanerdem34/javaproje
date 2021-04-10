package proje1_yesilMarket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class YesilMarket {
	
	public static List<String> �r�nler = new ArrayList<>();
	public static List<Double> fiyatlar = new ArrayList<>();
	
	public static List<String> sepet�r�nler = new ArrayList<>();
	public static List<Double> sepetKg = new ArrayList<>();
	public static List<Double> sepetFiyatlar = new ArrayList<>();
	
	public static void main(String[] args) {
		
		/* Ye�il Market al��-veri� program�.
         * 
         * 1. Ad�m: �r�nler ve fiyatlar� i�eren listeleri olu�turunuz.
         *          No      �r�n         Fiyat
                  ====  =======        =========
                    00   Domates         2.10 TL 
                    01   Patates         3.20 TL
                    02   Biber            1.50 TL
                    03   So�an            2.30 TL
                    04   Havu�            3.10 TL
                    05   Elma             1.20 TL
                    06   Muz              1.90 TL
                    07   �ilek             6.10 TL
                    08   Kavun            4.30 TL
                    09   �z�m               2.70 TL
                    10   Limon             0.50 TL
                    
         * 2. Ad�m: Kullan�c�n�n �r�n nosuna g�re listeden �r�n se�mesini isteyiniz.
         * 3. Ad�m: Ka� kg sat�n almak istedi�ini sorunuz.
         * 4. Ad�m: Al�nacak bu �r�n� sepete ekleyiniz ve Sepeti yazd�r�n�z.
         * 5. Ba�ka bir �r�n al�p almak istemedi�ini sorunuz.
         * 6. E�er devam etmek istiyorsa yeniden �r�n se�me k�sm�na y�nlendiriniz.
         * 7. E�er bitirmek istiyorsa �deme k�sm�na ge�iniz ve �dem sonras�nda program� bitirinzi.
         */
		
		Scanner scan =new Scanner(System.in);
		
		�r�nler.addAll(Arrays.asList("Domates","Patates","Biber","So�an","Havu�", "Elma", "Muz", "Cilek", "Kavun", "Uzum", "Limon"));
		
		fiyatlar.addAll(Arrays.asList(2.10,3.20,1.50,2.30,3.10,1.20,1.90,6.10,4.30,2.70,0.50));
		
		String devam;
		double toplamFiyat=0.0;
		do {
		�r�nListele();	
		System.out.println("�r�n�n�z� numaraya g�re se�iniz :");
		
		int �r�nNo=scan.nextInt();
		System.out.println("ka� kg istiyorsunuz giriniz :");
		double kg=scan.nextDouble();	
		//sepeteekle k�sm� laz�m orda urunun ad� kg si ve urunun toplma fiyat�, methodda parametre olarak olmal�
		
		sepeteEkle(�r�nNo, kg );
		
		toplamFiyat = Math.round(sepeteYazd�r());
		System.out.println("Al��veri�e devam etmek ister misiniz");
		devam = scan.next();
		}while(devam.equalsIgnoreCase("e"));
		
		�deme(toplamFiyat);	
		
		System.out.println("g�zel proje oldu SATIR 70");
		System.out.println("g�zel olmakla beraber ba�kalar�na arac� olacak");
		
	}
	public static void �r�nListele() {//�r�nleri g�sterecek bir method yazmal�y�z
		
		System.out.println("No\t �r�nler \tFiyatlar");
		System.out.println("===\t ======== \t========");
		
		for (int i = 0; i < �r�nler.size(); i++) {
			
			System.out.println(" "+ i + "\t" + �r�nler.get(i) + "\t \t" + fiyatlar.get(i));
		}
	
	}	
	public static void sepeteEkle(int �r�nNo, double kg) {

		sepet�r�nler.add(�r�nler.get(�r�nNo));
		sepetKg.add(kg);
		sepetFiyatlar.add(fiyatlar.get(�r�nNo) * kg);
		
		
	}
	
	public static double sepeteYazd�r() {
		double fiyatToplam�=0.0;
		double kgToplam�=0.0;
		System.out.println("�r�n ad� \tKG \tFiyat�");//s�rekli yazd�rmas�n diye buraya koyduk for d���nda
		System.out.println("============================================================");
		
		for (int i = 0; i <sepet�r�nler.size(); i++) {//list te size diyorduk
			System.out.println(sepet�r�nler.get(i) + "\t \t" + sepetKg.get(i) + "\t" + sepetFiyatlar.get(i));
			
			fiyatToplam�+=sepetFiyatlar.get(i);
			kgToplam�+=sepetKg.get(i);
			
			
		}
		
		System.out.println("============================================================");
		System.out.println("\t TOPLAM" + kgToplam� + "\t" + fiyatToplam�);
		
		return fiyatToplam�;
	}
	
	
	public static void �deme(double toplamFiyat){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("**************************");
		System.out.println("**********�DEME***********");
		System.out.println("�denecek Toplam Fiyat :" + toplamFiyat);
		
		double nakit=0.0;//local oldu�u i�in do d���nda tan�mlamak gerekiyor
		
		do {
		System.out.print("L�tfen nakit giriniz :");
		nakit+=scan.nextDouble();
		if(nakit<toplamFiyat) {
			System.out.println("girilen rakam yetersiz :");
			System.out.println((toplamFiyat-nakit) + "TL  daha yat�rman�z gerekmektedir :");
		
		}
		
		}while(nakit<toplamFiyat);
	
		double para�st�=nakit-toplamFiyat;
		
		if(para�st�>0) {
			
			System.out.println("para�st� ="+para�st�);
		}//burda else de koyard�k ama her durumda yine bekleriz durumunda g�r�ls�n
		
		System.out.println("yine bekleriz");
	}
}
