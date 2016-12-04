/*Yi-Chen Kuo, Chih-Wei Lin*/

package com.Kuo_Lin.PP5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Kuo_Lin_spring.xml");
		
		Book bookLin = (Book) context.getBean("BookBeanLin");
		System.out.println(bookLin);
		Book bookKuo = (Book) context.getBean("BookBeanKuo");
		System.out.println(bookKuo);
	}

}
