package config.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Date;

import config.bo.KioskService;
import config.DVDInfo;

public class TestClient {
	public static void main(String args[]) {
		TestClient testClient = new TestClient();
		testClient.test();
	}

	public void test() {
		String searchTitle = "2 Fast 2 Furious";
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:*Context.xml");
		KioskService kioskService = (KioskService) context.getBean("KioskService");

		List<DVDInfo> result = kioskService.searchByTitle(searchTitle);
		if (result.size() == 0) {
			System.out.println("Error, the DVD '2 Fast 2 Furious' should be available at location 'BUR-2'");
			return;
		}

		DVDInfo dvdInfo = result.get(0);

		int loandID = kioskService.loanDVD(dvdInfo.getId(), "j.wirth", "whoknows", new Date(), "AMS-1");
		System.out.println("Loan added underNumber: " + loandID);
	}

}
