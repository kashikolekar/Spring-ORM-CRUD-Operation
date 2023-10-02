package com.Spring.ORM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.Spring.ORM.Entitys.Student;
import com.Spring.ORM.Entitys.Dao.StudentDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
      ApplicationContext context =  new ClassPathXmlApplicationContext("com/Spring/ORM/Config.xml");
      
      StudentDao stuDao = context.getBean("studentDao",StudentDao.class);
  /*    Student student = new Student(1003,"Shravani","Shirala");
     
      int r = stuDao.insert(student);
      
      System.out.println("done "+r);
      
      */
     
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      boolean go=true;
      while(go)
      {
      System.out.println("press 1 for add new Student");
      System.out.println("press 2 for display all Student");
      System.out.println("press 3 for get detile of single Student");
      System.out.println("press 4 for delete Student");
      System.out.println("press 5 for update Student");
      System.out.println("press 6 for exit Student");
      
      
      try {
		
    	  
    	  
    	 int input = Integer.parseInt(br.readLine());
    	 
    	 switch (input) {
		case 1:
			System.out.println("Enter Student id:");
			int sid = Integer.parseInt(br.readLine());
			System.out.println("Enter Student Name");
			String name=br.readLine();
			System.out.println("Enter Student City");
			String city=br.readLine();
			Student student = new Student(sid,name,city);
		     
		       int r = stuDao.insert(student);
		      
		      System.out.println("done "+r);
			
			break;
		
		case 2:
		
			List<Student> allStudent = stuDao.getAllStudent();
			for(Student s:allStudent)
			{
				System.out.print("id ="+s.getId()+"  ");
				System.out.print("name ="+s.getName()+"   ");
				System.out.print("city ="+s.getCity()+"  ");
				System.out.println();
			}
			
			break;
		
		case 3:
			System.out.println("Enter Student id:");
			int id = Integer.parseInt(br.readLine());
			Student stu1 = stuDao.getStudent(id);
			System.out.print("id ="+stu1.getId()+"  ");
			System.out.print("name ="+stu1.getName()+"   ");
			System.out.print("city ="+stu1.getCity()+"  ");
			System.out.println();
			break;
		
		case 4:
			System.out.println("Enter Student id:");
			int idfordelect = Integer.parseInt(br.readLine());
		stuDao.deleteStudent(idfordelect);
		
		System.out.println("delete the data");
			
			
			break;
		
		case 5:
		
			System.out.println("Enter id which one update data");
			int updateid = Integer.parseInt(br.readLine());
			System.out.println("Enter new name");
			String nameup = br.readLine();
			System.out.println("Entyer new City");
			String city1 = br.readLine();
			Student stu = stuDao.getStudent(updateid);
			
			stu.setName(nameup);
			stu.setCity(city1);
			stuDao.updateStudent(stu);
		
		
			break;
		
		case 6:
		
			go=false;
			break;
		
		
		}
    	  
      
    	  
    	  
    	  
	} catch (Exception e) {
		System.out.println("invalid input");
		System.out.println(e.getMessage());
	}
      }
      
      System.out.println("thank for use apllication in consol");
      
    }
}
