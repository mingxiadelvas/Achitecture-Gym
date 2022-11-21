package Tests;
import GYM.DatabaseP;
import GYM.DatabaseS;
import GYM.Member;
import GYM.Professionnel;
import GYM.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class testJunit {
	DatabaseP dbp = new DatabaseP();
	DatabaseS dbs = new DatabaseS();
	
	@Test
	public void testAddMember()  {
		System.out.println("Test Ajout Membre");

		System.out.println("Before : " + dbp.listeMembres);
		Member testMember = new Member("Fujimaru", "Ritsuka", 4203141, "F.Ritsuka@Chaldea.com", 69, 00);
		testMember.setIdMembre(dbp.generateMemberID());
		boolean result = dbp.memberDBajout(testMember);
		System.out.println("After : " + dbp.listeMembres);
		Assert.assertTrue(result);
	}
	@Test
	public void testModifyMember()  {
		System.out.println("Test Modification Membre");
		Member testMember = new Member("Mash", "Kyrielight", 3141420, "M.Kyrielight@Chaldea.com", 42, 420);
		dbp.memberDBajout(testMember);
		System.out.println("Before : " + dbp.listeMembres);
		boolean result = dbp.memberModification("420", "3141777", "MashShielder@FGO.co.jp", "100");
		Assert.assertTrue(result);
		System.out.println("After : " + dbp.listeMembres);
	}
	@Test
	public void testDeleteMember()  {
		System.out.println("Test Suppression Membre");
		Member testMember = new Member("Mash", "Kyrielight", 3141420, "M.Kyrielight@Chaldea.com", 42, 420);
		dbp.memberDBajout(testMember);
		System.out.println("Before : " + dbp.listeMembres);
		boolean result = dbp.memberSuppression("420");
		Assert.assertTrue(result);
		System.out.println("After : " + dbp.listeMembres);
	}
	@Test
	public void testAjoutService()  {
		System.out.println("Test Ajout Service");
		Professionnel testPro = new Professionnel("Quetzacoatl", "Rider", 2404980, "M.Kyrielight@Chaldea.com", "Lucha Master", dbp.generateProID());
		dbp.proDBajout(testPro);
		Service testService = new Service(LocalDateTime.now(), LocalDate.of(2020, 8, 15), LocalDate.of(2020, 10, 15), LocalTime.of(10, 10), new Integer[] {1,2,3,4,5}, 30, 50, testPro.getIdPro(), dbs.generateServiceCode());
		boolean result = dbs.serviceDBajout(testService,dbp.listePros);
		Assert.assertTrue(result);
		System.out.println("After : " + dbs.listeServices);
	}
	@Test
	public void testModificationService()  {
		System.out.println("Test Modification Service");
		Professionnel testPro = new Professionnel("Quetzacoatl", "Rider", 2404980, "M.Kyrielight@Chaldea.com", "Lucha Master", dbp.generateProID());
		dbp.proDBajout(testPro);
		Service testService = new Service(LocalDateTime.now(), LocalDate.of(2020, 8, 15), LocalDate.of(2020, 10, 15), LocalTime.of(10, 10), new Integer[] {1,2,3,4,5}, 30, 50, testPro.getIdPro(), dbs.generateServiceCode());
		dbs.serviceDBajout(testService,dbp.listePros);
		System.out.println("Before : " + "(Last Time = " + dbs.listeServices.get(0).getLastTime());
		boolean result = dbs.serviceModification(testPro.getIdPro(), testService.getServiceCode(), LocalDate.of(2020, 12, 30), LocalTime.of(19, 00), new Integer[] {1,2}, 33, 55);
		Assert.assertTrue(result);
		System.out.
		println("After : " + "Last Time = " + dbs.listeServices.get(0).getLastTime());
	}
	@Test
	public void testSuppressionService()  {
		System.out.println("Test Suppression Service");
		Professionnel testPro = new Professionnel("Quetzacoatl", "Rider", 2404980, "M.Kyrielight@Chaldea.com", "Lucha Master", dbp.generateProID());
		dbp.proDBajout(testPro);
		Service testService = new Service(LocalDateTime.now(), LocalDate.of(2020, 8, 15), LocalDate.of(2020, 10, 15), LocalTime.of(10, 10), new Integer[] {1,2,3,4,5}, 30, 50, testPro.getIdPro(), dbs.generateServiceCode());
		dbs.serviceDBajout(testService,dbp.listePros);
		System.out.println("Before : " + dbs.listeServices);
		boolean result = dbs.serviceSuppression(testService.getServiceCode(), testPro.getIdPro());
		Assert.assertTrue(result);
		System.out.println("After : " + dbs.listeServices);
	}
}