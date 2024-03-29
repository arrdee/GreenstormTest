package tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class SeleniumTest {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void Login() throws Exception {
		selenium.open("/PaperMiner");
		selenium.click("link=User");
		Thread.sleep(300);
		selenium.click("link=Login or Register");
		Thread.sleep(300);
		selenium.type("em", "dev@paperminer.com");
		selenium.click("xpath=(//button[@type='button'])[5]");
		Thread.sleep(300);
		selenium.click("link=Query");
		Thread.sleep(3000);
		selenium.click("link=New");
	}
	
	   @Test
	    public void Logout() throws Exception {
	        selenium.open("/PaperMiner");
	        selenium.click("link=User");
	        Thread.sleep(300);
	        selenium.click("link=Login or Register");
	        Thread.sleep(300);
	        selenium.type("em", "dev@paperminer.com");
	        selenium.click("xpath=(//button[@type='button'])[5]");
	        Thread.sleep(300);
	        selenium.click("link=Logout");
	        Thread.sleep(3000);
	        selenium.click("link=Login or Register");
	    }
	
	@Test
	public void MenusOpen() throws Exception {
		selenium.open("/PaperMiner");
		selenium.click("link=User");
		Thread.sleep(300);
		selenium.click("link=Login or Register");
		Thread.sleep(300);
		selenium.type("em", "dev@paperminer.com");
		selenium.click("xpath=(//button[@type='button'])[5]");
		Thread.sleep(300);
		selenium.open("/PaperMiner");
		selenium.click("link=Home");
		Thread.sleep(1000);
		selenium.click("link=Map");
		Thread.sleep(1000);
		selenium.click("link=Histogram");
		Thread.sleep(1000);
		selenium.click("link=Term Cloud");
		Thread.sleep(1000);
		selenium.click("link=Raw Results");
		Thread.sleep(1000);
		selenium.click("link=About");
		Thread.sleep(1000);
		selenium.click("xpath=(//button[@type='button'])[4]");
		Thread.sleep(300);
		selenium.click("link=Trove");
		Thread.sleep(1000);
		selenium.click("link=Paper Miner");
		Thread.sleep(1000);
		selenium.click("link=Read Release Notes");
		Thread.sleep(1000);
		selenium.click("link=Home");
	}
	
	@Test
	public void AdvancedSearch() throws Exception {
		
	    selenium.open("/PaperMiner/");
	    
		selenium.click("link=User");
		Thread.sleep(600);
		selenium.click("link=Login or Register");
		Thread.sleep(600);
		selenium.type("id=em", "dev@paperminer.com");
		selenium.click("xpath=(//button[@type='button'])[5]");
		Thread.sleep(300);
		
		selenium.click("link=Home");
		
		Thread.sleep(2000);
		selenium.click("link=Query");
		Thread.sleep(700);
		selenium.click("link=New");
		selenium.click("id=aq1");
		Thread.sleep(1000);
		selenium.type("q1", "celestials");
		Thread.sleep(1000);
		selenium.click("id=nq-pb12");
		Thread.sleep(10000);
		selenium.click("id=cc-pb11");
		Thread.sleep(1000);
		selenium.click("link=View");
		Thread.sleep(1000);
		selenium.click("link=Raw Results");
		selenium.click("xpath=(//input[@name='raw-sort-rb'])[2]");
		Thread.sleep(4000);
		assertTrue(selenium.isTextPresent("13."));
		selenium.click("css=#raw-view > h3");
		selenium.click("link=Query");
		selenium.click("link=New");
		selenium.click("xpath=(//input[@name='query-rb1'])[2]");
		selenium.click("id=aq1");
		Thread.sleep(1000);
		selenium.type("aq1", "celestials");
		selenium.click("z1b");
		selenium.click("xpath=(//button[@id='nq-pb12'])[2]");
		Thread.sleep(10000);
		selenium.click("id=btn-pause");
		selenium.click("link=View");
		selenium.click("link=Raw Results");
		selenium.click("xpath=(//input[@name='raw-sort-rb'])[2]");
		Thread.sleep(3000);
		assertTrue(selenium.isTextPresent("9.3"));
	}
	
	@Test
    public void Histograms() throws Exception {
        selenium.open("/PaperMiner/");
        selenium.click("css=html");
        selenium.click("link=Home");
        selenium.waitForPageToLoad("30000");
        selenium.click("link=Login or Register");
        selenium.type("id=em", "dev@paperminer.com");
        selenium.click("xpath=(//button[@type='button'])[5]");
        Thread.sleep(1000);
        selenium.click("link=New");
        selenium.type("id=q1", "celestials");
        selenium.click("id=nq-pb12");
        Thread.sleep(7000);
        selenium.click("id=btn-pause");
        selenium.click("link=Histogram");
        
    }
    @Test
    public void AdvancedDate() throws Exception {
        selenium.open("/PaperMiner/#");
	    selenium.click("link=Login or Register");
	    Thread.sleep(600);
	    selenium.type("id=em", "dev@paperminer.com");
	    selenium.click("xpath=(//button[@type='button'])[5]");
	    Thread.sleep(600);
	    selenium.click("link=New");
	    selenium.click("xpath=(//input[@name='query-rb1'])[2]");
	    Thread.sleep(600);
	    selenium.type("id=aq1", "celestials");
	    selenium.click("id=z1a");
	    selenium.select("id=aqYearStart", "label=1900");
	    selenium.select("id=aqYearEnd", "label=1920");
	    selenium.click("xpath=(//button[@id='nq-pb12'])[2]");
	    Thread.sleep(5000);
	    selenium.click("id=cc-pb11");
	    selenium.click("link=Raw Results");
	    Thread.sleep(2000);
	    assertTrue(selenium.isTextPresent("1900"));
	    assertTrue(selenium.isTextPresent("1920"));
	    assertFalse(selenium.isTextPresent("1898"));
        assertFalse(selenium.isTextPresent("2027"));
	    }
	
    @Test
    public void SaveQuery() throws Exception {
        selenium.open("/PaperMiner/#");
        Thread.sleep(500);
        selenium.click("link=Login or Register");
        Thread.sleep(500);
        selenium.type("id=em", "dev@paperminer.com");
        selenium.click("xpath=(//button[@type='button'])[5]");
        Thread.sleep(500);
        selenium.click("link=New");
        Thread.sleep(500);
        selenium.type("id=q1", (selenium.getValue("id=q1")));
        selenium.click("id=nq-pb12");
        Thread.sleep(2000);
        selenium.click("id=cc-pb11");
        Thread.sleep(1000);
        selenium.click("id=cc-pb13");
        Thread.sleep(1000);
        assertTrue((selenium.getText("id=q1")) == "celestials");
        
    }
    
    @Test
    public void SortByDate() throws Exception {
        
        selenium.open("/PaperMiner/");
        
        selenium.click("link=User");
        Thread.sleep(600);
        selenium.click("link=Login or Register");
        Thread.sleep(600);
        selenium.type("id=em", "dev@paperminer.com");
        selenium.click("xpath=(//button[@type='button'])[5]");
        Thread.sleep(300);
        
        selenium.click("link=Home");
        
        Thread.sleep(2000);
        selenium.click("link=Query");
        Thread.sleep(700);
        selenium.click("link=New");
        selenium.click("id=aq1");
        Thread.sleep(1000);
        selenium.type("q1", "celestials");
        Thread.sleep(1000);
        selenium.click("id=nq-pb12");
        Thread.sleep(10000);
        selenium.click("id=cc-pb11");
        Thread.sleep(1000);
        selenium.click("link=View");
        Thread.sleep(1000);
        selenium.click("link=Raw Results");
        selenium.click("xpath=(//input[@name='raw-sort-rb'])[2]");
        Thread.sleep(4000);
        
        selenium.click("name=raw-sort-rb");
        Thread.sleep(4000);
        assertTrue(selenium.isTextPresent("1853-03-15\n1855-04-28"));
    }
    
    @Test
    public void SortByRelevance() throws Exception {
        
        selenium.open("/PaperMiner/");
        
        selenium.click("link=User");
        Thread.sleep(600);
        selenium.click("link=Login or Register");
        Thread.sleep(600);
        selenium.type("id=em", "dev@paperminer.com");
        selenium.click("xpath=(//button[@type='button'])[5]");
        Thread.sleep(300);
        
        selenium.click("link=Home");
        
        Thread.sleep(2000);
        selenium.click("link=Query");
        Thread.sleep(700);
        selenium.click("link=New");
        selenium.click("id=aq1");
        Thread.sleep(1000);
        selenium.type("q1", "celestials");
        Thread.sleep(1000);
        selenium.click("id=nq-pb12");
        Thread.sleep(10000);
        selenium.click("id=cc-pb11");
        Thread.sleep(1000);
        selenium.click("link=View");
        Thread.sleep(1000);
        selenium.click("link=Raw Results");
        selenium.click("xpath=(//input[@name='raw-sort-rb'])[2]");
        Thread.sleep(4000);
        
        selenium.click("xpath=(//input[@name='raw-sort-rb'])[2]");
        Thread.sleep(4000);
        assertTrue(selenium.isTextPresent("13.756592\n8.742218 "));
        
    }
    
    @Test
    public void SortBySource() throws Exception {
        
        selenium.open("/PaperMiner/");
        
        selenium.click("link=User");
        Thread.sleep(600);
        selenium.click("link=Login or Register");
        Thread.sleep(600);
        selenium.type("id=em", "dev@paperminer.com");
        selenium.click("xpath=(//button[@type='button'])[5]");
        Thread.sleep(300);
        
        selenium.click("link=Home");
        
        Thread.sleep(2000);
        selenium.click("link=Query");
        Thread.sleep(700);
        selenium.click("link=New");
        selenium.click("id=aq1");
        Thread.sleep(1000);
        selenium.type("q1", "celestials");
        Thread.sleep(1000);
        selenium.click("id=nq-pb12");
        Thread.sleep(10000);
        selenium.click("id=cc-pb11");
        Thread.sleep(1000);
        selenium.click("link=View");
        Thread.sleep(1000);
        selenium.click("link=Raw Results");
        selenium.click("xpath=(//input[@name='raw-sort-rb'])[2]");
        Thread.sleep(4000);
        
        selenium.click("xpath=(//input[@name='raw-sort-rb'])[3]");
        Thread.sleep(4000);
        assertTrue(selenium.isTextPresent("000008\n000009"));
        
    }
    
    @Test
    public void SortByRetrieveOrder() throws Exception {
        
        selenium.open("/PaperMiner/");
        
        selenium.click("link=User");
        Thread.sleep(600);
        selenium.click("link=Login or Register");
        Thread.sleep(600);
        selenium.type("id=em", "dev@paperminer.com");
        selenium.click("xpath=(//button[@type='button'])[5]");
        Thread.sleep(300);
        
        selenium.click("link=Home");
        
        Thread.sleep(2000);
        selenium.click("link=Query");
        Thread.sleep(700);
        selenium.click("link=New");
        selenium.click("id=aq1");
        Thread.sleep(1000);
        selenium.type("q1", "celestials");
        Thread.sleep(1000);
        selenium.click("id=nq-pb12");
        Thread.sleep(10000);
        selenium.click("id=cc-pb11");
        Thread.sleep(1000);
        selenium.click("link=View");
        Thread.sleep(1000);
        selenium.click("link=Raw Results");
        selenium.click("xpath=(//input[@name='raw-sort-rb'])[2]");
        Thread.sleep(4000);
        
        selenium.click("xpath=(//input[@name='raw-sort-rb'])[4]");
        Thread.sleep(4000);
        assertTrue(selenium.isTextPresent("1897-04-15\n1923-01-30"));
        
    }
    
    @Test
    public void CustomSearchNewspapers() throws Exception {
        selenium.open("/PaperMiner/");
        Thread.sleep(700);
        
        selenium.click("link=User");
        Thread.sleep(600);
        selenium.click("link=Login or Register");
        Thread.sleep(600);
        selenium.type("id=em", "dev@paperminer.com");
        selenium.click("xpath=(//button[@type='button'])[5]");
        Thread.sleep(300);
        
        selenium.click("link=New");
        Thread.sleep(700);
        selenium.click("xpath=(//input[@name='query-rb1'])[3]");
        selenium.click("xpath=(//input[@type='checkbox'])[59]");
        selenium.type("xpath=(//input[@id='q1'])[2]", "Celestials");
        selenium.click("xpath=(//button[@id='nq-pb12'])[3]");
        Thread.sleep(4000);
        selenium.click("id=btn-pause");
        selenium.click("link=View");
        Thread.sleep(700);
        selenium.click("link=Raw Results");
        assertTrue(selenium.isTextPresent("1897-04-15"));
    }
    
    @Test
    public void CustomSearchBooks() throws Exception {
        selenium.open("/PaperMiner/");
        Thread.sleep(700);
        
        selenium.click("link=User");
        Thread.sleep(600);
        selenium.click("link=Login or Register");
        Thread.sleep(600);
        selenium.type("id=em", "dev@paperminer.com");
        selenium.click("xpath=(//button[@type='button'])[5]");
        Thread.sleep(300);
        
        selenium.click("link=New");
        Thread.sleep(700);
        selenium.click("xpath=(//input[@name='query-rb1'])[3]");
        selenium.click("xpath=(//input[@type='checkbox'])[5]");
        selenium.type("xpath=(//input[@id='q1'])[2]", "Celestials");
        selenium.click("xpath=(//button[@id='nq-pb12'])[3]");
        Thread.sleep(4000);
        selenium.click("id=btn-pause");
        selenium.click("link=View");
        Thread.sleep(700);
        selenium.click("link=Raw Results");
        assertTrue(selenium.isTextPresent("2004-2009"));
    }
    
    @Test
    public void CustomSearchPictures() throws Exception {
        selenium.open("/PaperMiner/");
        Thread.sleep(700);
        
        selenium.click("link=User");
        Thread.sleep(600);
        selenium.click("link=Login or Register");
        Thread.sleep(600);
        selenium.type("id=em", "dev@paperminer.com");
        selenium.click("xpath=(//button[@type='button'])[5]");
        Thread.sleep(300);
        
        selenium.click("link=New");
        Thread.sleep(700);
        selenium.click("xpath=(//input[@name='query-rb1'])[3]");
        selenium.click("xpath=(//input[@type='checkbox'])[14]");
        selenium.type("xpath=(//input[@id='q1'])[2]", "Celestials");
        selenium.click("xpath=(//button[@id='nq-pb12'])[3]");
        Thread.sleep(4000);
        selenium.click("id=btn-pause");
        selenium.click("link=View");
        Thread.sleep(700);
        selenium.click("link=Raw Results");
        assertTrue(selenium.isTextPresent("1855"));
    }
    
    @Test
    public void CustomSearchArticle() throws Exception {
        selenium.open("/PaperMiner/");
        Thread.sleep(700);
        
        selenium.click("link=User");
        Thread.sleep(600);
        selenium.click("link=Login or Register");
        Thread.sleep(600);
        selenium.type("id=em", "dev@paperminer.com");
        selenium.click("xpath=(//button[@type='button'])[5]");
        Thread.sleep(300);
        
        selenium.click("link=New");
        Thread.sleep(700);
        selenium.click("xpath=(//input[@name='query-rb1'])[3]");
        selenium.click("xpath=(//input[@type='checkbox'])[23]");
        selenium.type("xpath=(//input[@id='q1'])[2]", "Celestials");
        selenium.click("xpath=(//button[@id='nq-pb12'])[3]");
        Thread.sleep(4000);
        selenium.click("id=btn-pause");
        selenium.click("link=View");
        Thread.sleep(700);
        selenium.click("link=Raw Results");
        assertTrue(selenium.isTextPresent("2010"));
    }
    
    @Test
    public void CustomSearchMusic() throws Exception {
        selenium.open("/PaperMiner/");
        Thread.sleep(700);
        
        selenium.click("link=User");
        Thread.sleep(600);
        selenium.click("link=Login or Register");
        Thread.sleep(600);
        selenium.type("id=em", "dev@paperminer.com");
        selenium.click("xpath=(//button[@type='button'])[5]");
        Thread.sleep(300);
        
        selenium.click("link=New");
        Thread.sleep(700);
        selenium.click("xpath=(//input[@name='query-rb1'])[3]");
        selenium.click("xpath=(//input[@type='checkbox'])[32]");
        selenium.type("xpath=(//input[@id='q1'])[2]", "Celestials");
        selenium.click("xpath=(//button[@id='nq-pb12'])[3]");
        Thread.sleep(4000);
        selenium.click("id=btn-pause");
        selenium.click("link=View");
        Thread.sleep(700);
        selenium.click("link=Raw Results");
        assertTrue(selenium.isTextPresent("19"));
    }
    
    @Test
    public void CustomSearchMaps() throws Exception {
        selenium.open("/PaperMiner/");
        Thread.sleep(700);
        
        selenium.click("link=User");
        Thread.sleep(600);
        selenium.click("link=Login or Register");
        Thread.sleep(600);
        selenium.type("id=em", "dev@paperminer.com");
        selenium.click("xpath=(//button[@type='button'])[5]");
        Thread.sleep(300);
        
        selenium.click("link=New");
        Thread.sleep(700);
        selenium.click("xpath=(//input[@name='query-rb1'])[3]");
        selenium.click("xpath=(//input[@type='checkbox'])[41]");
        selenium.type("xpath=(//input[@id='q1'])[2]", "Celestials");
        selenium.click("xpath=(//button[@id='nq-pb12'])[3]");
        Thread.sleep(4000);
        selenium.click("id=btn-pause");
        selenium.click("link=View");
        Thread.sleep(700);
        selenium.click("link=Raw Results");
        assertTrue(selenium.isTextPresent("19"));
    }
    
    @Test
    public void CustomSearchLists() throws Exception {
        selenium.open("/PaperMiner/");
        Thread.sleep(700);
        
        selenium.click("link=User");
        Thread.sleep(600);
        selenium.click("link=Login or Register");
        Thread.sleep(600);
        selenium.type("id=em", "dev@paperminer.com");
        selenium.click("xpath=(//button[@type='button'])[5]");
        Thread.sleep(300);
        
        selenium.click("link=New");
        Thread.sleep(700);
        selenium.click("xpath=(//input[@name='query-rb1'])[3]");
        selenium.click("xpath=(//input[@type='checkbox'])[65]");
        selenium.type("xpath=(//input[@id='q1'])[2]", "Celestials");
        selenium.click("xpath=(//button[@id='nq-pb12'])[3]");
        Thread.sleep(4000);
        selenium.click("id=btn-pause");
        selenium.click("link=View");
        Thread.sleep(700);
        selenium.click("link=Raw Results");
        assertTrue(selenium.isTextPresent("19"));
    }
   
    @Test
    public void MultipleZones() throws Exception {
        
        selenium.open("/PaperMiner/");
        
        selenium.click("link=User");
        Thread.sleep(600);
        selenium.click("link=Login or Register");
        Thread.sleep(600);
        selenium.type("id=em", "dev@paperminer.com");
        selenium.click("xpath=(//button[@type='button'])[5]");
        Thread.sleep(600);
        
        selenium.click("link=Home");
        selenium.click("link=New");
        Thread.sleep(600);
        selenium.click("xpath=(//input[@name='query-rb1'])[2]");
        Thread.sleep(3000);
        selenium.type("id=aq1", "Celestials");
        selenium.click("id=z1a");
        selenium.click("id=z1b");
        selenium.click("xpath=(//button[@id='nq-pb12'])[2]");
        Thread.sleep(5000);
        selenium.click("id=cc-pb11");
        selenium.click("link=Raw Results");
        Thread.sleep(3000);
        assertTrue(selenium.isTextPresent("1897-04-15"));
        assertTrue(selenium.isTextPresent("2004-2009"));
      
    }
    
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}