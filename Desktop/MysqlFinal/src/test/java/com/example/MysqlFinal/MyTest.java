package com.example.MysqlFinal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.testPackage.JunitClaseATestear;


class MyTest {
	
	JunitClaseATestear calculator = new JunitClaseATestear();
	  @Before 
	    public void setUp() throws Exception { 
		MockMvcBuilders.standaloneSetup(new JunitClaseATestear()).build(); 
	    }
	    
    @Test
    public void suma() {
    	
        assertEquals(11, calculator.add(3, 8));
    }

}
