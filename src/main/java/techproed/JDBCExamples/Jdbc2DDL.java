package techproed.JDBCExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc2DDL {
	/*her sorguda öncekileri yoruma al hata vermesin
	   A) CREATE TABLE, DROP TABLE, ALTER TABLE gibi DDL ifadeleri icin sonuc kümesi (ResultSet) 
	      dondurmeyen metotlar kullanilmalidir.(executeQuery kullanamayız) Bunun icin JDBC'de 2 alternatif bulunmaktadir.  
	       1) execute() metodu 
	       2) excuteUpdate() metodu.  
	       
	   B) - execute() metodu hertur SQL ifadesiyle kullanilabilen genel bir komuttur.
	      - execute(), Boolean bir deger dondurur. DDL islemlerin false dondururken, 
	        DML islemlerinde true deger dondurur. 
	      - Ozellikle, hangi tip SQL ifadesinin kullanilmasinin gerektiginin belli olmadigi 
	        durumlarda tercih edilmektedir.  
	        
	   C) - executeUpdate() metodu ise INSERT, Update gibi DML islemlerinde yaygin kullanilir.
	      - bu islemlerde islemden etkilenen satir sayisini dondurur.
	      - Ayrıca, DDL islemlerinde de kullanilabilir ve bu islemlerde 0 dondurur.
	*/

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
	    Connection con=	DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
		Statement st=	con.createStatement();
		
//ORNEK1:isciler adinda bir tablo olusturunuz id NUMBER(3), 
//birim VARCHAR2(10), maas NUMBER(5)
		
//		st.execute("CREATE TABLE isciler"
//				+ " (id NUMBER(3),"
//				+ " birim VARCHAR(10),"
//				+ " maas NUMBER(5))");
//		System.out.println("İsçiler tablosu oluşturuldu...");
//	
//soru2:işçiler tablosunu kalıcı olark siliniz
//		System.out.println("==============================");
//		st.executeUpdate("DROP TABLE isciler PURGE");
//		System.out.println("İsçiler tablosu silindi");
//Soru3: işçiler tablosuna yeni bir sütun {isim varchar(20)ekleyiniz}
//		
//		st.execute("ALTER TABLE isciler ADD isim VARCHAR2(20) ");
//		System.out.println("İsim sütunu eklendi");

//SORU4: işçiler tablosundaki maas sütununu siliniz
//		
//st.execute("ALTER TABLE isciler DROP COLUMN maas");
//System.out.println("Sütun silindi.");

//ORNEK6:isciler tablosunun adini calisanlar olarak degistiriniz. 

st.execute("ALTER TABLE isciler"
		+ " RENAME TO calisanlar");
System.out.println("İsim değiştirildi");
	}

}
