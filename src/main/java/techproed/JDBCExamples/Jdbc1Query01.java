package techproed.JDBCExamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc1Query01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

//1) ilgili driverı yüklemeliyiz.TV nin fişini takma
		
Class.forName("oracle.jdbc.driver.OracleDriver");

//2) Bağlantıyı oluşturmalıyız.şifre kullanıcı adı gibi...netflix bağlanma gibi

Connection con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","hr","hr");
		
//3) SQL komutları için  bir alan Statement nesnesi oluşturduk.(kumandadan kanal ayarlama)

Statement st=con.createStatement();

//4) SQL ifadeleri yazabilir ve çalıştırabiliriz...
//(personele tablosundaki personel_id si 7369 olan personelin adını ve maaşını sorgulayınız)

ResultSet isim= st.executeQuery("SELECT personel_isim,maas from personel where personel_id=7369");

// sonuçları aldık ve işledik, tablonun içinde gezindireceğiz

while(isim.next()) {
	System.out.print("Personel İsim : "+isim.getString("personel_isim")+"\nMaaş : "+isim.getInt("maas"));
}
//oluşturulan nesneleri bellekten kaldıralim.
con.close();
st.close();
isim.close();
		
	}
}
